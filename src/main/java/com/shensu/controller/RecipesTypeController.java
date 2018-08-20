package com.shensu.controller;

import java.io.File;
import java.io.IOException;

/**
 * 食谱类目管理
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shensu.pojo.FranchiserUser;
import com.shensu.pojo.RecipesType;
import com.shensu.service.RecipesTypeService;
import com.shensu.tool.DateTime;


@Controller
@RequestMapping("admin/RecipesType")
public class RecipesTypeController {

	@Autowired
	RecipesTypeService recipesTypeService;
	
	
	// 跳转添加食谱类别页面
	@RequestMapping(value = "addPage", method = RequestMethod.GET)
	public String add() {
		return "add";
	}
	
	// 食谱类目列表添加保存
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public String addsave(RecipesType rt) {
		//System.out.println("正在添加");
		rt.setRecipestypecreattime(new DateTime().getDate());
		recipesTypeService.insertSelective(rt);
		//System.out.println("添加成功");
		return "list";
	}
	
	// 跳转到修改食谱类目页面
	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	@ResponseBody
	public String update() {
		return "update";
	}

	// 修改食谱类别保存
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public String updatesave(RecipesType rt) {
		rt.setRecipestypecreattime(new DateTime().getDate());
		recipesTypeService.updateByPrimaryKey(rt);
		System.out.println("修改成功");
		return "list";
	}
	
	// 删除一个食谱类别
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String del(int recipesTypeId) {
		recipesTypeService.deleteByPrimaryKey(recipesTypeId);
		return "redirect:foodTypelist";
	}
	
	//查询所有的食品类目列表
	@RequestMapping(value = "/foodTypelist",method=RequestMethod.GET)
	public String findAllRecipesType(RecipesType recipesType ,Model model) {
		List<RecipesType> recipeList= recipesTypeService.queryAllRecipesType(recipesType);
		model.addAttribute("recipeList", recipeList);
		 return "foodType/foodType";
	}
	
	// 食谱列表添加保存
	@RequestMapping(value = "/HtAdd", method = RequestMethod.POST)
	public String add(RecipesType recipesType) {
		recipesType.setRecipestypecreattime(new DateTime().getDate());
		recipesTypeService.insertSelective(recipesType);
		return "redirect:foodTypelist";
	}
		
		// 删除一个食谱类别
		@RequestMapping(value = "/HtDelete", method = RequestMethod.GET)
		public String del(Integer recipesTypeId, HttpServletRequest request) {
			String requestUrl = request.getScheme() // 当前链接使用的协议
					+ "://" + request.getServerName()// 服务器地址
					+ "RegistCompanyIMG/";
			String prefix = request.getSession().getServletContext().getRealPath("/").replace("Svip", "RegistCompanyIMG");
			
			RecipesType recipesType = recipesTypeService.selectByPrimaryKey(recipesTypeId);
			if (recipesType.getRecipsetypeimg() != null  && !("".equals(recipesType.getRecipsetypeimg()))) {
				String suffix = recipesType.getRecipsetypeimg().substring(requestUrl.length() + 1);

				String realUrl = prefix + suffix;
				File targetFile = new File(realUrl);

				if (targetFile.exists()) {

					System.out.println("文件存在");
				} else {
					System.out.println("文件不存在");
				}

				if (targetFile.isDirectory()) { // 如果是 文件夹
					try {
						FileUtils.deleteDirectory(targetFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (targetFile.isFile()) {// 如果是文件
					targetFile.delete();
				}
				
				recipesTypeService.deleteByPrimaryKey(recipesTypeId);
				
			} else {
				recipesTypeService.deleteByPrimaryKey(recipesTypeId);
			}
			return "redirect:foodTypelist";
		}
		
		// 修改食谱类别保存
		@RequestMapping(value = "/HtUpdate", method = RequestMethod.GET)
		public String update(RecipesType rt) {
			rt.setRecipestypecreattime(new DateTime().getDate());
			recipesTypeService.updateByPrimaryKey(rt);
			return "redirect:foodTypelist";
		}
		
		/*
		//根据食谱类目分页查询食谱信息
		@RequestMapping("/findRecipes")
		public String findRecipes(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,
				@RequestParam(value="recipestypename",required=false)String recipestypename,
				@RequestParam(value="recipestypestate",required=false)Integer recipestypestate,
				HttpServletRequest request,Model model	){
			if("".equals(recipestypename)){
				recipestypename=null;
			}
			
			List<RecipesType> recipesNameList= recipesTypeService.queryRecipesType();
			Page<RecipesType> recipesTypeList= recipesTypeService.findRecipesByName(currentPage, recipestypename, recipestypestate);
			
			System.out.println("食谱类别表名=========================");
			System.out.println(recipestypename);
			System.out.println("食谱类别表=========================");
			System.out.println(recipesNameList);
			System.out.println("食谱分页表=========================");
			System.out.println(recipesTypeList.getLists());
			System.out.println(recipesTypeList.getPageSize() +"===" + recipesTypeList.getTotalPage());
			
			model.addAttribute("recipesTypeList", recipesTypeList);
			model.addAttribute("recipestypename", recipestypename);
			model.addAttribute("recipestypestate", recipestypestate);
			return "food/findFood";
		}*/
		
		
		
		//添加食谱校验
		@ResponseBody
		@RequestMapping("addRecipesTypeXY")
		public String addRecipesTypeXY(RecipesType recipesType,String aa){
			System.out.println(aa+"*************************");
			List<RecipesType> recipeList= recipesTypeService.queryAllRecipesType(recipesType);
			System.out.println(recipeList.size()+"*************************");
			for (int i = 0; i < recipeList.size(); i++) {
					if(recipeList.get(i).getRecipestypename().equals(aa)){
						return  "0";
					}				
				}	
		     return "1";
		}
		
		//修改食谱校验
		@ResponseBody
		@RequestMapping("editRecipesTypeXY")
		public String editRecipesTypeXY(RecipesType recipesType,String Obtain,Integer recipestypeid){
			System.out.println(Obtain+"*************************"+recipestypeid);
			List<RecipesType> recipeList= recipesTypeService.editRecipesTypeXY(recipestypeid);
			System.out.println(recipeList.size());
			for (int i = 0; i < recipeList.size(); i++) {
					if(recipeList.get(i).getRecipestypename().equals(Obtain)){
						return  "0";
					}				
				}	
		     return "1";
		}
}

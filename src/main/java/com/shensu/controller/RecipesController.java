package com.shensu.controller;

import java.io.File;
/**
 * 食谱管理
 */
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.shensu.pojo.Recipes;
import com.shensu.pojo.RecipesSwiper;
import com.shensu.pojo.RecipesType;
import com.shensu.service.RecipesService;
import com.shensu.service.RecipesSwiperService;
import com.shensu.service.RecipesTypeService;
import com.shensu.tool.DateTime;
import com.shensu.tool.Page;
import com.shensu.tool.UploadHelper;

@Controller
@RequestMapping("/Recipes")
public class RecipesController {
	
	@Autowired
	RecipesService recipesService;
	
	@Autowired
	RecipesTypeService recipesTypeService;
	
	@Autowired
	RecipesSwiperService recipesSwiperService;
    
	// 单张图片上传
	@ResponseBody
	@RequestMapping("/recipeUpload")
	public String studyUpload(@RequestParam(value="file",required=false)MultipartFile files,HttpServletRequest request) throws IOException{
		
		String imgUrl=UploadHelper.upload(files, request);
		
		return imgUrl;
	}
	
	// 跳转添加食谱页面
	@RequestMapping(value = "addRecipesPage", method = RequestMethod.GET)
	public String add(Model model) {
		List<RecipesType> recipesTypeList= recipesTypeService.queryRecipesType();
		model.addAttribute("recipesTypeList", recipesTypeList);
		model.addAttribute("recipesTypedefault", recipesTypeList.get(0));
		return "food/addfood";
	}

	// 食谱列表添加保存
	@RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
	public String addsave(Recipes recipes,HttpServletRequest request) throws IOException {
		/*System.out.println("进入程序+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("添加食谱数据：" + recipes);*/
		
		recipes.setRecipescreattime(new DateTime().getDate());
		String recipSwiper = recipes.getRecipesimg();
		recipes.setRecipesimg("");
		recipes.setRecipesbrowse(0);
		recipesService.insert(recipes);
		Integer recipesId = recipes.getRecipesid();
		
		if (!"".equals(recipSwiper) && recipSwiper != null) {
			recipSwiper = recipSwiper.substring(0, recipSwiper.length()-1);
			String[] recipSwiperList = recipSwiper.split(",");
			RecipesSwiper recipesSwiper = new RecipesSwiper();
			recipesSwiper.setRecipesid(recipesId);
			for (String string : recipSwiperList) {
				recipesSwiper.setRecipesswipercreattime(new DateTime().getDate());
				recipesSwiper.setRecipesswiperimg(string);
				recipesSwiperService.insertRecipesSwiperImg(recipesSwiper);
			}
		}
		/*recipesSwiperService.insertRecipesSwiperImg(rs)*/
		/*System.out.println("*********************"+recipesId+"********************************");
		System.out.println("程序结束+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");*/
		return "redirect:Recipeslist";
	}

	// 根据条件分页查询
	@RequestMapping("/Recipeslist")
	public String list(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value="recipestypename",required=false)String recipestypename,
			@RequestParam(value="recipestate",required=false)Integer recipestate,
			@RequestParam(value = "recipesTitle", required = false) String recipesTitle,
			HttpServletRequest request, Model model) {
			
		Integer recipestypeId = null;
		if(recipestypename != null && !"".equals(recipestypename)){
			recipestypeId = recipesTypeService.queryRecipesTypeIdByName(recipestypename);
		}
		
		List<RecipesType> recipestypeList = recipesTypeService.queryRecipesType();
		
		Page<Recipes> recipesList = recipesService.selectByCondition(currentPage, recipesTitle, null, recipestate, recipestypeId);
		
/*//		List<Recipes> rec = recipesList.getLists();
//		for (Recipes r : rec) {
//			System.out.println(r.getRecipesType().getRecipestypename());
//		}
		
		System.out.println(recipesList.getCurrPage()+"当前页码");
		System.out.println(recipesList.getPageSize()+"每页条数");
		System.out.println(recipesList.getTotalCount()+"总记录数");
		System.out.println(recipesList.getTotalPage()+"总页数");
		System.out.println(recipesList.getLists().size());*/
		
		model.addAttribute("recipestypeList", recipestypeList);
		model.addAttribute("recipestypename", recipestypename);
		model.addAttribute("recipestate", recipestate);
		model.addAttribute("recipesList", recipesList);
		return "food/findFood";
	}
	
	//根据食谱Id删除食谱轮播图
	public void DeleteRecipesSwiperImgs(Integer recipeid, HttpServletRequest request){
	
			List<RecipesSwiper> recipesSwiperList = recipesSwiperService.findRecipesSwiperById(recipeid);
			if(recipesSwiperList.size()!=0){
				
				for (RecipesSwiper s : recipesSwiperList) {
					
					deleteLocalHostResources(s.getRecipesswiperimg(), request);
				}
			}
			
			recipesSwiperService.deleteRecipesSwiperById(recipeid);
	}

	// 删除一个食谱
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String del(Integer recipesId, HttpServletRequest request) {
		DeleteRecipesSwiperImgs(recipesId,request);
		recipesService.deleteByPrimaryKey(recipesId);
		return "redirect:Recipeslist";
	}

	// 跳转到修改食谱类别页面
	@RequestMapping(value = "/editPage", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value="recipestypename",required=false)String recipestypename,
			@RequestParam(value="recipestate",required=false)Integer recipestate,
			Integer recipesId, Model model) {
		
		Recipes recipes = recipesService.selectByPrimaryKey(recipesId);
		
		List<RecipesType> recipesTypeList= recipesTypeService.queryRecipesType();
		System.out.println("食谱：" + recipes);
		
		List<RecipesSwiper> recipesSwiperList = recipes.getRecipesSwiper();
		
		String recipeImgStr ="";
		for (RecipesSwiper recipesSwiper : recipesSwiperList) {
			recipeImgStr += recipesSwiper.getRecipesswiperimg() + ",";
		}
		System.out.println("recipeImgStr:" + recipeImgStr);
		 
		model.addAttribute("recipes", recipes);
		model.addAttribute("recipeImgStr", recipeImgStr);
		model.addAttribute("recipestypeList", recipesTypeList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("recipestypename", recipestypename);
		model.addAttribute("recipestate", recipestate);
		return "food/editfood";
	}

	// 修改食谱保存
	@RequestMapping(value = "/updateSave", method = RequestMethod.POST)
	public String updatesave(Recipes recipes ,HttpServletRequest request) {
		
		System.out.println("shi pu xiu gai shu ju :" + recipes);
		
		String recipSwiper = recipes.getRecipesimg();
		Integer recipesId = recipes.getRecipesid();
		recipes.setRecipesimg("");
		recipesService.updateByPrimaryKey(recipes);
		DeleteRecipesSwiperImgs(recipesId, request);
		
		if (!"".equals(recipSwiper) && recipSwiper != null) {
			recipSwiper = recipSwiper.substring(0, recipSwiper.length()-1);
			String[] recipSwiperList = recipSwiper.split(",");
			RecipesSwiper recipesSwiper = new RecipesSwiper();
			recipesSwiper.setRecipesid(recipesId);
			for (String string : recipSwiperList) {
				recipesSwiper.setRecipesswipercreattime(new DateTime().getDate());
				recipesSwiper.setRecipesswiperimg(string);
				recipesSwiperService.insertRecipesSwiperImg(recipesSwiper);
			}
		}
		
		return "redirect:Recipeslist";
	}
	
	//设置食谱为上架状态
	@RequestMapping(value="/putawayRecipes",method=RequestMethod.GET)
	public String putawayRecipes(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value="recipestypename",required=false)String recipestypename,
			@RequestParam(value="recipestate",required=false)Integer recipestate,
			Integer recipesId, Model model){
		recipesService.putawayRecipes(recipesId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("recipestypename", recipestypename);
		model.addAttribute("recipestate", recipestate);
		 return "redirect:Recipeslist";
	} 
	
	//设置食谱为下架状态
	@RequestMapping(value="/unshelveRecipes",method=RequestMethod.GET)
	public String unshelveRecipes(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value="recipestypename",required=false)String recipestypename,
			@RequestParam(value="recipestate",required=false)Integer recipestate,
			Integer recipesId, Model model){
		recipesService.unshelveRecipes(recipesId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("recipestypename", recipestypename);
		model.addAttribute("recipestate", recipestate);
		return "redirect:Recipeslist";
	} 
	
	//批量上架
		@RequestMapping(value="/batchPutawayRecipes",method=RequestMethod.GET)
		public String batchPutawayRecipes(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
				@RequestParam(value="recipestypename",required=false)String recipestypename,
				@RequestParam(value="recipestate",required=false)Integer recipestate,
				@RequestParam(value="choseStr",required=true)String choseStr,
				Model model){
			
			String[] shopArray = choseStr.split("-");
			for (String string : shopArray) {
				if (!string.equals("0")) {
					Integer recipesId = Integer.parseInt(string);
					recipesService.putawayRecipes(recipesId);
				}
			}
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("recipestypename", recipestypename);
			model.addAttribute("recipestate", recipestate);
			return "redirect:Recipeslist";
		} 
		
/*		//批量下架
		@RequestMapping(value="/batchUnshelveRecipes",method=RequestMethod.GET)
		@ResponseBody
		public String batchUnshelveRecipes(String idList,HttpServletRequest request,HttpServletResponse response){
			String listId[] = idList.split(",");
					for (String s : listId) {
						int sid=Integer.parseInt(s);
						recipesService.unshelveRecipes(sid);
					}
			return "list";
			} 
	*/
	public void deleteLocalHostResources(String URL,HttpServletRequest request){
		   String requestUrl = request.getScheme() //当前链接使用的协议
				    +"://" + request.getServerName()//服务器地址
				    +"RegistCompanyIMG/"
				    ; 
		   String qzz=request.getSession().getServletContext().getRealPath("/");
			qzz= qzz.replace("Svip","RegistCompanyIMG");
		    String hz=URL.substring(requestUrl.length()+1);
			String allUrl=qzz+hz;
			File targetFile=new File(allUrl);
			if(targetFile.exists()){
				
				System.out.println("文件存在");
			}else{
				System.out.println("文件不存在");
			}
			
			if (targetFile.isDirectory()) { //如果是 文件夹
		         try {
		               FileUtils.deleteDirectory(targetFile);
		            } catch (IOException e) {
		               e.printStackTrace();
		            }  
		      } else if (targetFile.isFile()) {//如果是文件  
		          targetFile.delete();  
		      }
	   }
		
}

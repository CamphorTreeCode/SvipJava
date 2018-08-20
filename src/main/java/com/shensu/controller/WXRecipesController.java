package com.shensu.controller;

/**
 * 首页-超级食谱
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shensu.pojo.RecipesType;
import com.shensu.service.RecipesService;
import com.shensu.service.RecipesTypeService;


import net.sf.json.JSONArray;


@Controller
@RequestMapping("/WXRecipes")
public class WXRecipesController {
	
	@Autowired
	RecipesTypeService recipesTypeService;
	
	@Autowired
	RecipesService recipesService;
	
	//查询食谱类目列表
	@RequestMapping(value = "/findRecipesTypeList", method = RequestMethod.GET)
	@ResponseBody
	public void findRecipesTypeList(RecipesType recipesType, HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(recipesTypeService.queryAllRecipesType(recipesType));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
//	//查询食谱类目下前四个食谱的轮播图第一张
//	@RequestMapping(value = "/findRecipesSwiperList", method = RequestMethod.GET)
//	@ResponseBody
//	public void findRecipesSwiperList(int recipesTypeId, HttpServletResponse response) throws IOException{
//		response.setHeader("Content-type", "text/html;charset=UTF-8");  
//		System.out.println("进入主方法了");
//		response.setCharacterEncoding("utf-8");
//		JSONArray jsonArray = JSONArray.fromObject(recipesService.findRecipesSwiperList(recipesTypeId));
//		PrintWriter pw = response.getWriter();
//		pw.print(jsonArray);
//	}
	
	//查询食谱文章详情
	@RequestMapping(value = "/findRecipesDetails", method = RequestMethod.GET)
	@ResponseBody
	public void findRecipesDetails(int recipesId, HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(recipesService.findRecipesDetails(recipesId));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//跳转到食谱列表(查询食谱列表)
	@RequestMapping(value = "/findRecipesList", method = RequestMethod.GET)
	@ResponseBody
	public void findRecipesList(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,int recipesTypeId, HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(recipesService.findRecipesList(currentPage,recipesTypeId));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
}

package com.shensu.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.RecipesMapper;
import com.shensu.pojo.MyCard;
import com.shensu.pojo.Recipes;
import com.shensu.service.RecipesService;
import com.shensu.tool.Page;
@Service("RecipesService")
public class RecipesServiceImpl implements RecipesService{
	
	@Autowired
	RecipesMapper recipesMapper;
	@Override
	public int insert(Recipes recipses) {
		// TODO Auto-generated method stub
		return recipesMapper.insert(recipses);
	}
	@Override
	public List<Recipes> queryAllRecipesType() {
		// TODO Auto-generated method stub
		return recipesMapper.queryAllRecipes();
	}
	//根据条件分页
		public Page<Recipes> selectByCondition(Integer currentPage, String recipesTitle, Integer recipesId, Integer recipestate, Integer recipestypeId) {
			HashMap<String,Object> map = new HashMap<String,Object>();
			HashMap<String,Object> map1 = new HashMap<String,Object>();
			map1.put("recipesTitle", recipesTitle);
			map1.put("recipesId", recipesId);
			map1.put("recipestate", recipestate);
			map1.put("recipestypeId", recipestypeId);
			Page<Recipes> pageBean = new Page<Recipes>();

			//封装当前页数
			pageBean.setCurrPage(currentPage);

			//每页显示的数据
			int pageSize=5;
			pageBean.setPageSize(pageSize);

			//封装总记录数
			int totalCount = recipesMapper.selectCountByCondition(map1);
			pageBean.setTotalCount(totalCount);
			/*System.out.println(totalCount);*/
			//封装总页数
			double tc = totalCount;
			Double num =Math.ceil(tc/pageSize);//向上取整
			pageBean.setTotalPage(num.intValue());

			map.put("start",(currentPage-1)*pageSize);
			map.put("size", pageBean.getPageSize());
			map.put("recipesTitle", recipesTitle);
			map.put("recipesId", recipesId);
			map.put("recipestate", recipestate);
			map.put("recipestypeId", recipestypeId);
			//封装每页显示的数据
			List<Recipes> lists = recipesMapper.selectByCondition(map);
			pageBean.setLists(lists);
			return pageBean;
		}
		
		//根據主鍵刪除食譜
		@Override
		public int deleteByPrimaryKey(Integer recipesId) {
			// TODO Auto-generated method stub
			return recipesMapper.deleteByPrimaryKey(recipesId);
		}	
		//根據主鍵修改食譜
		@Override
		public int updateByPrimaryKey(Recipes recipes) {
			// TODO Auto-generated method stub
			return recipesMapper.updateByPrimaryKey(recipes);
		}
		//根據主鍵查詢當前食譜
		@Override
		public Recipes selectByPrimaryKey(Integer recipesId) {
			// TODO Auto-generated method stub
			return recipesMapper.selectByPrimaryKey(recipesId);
		}
		
		//设置食谱为上架状态
		@Override
		public int putawayRecipes(int recipesId) {
			return recipesMapper.putawayRecipes(recipesId);
		}
		
		//设置食谱为下架状态
		@Override
		public int unshelveRecipes(int recipesId) {
			return recipesMapper.unshelveRecipes(recipesId);
		}
		
		//根据食谱类目id查询出前四个食谱上架状态(小程序)
		@Override
		public List<Recipes> findRecipesSwiperList(int recipesTypeId) {
			return recipesMapper.findRecipesSwiperList(recipesTypeId);
		}
			
		//查询食谱下面的详细信息(小程序)
		@Override
		public List<Recipes> findRecipesDetails(int recipesId) {
			//增加食谱阅读量
			recipesMapper.addrecipesBrowse(recipesId);
			return recipesMapper.findRecipesDetails(recipesId);
		}
		
		//根据类目id查询对应的食谱全部列表上架状态(小程序)
		@Override
		public Page<Recipes> findRecipesList(int currentPage,int recipesTypeId) {

			// TODO 自动生成的方法存根
			HashMap<String,Object> map = new HashMap<String,Object>();
	        Page<Recipes> pageBean = new Page<Recipes>();
	        //封装当前页数
	        pageBean.setCurrPage(currentPage);
	        //每页显示的数据
	        int pageSize=6;
	        pageBean.setPageSize(pageSize);
	        //封装总记录数
	        int totalCount = recipesMapper.selectCountRecipes(recipesTypeId);
	        //封装总页数
	        double tc = totalCount;
	        Double num =Math.ceil(tc/pageSize);//向上取整
	        pageBean.setTotalPage(num.intValue() );      
	        map.put("start",(currentPage-1)*pageSize);
	        map.put("size", pageBean.getPageSize());
	        map.put("recipesTypeId",recipesTypeId);
	        //封装每页显示的数据
	        List<Recipes> lists = recipesMapper.selectRecipesPage(map);
	        pageBean.setLists(lists);
	        return pageBean;	
		}
		
}

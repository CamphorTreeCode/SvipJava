package com.shensu.service;

import java.util.HashMap;
import java.util.List;

import com.shensu.pojo.Recipes;
import com.shensu.pojo.RecipesType;
import com.shensu.pojo.Shop;
import com.shensu.pojo.ShopType;
import com.shensu.tool.Page;

public interface RecipesService {
	//添加食品类目
    int insert (Recipes recipses);
    
    //查詢食品列表
    List<Recipes> queryAllRecipesType();
    
    //根据条件分页查询
  	Page<Recipes> selectByCondition(Integer currentPage, String recipesTitle, Integer recipesId, Integer recipestate, Integer recipestypeId);	
  	//删除食譜
  	int deleteByPrimaryKey(Integer recipesId);
  	//更改食譜
	int updateByPrimaryKey(Recipes recipes);
	
	//根据id查询单个食譜
	Recipes selectByPrimaryKey(Integer recipseId);
	
	//设置食谱为上架状态
	int putawayRecipes(int recipesId);
	
	//设置食谱为下架状态
	int unshelveRecipes(int recipesId);
	
	//根据类目id查询对应的食谱上架状态(小程序)
	List<Recipes> findRecipesSwiperList(int recipesTypeId);
	
	//查询食谱下面的详细信息(小程序)
	List<Recipes> findRecipesDetails(int recipesId);
	
	//根据类目id查询对应的食谱全部列表上架状态(小程序)
	Page<Recipes> findRecipesList(int currentPage,int recipesTypeId);
	
	
	
}

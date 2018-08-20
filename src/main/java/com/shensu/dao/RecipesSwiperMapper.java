package com.shensu.dao;

import java.util.List;

import com.shensu.pojo.RecipesSwiper;

public interface RecipesSwiperMapper {
	//添加食谱展示图片信息
	int insertRecipesSwiperImg(RecipesSwiper rs);
	
	//查询食谱的全部展示图(小程序)
	RecipesSwiper findRecipesSwiperList(int recipesId);
	
	//根据食谱Id查找对应的所有轮播图
	List<RecipesSwiper>findRecipesSwiperById(Integer recipesId);
	
	//根据食谱Id删除对应的所有轮播图
	void deleteRecipesSwiperById(Integer recipesId);
	
}
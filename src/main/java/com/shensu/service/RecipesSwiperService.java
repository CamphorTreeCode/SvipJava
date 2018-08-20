package com.shensu.service;

import java.util.List;

import com.shensu.pojo.RecipesSwiper;

public interface RecipesSwiperService {
	
	//添加食谱展示图片信息
	int insertRecipesSwiperImg(RecipesSwiper rs);
	
	//根据食谱Id查找对应的所有轮播图
	List<RecipesSwiper>findRecipesSwiperById(Integer recipesId);
	
	//根据食谱Id删除对应的所有轮播图
	void deleteRecipesSwiperById(Integer recipesId);
		
}

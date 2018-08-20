package com.shensu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.RecipesSwiperMapper;
import com.shensu.pojo.RecipesSwiper;
import com.shensu.service.RecipesSwiperService;

@Service("RecipesSwiperService")
public class RecipesSwiperServiceImpl implements RecipesSwiperService {

	@Autowired
	RecipesSwiperMapper recipesSwiperMapper;

	// 添加食谱展示图片信息
	@Override
	public int insertRecipesSwiperImg(RecipesSwiper rs) {
		return recipesSwiperMapper.insertRecipesSwiperImg(rs);
	}

	@Override
	public List<RecipesSwiper> findRecipesSwiperById(Integer recipesId) {
		
		return recipesSwiperMapper.findRecipesSwiperById(recipesId);
	}

	@Override
	public void deleteRecipesSwiperById(Integer recipesId) {
		
		recipesSwiperMapper.deleteRecipesSwiperById(recipesId);
	}
	
}

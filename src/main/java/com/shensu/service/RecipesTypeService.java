package com.shensu.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shensu.pojo.RecipesType;
import com.shensu.tool.Page;

public interface RecipesTypeService {
	
	//查询出所有食品类目
	List<RecipesType> queryAllRecipesType(RecipesType recipesType);
		
	//添加食品类目
	int insertSelective (RecipesType recipsesType);
	
	//更改食品类目
	int updateByPrimaryKey(RecipesType recipesType);
	
	//删除食品类目
	int deleteByPrimaryKey(Integer recipesTypeId);
	
	//根据主键查出对应的食品
	RecipesType selectByPrimaryKey(Integer recipesTypeId);
	
	//批量更新下架食谱变为上架
    int batchUpdateRecipesType(List<Integer> list);
    
  //根据类目名称来进行分页查询
    Page<RecipesType> findRecipesByName(int currentPage, String recipestypename, Integer recipestypestate);
    
    //根据条件查总数
    int selectCountByCondition(HashMap<String,Object> map);
    
    List<RecipesType> queryRecipesType();
    
    int queryRecipesTypeIdByName(String recipestypename);
    
    //查询全部类目(除了本条之外的)
    List<RecipesType> editRecipesTypeXY(Integer recipestypeid);
}

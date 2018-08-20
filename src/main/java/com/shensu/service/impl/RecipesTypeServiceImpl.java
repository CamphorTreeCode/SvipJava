package com.shensu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.RecipesTypeMapper;
import com.shensu.pojo.RecipesType;
import com.shensu.service.RecipesTypeService;
import com.shensu.tool.Page;
@Service("RecipesTypeService")
public class RecipesTypeServiceImpl implements RecipesTypeService{
	@Autowired
	RecipesTypeMapper recipesTypeMapper;
	
	//查询食谱列表
	public List<RecipesType> queryAllRecipesType(RecipesType recipesType) {
		return recipesTypeMapper.queryAllRecipesType( recipesType);
	}
	
	//增加食谱类别
	@Override
	public int insertSelective(RecipesType recipsesType) {
		return recipesTypeMapper.insertSelective(recipsesType);
	}
	
	//修改食谱类别
	@Override
	public int updateByPrimaryKey(RecipesType recipesType) {
		return recipesTypeMapper.updateByPrimaryKey(recipesType);
	}
		
	//删除食谱类别
	@Override
	public int deleteByPrimaryKey(Integer RecipesTypeId) {	
		return recipesTypeMapper.deleteByPrimaryKey(RecipesTypeId);
	}
	
	//根据食谱主键查询单个食谱	
	@Override
	public RecipesType selectByPrimaryKey(Integer recipesTypeId) {
		// TODO Auto-generated method stub
		return recipesTypeMapper.selectByPrimaryKey(recipesTypeId);
	}
	//批量更新食谱上下架
	@Override
	public int batchUpdateRecipesType(List<Integer> list) {
		// TODO Auto-generated method stub
		return recipesTypeMapper.batchUpdateRecipesType(list);
	}

	@Override
	public Page<RecipesType> findRecipesByName(int currentPage, String recipestypename, Integer recipestypestate) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
		HashMap<String,Object> map1 = new HashMap<String,Object>();
		map1.put("recipestypename", recipestypename);
		map1.put("recipestypestate", recipestypestate);
		Page<RecipesType> pageBean = new Page<RecipesType>();

		//封装当前页数
		pageBean.setCurrPage(currentPage);

		//每页显示的数据
		int pageSize=5;
		pageBean.setPageSize(pageSize);

		//封装总记录数
		int totalCount = recipesTypeMapper.selectCountByCondition(map1);
		pageBean.setTotalCount(totalCount);
		System.out.println(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("recipestypename", recipestypename);
		map.put("recipestypestate", recipestypestate);
		//封装每页显示的数据
		List<RecipesType> lists = recipesTypeMapper.findRecipesByName(map);
		pageBean.setLists(lists);
		return pageBean;
	}

	@Override
	public int selectCountByCondition(HashMap<String, Object> map) {
		
		return recipesTypeMapper.selectCountByCondition(map);
	}


	@Override
	public List<RecipesType> queryRecipesType() {
		
		return recipesTypeMapper.queryRecipesType();
	}

	@Override
	public int queryRecipesTypeIdByName(String recipestypename) {
		
		return recipesTypeMapper.queryRecipesTypeIdByName(recipestypename);
	}
	
	 //查询全部类目(除了本条之外的)
	@Override
	public List<RecipesType> editRecipesTypeXY(Integer recipestypeid) {
		return recipesTypeMapper.editRecipesTypeXY(recipestypeid);
	}
	
}

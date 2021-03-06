package com.shensu.dao;

import java.util.HashMap;
import java.util.List;

import com.shensu.pojo.Maintenance;
import com.shensu.pojo.RecipesType;
import com.shensu.tool.Page;

public interface RecipesTypeMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RecipesType
     *
     * @mbggenerated
     */
    int insert(RecipesType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RecipesType
     *
     * @mbggenerated
     */
    RecipesType selectByPrimaryKey(Integer recipestypeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RecipesType
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RecipesType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RecipesType
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RecipesType record);
    
    //查询出所有商品类目
  	List<RecipesType> queryAllRecipesType(RecipesType recipesType);
    
    //添加食品类目
    int insertSelective(RecipesType record);
    
    //删除食品类目
    int deleteByPrimaryKey(Integer recipestypeid);
	
	//批量更新下架食谱变为上架
    int batchUpdateRecipesType(List<Integer> list);
    
    //根据类目名称来进行分页查询
    List<RecipesType> findRecipesByName(HashMap<String,Object> map);
    
    //根据条件查总数
    int selectCountByCondition(HashMap<String,Object> map);
    
    //查询所有食谱的类别（没有食谱）
    List<RecipesType> queryRecipesType();
    
    //根据食谱类别名查类别id
    int queryRecipesTypeIdByName(String recipestypename);
    
    //查询全部类目(除了本条之外的)
    List<RecipesType> editRecipesTypeXY(Integer recipestypeid);
   
}
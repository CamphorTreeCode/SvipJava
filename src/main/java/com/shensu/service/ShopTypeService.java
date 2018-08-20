package com.shensu.service;

import java.util.List;

import com.shensu.pojo.ShopType;

public interface ShopTypeService {
	//查询全部
	List<ShopType> selectAll();
	//根据id查询单个商品分类
	ShopType selectById(int shopTypeId);
	//添加一个商品类型
	int insertShopType(ShopType st);
	//删除一个商品类型
	int deleteShopType(int shopTypeId);
	//修改一个商品类型
	int updateShopType(ShopType st);
	
	//替换商品类目的
	int updateShopTypeImg(ShopType st);
	
	//根据商品类目id查询页面信息
	ShopType findShopTypeImg(int shopTypeId);
	
	//删除(设置为空)商品类目图片
	int deleteShopTypeImg(int shopTypeId);
	
	//根据商品类目id查询出商品的图片(小程序)
	List<ShopType> findShopTypeImg();
	//查找每个分类的前前两个商品
	List<ShopType> selectShopTypeTwo();
	
	//根据商品类别名查找其id
	int getShopTypeIdByName(String shopTypeName);
	
	//查询全部类目(除了本条之外的)
	List<ShopType> editShopTypeXY(Integer shoptypeid);
	
}

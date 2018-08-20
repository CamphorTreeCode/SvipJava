package com.shensu.service;

import java.util.List;

import com.shensu.pojo.ShopSKU;

public interface ShopSKUService {
	
	
	//添加商品SKU信息
	int insertShopSKU(ShopSKU ss);
	
	//修改商品SKU信息
	int modifyShopSKU(ShopSKU ss);
	
	//根据shopId删除对应的所有图片
	int deleteShopSwiperImg(int shopId);
	
  	//根据商品shopid 查找所有shopsku
  	List<ShopSKU> findShopSKUAllByshopId(Integer shopId);
}

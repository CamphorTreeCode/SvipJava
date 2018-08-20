package com.shensu.dao;

import java.util.List;

import com.shensu.pojo.ShopSkuSwiper;

public interface ShopSkuSwiperMapper {
	
	ShopSkuSwiper selectByPrimaryKey(Integer shopSkuSwiperId);
	
	//添加商品sku轮播图
	void insertShopSkuSwiper(ShopSkuSwiper shopSkuSwiper);
	
	//根据shopSKUid查找轮播图
	List<ShopSkuSwiper> selectShopSkuId(Integer shopSkuId);
	
	//根据shopSKUid查找轮播图
	void deleteShopSkuSwireBySkuid(Integer shopSkuId);
}

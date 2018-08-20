package com.shensu.service;

import java.util.List;

import com.shensu.pojo.ShopSwiper;

public interface ShopSwiperService {
	
	//添加一个商品图片
	int insertShopSwiper(ShopSwiper ss);
	
	//删除一张图片
	int deleteShopSwiper(int shopSwiperId);
	
	//根据商品id查询对应图片
	List<ShopSwiper> selectShopSwiperByShopId(int shopId);
	
	//条件修改
	int updateByPrimaryKeySelective(ShopSwiper record);

}

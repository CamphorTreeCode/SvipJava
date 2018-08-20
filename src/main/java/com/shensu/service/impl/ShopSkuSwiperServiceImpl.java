package com.shensu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.ShopSkuSwiperMapper;
import com.shensu.pojo.ShopSkuSwiper;
import com.shensu.service.ShopSkuSwiperService;
@Service("ShopSkuSwiperService")
public class ShopSkuSwiperServiceImpl implements ShopSkuSwiperService {
	
	@Autowired
	private ShopSkuSwiperMapper shopSkuSwiperMapper;
	@Override
	public ShopSkuSwiper selectByPrimaryKey(Integer shopSkuSwiperId) {
		// TODO Auto-generated method stub
		return shopSkuSwiperMapper.selectByPrimaryKey(shopSkuSwiperId);
	}
	@Override
	public void insertShopSkuSwiper(ShopSkuSwiper shopSkuSwiper) {
		
		shopSkuSwiperMapper.insertShopSkuSwiper(shopSkuSwiper);
		
	}
	@Override
	public List<ShopSkuSwiper> selectShopSkuId(Integer shopSkuId) {
		
		return shopSkuSwiperMapper.selectShopSkuId(shopSkuId);
	}
	@Override
	public void deleteShopSkuSwireBySkuid(Integer shopSkuId) {
		
		shopSkuSwiperMapper.deleteShopSkuSwireBySkuid(shopSkuId);
		
	}

}

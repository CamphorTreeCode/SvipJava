package com.shensu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.ShopSKUMapper;
import com.shensu.pojo.ShopSKU;
import com.shensu.service.ShopSKUService;

@Service("ShopSKUService")
public class ShopSKUImpl implements ShopSKUService {
    
	@Autowired
	ShopSKUMapper shopSKUMapper;
	
	//添加商品SKU信息
	@Override
	public int insertShopSKU(ShopSKU ss) {
		
		return shopSKUMapper.insertShopSKU(ss);
	}
	
	//修改商品SKU信息
	@Override
	public int modifyShopSKU(ShopSKU ss) {
		return shopSKUMapper.modifyShopSKU(ss);
	}
	
	@Override
	public int deleteShopSwiperImg(int shopId) {
		
		return 0;
	}

	@Override
	public List<ShopSKU> findShopSKUAllByshopId(Integer shopId) {
		
		return shopSKUMapper.findShopSKUAllByshopId(shopId);
	}

	
}

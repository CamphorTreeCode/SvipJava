package com.shensu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.ShopSwiperMapper;
import com.shensu.pojo.ShopSwiper;
import com.shensu.service.ShopSwiperService;
@Service("ShopSwiperService")
public class ShopSwiperServiceImpl implements ShopSwiperService {
    @Autowired
    ShopSwiperMapper shopSwiperMapper;
	@Override
	public int insertShopSwiper(ShopSwiper ss) {
		// TODO Auto-generated method stub
		return shopSwiperMapper.insertSelective(ss);
	}

	@Override
	public int deleteShopSwiper(int shopSwiperId) {
		// TODO Auto-generated method stub
		return shopSwiperMapper.deleteByPrimaryKey(shopSwiperId);
	}

	@Override
	public List<ShopSwiper> selectShopSwiperByShopId(int shopId) {
		// TODO Auto-generated method stub
		return shopSwiperMapper.selectShopSwiperByShopId(shopId);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopSwiper record) {
		
		return shopSwiperMapper.updateByPrimaryKeySelective(record);
	}

}

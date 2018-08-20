package com.shensu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.SwiperMapper;
import com.shensu.pojo.Swiper;
import com.shensu.service.SwiperService;

@Service("SwiperService")
public class SwiperServiceImpl implements SwiperService {
	
    @Autowired
	SwiperMapper swiperMapper;
    
	//增加轮播图
	@Override
	public int inserSwiper(Swiper swiper) {
     return swiperMapper.inserSwiper(swiper);
	}
	
	//删除一张轮播图
	@Override
	public int deleteSwiper(Integer swiperid) {
		return swiperMapper.deleteSwiper(swiperid);
	}
	
	//展示全部轮播图
	@Override
	public List<Swiper> findAllSwiper() {
		return swiperMapper.findAllSwiper();
	}
	
	@Override
	public int deleteAllSwiper() {
		// TODO Auto-generated method stub
		return swiperMapper.deleteAllSwiper();
	}

	@Override
	public Swiper findByLocation(int location) {
		// TODO Auto-generated method stub
		return swiperMapper.findByLocation(location);
	}

	@Override
	public int update(Swiper record) {
		// TODO Auto-generated method stub
		return swiperMapper.updateByPrimaryKeySelective(record);
	}
	
//	
//   //修改轮播图的方法
//	@Override
//	public void updataSwiper(Swiper s) {
//		// TODO 自动生成的方法存根
//       
//	}
//	
//	//根據主鍵查詢對應的图片
//	@Override
//	public Swiper selectByPrimaryKey(Integer swiperid) {
//		// TODO Auto-generated method stub
//		return swiperMapper.selectByPrimaryKey(swiperid);
//	}
	
	
	}



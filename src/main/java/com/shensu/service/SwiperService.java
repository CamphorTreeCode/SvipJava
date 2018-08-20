package com.shensu.service;

import java.util.List;

import com.shensu.pojo.Swiper;
import com.shensu.pojo.Swiper;

/**
 * 
 * @author YUKI
 * 轮播图的接口
 */
public interface SwiperService {

	//增加轮播图的方法
	 int inserSwiper(Swiper swiper);
	 
	//删除一张轮播图
	 int deleteSwiper(Integer swiperid);
	 
	//查询全部的轮播图前三张
	List<Swiper> findAllSwiper();
	 
	 
//	 //修改轮播图的方法
//	 public void updataSwiper(Swiper s);
//	 //	查询全部的轮播图前三张
//	 List<Swiper> selectSwiperAll();
//	 //根据主键查询对应的图片
//	 Swiper selectByPrimaryKey(Integer swiperid);
	//删除全部轮播图
	int deleteAllSwiper();
	
	//查询特定位置轮播图
    Swiper findByLocation(int location);
	
    int update(Swiper record);
}

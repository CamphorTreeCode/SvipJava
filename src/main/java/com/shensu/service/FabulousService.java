package com.shensu.service;

import com.shensu.pojo.Fabulous;

public interface FabulousService {
	
	//获取用户openid是否点过赞(小程序)
	Integer findFabulousNum(Integer learningWorldId,String openId);
		
	//添加用户openid到点赞表
	int addUserOpen(Fabulous fabulous);
	
}

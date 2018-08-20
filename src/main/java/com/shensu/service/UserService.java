package com.shensu.service;

import java.util.List;

import com.shensu.pojo.User;

public interface UserService {
	
	//增加用户的方法
	int insetUser(User u);
	
	//根据id查询是否已经存在
	int selectUser(String openid);
	
	//根据用户openid查询用户信息(小程序)
	User findVIPCentre(String openid);
	
	
}

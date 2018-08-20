package com.shensu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.UserMapper;
import com.shensu.pojo.User;
import com.shensu.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	//增加用户的信息
	@Override
	public int insetUser(User u) {
		int rum = userMapper.insert(u);
		if(rum>0){
			System.out.println("增加成功！");
		}
		return rum;
	}
	
	//查询用户是否存在
	@Override
	public int selectUser(String openid) {
		int num  =userMapper.selectUserOpenid(openid);
//		表情转换
//	    user u  =userm.selectUserOne(openid);
//	    System.out.println(IsNomber.decodeString( u.getNickname())); 
		return num;
	}
	
	//根据用户openid查询用户信息(小程序)
	@Override
	public User findVIPCentre(String openid) {
		return userMapper.findVIPCentre(openid);
	}
	
	
	
}

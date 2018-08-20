package com.shensu.dao;

import com.shensu.pojo.User;

public interface UserMapper {

    int deleteByPrimaryKey(String openid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //增加用户
    int selectUserOpenid (String openid);
    
    //查詢用戶是否已经存在
    int selectUserOne(String s);
    
	//根据用户openid查询用户信息
	User findVIPCentre(String openid);
}
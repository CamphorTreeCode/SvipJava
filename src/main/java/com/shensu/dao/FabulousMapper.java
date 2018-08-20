package com.shensu.dao;

import org.apache.ibatis.annotations.Param;

import com.shensu.pojo.Fabulous;

public interface FabulousMapper {

    int deleteByPrimaryKey(Integer fabulousid);

    int insert(Fabulous record);

    int insertSelective(Fabulous record);

    Fabulous selectByPrimaryKey(Integer fabulousid);

    int updateByPrimaryKeySelective(Fabulous record);

    int updateByPrimaryKey(Fabulous record);
    
	//获取用户openid是否点过赞(小程序)
	Integer findFabulousNum(@Param("learningWorldId")Integer learningWorldId,@Param("openId")String openId);
  	
  	//添加用户openid到点赞表
  	int addUserOpen(Fabulous fabulous);
}
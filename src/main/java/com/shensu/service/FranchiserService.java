package com.shensu.service;

import java.util.List;

import com.shensu.pojo.Franchiser;
import com.shensu.pojo.FranchiserUser;
import com.shensu.tool.Page;

public interface FranchiserService {
	//分页查询加盟者列表
	Page<Franchiser> selectByCondition(
			int currentPage,String franchiserName,String franchiseCreatTime,String franchiseOrderNmuber);
	
	//删除加盟者信息
	int deleteFranchiser(int franchiserId);
	
	//查找一个加盟者信息
	Franchiser findFranchiserDetails(int franchiserId);
	
	//审核成功
	int auditSuccess(int franchiserId);
	
	//审核失败
	int auditFail(int franchiserId);
	
	//查询全部加盟列表
	List<Franchiser> findAllFranchiserDetails(Franchiser franchiser);
	
	//根据加盟者id查询openId
	int findFranchiserOpenId(int franchiserId);
	
	//添加加盟者申请信息(小程序)
	int addFranchiserMsg(Franchiser franchiser);
	
	//统计申请加盟管理未读总数
	int findAllUnRead();
	
	//设置阅读状态为已读
	int finishRead(int franchiserId);
	
	//查询申请者申请状态(小程序)
	int findFranchiserState(int franchiserId);
    //根据openid查询加盟者信息（小程序）
	Franchiser findOpenidState(String openid);
   //修改加盟者信息
	int updateFranchiser(Franchiser franchiser);
   //加盟者pid
	FranchiserUser findUserPId(String openid);

   //根据openid来查询模版消息 
	Franchiser findOpenidTemplate(Franchiser franchiser);


	//根据openid修改加盟状态
	int updateFranchiserState(String openId);
	
	//根据openid删除加盟信息
	int deleteFranchiserByOpenId(String openId);
	//根据openid查询加盟信息
	Franchiser findByOpenid(String openId);

}

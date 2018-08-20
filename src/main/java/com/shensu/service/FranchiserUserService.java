package com.shensu.service;

import java.util.List;
import com.shensu.pojo.FranchiserUser;
import com.shensu.tool.Page;


public interface FranchiserUserService {
	
	 //添加加盟者账号
	 int insertFranchiserUser (FranchiserUser franchiserUser);
	 
	 //修改加盟者账号
	 int modifyFranchiserUser(FranchiserUser franchiserUser);
	 
	 //根据加盟者ID查询账号信息
	 FranchiserUser findByFranchiserUser(Integer franchiserUserId);
	 
	 //删除加盟者账号信息
	 int deleteFranchiserUser(Integer franchiserUserId);
	 
	 //分页查询加盟者列表
		Page<FranchiserUser> selectByCondition(
				int currentPage,String franchiserUserUserName,String franchiserUserAccounts ,String franchiserUserPid);
		
	 //根据openid查询加盟者信息
	 int findUser(String openId);

	//查询加盟者全部列表
	 List<FranchiserUser> findAllFranchiserUserDetails(FranchiserUser franchiserUser);
	 
	 //查询编辑账号全部信息(除了本条信息之外的)
	 List<FranchiserUser> editFranchiserUser(Integer franchiseruserid);
}

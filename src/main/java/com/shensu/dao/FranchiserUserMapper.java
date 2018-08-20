package com.shensu.dao;

import java.util.HashMap;
import java.util.List;

import com.shensu.pojo.Franchiser;
import com.shensu.pojo.FranchiserUser;


public interface FranchiserUserMapper {

    int deleteByPrimaryKey(Integer franchiseruserid);

    int insert(FranchiserUser record);

    int insertSelective(FranchiserUser record);

    FranchiserUser selectByPrimaryKey(Integer franchiseruserid);

    int updateByPrimaryKeySelective(FranchiserUser record);

    int updateByPrimaryKey(int franchiserUserId);
    
  	//添加加盟者账号信息
    int insertFranchiserUser(FranchiserUser franchiserUser);
    
   //根据加盟者openId查询用户信息
  	int findUser(String openId);
  	
  	//根据条件分页
    List<FranchiserUser> selectByCondition(HashMap<String,Object> map);
    
    //根据条件查总数
    int selectCountByCondition(HashMap<String,Object> map);
    
    //根据加盟者id查询用户信息
    FranchiserUser findFranchiserUser(Integer franchiseruserid);
    
    //修改加盟者信息
    int modifyFranchiserUser(FranchiserUser franchiserUser);
    
    //删除加盟者信息
    int deleteFranchiserUser(int franchiserUserId);
    
    //查询加盟者账号全部列表
    List<FranchiserUser> findAllFranchiserUserDetails(FranchiserUser franchiserUser);
    //用户查询pid
    FranchiserUser findUserPId(String openId);
    
    //查询编辑账号全部信息(除了本条信息之外的)
  	List<FranchiserUser> editFranchiserUser(Integer franchiseruserid);
      

}
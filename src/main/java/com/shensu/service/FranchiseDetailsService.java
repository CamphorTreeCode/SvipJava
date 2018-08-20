package com.shensu.service;

import java.util.List;

import com.shensu.pojo.FranchiseDetails;

/**
 * 
 * @author YUKI
 *  加盟展示资料修改
 */
public interface FranchiseDetailsService {

    //修改加盟的消息
	public int updataFranchiseDetails(FranchiseDetails f);

	
	//增加加盟页面信息
	int addFranchiseDetails(FranchiseDetails franchiseDetails);
	

    //查询加盟的信息	

	public FranchiseDetails selectFranchisseDetails(FranchiseDetails f);

	public FranchiseDetails findFranchiseDetails(FranchiseDetails franchiseDetails);
	
//    //修改加盟的消息
//	public int updataFranchiseDetails(FranchiseDetails franchiseDetails);

	//查询出所有的加盟者信息
    List<FranchiseDetails> HtFindFranchiseDetails();
    
    //删除所有加盟者信息
    int deleteAll();
	
}

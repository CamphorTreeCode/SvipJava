package com.shensu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.FranchiseDetailsMapper;
import com.shensu.pojo.FranchiseDetails;
import com.shensu.service.FranchiseDetailsService;

/**
 * 
 * @author YUKI 加盟展示的信息的增删查改
 */
@Service("FranchiseDetailsService")
public class FranchiseDetailsServiceImpl implements FranchiseDetailsService {
	@Autowired
	FranchiseDetailsMapper franchiseDetailsMapper;
	// 修改加盟信息
//	@Override
//	public int updataFranchiseDetails(FranchiseDetails f) {
//	// TODO 自动生成的方法存根
//		return franchiseDetailsMapper.updataFranchiseDetails(f);
//	}

	// 查询加盟信息

	
	//增加加盟者页面信息
	@Override
	public int addFranchiseDetails(FranchiseDetails franchiseDetails) {
		return franchiseDetailsMapper.addFranchiseDetails(franchiseDetails);
	}
	
    //查询加盟信息

	@Override
	public FranchiseDetails selectFranchisseDetails(FranchiseDetails f) {
	// TODO 自动生成的方法存根
       return franchiseDetailsMapper.selectFranchiseDetails(f);
	}
	
	//查询加盟信息(小程序)
	public FranchiseDetails findFranchiseDetails(FranchiseDetails franchiseDetails) {
		return franchiseDetailsMapper.findFranchiseDetails(franchiseDetails);	
	}



	 //修改加盟信息
	@Override
	public int updataFranchiseDetails(FranchiseDetails franchiseDetails) {
		return franchiseDetailsMapper.updataFranchiseDetails(franchiseDetails);
	}

	@Override
	public List<FranchiseDetails> HtFindFranchiseDetails() {
		// TODO Auto-generated method stub
		return franchiseDetailsMapper.HtFindFranchiseDetails();
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return franchiseDetailsMapper.deleteAll();
	}
	
	




	


     
}

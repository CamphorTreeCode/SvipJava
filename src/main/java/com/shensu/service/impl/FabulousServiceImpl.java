package com.shensu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.FabulousMapper;
import com.shensu.pojo.Fabulous;
import com.shensu.service.FabulousService;

@Service("FabulousService")
public class FabulousServiceImpl implements FabulousService {
	
	@Autowired
	FabulousMapper fabulousMapper;
	@Override
	public Integer findFabulousNum(Integer learningWorldId,String openId) {
		return fabulousMapper.findFabulousNum(learningWorldId,openId);
	}
	
	//添加点赞信息
	@Override
	public int addUserOpen(Fabulous fabulous) {
		return fabulousMapper.addUserOpen(fabulous);
	}
	
}

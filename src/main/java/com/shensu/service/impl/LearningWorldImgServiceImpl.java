package com.shensu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.LearningWorldImgMapper;
import com.shensu.pojo.LearningWorldImg;
import com.shensu.service.LearningWorldImgService;
@Service("LearningWorldImgService")
public class LearningWorldImgServiceImpl implements LearningWorldImgService {
    
	@Autowired
	LearningWorldImgMapper learningWorldImgMapper;
	
	
	@Override
	public int insert(LearningWorldImg ls) {
		// TODO Auto-generated method stub
		return learningWorldImgMapper.insert(ls);
	}

	@Override
	public int del(int lsId) {
		// TODO Auto-generated method stub
		return learningWorldImgMapper.deleteByPrimaryKey(lsId);
	}
	
	

}

package com.shensu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.AboutMeMapper;
import com.shensu.pojo.AboutMe;
import com.shensu.service.AboutMeService;

@Service("AboutMeService")
public class AboutMeServiceImpl implements AboutMeService {
	
	@Autowired
	AboutMeMapper aboutMeMapper;
	//查询关于我们的内容
	@Override
	public List<AboutMe> findAboutMeDetails() {
		return aboutMeMapper.findAboutMeDetails();
	}
	
	//增加关于我们的内容
	@Override
	public int addAboutMe(AboutMe aboutMe) {
		return aboutMeMapper.addAboutMe(aboutMe);
	}
	
	//修改关于我们的内容
	@Override
	public int modifyAboutMe(AboutMe aboutMe) {
		return aboutMeMapper.modifyAboutMe(aboutMe);
	}

	@Override
	public int deleteByPrimaryKey() {
		// TODO Auto-generated method stub
		return aboutMeMapper.deleteByPrimaryKey();
	}

}

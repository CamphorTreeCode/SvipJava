package com.shensu.service;

import java.util.List;

import com.shensu.pojo.AboutMe;

public interface AboutMeService {
	
	//查询关于我们的内容
	List<AboutMe> findAboutMeDetails ();
	
	//增加关于我们的内容
	int addAboutMe(AboutMe aboutMe);
	
	//修改关于我们的内容
	int modifyAboutMe(AboutMe aboutMe);
	//删除关于我们的内容
	int deleteByPrimaryKey();
	
}

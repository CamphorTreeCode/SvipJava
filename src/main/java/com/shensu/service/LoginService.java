package com.shensu.service;

import com.shensu.pojo.Admin;

public interface LoginService {
	
	//直接登录 返回admin对象
    Admin selectAdmin(Admin adm);
	
  	//修改管理员
  	int updateAdmin(Admin adm);
}

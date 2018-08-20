package com.shensu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.AdminMapper;
import com.shensu.pojo.Admin;
import com.shensu.service.LoginService;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin selectAdmin(Admin adm) {
		// TODO Auto-generated method stub
		return adminMapper.selectAdmin(adm);
	}
	
	//修改管理员信息
	@Override
	public int updateAdmin(Admin adm) {
		return adminMapper.updateByPrimaryKeySelective(adm);
	}
  

}

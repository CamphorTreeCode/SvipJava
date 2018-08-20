package com.shensu.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.FranchiserUserMapper;
import com.shensu.pojo.FranchiserUser;
import com.shensu.service.FranchiserUserService;
import com.shensu.tool.Page;


@Service("FranchiserUserService")
public class FranchiserUserServiceImpl implements FranchiserUserService {
	
	@Autowired
	FranchiserUserMapper franchiserUserMapper;
	
	//增加加盟者账号信息
	@Override
	public int insertFranchiserUser(FranchiserUser franchiserUser) {
		return franchiserUserMapper.insertFranchiserUser(franchiserUser);
	}
	
	//修改加盟者账号信息
	@Override
	public int modifyFranchiserUser(FranchiserUser franchiserUser) {

		return franchiserUserMapper.modifyFranchiserUser(franchiserUser);
	}
	
	//根据加盟者id查询加盟者账号数据
	@Override
	public FranchiserUser findByFranchiserUser(Integer franchiserUserId) {
		return franchiserUserMapper.findFranchiserUser(franchiserUserId);
	}
	
	//删除加盟者账号信息
	@Override
	public int deleteFranchiserUser(Integer franchiserUserId) {

		return franchiserUserMapper.deleteFranchiserUser(franchiserUserId);
	}
	
		//根据条件分页
		@Override
		public Page<FranchiserUser> selectByCondition(
				int currentPage, String franchiserUserUserName, String franchiserUserAccounts, String franchiserUserPid) {
			HashMap<String,Object> map = new HashMap<String,Object>();
			HashMap<String,Object> map1 = new HashMap<String,Object>();
			map1.put("franchiserUserUserName", franchiserUserUserName);
			map1.put("franchiserUserAccounts", franchiserUserAccounts);
			map1.put("franchiserUserPid", franchiserUserPid);
			Page<FranchiserUser> pageBean = new Page<FranchiserUser>();

			//封装当前页数
			pageBean.setCurrPage(currentPage);

			//每页显示的数据
			int pageSize=6;
			pageBean.setPageSize(pageSize);

			//封装总记录数
			int totalCount = franchiserUserMapper.selectCountByCondition(map1);
			pageBean.setTotalCount(totalCount);
			System.out.println(totalCount);
			//封装总页数
			double tc = totalCount;
			Double num =Math.ceil(tc/pageSize);//向上取整
			pageBean.setTotalPage(num.intValue());

			map.put("start",(currentPage-1)*pageSize);
			map.put("size", pageBean.getPageSize());
			map.put("franchiserUserUserName", franchiserUserUserName);
			map.put("franchiserUserAccounts", franchiserUserAccounts);
			map.put("franchiserUserPid", franchiserUserPid);
			//封装每页显示的数据
			List<FranchiserUser> lists = franchiserUserMapper.selectByCondition(map);
			pageBean.setLists(lists);
			return pageBean;
		}
	
	//根据加盟者id查询用户openId信息 
	@Override
	public int findUser(String openId) {
		
		return franchiserUserMapper.findUser(openId);
	}


	//查询加盟者账号全部列表
	public List<FranchiserUser> findAllFranchiserUserDetails(FranchiserUser franchiserUser) {
		return franchiserUserMapper.findAllFranchiserUserDetails(franchiserUser);
	}
	
	//查询编辑账号全部信息(除了本条信息之外的)
	@Override
	public List<FranchiserUser> editFranchiserUser(Integer franchiseruserid) {
		return franchiserUserMapper.editFranchiserUser(franchiseruserid);
	}


}

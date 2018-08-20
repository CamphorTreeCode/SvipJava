package com.shensu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.FranchiserMapper;
import com.shensu.dao.FranchiserUserMapper;
import com.shensu.pojo.Franchiser;
import com.shensu.pojo.FranchiserUser;
import com.shensu.service.FranchiserService;
import com.shensu.tool.Page;

@Service("FranchiserService")
public class FranchiserServiceImpl implements FranchiserService{
	
	@Autowired
	FranchiserMapper franchiserMapper;
	@Autowired
	FranchiserUserMapper franchiserUserMapper;
	
	//根据条件分页
	@Override
	public Page<Franchiser> selectByCondition(
			int currentPage, String franchiserName, String franchiseCreatTime, String franchiseOrderNmuber) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		HashMap<String,Object> map1 = new HashMap<String,Object>();
		map1.put("franchiserName", franchiserName);
		map1.put("franchiseCreatTime", franchiseCreatTime);
		map1.put("franchiseOrderNmuber", franchiseOrderNmuber);
		Page<Franchiser> pageBean = new Page<Franchiser>();

		//封装当前页数
		pageBean.setCurrPage(currentPage);

		//每页显示的数据
		int pageSize=6;
		pageBean.setPageSize(pageSize);

		//封装总记录数
		int totalCount = franchiserMapper.selectCountByCondition(map1);
		pageBean.setTotalCount(totalCount);
		System.out.println(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("franchiserName", franchiserName);
		map.put("franchiseCreatTime", franchiseCreatTime);
		map.put("franchiseOrderNmuber", franchiseOrderNmuber);
		//封装每页显示的数据
		List<Franchiser> lists = franchiserMapper.selectByCondition(map);
		pageBean.setLists(lists);
		return pageBean;
	}

	//删除加盟者信息
	@Override
	public int deleteFranchiser(int franchiserId) {
		return franchiserMapper.deleteByPrimaryKey(franchiserId);
	}

	//查找一个加盟者信息
	@Override
	public Franchiser findFranchiserDetails(int franchiserId) {
		return franchiserMapper.findFranchiserDetails(franchiserId);
	}

	//申请成功
	@Override
	public int auditSuccess(int franchiserId) {
		return franchiserMapper.auditSuccess(franchiserId);
	}
	
	//申请失败
	@Override
	public int auditFail(int franchiserId) {
		return franchiserMapper.auditFail(franchiserId);
	}
	
	//查询加盟者全部列表
	public List<Franchiser> findAllFranchiserDetails(Franchiser franchiser) {
		return franchiserMapper.findAllFranchiserDetails(franchiser);
	}
	
	//根据加盟者id查询openId
	@Override
	public int findFranchiserOpenId(int franchiserId) {
		return franchiserMapper.findFranchiserOpenId(franchiserId);
	}
	
	//添加加盟者申请信息(小程序)
	@Override
	public int addFranchiserMsg(Franchiser franchiser) {
		return franchiserMapper.addFranchiserMsg(franchiser);
	}
	
	//统计申请加盟管理未读总数
	@Override
	public int findAllUnRead() {
		return franchiserMapper.findAllUnRead();
	}
	
	//设置阅读状态为已读
	@Override
	public int finishRead(int franchiserId) {
		return franchiserMapper.finishRead(franchiserId);
	}
	
	//查询申请者申请状态(小程序)
	@Override
	public int findFranchiserState(int franchiserId) {
		return franchiserMapper.findFranchiserState(franchiserId);
	}
 
	//根据openid查询加盟者信息(小程序)
	@Override
	public Franchiser findOpenidState(String openid) {
		// TODO 自动生成的方法存根
		return franchiserMapper.findOpenidState(openid);
	}
    // 修改加盟者信息(小程序)
	@Override
	public int updateFranchiser(Franchiser franchiser) {
		// TODO 自动生成的方法存根
		return franchiserMapper.updateFranchiser(franchiser);
	}
   //寻找用户的pid
	@Override
	public FranchiserUser findUserPId(String openid) {
		// TODO 自动生成的方法存根
		return franchiserUserMapper.findUserPId(openid);
	}

	//根据openid来查询用户的模版消息
	@Override
	public Franchiser findOpenidTemplate(Franchiser franchiser) {
		// TODO 自动生成的方法存根
		return franchiserMapper.findOpenidTemplate(franchiser);
	}
	
	//根据openid修改加盟状态
	@Override
	public int updateFranchiserState(String openId) {
		
		return franchiserMapper.updateFranchiserState(openId);
	}
    //根据openid删除加盟信息
	@Override
	public int deleteFranchiserByOpenId(String openId) {
		// TODO Auto-generated method stub
		return franchiserMapper.deleteFranchiserByOpenId(openId);
	}

	@Override
	public Franchiser findByOpenid(String openId) {
		// TODO Auto-generated method stub
		return franchiserMapper.findByOpenid(openId);
	}

	
}

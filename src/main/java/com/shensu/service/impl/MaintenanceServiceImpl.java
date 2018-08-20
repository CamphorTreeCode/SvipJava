package com.shensu.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.MaintenanceMapper;
import com.shensu.pojo.Maintenance;
import com.shensu.service.MaintenanceService;
import com.shensu.tool.Page;

@Service("MaintenanceService")
public class MaintenanceServiceImpl implements MaintenanceService {
	
	@Autowired
	MaintenanceMapper maintenanceMapper;
	
	//添加维修申请信息(小程序)
	@Override
	public int addMaintenanceMsg(Maintenance maintenance) {
		return maintenanceMapper.addMaintenanceMsg(maintenance);
	}
	
	//分业查询
	@Override
	public Page<Maintenance> selectByCondition(
			int currentPage, String maintenanceName, String maintenancemodel,String maintenancePhone) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		HashMap<String,Object> map1 = new HashMap<String,Object>();
		map1.put("maintenanceName", maintenanceName);
		map1.put("maintenancemodel", maintenancemodel);
		map1.put("maintenancePhone", maintenancePhone);
		
		Page<Maintenance> pageBean = new Page<Maintenance>();

		//封装当前页数
		pageBean.setCurrPage(currentPage);

		//每页显示的数据
		int pageSize=6;
		pageBean.setPageSize(pageSize);

		//封装总记录数
		int totalCount = maintenanceMapper.selectCountByCondition(map1);
		pageBean.setTotalCount(totalCount);
		System.out.println(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("maintenanceName", maintenanceName);
		map.put("maintenancemodel", maintenancemodel);
		map.put("maintenancePhone", maintenancePhone);
		//封装每页显示的数据
		List<Maintenance> lists = maintenanceMapper.selectByCondition(map);
		pageBean.setLists(lists);
		return pageBean;
	}
	
	//查询单条维修全部信息
	@Override
	public Maintenance findMaintenanceMsgDetails(Integer maintenanceId) {
		return maintenanceMapper.findMaintenanceMsgDetails(maintenanceId);
	}
	
	//审核通过
	@Override
	public int auditSuccess(int maintenanceId) {
		return maintenanceMapper.auditSuccess(maintenanceId);
	}
	
	//审核不通过
	@Override
	public int auditFail(int maintenanceId) {
		return maintenanceMapper.auditFail(maintenanceId);
	}
	
	//删除维修申请信息
	@Override
	public int deleteMaintenanceMsg(int maintenanceId) {
		return maintenanceMapper.deleteMaintenanceMsg(maintenanceId);
	}
	
	//设置阅读状态为已读
	@Override	
	public int finishRead(int maintenanceId) {
		return maintenanceMapper.finishRead(maintenanceId);
	}
	
	//统计维修管理未读总数
	@Override
	public int findAllUnRead() {
		return maintenanceMapper.findAllUnRead();
	}
	
	

}

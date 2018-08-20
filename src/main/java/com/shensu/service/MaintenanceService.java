package com.shensu.service;

import com.shensu.pojo.Maintenance;
import com.shensu.tool.Page;

public interface MaintenanceService {
	
	//添加维修申请信息(小程序)
	int addMaintenanceMsg(Maintenance maintenance);
	
	//分页查询加盟者列表
			Page<Maintenance> selectByCondition(
					int currentPage,String maintenanceName,String maintenancemodel,String maintenancePhone);
	//查询单条维修全部信息
	Maintenance findMaintenanceMsgDetails(Integer maintenanceId);
	
	//审核成功
	int auditSuccess(int maintenanceId);
		
	//审核不通过
	int auditFail(int maintenanceId);
	
	//删除维修申请信息
	int deleteMaintenanceMsg(int maintenanceId);
	
	//设置阅读状态为已读
	int finishRead(int maintenanceId);
	
	//统计维修管理未读总数
	int findAllUnRead();
	
}
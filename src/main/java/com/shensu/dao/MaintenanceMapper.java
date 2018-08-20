package com.shensu.dao;

import java.util.HashMap;
import java.util.List;
import com.shensu.pojo.Maintenance;

public interface MaintenanceMapper {

    int deleteByPrimaryKey(Integer maintenanceid);

    int insert(Maintenance record);

    int insertSelective(Maintenance record);

    Maintenance selectByPrimaryKey(Integer maintenanceid);

    int updateByPrimaryKeySelective(Maintenance record);

    int updateByPrimaryKey(Maintenance record);
    
	//添加维修申请信息(小程序)
	int addMaintenanceMsg(Maintenance maintenance);
	
	//根据条件分页
    List<Maintenance> selectByCondition(HashMap<String,Object> map);
    
    //根据条件查总数
    int selectCountByCondition(HashMap<String,Object> map);
    
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
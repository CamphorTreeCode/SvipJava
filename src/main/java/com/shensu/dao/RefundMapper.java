package com.shensu.dao;

import java.util.HashMap;
import java.util.List;

import com.shensu.pojo.Refund;
public interface RefundMapper {
	
	int addRefund(Refund refund);//申请退款
	
	List<Refund> findListCondition(HashMap<String, Object> map);//根据条件分页查询退款列表
	
	int findCountCondition(HashMap<String, Object> map);//根据条件查询分页数量
	
	Refund findByRefundId(int refundId);//根据id查询
	
	int updateRefund(Refund refund);//修改退款列表
	
	int deleteRefund(int refundId);
	

}

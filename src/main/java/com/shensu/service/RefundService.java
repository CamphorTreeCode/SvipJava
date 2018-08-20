package com.shensu.service;


import com.shensu.pojo.Refund;
import com.shensu.tool.Page;

public interface RefundService {
	
	int addRefund(Refund refund);
	
	Page findListCondition(int currentPage,Refund refund);
	
	Refund findByRefundId(int refundId);//根据id查询
	
	int updateRefund(Refund refund);//修改退款列表
	
	int deleteRefund(int refundId);//根据id删除一条退款信息

}

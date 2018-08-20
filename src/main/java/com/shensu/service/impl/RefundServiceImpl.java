package com.shensu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.RefundMapper;
import com.shensu.pojo.Refund;
import com.shensu.service.RefundService;
import com.shensu.tool.Page;
@Service("RefundService")
public class RefundServiceImpl implements RefundService {
	
	@Autowired
	RefundMapper refundMapper;

	@Override
	public int addRefund(Refund refund) {
		// TODO Auto-generated method stub
		return refundMapper.addRefund(refund);
	}

	@Override
	public Page findListCondition(int currentPage, Refund refund) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name", refund.getName());
		map.put("phone", refund.getPhone());
		map.put("refundState", refund.getRefundState());
		Page<Refund> pageBean = new Page<Refund>();
		
		//封装当前页数
		pageBean.setCurrPage(currentPage);

		//每页显示的数据
		int pageSize=5;
		pageBean.setPageSize(pageSize);

		//封装总记录数
		int totalCount = refundMapper.findCountCondition(map);
		pageBean.setTotalCount(totalCount);
		/*System.out.println(totalCount);*/
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		//封装每页显示的数据
		List<Refund> lists = refundMapper.findListCondition(map);
		pageBean.setLists(lists);
		return pageBean;
	}

	@Override
	public Refund findByRefundId(int refundId) {
		// TODO Auto-generated method stub
		return refundMapper.findByRefundId(refundId);
	}

	@Override
	public int updateRefund(Refund refund) {
		// TODO Auto-generated method stub
		return refundMapper.updateRefund(refund);
	}

	@Override
	public int deleteRefund(int refundId) {
		// TODO Auto-generated method stub
		return refundMapper.deleteRefund(refundId);
	}

}

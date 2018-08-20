package com.shensu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.OrdersMapper;
import com.shensu.dao.RecipesMapper;
import com.shensu.pojo.Orders;
import com.shensu.service.OrderService;
@Service("OrderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrdersMapper ordersMapper;
	
	@Override
	public Orders selectByPrimaryKey(Integer orderId) {
		// TODO Auto-generated method stub
		return ordersMapper.selectByPrimaryKey(orderId);
	}

}

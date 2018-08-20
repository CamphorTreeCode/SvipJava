package com.shensu.service;

import com.shensu.pojo.Orders;

public interface OrderService {
	Orders selectByPrimaryKey(Integer orderId);
}

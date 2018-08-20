package com.shensu.dao;

import com.shensu.pojo.Orders;
import com.shensu.pojo.Recipes;

public interface OrdersMapper {

	Orders selectByPrimaryKey(Integer orderId);
	
}

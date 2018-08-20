package com.shensu.pojo;

public class Orders {
	//订单的唯一标识，自增id
	private Integer orderId;
	//用户的唯一标识
	private String openId;
	//订单的创建时间
	private String orderCreateTime;
	//订单状态，0代表未通过审核，1代表通过审核、
	private Integer orderStatus;
	//订单编号
	private String orderNumber;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOrderCreateTime() {
		return orderCreateTime;
	}
	public void setOrderCreateTime(String orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	@Override
	public String toString() {
		return "orders [orderId=" + orderId + ", openId=" + openId + ", orderCreateTime=" + orderCreateTime
				+ ", orderStatus=" + orderStatus + ", orderNumber=" + orderNumber + "]";
	}
	
}

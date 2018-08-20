package com.shensu.pojo;

public class Refund {
	
	private int refundId;//订单id
	
	private String openId;//用户openid
	
	private float money;//退款金额
	
	private String refundReason;//退款理由
	
	private String name;//退款人姓名
	
	private String refundCreateTime;//申请退款时间
	
	private int refundState;//退款状态  0 待审核  1 已退款  2 不通过
	
	private String phone;//退款人电话
	
	private String formId;//小程序端提交的表单id 用于发送模板消息
	
	private String partner_trade_no;//微信企业打款的商户订单号;
	
	private String platform;//退款的商品平台

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public int getRefundId() {
		return refundId;
	}

	public void setRefundId(int refundId) {
		this.refundId = refundId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRefundCreateTime() {
		return refundCreateTime;
	}

	public void setRefundCreateTime(String refundCreateTime) {
		this.refundCreateTime = refundCreateTime;
	}

	public int getRefundState() {
		return refundState;
	}

	public void setRefundState(int refundState) {
		this.refundState = refundState;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}

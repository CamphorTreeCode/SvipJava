package com.shensu.service;

import com.shensu.pojo.MyCard;
import com.shensu.tool.Page;

//卡卷中心
public interface MyCardService {
    //增加卡卷中心
	public int insertMyCard(MyCard mc);
	//分页查询
	public Page<MyCard> select(int currentPage,MyCard mc);
	//查询卡卷数据是否有没有
	public int selectCardIs(MyCard mc);
	//根据商品id删除优惠券
	int deleteMyCardByShopId(int shopId);
	//根据openid删除优惠券
	int deleteMyCardByOpenidId(String openId);
}

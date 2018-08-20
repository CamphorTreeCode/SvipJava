package com.shensu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.MyCardMapper;
import com.shensu.pojo.MyCard;
import com.shensu.service.MyCardService;
import com.shensu.tool.Page;
@Service
public class MyCardServiceImpl implements MyCardService{
    //增加卡卷中心
	@Autowired
	MyCardMapper myCardMapper;
	//增加卡卷
	@Override
	public int insertMyCard(MyCard mc) {
		// TODO 自动生成的方法存根
		return myCardMapper.insertSelective(mc);
	}
    //卡卷中心的分页查询
	@Override
	public Page<MyCard> select(int currentPage,MyCard mc) {
		// TODO 自动生成的方法存根
		HashMap<String,Object> map = new HashMap<String,Object>();
        Page<MyCard> pageBean = new Page<MyCard>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=7;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = myCardMapper.selectCountCard(mc);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue() );      
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("openid",mc.getOpenid());
        //封装每页显示的数据
        List<MyCard> lists = myCardMapper.selectMycardPage(map);
        pageBean.setLists(lists);
        return pageBean;	
	}
	
	//查询卡卷的id有没有
	@Override
	public int selectCardIs(MyCard mc) {
		
		return myCardMapper.selectHaveIs(mc);
	}
	@Override
	public int deleteMyCardByShopId(int shopId) {
		// TODO Auto-generated method stub
		return myCardMapper.deleteMyCardByShopId(shopId);
	}
	@Override
	public int deleteMyCardByOpenidId(String openId) {
		// TODO Auto-generated method stub
		return myCardMapper.deleteMyCardByOpenidId(openId);
	}

}

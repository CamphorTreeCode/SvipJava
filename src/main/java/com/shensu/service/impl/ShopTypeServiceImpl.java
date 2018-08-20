package com.shensu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.ShopTypeMapper;
import com.shensu.pojo.ShopType;
import com.shensu.service.ShopTypeService;
@Service("ShopTypeService")
public class ShopTypeServiceImpl implements ShopTypeService {
    @Autowired
    ShopTypeMapper shopTypeMapper;
	
	//查询全部商品类别
	@Override
	public List<ShopType> selectAll() {
		// TODO Auto-generated method stub
		return shopTypeMapper.selectAll();
	}
    //根据id查询单个商品类别
	@Override
	public ShopType selectById(int shopTypeId) {
		// TODO Auto-generated method stub
		return shopTypeMapper.selectByPrimaryKey(shopTypeId);
	}
    //添加一个商品类别
	@Override
	public int insertShopType(ShopType st) {
		// TODO Auto-generated method stub
		return shopTypeMapper.insert(st);
	}
    //根据id删除商品类别
	@Override
	public int deleteShopType(int shopTypeId) {
		// TODO Auto-generated method stub
		return shopTypeMapper.deleteByPrimaryKey(shopTypeId);
	}
    //修改一个商品类别
	@Override
	public int updateShopType(ShopType st) {
		// TODO Auto-generated method stub
		return shopTypeMapper.updateByPrimaryKeySelective(st);
	}
	
	//替换商品类目的展示图片
	@Override
	public int updateShopTypeImg(ShopType st) {
		return shopTypeMapper.updateShopTypeImg(st);
	}
	
	//根据商品类目id查询页面信息
	@Override
	public ShopType findShopTypeImg(int shopTypeId) {
		return shopTypeMapper.findShopTypeImg(shopTypeId);
	}
	
	//删除(设置为空)商品类目图片
	@Override
	public int deleteShopTypeImg(int shopTypeId) {
		return shopTypeMapper.deleteShopTypeImg(shopTypeId);
	}
	
	//根据商品类目id查询出商品的图片(小程序)
	@Override
	public List<ShopType> findShopTypeImg() {
		return shopTypeMapper.findShopType();
	}
	//微信小程序 每个分类查询商品的前两个商品
	@Override
	public List<ShopType> selectShopTypeTwo() {
		// TODO 自动生成的方法存根
		return shopTypeMapper.selectShopTypeTwo();
	}
	@Override
	public int getShopTypeIdByName(String shopTypeName) {
		
		return shopTypeMapper.getShopTypeIdByName(shopTypeName);
	}
	
	//查询全部类目(除了本条之外的)
	@Override
	public List<ShopType> editShopTypeXY(Integer shoptypeid) {
		
		return shopTypeMapper.editShopTypeXY(shoptypeid);
	}
	
}

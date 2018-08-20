package com.shensu.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.ShopMapper;
import com.shensu.pojo.Shop;
import com.shensu.pojo.ShopSwiper;
import com.shensu.service.ShopService;
import com.shensu.tool.Page;
@Service("ShopService")
public class ShopServiceImpl implements ShopService {
    
	@Autowired
	ShopMapper shopMapper;
	
	@Override
	//根据条件分页
	public Page<Shop> selectByCondition(int currentPage, String shopTitle, Integer shopId, 
			String shopName, Integer shopState, Integer shopTypeId) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		HashMap<String,Object> map1 = new HashMap<String,Object>();
		map1.put("shopTitle", shopTitle);
		map1.put("shopId", shopId);
		map1.put("shopName", shopName);
		map1.put("shopState", shopState);
		map1.put("shopTypeId", shopTypeId);
		Page<Shop> pageBean = new Page<Shop>();
		
		//封装当前页数
		pageBean.setCurrPage(currentPage);

		//每页显示的数据
		int pageSize=5;
		pageBean.setPageSize(pageSize);

		//封装总记录数
		int totalCount = shopMapper.selectCountByCondition(map1);
		pageBean.setTotalCount(totalCount);
		/*System.out.println(totalCount);*/
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("shopTitle", shopTitle);
		map.put("shopId", shopId);
		map.put("shopName", shopName);
		map.put("shopState", shopState);
		map.put("shopTypeId", shopTypeId);
		//封装每页显示的数据
		List<Shop> lists = shopMapper.selectByCondition(map);
	/*	System.out.println("分页page Lists 中shop 数量+++++++++++++++++++++++");
		System.out.println(lists.size());*/
		pageBean.setLists(lists);
		return pageBean;
	}
	@Override
	public int insertShop(Shop s) {
		// TODO Auto-generated method stub
		return shopMapper.insertShop(s);
	}
	
	@Override
	public Shop selectById(int shopId) {
		// TODO Auto-generated method stub
		return shopMapper.seleteByShopId(shopId);
	}
	
	@Override
	public int modifyShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.modifyShop(shop);
	}
	
	//添加商品图片信息
	@Override
	public int insertShopImg(ShopSwiper simg) {
		return shopMapper.insertShopImg(simg);
	}
	
	//删除商品信息
	@Override
	public int deleteShop(int shopId) {
		return shopMapper.deleteByPrimaryKey(shopId);
	}
	
	//根据shopId删除对应的所有图片
	@Override
	public int deleteShopSwiperImg(int shopId) {
		return shopMapper.deleteShopSwiperImg(shopId);
	}
	
	//设置商品为上架状态
	@Override
	public int putawayShop(int shopId) {
		return shopMapper.putawayShop(shopId);
	}
	
	//设置商品为上架状态
	@Override
	public int unshelveShop(int shopId) {
		return shopMapper.unshelveShop(shopId);
	}
	
	//根据商品id删除商品SKU信息
	@Override
	public int deleteShopSKU(int shopId) {

		return shopMapper.deleteShopSKU(shopId);
	}
	
	//根据商品类目查询商品信息(小程序)
	@Override
	public List<Shop> findHomePageShop(int shopTypeId) {
		return shopMapper.findHomePageShop(shopTypeId);
	}
	
	//根据商品类目id查询全部商品列表(小程序)
	@Override
	public List<Shop> findShopList(int shopTypeId) {
		return shopMapper.findShopList(shopTypeId);
	}
	
	//根据商品id查询商品详细信息(小程序)
	@Override
	public List<Shop> findShopDetails(int shopId) {
		return shopMapper.findShopDetails(shopId);
	}
	
	//根据商品的分类id分页查询数据
	@Override
	public Page<Shop> selectShopTypePage(int currentPage, Shop shop) {
		// TODO 自动生成的方法存根
		HashMap<String,Object> map = new HashMap<String,Object>();
        Page<Shop> pageBean = new Page<Shop>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=6;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = shopMapper.selectShopTypeIdCount(shop);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue() );      
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("shoptypeid",shop.getShoptypeid());
        map.put("shopTitle",shop.getShoptitle());
        System.out.println(shop.getShoptypeid()+shop.getShoptitle());
        //封装每页显示的数据
        List<Shop> lists = shopMapper.selectShopTypePage(map);
        pageBean.setLists(lists);
        return pageBean;	
	}
	@Override
	public Shop queryShopAllandSKUAll(Integer shopid) {
		
		return shopMapper.queryShopAllandSKUAll(shopid);
	}
	@Override
	public List<Shop> getAll() {
		// TODO Auto-generated method stub
		return shopMapper.getAll();
	}
	


}

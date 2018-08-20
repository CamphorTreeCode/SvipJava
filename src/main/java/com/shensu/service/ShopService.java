package com.shensu.service;

import java.util.List;

import com.shensu.pojo.Shop;
import com.shensu.pojo.ShopSwiper;
import com.shensu.tool.Page;

public interface ShopService {
	
	//根据条件分页查询
	Page<Shop> selectByCondition(int currentPage, String shopTitle, Integer shopId, String shopName, Integer shopState, Integer shopTypeId) ;
			
	//添加一个商品
	int insertShop(Shop s);
	
	//添加商品图片信息
	int insertShopImg(ShopSwiper simg);
	
	//删除一个商品
	int deleteShop(int shopId);
	
	//根据id查询一个商品
	Shop selectById(int shopId);
	
	//修改一个商品
	int modifyShop(Shop shop);
	
	//根据shopId删除对应的所有图片
	int deleteShopSwiperImg(int shopId);
	
	//设置商品为上架状态
	int putawayShop(int shopId);
	
	//设置商品为上架状态
	int unshelveShop(int shopId);
	
	//根据商品id删除商品呢SKU信息
	int deleteShopSKU(int shopId);
	
	//根据商品类目查询商品信息前两个(小程序)
	List<Shop> findHomePageShop(int shopTypeId);
	
	//查询商品类目下全部商品(小程序)
	List<Shop> findShopList(int shopTypeId);
	
	//根据shopid查询所有的轮播图、SKU、SKU轮播图
	Shop queryShopAllandSKUAll(Integer shopid);
	
	//根据商品id查询商品详细信息(小程序)
	List<Shop> findShopDetails(int shopId);
    //根据商品的分类id分页查询 
	Page<Shop> selectShopTypePage(int currentPage, Shop shop);
	//查询全部商品
	List<Shop> getAll();
}

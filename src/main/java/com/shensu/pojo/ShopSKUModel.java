package com.shensu.pojo;

import java.io.Serializable;
import java.util.List;


public class ShopSKUModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<ShopSKU> shopSKU;

	public List<ShopSKU> getShopSKU() {
		return shopSKU;
	}

	public void setShopSKU(List<ShopSKU> shopSKU) {
		this.shopSKU = shopSKU;
	}

	public ShopSKUModel(List<ShopSKU> shopSKU) {
		super();
		this.shopSKU = shopSKU;
	}
	
	public ShopSKUModel(){
		super();
	}
}

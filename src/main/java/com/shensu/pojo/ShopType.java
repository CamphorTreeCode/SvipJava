package com.shensu.pojo;

import java.io.Serializable;
import java.util.List;

public class ShopType implements Serializable {

	//商品的分类
    private Integer shoptypeid;
     
	//商品的名称
    private String shoptypename;

	//商品的分类
    private String shoptypecreatetime;
    
    //商品类目的展示图
    private String shoptypeimg;
    
   private  List<Shop> shop;
   
    
	/**
 * @return shop
 */
public List<Shop> getShop() {
	return shop;
}

/**
 * @param shop 要设置的 shop
 */
public void setShop(List<Shop> shop) {
	this.shop = shop;
}

	//商品的分类
    private static final long serialVersionUID = 1L;

	public Integer getShoptypeid() {
		return shoptypeid;
	}

	public void setShoptypeid(Integer shoptypeid) {
		this.shoptypeid = shoptypeid;
	}

	public String getShoptypename() {
		return shoptypename;
	}

	public void setShoptypename(String shoptypename) {
		this.shoptypename = shoptypename;
	}

	public String getShoptypecreatetime() {
		return shoptypecreatetime;
	}

	public void setShoptypecreatetime(String shoptypecreatetime) {
		this.shoptypecreatetime = shoptypecreatetime;
	}

	public String getShoptypeimg() {
		return shoptypeimg;
	}

	public void setShoptypeimg(String shoptypeimg) {
		this.shoptypeimg = shoptypeimg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shoptypecreatetime == null) ? 0 : shoptypecreatetime.hashCode());
		result = prime * result + ((shoptypeid == null) ? 0 : shoptypeid.hashCode());
		result = prime * result + ((shoptypeimg == null) ? 0 : shoptypeimg.hashCode());
		result = prime * result + ((shoptypename == null) ? 0 : shoptypename.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopType other = (ShopType) obj;
		if (shoptypecreatetime == null) {
			if (other.shoptypecreatetime != null)
				return false;
		} else if (!shoptypecreatetime.equals(other.shoptypecreatetime))
			return false;
		if (shoptypeid == null) {
			if (other.shoptypeid != null)
				return false;
		} else if (!shoptypeid.equals(other.shoptypeid))
			return false;
		if (shoptypeimg == null) {
			if (other.shoptypeimg != null)
				return false;
		} else if (!shoptypeimg.equals(other.shoptypeimg))
			return false;
		if (shoptypename == null) {
			if (other.shoptypename != null)
				return false;
		} else if (!shoptypename.equals(other.shoptypename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShopType [shoptypeid=" + shoptypeid + ", shoptypename=" + shoptypename + ", shoptypecreatetime="
				+ shoptypecreatetime + ", shoptypeimg=" + shoptypeimg + "]";
	}


}
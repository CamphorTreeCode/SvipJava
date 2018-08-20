package com.shensu.pojo;

import java.io.Serializable;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
@ApiModel(value = "com.shensu.pojo.Shop", description = "关于我们参数")
public class Shop implements Serializable {
	
	//商品的id
	@ApiModelProperty("商品的id")
    private Integer shopid;

    //商品的品牌
	@ApiModelProperty("商品的品牌")
    private String shopname;

    //商品的title
	@ApiModelProperty("商品的title")
    private String shoptitle;

    //商品的型号
	@ApiModelProperty("商品的型号")
    private String shopmodel;

    // 商品的上架的状态 0是下架 1是上架
	@ApiModelProperty("商品的上架的状态 0是下架 1是上架")
    private Integer shopstate;

    //商品的地址
	@ApiModelProperty("商品的地址")
    private String shopurl;

    // 商品的优惠券地址
	@ApiModelProperty("商品的优惠券地址")
    private String shopdiscounturl; 

    //商品的标签
	@ApiModelProperty("商品的标签")
    private String shoplable;
    
    //存放小程序的富文本内容
	@ApiModelProperty("存放小程序的富文本内容")
    private String shopcontent; 

    //商品的属性 存放json
	@ApiModelProperty("商品的属性 存放json")
    private String shopdetails;

    //分类的id
	@ApiModelProperty("分类的id")
    private Integer shoptypeid;

    //商品创建时间
	@ApiModelProperty("商品创建时间")
    private String shopcretattime; 
    
    //外键商品类型对象
	@ApiModelProperty("外键商品类型对象")
    ShopType shopType;
    
	//淘口令
	@ApiModelProperty("淘口令")
	String TaobaoToken;
	
	//存放商品图片的集合
	@ApiModelProperty("存放商品图片的集合")
	List<ShopSwiper> shopSwiperList;
	
	//一个商品SKUMoney
	@ApiModelProperty("一个商品SKUMoney")
	List<ShopSKU> shopSKUMoney;
	
	//一个商品的轮播图
	@ApiModelProperty("一个商品的轮播图")
	List<ShopSwiper> shopSwiperImg;
	
	//商品优惠面额
	@ApiModelProperty("商品优惠面额")
	private Float shopDiscountMoney;
	
	//游客优惠券地址
	@ApiModelProperty("游客优惠券地址")
	private String touristShopDiscountUrl;
	
	//游客优惠券面额
	@ApiModelProperty("游客商品优惠面额")
	private Float touristShopDiscountMoney;
	
    public String getTouristShopDiscountUrl() {
		return touristShopDiscountUrl;
	}

	public void setTouristShopDiscountUrl(String touristShopDiscountUrl) {
		this.touristShopDiscountUrl = touristShopDiscountUrl;
	}

	public Float getTouristShopDiscountMoney() {
		return touristShopDiscountMoney;
	}

	public void setTouristShopDiscountMoney(Float touristShopDiscountMoney) {
		this.touristShopDiscountMoney = touristShopDiscountMoney;
	}

	public Float getShopDiscountMoney() {
		return shopDiscountMoney;
	}

	public void setShopDiscountMoney(Float shopDiscountMoney) {
		this.shopDiscountMoney = shopDiscountMoney;
	}

	public List<ShopSKU> getShopSKUMoney() {
		return shopSKUMoney;
	}

	public void setShopSKUMoney(List<ShopSKU> shopSKUMoney) {
		this.shopSKUMoney = shopSKUMoney;
	}

	public List<ShopSwiper> getShopSwiperImg() {
		return shopSwiperImg;
	}

	public void setShopSwiperImg(List<ShopSwiper> shopSwiperImg) {
		this.shopSwiperImg = shopSwiperImg;
	}

	private static final long serialVersionUID = 1L;

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getShoptitle() {
		return shoptitle;
	}

	public void setShoptitle(String shoptitle) {
		this.shoptitle = shoptitle;
	}

	public String getShopmodel() {
		return shopmodel;
	}

	public void setShopmodel(String shopmodel) {
		this.shopmodel = shopmodel;
	}

	public Integer getShopstate() {
		return shopstate;
	}

	public void setShopstate(Integer shopstate) {
		this.shopstate = shopstate;
	}

	public String getShopurl() {
		return shopurl;
	}

	public void setShopurl(String shopurl) {
		this.shopurl = shopurl;
	}

	public String getShopdiscounturl() {
		return shopdiscounturl;
	}

	public void setShopdiscounturl(String shopdiscounturl) {
		this.shopdiscounturl = shopdiscounturl;
	}

	public String getShoplable() {
		return shoplable;
	}

	public void setShoplable(String shoplable) {
		this.shoplable = shoplable;
	}

	public String getShopcontent() {
		return shopcontent;
	}

	public void setShopcontent(String shopcontent) {
		this.shopcontent = shopcontent;
	}

	public String getShopdetails() {
		return shopdetails;
	}

	public void setShopdetails(String shopdetails) {
		this.shopdetails = shopdetails;
	}

	public Integer getShoptypeid() {
		return shoptypeid;
	}

	public void setShoptypeid(Integer shoptypeid) {
		this.shoptypeid = shoptypeid;
	}

	public String getShopcretattime() {
		return shopcretattime;
	}

	public void setShopcretattime(String shopcretattime) {
		this.shopcretattime = shopcretattime;
	}

	public ShopType getShopType() {
		return shopType;
	}

	public void setShopType(ShopType shopType) {
		this.shopType = shopType;
	}

	public String getTaobaoToken() {
		return TaobaoToken;
	}

	public void setTaobaoToken(String taobaoToken) {
		TaobaoToken = taobaoToken;
	}

	public List<ShopSwiper> getShopSwiperList() {
		return shopSwiperList;
	}

	public void setShopSwiperList(List<ShopSwiper> shopSwiperList) {
		this.shopSwiperList = shopSwiperList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TaobaoToken == null) ? 0 : TaobaoToken.hashCode());
		result = prime * result + ((shopDiscountMoney == null) ? 0 : shopDiscountMoney.hashCode());
		result = prime * result + ((shopSKUMoney == null) ? 0 : shopSKUMoney.hashCode());
		result = prime * result + ((shopSwiperImg == null) ? 0 : shopSwiperImg.hashCode());
		result = prime * result + ((shopSwiperList == null) ? 0 : shopSwiperList.hashCode());
		result = prime * result + ((shopType == null) ? 0 : shopType.hashCode());
		result = prime * result + ((shopcontent == null) ? 0 : shopcontent.hashCode());
		result = prime * result + ((shopcretattime == null) ? 0 : shopcretattime.hashCode());
		result = prime * result + ((shopdetails == null) ? 0 : shopdetails.hashCode());
		result = prime * result + ((shopdiscounturl == null) ? 0 : shopdiscounturl.hashCode());
		result = prime * result + ((shopid == null) ? 0 : shopid.hashCode());
		result = prime * result + ((shoplable == null) ? 0 : shoplable.hashCode());
		result = prime * result + ((shopmodel == null) ? 0 : shopmodel.hashCode());
		result = prime * result + ((shopname == null) ? 0 : shopname.hashCode());
		result = prime * result + ((shopstate == null) ? 0 : shopstate.hashCode());
		result = prime * result + ((shoptitle == null) ? 0 : shoptitle.hashCode());
		result = prime * result + ((shoptypeid == null) ? 0 : shoptypeid.hashCode());
		result = prime * result + ((shopurl == null) ? 0 : shopurl.hashCode());
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
		Shop other = (Shop) obj;
		if (TaobaoToken == null) {
			if (other.TaobaoToken != null)
				return false;
		} else if (!TaobaoToken.equals(other.TaobaoToken))
			return false;
		if (shopDiscountMoney == null) {
			if (other.shopDiscountMoney != null)
				return false;
		} else if (!shopDiscountMoney.equals(other.shopDiscountMoney))
			return false;
		if (shopSKUMoney == null) {
			if (other.shopSKUMoney != null)
				return false;
		} else if (!shopSKUMoney.equals(other.shopSKUMoney))
			return false;
		if (shopSwiperImg == null) {
			if (other.shopSwiperImg != null)
				return false;
		} else if (!shopSwiperImg.equals(other.shopSwiperImg))
			return false;
		if (shopSwiperList == null) {
			if (other.shopSwiperList != null)
				return false;
		} else if (!shopSwiperList.equals(other.shopSwiperList))
			return false;
		if (shopType == null) {
			if (other.shopType != null)
				return false;
		} else if (!shopType.equals(other.shopType))
			return false;
		if (shopcontent == null) {
			if (other.shopcontent != null)
				return false;
		} else if (!shopcontent.equals(other.shopcontent))
			return false;
		if (shopcretattime == null) {
			if (other.shopcretattime != null)
				return false;
		} else if (!shopcretattime.equals(other.shopcretattime))
			return false;
		if (shopdetails == null) {
			if (other.shopdetails != null)
				return false;
		} else if (!shopdetails.equals(other.shopdetails))
			return false;
		if (shopdiscounturl == null) {
			if (other.shopdiscounturl != null)
				return false;
		} else if (!shopdiscounturl.equals(other.shopdiscounturl))
			return false;
		if (shopid == null) {
			if (other.shopid != null)
				return false;
		} else if (!shopid.equals(other.shopid))
			return false;
		if (shoplable == null) {
			if (other.shoplable != null)
				return false;
		} else if (!shoplable.equals(other.shoplable))
			return false;
		if (shopmodel == null) {
			if (other.shopmodel != null)
				return false;
		} else if (!shopmodel.equals(other.shopmodel))
			return false;
		if (shopname == null) {
			if (other.shopname != null)
				return false;
		} else if (!shopname.equals(other.shopname))
			return false;
		if (shopstate == null) {
			if (other.shopstate != null)
				return false;
		} else if (!shopstate.equals(other.shopstate))
			return false;
		if (shoptitle == null) {
			if (other.shoptitle != null)
				return false;
		} else if (!shoptitle.equals(other.shoptitle))
			return false;
		if (shoptypeid == null) {
			if (other.shoptypeid != null)
				return false;
		} else if (!shoptypeid.equals(other.shoptypeid))
			return false;
		if (shopurl == null) {
			if (other.shopurl != null)
				return false;
		} else if (!shopurl.equals(other.shopurl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shop [shopid=" + shopid + ", shopname=" + shopname + ", shoptitle=" + shoptitle + ", shopmodel="
				+ shopmodel + ", shopstate=" + shopstate + ", shopurl=" + shopurl + ", shopdiscounturl="
				+ shopdiscounturl + ", shoplable=" + shoplable + ", shopcontent=" + shopcontent + ", shopdetails="
				+ shopdetails + ", shoptypeid=" + shoptypeid + ", shopcretattime=" + shopcretattime + ", shopType="
				+ shopType + ", TaobaoToken=" + TaobaoToken + ", shopSwiperList=" + shopSwiperList + ", shopSKUMoney="
				+ shopSKUMoney + ", shopSwiperImg=" + shopSwiperImg + ", shopDiscountMoney=" + shopDiscountMoney + "]";
	}
    
    

}
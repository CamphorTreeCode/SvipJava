package com.shensu.pojo;

import java.io.Serializable;

public class MyCard implements Serializable {

    private Integer mycardid; //我的卡卷id

    private String openid; //用户的唯一标识

    private String mycardtitle; //我的优惠劵的标题

    private String mycarditemUrl; //商品的id地址

    private String mycardcouponClickUrl; //商品优惠券推广链接

    private String mycardzkFinalPrice; //商品折扣价格

    private String mycardpictUrl; //商品的图片

    private String mycardcreattime; //卡劵的创建时间

    private String mycardcouponAmount; //优惠卷的金额
    
    private Integer shopid; //商品的id
    
    private Shop shop;//商品信息
    

    /**
	 * @return shop
	 */
	public Shop getShop() {
		return shop;
	}


	/**
	 * @param shop 要设置的 shop
	 */
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	private static final long serialVersionUID = 1L;

    public Integer getMycardid() {
        return mycardid;
    }

    


	/**
	 * @return shopid
	 */
	public Integer getShopid() {
		return shopid;
	}


	/**
	 * @param shopid 要设置的 shopid
	 */
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}


	public void setMycardid(Integer mycardid) {
        this.mycardid = mycardid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getMycardtitle() {
        return mycardtitle;
    }

    public void setMycardtitle(String mycardtitle) {
        this.mycardtitle = mycardtitle == null ? null : mycardtitle.trim();
    }

    public String getMycarditemUrl() {
        return mycarditemUrl;
    }

    public void setMycarditemUrl(String mycarditemUrl) {
        this.mycarditemUrl = mycarditemUrl == null ? null : mycarditemUrl.trim();
    }

    public String getMycardcouponClickUrl() {
        return mycardcouponClickUrl;
    }

    public void setMycardcouponClickUrl(String mycardcouponClickUrl) {
        this.mycardcouponClickUrl = mycardcouponClickUrl == null ? null : mycardcouponClickUrl.trim();
    }

    public String getMycardzkFinalPrice() {
        return mycardzkFinalPrice;
    }

    public void setMycardzkFinalPrice(String mycardzkFinalPrice) {
        this.mycardzkFinalPrice = mycardzkFinalPrice == null ? null : mycardzkFinalPrice.trim();
    }

    public String getMycardpictUrl() {
        return mycardpictUrl;
    }

    public void setMycardpictUrl(String mycardpictUrl) {
        this.mycardpictUrl = mycardpictUrl == null ? null : mycardpictUrl.trim();
    }

    public String getMycardcreattime() {
        return mycardcreattime;
    }

    public void setMycardcreattime(String mycardcreattime) {
        this.mycardcreattime = mycardcreattime == null ? null : mycardcreattime.trim();
    }

    public String getMycardcouponAmount() {
        return mycardcouponAmount;
    }

    public void setMycardcouponAmount(String mycardcouponAmount) {
        this.mycardcouponAmount = mycardcouponAmount == null ? null : mycardcouponAmount.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MyCard other = (MyCard) that;
        return (this.getMycardid() == null ? other.getMycardid() == null : this.getMycardid().equals(other.getMycardid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getMycardtitle() == null ? other.getMycardtitle() == null : this.getMycardtitle().equals(other.getMycardtitle()))
            && (this.getMycarditemUrl() == null ? other.getMycarditemUrl() == null : this.getMycarditemUrl().equals(other.getMycarditemUrl()))
            && (this.getMycardcouponClickUrl() == null ? other.getMycardcouponClickUrl() == null : this.getMycardcouponClickUrl().equals(other.getMycardcouponClickUrl()))
            && (this.getMycardzkFinalPrice() == null ? other.getMycardzkFinalPrice() == null : this.getMycardzkFinalPrice().equals(other.getMycardzkFinalPrice()))
            && (this.getMycardpictUrl() == null ? other.getMycardpictUrl() == null : this.getMycardpictUrl().equals(other.getMycardpictUrl()))
            && (this.getMycardcreattime() == null ? other.getMycardcreattime() == null : this.getMycardcreattime().equals(other.getMycardcreattime()))
            && (this.getMycardcouponAmount() == null ? other.getMycardcouponAmount() == null : this.getMycardcouponAmount().equals(other.getMycardcouponAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMycardid() == null) ? 0 : getMycardid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getMycardtitle() == null) ? 0 : getMycardtitle().hashCode());
        result = prime * result + ((getMycarditemUrl() == null) ? 0 : getMycarditemUrl().hashCode());
        result = prime * result + ((getMycardcouponClickUrl() == null) ? 0 : getMycardcouponClickUrl().hashCode());
        result = prime * result + ((getMycardzkFinalPrice() == null) ? 0 : getMycardzkFinalPrice().hashCode());
        result = prime * result + ((getMycardpictUrl() == null) ? 0 : getMycardpictUrl().hashCode());
        result = prime * result + ((getMycardcreattime() == null) ? 0 : getMycardcreattime().hashCode());
        result = prime * result + ((getMycardcouponAmount() == null) ? 0 : getMycardcouponAmount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mycardid=").append(mycardid);
        sb.append(", openid=").append(openid);
        sb.append(", mycardtitle=").append(mycardtitle);
        sb.append(", mycarditemUrl=").append(mycarditemUrl);
        sb.append(", mycardcouponClickUrl=").append(mycardcouponClickUrl);
        sb.append(", mycardzkFinalPrice=").append(mycardzkFinalPrice);
        sb.append(", mycardpictUrl=").append(mycardpictUrl);
        sb.append(", mycardcreattime=").append(mycardcreattime);
        sb.append(", mycardcouponAmount=").append(mycardcouponAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
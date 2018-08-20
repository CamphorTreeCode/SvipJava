package com.shensu.pojo;

import java.io.Serializable;

public class Franchiser implements Serializable {

    private Integer franchiserid; //加盟的id

    private String franchisename; //加盟者姓名

    private String franchiseordernmuber; //加盟的订单号id

    private String franchisephone; //加盟者联系电话

    private String franchiseapplyreason; //申请理由

    private String franchiseconsumption; //消费平台  0是天猫，1是淘宝

    private String openid; //用户的唯一标识

    private String franchisecreattime; //申请联盟时间

    private Integer franchisestate; //加盟的状态 0代表待审核  1代表通过  2代表不通过
    
    private Integer readstate; //阅读状态  0表示未读  1表示已读
    
    private String formId;//模版消息
    

    /**
	 * @return formId
	 */
	public String getFormId() {
		return formId;
	}

	/**
	 * @param formId 要设置的 formId
	 */
	public void setFormId(String formId) {
		this.formId = formId;
	}

	public Integer getReadstate() {
		return readstate;
	}

	public void setReadstate(Integer readstate) {
		this.readstate = readstate;
	}

	private static final long serialVersionUID = 1L;

    public Integer getFranchiserid() {
        return franchiserid;
    }

    public void setFranchiserid(Integer franchiserid) {
        this.franchiserid = franchiserid;
    }

    public String getFranchisename() {
        return franchisename;
    }

    public void setFranchisename(String franchisename) {
        this.franchisename = franchisename == null ? null : franchisename.trim();
    }

    public String getFranchiseordernmuber() {
        return franchiseordernmuber;
    }

    public void setFranchiseordernmuber(String franchiseordernmuber) {
        this.franchiseordernmuber = franchiseordernmuber == null ? null : franchiseordernmuber.trim();
    }

    public String getFranchisephone() {
        return franchisephone;
    }

    public void setFranchisephone(String franchisephone) {
        this.franchisephone = franchisephone == null ? null : franchisephone.trim();
    }

    public String getFranchiseapplyreason() {
        return franchiseapplyreason;
    }

    public void setFranchiseapplyreason(String franchiseapplyreason) {
        this.franchiseapplyreason = franchiseapplyreason == null ? null : franchiseapplyreason.trim();
    }

    public String getFranchiseconsumption() {
        return franchiseconsumption;
    }

    public void setFranchiseconsumption(String franchiseconsumption) {
        this.franchiseconsumption = franchiseconsumption == null ? null : franchiseconsumption.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getFranchisecreattime() {
        return franchisecreattime;
    }

    public void setFranchisecreattime(String franchisecreattime) {
        this.franchisecreattime = franchisecreattime == null ? null : franchisecreattime.trim();
    }

    public Integer getFranchisestate() {
        return franchisestate;
    }

    public void setFranchisestate(Integer franchisestate) {
        this.franchisestate = franchisestate;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Franchiser other = (Franchiser) obj;
		if (franchiseapplyreason == null) {
			if (other.franchiseapplyreason != null)
				return false;
		} else if (!franchiseapplyreason.equals(other.franchiseapplyreason))
			return false;
		if (franchiseconsumption == null) {
			if (other.franchiseconsumption != null)
				return false;
		} else if (!franchiseconsumption.equals(other.franchiseconsumption))
			return false;
		if (franchisecreattime == null) {
			if (other.franchisecreattime != null)
				return false;
		} else if (!franchisecreattime.equals(other.franchisecreattime))
			return false;
		if (franchisename == null) {
			if (other.franchisename != null)
				return false;
		} else if (!franchisename.equals(other.franchisename))
			return false;
		if (franchiseordernmuber == null) {
			if (other.franchiseordernmuber != null)
				return false;
		} else if (!franchiseordernmuber.equals(other.franchiseordernmuber))
			return false;
		if (franchisephone == null) {
			if (other.franchisephone != null)
				return false;
		} else if (!franchisephone.equals(other.franchisephone))
			return false;
		if (franchiserid == null) {
			if (other.franchiserid != null)
				return false;
		} else if (!franchiserid.equals(other.franchiserid))
			return false;
		if (franchisestate == null) {
			if (other.franchisestate != null)
				return false;
		} else if (!franchisestate.equals(other.franchisestate))
			return false;
		if (openid == null) {
			if (other.openid != null)
				return false;
		} else if (!openid.equals(other.openid))
			return false;
		if (readstate == null) {
			if (other.readstate != null)
				return false;
		} else if (!readstate.equals(other.readstate))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((franchiseapplyreason == null) ? 0 : franchiseapplyreason.hashCode());
		result = prime * result + ((franchiseconsumption == null) ? 0 : franchiseconsumption.hashCode());
		result = prime * result + ((franchisecreattime == null) ? 0 : franchisecreattime.hashCode());
		result = prime * result + ((franchisename == null) ? 0 : franchisename.hashCode());
		result = prime * result + ((franchiseordernmuber == null) ? 0 : franchiseordernmuber.hashCode());
		result = prime * result + ((franchisephone == null) ? 0 : franchisephone.hashCode());
		result = prime * result + ((franchiserid == null) ? 0 : franchiserid.hashCode());
		result = prime * result + ((franchisestate == null) ? 0 : franchisestate.hashCode());
		result = prime * result + ((openid == null) ? 0 : openid.hashCode());
		result = prime * result + ((readstate == null) ? 0 : readstate.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Franchiser [franchiserid=" + franchiserid + ", franchisename=" + franchisename
				+ ", franchiseordernmuber=" + franchiseordernmuber + ", franchisephone=" + franchisephone
				+ ", franchiseapplyreason=" + franchiseapplyreason + ", franchiseconsumption=" + franchiseconsumption
				+ ", openid=" + openid + ", franchisecreattime=" + franchisecreattime + ", franchisestate="
				+ franchisestate + ", readstate=" + readstate + "]";
	}
}
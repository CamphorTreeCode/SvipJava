package com.shensu.pojo;

import java.io.Serializable;

public class FranchiserUser implements Serializable {
	
    private Integer franchiseruserid; //通过加盟的id

    private String openid; //用户的唯一标识

    private String franchiserusercreattime; //加盟用户通过时间
  
    private String franchiseruseraccounts; //加盟用户的帐号

    private String franchiseruserpassword; //加盟用户的密码

    private String franchiseruserusername; //加盟用户的昵称

    private String franchiseruserpid; //用户加盟的pid

    private static final long serialVersionUID = 1L;

    public Integer getFranchiseruserid() {
        return franchiseruserid;
    }

    public void setFranchiseruserid(Integer franchiseruserid) {
        this.franchiseruserid = franchiseruserid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getFranchiserusercreattime() {
        return franchiserusercreattime;
    }

    public void setFranchiserusercreattime(String franchiserusercreattime) {
        this.franchiserusercreattime = franchiserusercreattime == null ? null : franchiserusercreattime.trim();
    }

    public String getFranchiseruseraccounts() {
        return franchiseruseraccounts;
    }

    public void setFranchiseruseraccounts(String franchiseruseraccounts) {
        this.franchiseruseraccounts = franchiseruseraccounts == null ? null : franchiseruseraccounts.trim();
    }

    public String getFranchiseruserpassword() {
        return franchiseruserpassword;
    }

    public void setFranchiseruserpassword(String franchiseruserpassword) {
        this.franchiseruserpassword = franchiseruserpassword == null ? null : franchiseruserpassword.trim();
    }

    public String getFranchiseruserusername() {
        return franchiseruserusername;
    }

    public void setFranchiseruserusername(String franchiseruserusername) {
        this.franchiseruserusername = franchiseruserusername == null ? null : franchiseruserusername.trim();
    }

    public String getFranchiseruserpid() {
        return franchiseruserpid;
    }

    public void setFranchiseruserpid(String franchiseruserpid) {
        this.franchiseruserpid = franchiseruserpid == null ? null : franchiseruserpid.trim();
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
        FranchiserUser other = (FranchiserUser) that;
        return (this.getFranchiseruserid() == null ? other.getFranchiseruserid() == null : this.getFranchiseruserid().equals(other.getFranchiseruserid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getFranchiserusercreattime() == null ? other.getFranchiserusercreattime() == null : this.getFranchiserusercreattime().equals(other.getFranchiserusercreattime()))
            && (this.getFranchiseruseraccounts() == null ? other.getFranchiseruseraccounts() == null : this.getFranchiseruseraccounts().equals(other.getFranchiseruseraccounts()))
            && (this.getFranchiseruserpassword() == null ? other.getFranchiseruserpassword() == null : this.getFranchiseruserpassword().equals(other.getFranchiseruserpassword()))
            && (this.getFranchiseruserusername() == null ? other.getFranchiseruserusername() == null : this.getFranchiseruserusername().equals(other.getFranchiseruserusername()))
            && (this.getFranchiseruserpid() == null ? other.getFranchiseruserpid() == null : this.getFranchiseruserpid().equals(other.getFranchiseruserpid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFranchiseruserid() == null) ? 0 : getFranchiseruserid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getFranchiserusercreattime() == null) ? 0 : getFranchiserusercreattime().hashCode());
        result = prime * result + ((getFranchiseruseraccounts() == null) ? 0 : getFranchiseruseraccounts().hashCode());
        result = prime * result + ((getFranchiseruserpassword() == null) ? 0 : getFranchiseruserpassword().hashCode());
        result = prime * result + ((getFranchiseruserusername() == null) ? 0 : getFranchiseruserusername().hashCode());
        result = prime * result + ((getFranchiseruserpid() == null) ? 0 : getFranchiseruserpid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", franchiseruserid=").append(franchiseruserid);
        sb.append(", openid=").append(openid);
        sb.append(", franchiserusercreattime=").append(franchiserusercreattime);
        sb.append(", franchiseruseraccounts=").append(franchiseruseraccounts);
        sb.append(", franchiseruserpassword=").append(franchiseruserpassword);
        sb.append(", franchiseruserusername=").append(franchiseruserusername);
        sb.append(", franchiseruserpid=").append(franchiseruserpid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
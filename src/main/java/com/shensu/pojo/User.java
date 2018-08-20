package com.shensu.pojo;

import java.io.Serializable;

public class User implements Serializable {

	//用户唯一标识
    private String openid;

    //用户的id
    private Integer userid;

    //用户的的头像地址
    private String avatarurl;

    //用户的昵称
    private String nickname;

    //用户的性别
    private String gender;

    //用户的城市
    private String city;

    //用户的省份
    private String province;

    //用户的国家
    private String country;

    //用户的语言
    private String language;

    //用户的注册时间
    private String registerdate;
    
    //登录时获取的 code
    private String jscode;

    public String getJscode() {
		return jscode;
	}

	public void setJscode(String jscode) {
		this.jscode = jscode;
	}

	private static final long serialVersionUID = 1L;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getUserid() {
        return userid;
    }


    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getRegisterdate() {
        return registerdate;
    }
    
    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate == null ? null : registerdate.trim();
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (avatarurl == null) {
			if (other.avatarurl != null)
				return false;
		} else if (!avatarurl.equals(other.avatarurl))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (jscode == null) {
			if (other.jscode != null)
				return false;
		} else if (!jscode.equals(other.jscode))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (openid == null) {
			if (other.openid != null)
				return false;
		} else if (!openid.equals(other.openid))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (registerdate == null) {
			if (other.registerdate != null)
				return false;
		} else if (!registerdate.equals(other.registerdate))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatarurl == null) ? 0 : avatarurl.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((jscode == null) ? 0 : jscode.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((openid == null) ? 0 : openid.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((registerdate == null) ? 0 : registerdate.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "User [openid=" + openid + ", userid=" + userid + ", avatarurl=" + avatarurl + ", nickname=" + nickname
				+ ", gender=" + gender + ", city=" + city + ", province=" + province + ", country=" + country
				+ ", language=" + language + ", registerdate=" + registerdate + ", jscode=" + jscode + "]";
	}
}
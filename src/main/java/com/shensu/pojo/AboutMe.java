package com.shensu.pojo;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
@ApiModel(value = "com.shensu.pojo.AboutMe", description = "关于我们参数")
public class AboutMe implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column AboutMe.aboutMeId
     *
     * @mbggenerated
     */
	//关于我们的id
	@ApiModelProperty("关于我们的id")
    private Integer aboutmeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column AboutMe.aboutMeCreatTime
     *
     * @mbggenerated
     */
    //关于我们时间
	@ApiModelProperty("关于我们时间")
    private String aboutmecreattime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column AboutMe.aboutMeServer
     *
     * @mbggenerated
     */
    //关于我们服务
	@ApiModelProperty("关于我们服务")
    private String aboutmeserver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column AboutMe.aboutMeImg
     *
     * @mbggenerated
     */
    //小程序品牌的图片地址
	@ApiModelProperty("小程序品牌的图片地址")
    private String aboutmeimg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column AboutMe.aboutMeContent
     *
     * @mbggenerated
     */
    //品牌的内容
	@ApiModelProperty("品牌的内容")
    private String aboutmecontent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table AboutMe
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AboutMe.aboutMeId
     *
     * @return the value of AboutMe.aboutMeId
     *
     * @mbggenerated
     */
    public Integer getAboutmeid() {
        return aboutmeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AboutMe.aboutMeId
     *
     * @param aboutmeid the value for AboutMe.aboutMeId
     *
     * @mbggenerated
     */
    public void setAboutmeid(Integer aboutmeid) {
        this.aboutmeid = aboutmeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AboutMe.aboutMeCreatTime
     *
     * @return the value of AboutMe.aboutMeCreatTime
     *
     * @mbggenerated
     */
    public String getAboutmecreattime() {
        return aboutmecreattime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AboutMe.aboutMeCreatTime
     *
     * @param aboutmecreattime the value for AboutMe.aboutMeCreatTime
     *
     * @mbggenerated
     */
    public void setAboutmecreattime(String aboutmecreattime) {
        this.aboutmecreattime = aboutmecreattime == null ? null : aboutmecreattime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AboutMe.aboutMeServer
     *
     * @return the value of AboutMe.aboutMeServer
     *
     * @mbggenerated
     */
    public String getAboutmeserver() {
        return aboutmeserver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AboutMe.aboutMeServer
     *
     * @param aboutmeserver the value for AboutMe.aboutMeServer
     *
     * @mbggenerated
     */
    public void setAboutmeserver(String aboutmeserver) {
        this.aboutmeserver = aboutmeserver == null ? null : aboutmeserver.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AboutMe.aboutMeImg
     *
     * @return the value of AboutMe.aboutMeImg
     *
     * @mbggenerated
     */
    public String getAboutmeimg() {
        return aboutmeimg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AboutMe.aboutMeImg
     *
     * @param aboutmeimg the value for AboutMe.aboutMeImg
     *
     * @mbggenerated
     */
    public void setAboutmeimg(String aboutmeimg) {
        this.aboutmeimg = aboutmeimg == null ? null : aboutmeimg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AboutMe.aboutMeContent
     *
     * @return the value of AboutMe.aboutMeContent
     *
     * @mbggenerated
     */
    public String getAboutmecontent() {
        return aboutmecontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AboutMe.aboutMeContent
     *
     * @param aboutmecontent the value for AboutMe.aboutMeContent
     *
     * @mbggenerated
     */
    public void setAboutmecontent(String aboutmecontent) {
        this.aboutmecontent = aboutmecontent == null ? null : aboutmecontent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AboutMe
     *
     * @mbggenerated
     */
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
        AboutMe other = (AboutMe) that;
        return (this.getAboutmeid() == null ? other.getAboutmeid() == null : this.getAboutmeid().equals(other.getAboutmeid()))
            && (this.getAboutmecreattime() == null ? other.getAboutmecreattime() == null : this.getAboutmecreattime().equals(other.getAboutmecreattime()))
            && (this.getAboutmeserver() == null ? other.getAboutmeserver() == null : this.getAboutmeserver().equals(other.getAboutmeserver()))
            && (this.getAboutmeimg() == null ? other.getAboutmeimg() == null : this.getAboutmeimg().equals(other.getAboutmeimg()))
            && (this.getAboutmecontent() == null ? other.getAboutmecontent() == null : this.getAboutmecontent().equals(other.getAboutmecontent()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AboutMe
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAboutmeid() == null) ? 0 : getAboutmeid().hashCode());
        result = prime * result + ((getAboutmecreattime() == null) ? 0 : getAboutmecreattime().hashCode());
        result = prime * result + ((getAboutmeserver() == null) ? 0 : getAboutmeserver().hashCode());
        result = prime * result + ((getAboutmeimg() == null) ? 0 : getAboutmeimg().hashCode());
        result = prime * result + ((getAboutmecontent() == null) ? 0 : getAboutmecontent().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AboutMe
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new  StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aboutmeid=").append(aboutmeid);
        sb.append(", aboutmecreattime=").append(aboutmecreattime);
        sb.append(", aboutmeserver=").append(aboutmeserver);
        sb.append(", aboutmeimg=").append(aboutmeimg);
        sb.append(", aboutmecontent=").append(aboutmecontent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
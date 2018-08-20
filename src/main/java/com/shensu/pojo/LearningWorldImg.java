package com.shensu.pojo;

import java.io.Serializable;

public class LearningWorldImg implements Serializable {

    private Integer learningworldimgid; //学习天地img的id

    private String learningworldimgurl; //学习天地图片的地址

    private String learningworldimgcreattime; //学习天地图片创建时间

    private Integer learningworldid; //学习天地的id

    private static final long serialVersionUID = 1L;

    public Integer getLearningworldimgid() {
        return learningworldimgid;
    }

    public void setLearningworldimgid(Integer learningworldimgid) {
        this.learningworldimgid = learningworldimgid;
    }

    public String getLearningworldimgurl() {
        return learningworldimgurl;
    }

    public void setLearningworldimgurl(String learningworldimgurl) {
        this.learningworldimgurl = learningworldimgurl == null ? null : learningworldimgurl.trim();
    }

    public String getLearningworldimgcreattime() {
        return learningworldimgcreattime;
    }

    public void setLearningworldimgcreattime(String learningworldimgcreattime) {
        this.learningworldimgcreattime = learningworldimgcreattime == null ? null : learningworldimgcreattime.trim();
    }

    public Integer getLearningworldid() {
        return learningworldid;
    }

    public void setLearningworldid(Integer learningworldid) {
        this.learningworldid = learningworldid;
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
        LearningWorldImg other = (LearningWorldImg) that;
        return (this.getLearningworldimgid() == null ? other.getLearningworldimgid() == null : this.getLearningworldimgid().equals(other.getLearningworldimgid()))
            && (this.getLearningworldimgurl() == null ? other.getLearningworldimgurl() == null : this.getLearningworldimgurl().equals(other.getLearningworldimgurl()))
            && (this.getLearningworldimgcreattime() == null ? other.getLearningworldimgcreattime() == null : this.getLearningworldimgcreattime().equals(other.getLearningworldimgcreattime()))
            && (this.getLearningworldid() == null ? other.getLearningworldid() == null : this.getLearningworldid().equals(other.getLearningworldid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLearningworldimgid() == null) ? 0 : getLearningworldimgid().hashCode());
        result = prime * result + ((getLearningworldimgurl() == null) ? 0 : getLearningworldimgurl().hashCode());
        result = prime * result + ((getLearningworldimgcreattime() == null) ? 0 : getLearningworldimgcreattime().hashCode());
        result = prime * result + ((getLearningworldid() == null) ? 0 : getLearningworldid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", learningworldimgid=").append(learningworldimgid);
        sb.append(", learningworldimgurl=").append(learningworldimgurl);
        sb.append(", learningworldimgcreattime=").append(learningworldimgcreattime);
        sb.append(", learningworldid=").append(learningworldid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
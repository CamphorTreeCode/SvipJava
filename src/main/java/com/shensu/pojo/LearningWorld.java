package com.shensu.pojo;

import java.io.Serializable;

/**
 * 学习天地
 * @author YUKI
 *
 */

import java.util.List;


public class LearningWorld implements Serializable {
 
    private Integer learningworldid; //学习天地id

    private String learningworldtitle; //学习天地的标题

    private String learningworldvideourl; //学习天地视频
    
    private String learningworldvideoimgurl;//学习天地视频预览图

    private String learningworldcreattime; //学习天地创建时间

    private Integer learningworldbrowse; //学习天地浏览量

    private Integer learningworldfabulous; //学习天地点赞

    private Integer learningworldstate; //学习天地的状态 0代表下架 1代表上架

    private String learningworldcontent; //学习天地的内容
    
    private Integer learningWorldForward;//学习天地转发量
    
    private Integer draftstate; //草稿状态：0不是草稿  1是草稿
    

	public String getLearningworldvideoimgurl() {
		return learningworldvideoimgurl;
	}

	public void setLearningworldvideoimgurl(String learningworldvideoimgurl) {
		this.learningworldvideoimgurl = learningworldvideoimgurl;
	}

	private List<LearningWorldImg> learningWorldImg;
    
    
    
	/**
	 * @return learningWorldForward
	 */
	public Integer getLearningWorldForward() {
		return learningWorldForward;
	}

	/**
	 * @param learningWorldForward 要设置的 learningWorldForward
	 */
	public void setLearningWorldForward(Integer learningWorldForward) {
		this.learningWorldForward = learningWorldForward;
	}

	public List<LearningWorldImg> getLearningWorldImg() {
		return learningWorldImg;
	}

	public void setLearningWorldImg(List<LearningWorldImg> learningWorldImg) {
		this.learningWorldImg = learningWorldImg;
	}

	private static final long serialVersionUID = 1L;


    public Integer getDraftstate() {
		return draftstate;
	}

	public void setDraftstate(Integer draftstate) {
		this.draftstate = draftstate;
	}

	public Integer getLearningworldid() {
        return learningworldid;
    }

    public void setLearningworldid(Integer learningworldid) {
        this.learningworldid = learningworldid;
    }

    public String getLearningworldtitle() {
        return learningworldtitle;
    }

    public void setLearningworldtitle(String learningworldtitle) {
        this.learningworldtitle = learningworldtitle == null ? null : learningworldtitle.trim();
    }

    public String getLearningworldvideourl() {
        return learningworldvideourl;
    }

    public void setLearningworldvideourl(String learningworldvideourl) {
        this.learningworldvideourl = learningworldvideourl == null ? null : learningworldvideourl.trim();
    }

    public String getLearningworldcreattime() {
        return learningworldcreattime;
    }

    public void setLearningworldcreattime(String learningworldcreattime) {
        this.learningworldcreattime = learningworldcreattime == null ? null : learningworldcreattime.trim();
    }

    public Integer getLearningworldbrowse() {
        return learningworldbrowse;
    }

    public void setLearningworldbrowse(Integer learningworldbrowse) {
        this.learningworldbrowse = learningworldbrowse;
    }

    public Integer getLearningworldfabulous() {
        return learningworldfabulous;
    }

    public void setLearningworldfabulous(Integer learningworldfabulous) {
        this.learningworldfabulous = learningworldfabulous;
    }

    public Integer getLearningworldstate() {
        return learningworldstate;
    }

    public void setLearningworldstate(Integer learningworldstate) {
        this.learningworldstate = learningworldstate;
    }

    public String getLearningworldcontent() {
        return learningworldcontent;
    }

    public void setLearningworldcontent(String learningworldcontent) {
        this.learningworldcontent = learningworldcontent == null ? null : learningworldcontent.trim();
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LearningWorld other = (LearningWorld) obj;
		if (draftstate == null) {
			if (other.draftstate != null)
				return false;
		} else if (!draftstate.equals(other.draftstate))
			return false;
		if (learningWorldImg == null) {
			if (other.learningWorldImg != null)
				return false;
		} else if (!learningWorldImg.equals(other.learningWorldImg))
			return false;
		if (learningworldbrowse == null) {
			if (other.learningworldbrowse != null)
				return false;
		} else if (!learningworldbrowse.equals(other.learningworldbrowse))
			return false;
		if (learningworldcontent == null) {
			if (other.learningworldcontent != null)
				return false;
		} else if (!learningworldcontent.equals(other.learningworldcontent))
			return false;
		if (learningworldcreattime == null) {
			if (other.learningworldcreattime != null)
				return false;
		} else if (!learningworldcreattime.equals(other.learningworldcreattime))
			return false;
		if (learningworldfabulous == null) {
			if (other.learningworldfabulous != null)
				return false;
		} else if (!learningworldfabulous.equals(other.learningworldfabulous))
			return false;
		if (learningworldid == null) {
			if (other.learningworldid != null)
				return false;
		} else if (!learningworldid.equals(other.learningworldid))
			return false;
		if (learningworldstate == null) {
			if (other.learningworldstate != null)
				return false;
		} else if (!learningworldstate.equals(other.learningworldstate))
			return false;
		if (learningworldtitle == null) {
			if (other.learningworldtitle != null)
				return false;
		} else if (!learningworldtitle.equals(other.learningworldtitle))
			return false;
		if (learningworldvideourl == null) {
			if (other.learningworldvideourl != null)
				return false;
		} else if (!learningworldvideourl.equals(other.learningworldvideourl))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((draftstate == null) ? 0 : draftstate.hashCode());
		result = prime * result + ((learningWorldImg == null) ? 0 : learningWorldImg.hashCode());
		result = prime * result + ((learningworldbrowse == null) ? 0 : learningworldbrowse.hashCode());
		result = prime * result + ((learningworldcontent == null) ? 0 : learningworldcontent.hashCode());
		result = prime * result + ((learningworldcreattime == null) ? 0 : learningworldcreattime.hashCode());
		result = prime * result + ((learningworldfabulous == null) ? 0 : learningworldfabulous.hashCode());
		result = prime * result + ((learningworldid == null) ? 0 : learningworldid.hashCode());
		result = prime * result + ((learningworldstate == null) ? 0 : learningworldstate.hashCode());
		result = prime * result + ((learningworldtitle == null) ? 0 : learningworldtitle.hashCode());
		result = prime * result + ((learningworldvideourl == null) ? 0 : learningworldvideourl.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "LearningWorld [learningworldid=" + learningworldid + ", learningworldtitle=" + learningworldtitle
				+ ", learningworldvideourl=" + learningworldvideourl + ", learningworldcreattime="
				+ learningworldcreattime + ", learningworldbrowse=" + learningworldbrowse + ", learningworldfabulous="
				+ learningworldfabulous + ", learningworldstate=" + learningworldstate + ", learningworldcontent="
				+ learningworldcontent + ", draftstate=" + draftstate + ", learningWorldImg=" + learningWorldImg + "]";
	}
}
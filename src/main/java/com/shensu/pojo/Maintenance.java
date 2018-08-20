package com.shensu.pojo;

import java.io.Serializable;

public class Maintenance implements Serializable {

    private Integer maintenanceid; //中央维修的id

    private String maintenancecreattime; //中央维修的创建时间

    private String maintenancemodel; //机器型号

    private String maintenanceplatform; //购买平台

    private String maintenancenumber; //订单帐号

    private String maintenancename; //维修的姓名

    private String maintenancephone; //手机号

    private String maintenanceaddress; //选择地址

    private String maintenancedetailed; //详细地址

    private String openid; //用户的唯一标识
    
    private Integer maintenancestate; //维修申请的状态 0代表待审核  1代表通过  2代表不通过
    
    private Integer readstate; //阅读状态  0表示未读  1表示已读
    
    private String formId; //推送消息的id
    

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

	public Integer getMaintenancestate() {
		return maintenancestate;
	}

	public void setMaintenancestate(Integer maintenancestate) {
		this.maintenancestate = maintenancestate;
	}

	private static final long serialVersionUID = 1L;

    public Integer getMaintenanceid() {
        return maintenanceid;
    }

    public void setMaintenanceid(Integer maintenanceid) {
        this.maintenanceid = maintenanceid;
    }

    public String getMaintenancecreattime() {
        return maintenancecreattime;
    }

    public void setMaintenancecreattime(String maintenancecreattime) {
        this.maintenancecreattime = maintenancecreattime == null ? null : maintenancecreattime.trim();
    }

    public String getMaintenancemodel() {
        return maintenancemodel;
    }

    public void setMaintenancemodel(String maintenancemodel) {
        this.maintenancemodel = maintenancemodel == null ? null : maintenancemodel.trim();
    }

    public String getMaintenanceplatform() {
        return maintenanceplatform;
    }

    public void setMaintenanceplatform(String maintenanceplatform) {
        this.maintenanceplatform = maintenanceplatform == null ? null : maintenanceplatform.trim();
    }

    public String getMaintenancenumber() {
        return maintenancenumber;
    }

    public void setMaintenancenumber(String maintenancenumber) {
        this.maintenancenumber = maintenancenumber == null ? null : maintenancenumber.trim();
    }

    public String getMaintenancename() {
        return maintenancename;
    }

    public void setMaintenancename(String maintenancename) {
        this.maintenancename = maintenancename == null ? null : maintenancename.trim();
    }

    public String getMaintenancephone() {
        return maintenancephone;
    }

    public void setMaintenancephone(String maintenancephone) {
        this.maintenancephone = maintenancephone == null ? null : maintenancephone.trim();
    }

    public String getMaintenanceaddress() {
        return maintenanceaddress;
    }

    public void setMaintenanceaddress(String maintenanceaddress) {
        this.maintenanceaddress = maintenanceaddress == null ? null : maintenanceaddress.trim();
    }

    public String getMaintenancedetailed() {
        return maintenancedetailed;
    }

    public void setMaintenancedetailed(String maintenancedetailed) {
        this.maintenancedetailed = maintenancedetailed == null ? null : maintenancedetailed.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maintenance other = (Maintenance) obj;
		if (maintenanceaddress == null) {
			if (other.maintenanceaddress != null)
				return false;
		} else if (!maintenanceaddress.equals(other.maintenanceaddress))
			return false;
		if (maintenancecreattime == null) {
			if (other.maintenancecreattime != null)
				return false;
		} else if (!maintenancecreattime.equals(other.maintenancecreattime))
			return false;
		if (maintenancedetailed == null) {
			if (other.maintenancedetailed != null)
				return false;
		} else if (!maintenancedetailed.equals(other.maintenancedetailed))
			return false;
		if (maintenanceid == null) {
			if (other.maintenanceid != null)
				return false;
		} else if (!maintenanceid.equals(other.maintenanceid))
			return false;
		if (maintenancemodel == null) {
			if (other.maintenancemodel != null)
				return false;
		} else if (!maintenancemodel.equals(other.maintenancemodel))
			return false;
		if (maintenancename == null) {
			if (other.maintenancename != null)
				return false;
		} else if (!maintenancename.equals(other.maintenancename))
			return false;
		if (maintenancenumber == null) {
			if (other.maintenancenumber != null)
				return false;
		} else if (!maintenancenumber.equals(other.maintenancenumber))
			return false;
		if (maintenancephone == null) {
			if (other.maintenancephone != null)
				return false;
		} else if (!maintenancephone.equals(other.maintenancephone))
			return false;
		if (maintenanceplatform == null) {
			if (other.maintenanceplatform != null)
				return false;
		} else if (!maintenanceplatform.equals(other.maintenanceplatform))
			return false;
		if (maintenancestate == null) {
			if (other.maintenancestate != null)
				return false;
		} else if (!maintenancestate.equals(other.maintenancestate))
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
		result = prime * result + ((maintenanceaddress == null) ? 0 : maintenanceaddress.hashCode());
		result = prime * result + ((maintenancecreattime == null) ? 0 : maintenancecreattime.hashCode());
		result = prime * result + ((maintenancedetailed == null) ? 0 : maintenancedetailed.hashCode());
		result = prime * result + ((maintenanceid == null) ? 0 : maintenanceid.hashCode());
		result = prime * result + ((maintenancemodel == null) ? 0 : maintenancemodel.hashCode());
		result = prime * result + ((maintenancename == null) ? 0 : maintenancename.hashCode());
		result = prime * result + ((maintenancenumber == null) ? 0 : maintenancenumber.hashCode());
		result = prime * result + ((maintenancephone == null) ? 0 : maintenancephone.hashCode());
		result = prime * result + ((maintenanceplatform == null) ? 0 : maintenanceplatform.hashCode());
		result = prime * result + ((maintenancestate == null) ? 0 : maintenancestate.hashCode());
		result = prime * result + ((openid == null) ? 0 : openid.hashCode());
		result = prime * result + ((readstate == null) ? 0 : readstate.hashCode());
		return result;
	}

	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Maintenance [maintenanceid=" + maintenanceid + ", maintenancecreattime=" + maintenancecreattime
				+ ", maintenancemodel=" + maintenancemodel + ", maintenanceplatform=" + maintenanceplatform
				+ ", maintenancenumber=" + maintenancenumber + ", maintenancename=" + maintenancename
				+ ", maintenancephone=" + maintenancephone + ", maintenanceaddress=" + maintenanceaddress
				+ ", maintenancedetailed=" + maintenancedetailed + ", openid=" + openid + ", maintenancestate="
				+ maintenancestate + ", readstate=" + readstate + ", formId=" + formId + "]";
	}

}
package com.shensu.pojo;

import java.io.Serializable;

public class RecipesSwiper implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer recipesswiperid;//食谱展示图id
	
	private String recipesswiperimg;//食谱展示图地址
	
	private int recipesid;//食谱的文章id
	
	private String recipesswipercreattime;//食谱展示图创建时间

	public Integer getRecipesswiperid() {
		return recipesswiperid;
	}

	public void setRecipesswiperid(Integer recipesswiperid) {
		this.recipesswiperid = recipesswiperid;
	}

	public String getRecipesswiperimg() {
		return recipesswiperimg;
	}

	public void setRecipesswiperimg(String recipesswiperimg) {
		this.recipesswiperimg = recipesswiperimg;
	}

	public int getRecipesid() {
		return recipesid;
	}

	public void setRecipesid(int recipesid) {
		this.recipesid = recipesid;
	}

	public String getRecipesswipercreattime() {
		return recipesswipercreattime;
	}

	public void setRecipesswipercreattime(String recipesswipercreattime) {
		this.recipesswipercreattime = recipesswipercreattime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recipesid;
		result = prime * result + ((recipesswipercreattime == null) ? 0 : recipesswipercreattime.hashCode());
		result = prime * result + ((recipesswiperid == null) ? 0 : recipesswiperid.hashCode());
		result = prime * result + ((recipesswiperimg == null) ? 0 : recipesswiperimg.hashCode());
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
		RecipesSwiper other = (RecipesSwiper) obj;
		if (recipesid != other.recipesid)
			return false;
		if (recipesswipercreattime == null) {
			if (other.recipesswipercreattime != null)
				return false;
		} else if (!recipesswipercreattime.equals(other.recipesswipercreattime))
			return false;
		if (recipesswiperid == null) {
			if (other.recipesswiperid != null)
				return false;
		} else if (!recipesswiperid.equals(other.recipesswiperid))
			return false;
		if (recipesswiperimg == null) {
			if (other.recipesswiperimg != null)
				return false;
		} else if (!recipesswiperimg.equals(other.recipesswiperimg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecipesSwiper [recipesswiperid=" + recipesswiperid + ", recipesswiperimg=" + recipesswiperimg
				+ ", recipesid=" + recipesid + ", recipesswipercreattime=" + recipesswipercreattime + "]";
	}

	
	
}
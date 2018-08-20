package com.shensu.pojo;

import java.io.Serializable;
import java.util.List;

public class Recipes implements Serializable {

	private static final long serialVersionUID = 1L;

	RecipesType recipesType;
	
	//食谱的文章id
    private Integer recipesid;

    //商品的标题 
    private String recipestitle;

    //食谱的图片的地址
    private String recipesimg;

    //食谱文章的阅读量
    private Integer recipesbrowse;

    //食谱的创建的时间
    private String recipescreattime;

    //食谱的分类id
    private Integer recipestypeid;

    //食谱的材料
    private String recipesdata;

    //食谱的步骤保存json
    private String recipesstep;
    
    //0是下架 1是上架
    private Integer recipestypestate;
    			
    //食谱轮播图
    List<RecipesSwiper> recipesSwiper;

	public RecipesType getRecipesType() {
		return recipesType;
	}

	public void setRecipesType(RecipesType recipesType) {
		this.recipesType = recipesType;
	}

	public Integer getRecipesid() {
		return recipesid;
	}

	public void setRecipesid(Integer recipesid) {
		this.recipesid = recipesid;
	}

	public String getRecipestitle() {
		return recipestitle;
	}

	public void setRecipestitle(String recipestitle) {
		this.recipestitle = recipestitle;
	}

	public String getRecipesimg() {
		return recipesimg;
	}

	public void setRecipesimg(String recipesimg) {
		this.recipesimg = recipesimg;
	}

	public Integer getRecipesbrowse() {
		return recipesbrowse;
	}

	public void setRecipesbrowse(Integer recipesbrowse) {
		this.recipesbrowse = recipesbrowse;
	}

	public String getRecipescreattime() {
		return recipescreattime;
	}

	public void setRecipescreattime(String recipescreattime) {
		this.recipescreattime = recipescreattime;
	}

	public Integer getRecipestypeid() {
		return recipestypeid;
	}

	public void setRecipestypeid(Integer recipestypeid) {
		this.recipestypeid = recipestypeid;
	}

	public String getRecipesdata() {
		return recipesdata;
	}

	public void setRecipesdata(String recipesdata) {
		this.recipesdata = recipesdata;
	}

	public String getRecipesstep() {
		return recipesstep;
	}

	public void setRecipesstep(String recipesstep) {
		this.recipesstep = recipesstep;
	}

	public Integer getRecipestypestate() {
		return recipestypestate;
	}

	public void setRecipestypestate(Integer recipestypestate) {
		this.recipestypestate = recipestypestate;
	}

	public List<RecipesSwiper> getRecipesSwiper() {
		return recipesSwiper;
	}

	public void setRecipesSwiper(List<RecipesSwiper> recipesSwiper) {
		this.recipesSwiper = recipesSwiper;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recipesSwiper == null) ? 0 : recipesSwiper.hashCode());
		result = prime * result + ((recipesType == null) ? 0 : recipesType.hashCode());
		result = prime * result + ((recipesbrowse == null) ? 0 : recipesbrowse.hashCode());
		result = prime * result + ((recipescreattime == null) ? 0 : recipescreattime.hashCode());
		result = prime * result + ((recipesdata == null) ? 0 : recipesdata.hashCode());
		result = prime * result + ((recipesid == null) ? 0 : recipesid.hashCode());
		result = prime * result + ((recipesimg == null) ? 0 : recipesimg.hashCode());
		result = prime * result + ((recipesstep == null) ? 0 : recipesstep.hashCode());
		result = prime * result + ((recipestitle == null) ? 0 : recipestitle.hashCode());
		result = prime * result + ((recipestypeid == null) ? 0 : recipestypeid.hashCode());
		result = prime * result + ((recipestypestate == null) ? 0 : recipestypestate.hashCode());
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
		Recipes other = (Recipes) obj;
		if (recipesSwiper == null) {
			if (other.recipesSwiper != null)
				return false;
		} else if (!recipesSwiper.equals(other.recipesSwiper))
			return false;
		if (recipesType == null) {
			if (other.recipesType != null)
				return false;
		} else if (!recipesType.equals(other.recipesType))
			return false;
		if (recipesbrowse == null) {
			if (other.recipesbrowse != null)
				return false;
		} else if (!recipesbrowse.equals(other.recipesbrowse))
			return false;
		if (recipescreattime == null) {
			if (other.recipescreattime != null)
				return false;
		} else if (!recipescreattime.equals(other.recipescreattime))
			return false;
		if (recipesdata == null) {
			if (other.recipesdata != null)
				return false;
		} else if (!recipesdata.equals(other.recipesdata))
			return false;
		if (recipesid == null) {
			if (other.recipesid != null)
				return false;
		} else if (!recipesid.equals(other.recipesid))
			return false;
		if (recipesimg == null) {
			if (other.recipesimg != null)
				return false;
		} else if (!recipesimg.equals(other.recipesimg))
			return false;
		if (recipesstep == null) {
			if (other.recipesstep != null)
				return false;
		} else if (!recipesstep.equals(other.recipesstep))
			return false;
		if (recipestitle == null) {
			if (other.recipestitle != null)
				return false;
		} else if (!recipestitle.equals(other.recipestitle))
			return false;
		if (recipestypeid == null) {
			if (other.recipestypeid != null)
				return false;
		} else if (!recipestypeid.equals(other.recipestypeid))
			return false;
		if (recipestypestate == null) {
			if (other.recipestypestate != null)
				return false;
		} else if (!recipestypestate.equals(other.recipestypestate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipes [recipesType=" + recipesType + ", recipesid=" + recipesid + ", recipestitle=" + recipestitle
				+ ", recipesimg=" + recipesimg + ", recipesbrowse=" + recipesbrowse + ", recipescreattime="
				+ recipescreattime + ", recipestypeid=" + recipestypeid + ", recipesdata=" + recipesdata
				+ ", recipesstep=" + recipesstep + ", recipestypestate=" + recipestypestate + ", recipesSwiper="
				+ recipesSwiper + "]";
	}
    
    
}
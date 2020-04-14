package com.ats.webapi.model;

import java.util.List;

public class GetMCategoryList {

	List<GetMCategory> getMCategory;
	
	Info info;

	public List<GetMCategory> getGetMCategory() {
		return getMCategory;
	}

	public void setGetMCategory(List<GetMCategory> getMCategory) {
		this.getMCategory = getMCategory;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
}

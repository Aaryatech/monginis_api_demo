package com.ats.webapi.model;

import java.util.List;

public class GetItemByCatIdList {

	List<GetItemByCatId> getItemByCatId;
	Info info;
	public List<GetItemByCatId> getGetItemByCatId() {
		return getItemByCatId;
	}
	public void setGetItemByCatId(List<GetItemByCatId> getItemByCatId) {
		this.getItemByCatId = getItemByCatId;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	
}

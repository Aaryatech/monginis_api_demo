package com.ats.webapi.model;

import java.io.Serializable;
import java.util.List;

public class ItemSupList implements Serializable{
	
	List<GetItemSup> itemSupList;
	
	Info info;

	public List<GetItemSup> getItemSupList() {
		return itemSupList;
	}

	public void setItemSupList(List<GetItemSup> itemSupList) {
		this.itemSupList = itemSupList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ItemSupList [itemSupList=" + itemSupList + ", info=" + info + "]";
	}
	
	

}

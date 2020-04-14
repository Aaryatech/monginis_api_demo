package com.ats.webapi.model.opssalesreport;

import java.util.List;

public class SubCatWiseItems {

	private int subCatId;
	private String subCatName;
	
	private List<ItemList> itemList=null;

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public List<ItemList> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemList> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "SubCatWiseItems [subCatId=" + subCatId + ", subCatName=" + subCatName + ", itemList=" + itemList + "]";
	}

	
	
	
	
	
}

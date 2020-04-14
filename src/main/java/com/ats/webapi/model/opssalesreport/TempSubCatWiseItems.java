package com.ats.webapi.model.opssalesreport;

import java.util.List;

import com.ats.webapi.model.salesreport3.TempSubCatWiseBillData;

public class TempSubCatWiseItems {
	
	private int subCatId;
	private String subCatName;
	
	private List<TempItemList> itemList=null;

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

	public List<TempItemList> getItemList() {
		return itemList;
	}

	public void setItemList(List<TempItemList> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "TempSubCatWiseItems [subCatId=" + subCatId + ", subCatName=" + subCatName + ", itemList=" + itemList
				+ "]";
	}
	
	

}

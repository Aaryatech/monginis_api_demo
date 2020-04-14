package com.ats.webapi.model.yearlyreport;

import java.util.List;

public class TempSubCatList {

	private int subCatId;
	private String subCatName;
	
	private List<TempItemList> tempItemList=null;

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

	public List<TempItemList> getTempItemList() {
		return tempItemList;
	}

	public void setTempItemList(List<TempItemList> tempItemList) {
		this.tempItemList = tempItemList;
	}

	@Override
	public String toString() {
		return "TempSubCatList [subCatId=" + subCatId + ", subCatName=" + subCatName + ", tempItemList=" + tempItemList
				+ "]";
	}
	
	
	
}

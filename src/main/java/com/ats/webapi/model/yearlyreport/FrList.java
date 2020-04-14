package com.ats.webapi.model.yearlyreport;

import java.util.List;


public class FrList {
	
	private int frId;
	private String frName;

	private List<SubCatList> subCatList=null;

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public List<SubCatList> getSubCatList() {
		return subCatList;
	}

	public void setSubCatList(List<SubCatList> subCatList) {
		this.subCatList = subCatList;
	}

	@Override
	public String toString() {
		return "FrList [frId=" + frId + ", frName=" + frName + ", subCatList=" + subCatList + "]";
	}
	
	

}

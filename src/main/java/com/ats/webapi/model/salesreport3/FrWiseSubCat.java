package com.ats.webapi.model.salesreport3;

import java.util.List;

public class FrWiseSubCat {
	
	private int frId;
	private String frName;

	private List<SubCatWiseBillData> subCatList=null;

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

	public List<SubCatWiseBillData> getSubCatList() {
		return subCatList;
	}

	public void setSubCatList(List<SubCatWiseBillData> subCatList) {
		this.subCatList = subCatList;
	}

	@Override
	public String toString() {
		return "FrWiseSubCat [frId=" + frId + ", frName=" + frName + ", subCatList=" + subCatList + "]";
	}


	
	
}

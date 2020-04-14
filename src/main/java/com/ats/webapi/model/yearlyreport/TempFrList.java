package com.ats.webapi.model.yearlyreport;

import java.util.List;

public class TempFrList {

	private int frId;
	private String frName;

	private List<TempSubCatList> tempSubCatList=null;

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

	public List<TempSubCatList> getTempSubCatList() {
		return tempSubCatList;
	}

	public void setTempSubCatList(List<TempSubCatList> tempSubCatList) {
		this.tempSubCatList = tempSubCatList;
	}

	@Override
	public String toString() {
		return "TempFrList [frId=" + frId + ", frName=" + frName + ", tempSubCatList=" + tempSubCatList + "]";
	}
	
	
	
}

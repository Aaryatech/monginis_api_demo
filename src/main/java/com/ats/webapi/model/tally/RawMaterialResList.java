package com.ats.webapi.model.tally;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class RawMaterialResList {

	private List<RawMaterialResponse> rawMaterialList;
	
	ErrorMessage errorMessage;

	public List<RawMaterialResponse> getRawMaterialList() {
		return rawMaterialList;
	}

	public void setRawMaterialList(List<RawMaterialResponse> rawMaterialList) {
		this.rawMaterialList = rawMaterialList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "RawMaterialResList [rawMaterialList=" + rawMaterialList + ", errorMessage=" + errorMessage + "]";
	}
	
	
}

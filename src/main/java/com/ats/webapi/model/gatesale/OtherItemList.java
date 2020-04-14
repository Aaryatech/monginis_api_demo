package com.ats.webapi.model.gatesale;

import java.util.List;


import com.ats.webapi.model.ErrorMessage;


public class OtherItemList {
	
	private List<OtherItemRes> otherItemList;
	
	ErrorMessage errorMessage;


	public List<OtherItemRes> getOtherItemList() {
		return otherItemList;
	}

	public void setOtherItemList(List<OtherItemRes> otherItemList) {
		this.otherItemList = otherItemList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "OtherItemList [otherItemList=" + otherItemList + ", errorMessage=" + errorMessage + "]";
	}
    
}

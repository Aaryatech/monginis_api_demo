package com.ats.webapi.model.gatesale;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class GateSaleUserList {

	List<GetGateSaleUser> gateSaleUserList;
	
	ErrorMessage errorMessage;

	public List<GetGateSaleUser> getGateSaleUserList() {
		return gateSaleUserList;
	}

	public void setGateSaleUserList(List<GetGateSaleUser> gateSaleUserList) {
		this.gateSaleUserList = gateSaleUserList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "GateSaleUserList [gateSaleUserList=" + gateSaleUserList + ", errorMessage=" + errorMessage + "]";
	}
	
	
}

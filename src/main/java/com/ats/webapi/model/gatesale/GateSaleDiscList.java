package com.ats.webapi.model.gatesale;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class GateSaleDiscList {

	List<GateSaleDiscount> gateSaleDiscountList;
	
	ErrorMessage errorMessage;

	public List<GateSaleDiscount> getGateSaleDiscountList() {
		return gateSaleDiscountList;
	}

	public void setGateSaleDiscountList(List<GateSaleDiscount> gateSaleDiscountList) {
		this.gateSaleDiscountList = gateSaleDiscountList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "GateSaleDiscList [gateSaleDiscountList=" + gateSaleDiscountList + ", errorMessage=" + errorMessage
				+ "]";
	}
	
}

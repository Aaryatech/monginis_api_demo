package com.ats.webapi.model.purchaseorder;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class GetPurchaseOrder {
	
	List<GetPurchaseOrderList> getPurchaseOrderList;
	ErrorMessage errorMessage;
	public List<GetPurchaseOrderList> getGetPurchaseOrderList() {
		return getPurchaseOrderList;
	}
	public void setGetPurchaseOrderList(List<GetPurchaseOrderList> getPurchaseOrderList) {
		this.getPurchaseOrderList = getPurchaseOrderList;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}

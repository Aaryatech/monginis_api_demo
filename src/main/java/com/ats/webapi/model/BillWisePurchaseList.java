package com.ats.webapi.model;

import java.io.Serializable;
import java.util.List;

public class BillWisePurchaseList implements Serializable{

	List<BillWisePurchase> billWisePurchaseList;
	ErrorMessage errorMessage;
	public List<BillWisePurchase> getBillWisePurchaseList() {
		return billWisePurchaseList;
	}
	public void setBillWisePurchaseList(List<BillWisePurchase> billWisePurchaseList) {
		this.billWisePurchaseList = billWisePurchaseList;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "BillWisePurchaseList [billWisePurchaseList=" + billWisePurchaseList + ", errorMessage=" + errorMessage
				+ "]";
	}
	
	
}

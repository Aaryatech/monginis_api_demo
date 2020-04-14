package com.ats.webapi.model;

public class SpCakeOrderRes {
	
	
	SpCakeOrders spCakeOrder;
	ErrorMessage errorMessage;
	public SpCakeOrders getSpCakeOrder() {
		return spCakeOrder;
	}
	public void setSpCakeOrder(SpCakeOrders spCakeOrder) {
		this.spCakeOrder = spCakeOrder;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}

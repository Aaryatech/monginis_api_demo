package com.ats.webapi.model;

import java.util.List;

public class RegSpCkOrderResponse {
	
List<RegularSpCkOrders> regularSpCkOrdersList;
ErrorMessage errorMessage;

public List<RegularSpCkOrders> getRegularSpCkOrdersList() {
	return regularSpCkOrdersList;
}
public void setRegularSpCkOrdersList(List<RegularSpCkOrders> regularSpCkOrdersList) {
	this.regularSpCkOrdersList = regularSpCkOrdersList;
}
public ErrorMessage getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(ErrorMessage errorMessage) {
	this.errorMessage = errorMessage;
}

}

package com.ats.webapi.model;

import java.util.List;

public class AllRegularSpCkItems {
	
	List<GetRegularSpCkItems> getRegularSpCkItems;
	ErrorMessage errorMessage;
	public List<GetRegularSpCkItems> getGetRegularSpCkItems() {
		return getRegularSpCkItems;
	}
	public void setGetRegularSpCkItems(List<GetRegularSpCkItems> getRegularSpCkItems) {
		this.getRegularSpCkItems = getRegularSpCkItems;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}

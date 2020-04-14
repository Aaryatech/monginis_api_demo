package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.ItemWithSubCat;

public class ItemsList {
	List<Item> items;
	ErrorMessage errorMessage;
	
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}

package com.ats.webapi.model.rawmaterial;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class ItemSfHeaderList {

	List<ItemSfHeader> itemSfHeaderList;
	
	ErrorMessage errorMessage;

	public List<ItemSfHeader> getItemSfHeaderList() {
		return itemSfHeaderList;
	}

	public void setItemSfHeaderList(List<ItemSfHeader> itemSfHeaderList) {
		this.itemSfHeaderList = itemSfHeaderList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}

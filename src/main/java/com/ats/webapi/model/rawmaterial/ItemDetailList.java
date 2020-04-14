package com.ats.webapi.model.rawmaterial;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class ItemDetailList {

	List<GetItemDetail> itemDetailList;
	ErrorMessage errorMessage;
	public List<GetItemDetail> getItemDetailList() {
		return itemDetailList;
	}
	public void setItemDetailList(List<GetItemDetail> itemDetailList) {
		this.itemDetailList = itemDetailList;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "ItemDetailList [itemDetailList=" + itemDetailList + ", errorMessage=" + errorMessage + "]";
	}
	
	
}

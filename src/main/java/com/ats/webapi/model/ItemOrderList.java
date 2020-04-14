package com.ats.webapi.model;

import java.util.List;

public class ItemOrderList {
List<ItemOrderHis> itemOrderList;
ErrorMessage errorMessage;
public List<ItemOrderHis> getItemOrderList() {
	return itemOrderList;
}
public ErrorMessage getErrorMessage() {
	return errorMessage;
}
public void setItemOrderList(List<ItemOrderHis> itemOrderList) {
	this.itemOrderList = itemOrderList;
}
public void setErrorMessage(ErrorMessage errorMessage) {
	this.errorMessage = errorMessage;
}

}

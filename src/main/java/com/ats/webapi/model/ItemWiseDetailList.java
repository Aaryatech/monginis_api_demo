package com.ats.webapi.model;

import java.io.Serializable;
import java.util.List;

public class ItemWiseDetailList implements Serializable{
	
List<ItemWiseDetail> itemWiseDetailList;
ErrorMessage errorMessage;
public List<ItemWiseDetail> getItemWiseDetailList() {
	return itemWiseDetailList;
}
public void setItemWiseDetailList(List<ItemWiseDetail> itemWiseDetailList) {
	this.itemWiseDetailList = itemWiseDetailList;
}
public ErrorMessage getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(ErrorMessage errorMessage) {
	this.errorMessage = errorMessage;
}
@Override
public String toString() {
	return "ItemWiseDetailList [itemWiseDetailList=" + itemWiseDetailList + ", errorMessage=" + errorMessage + "]";
}


}

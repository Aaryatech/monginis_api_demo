package com.ats.webapi.model;

import java.util.List;

public class SpCkOrderHisList {
List<SpCkOrderHis> spOrderList;
ErrorMessage errorMessage;
public List<SpCkOrderHis> getSpOrderList() {
	return spOrderList;
}
public ErrorMessage getErrorMessage() {
	return errorMessage;
}
public void setSpOrderList(List<SpCkOrderHis> spOrderList) {
	this.spOrderList = spOrderList;
}
public void setErrorMessage(ErrorMessage errorMessage) {
	this.errorMessage = errorMessage;
}


}

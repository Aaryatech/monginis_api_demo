package com.ats.webapi.model;

import java.util.List;

public class FrMenusList {
ErrorMessage errorMessage;
List<FrMenus> frMenus;
public ErrorMessage getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(ErrorMessage errorMessage) {
	this.errorMessage = errorMessage;
}
public List<FrMenus> getFrMenus() {
	return frMenus;
}
public void setFrMenus(List<FrMenus> frMenus) {
	this.frMenus = frMenus;
}

}

package com.ats.webapi.model;

public class LoginResponse {
User user;
ErrorMessage errorMessage;
public User getUser() {
	return user;
}
public ErrorMessage getErrorMessage() {
	return errorMessage;
}
public void setUser(User user) {
	this.user = user;
}
public void setErrorMessage(ErrorMessage errorMessage) {
	this.errorMessage = errorMessage;
}

}

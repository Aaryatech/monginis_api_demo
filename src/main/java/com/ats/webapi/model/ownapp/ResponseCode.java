package com.ats.webapi.model.ownapp;

public class ResponseCode {

	int statusCode;
	String message;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseCode [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	
	
	
}

package com.ats.webapi.service;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

import com.ats.webapi.model.SpMessage;;
public class spMessageList 
{
	List<SpMessage> spMsg;
	ErrorMessage errorMessage;
	public List<SpMessage> getspMessage() {
		return spMsg;
	}
	public void setSpMessage(List<SpMessage> spMsg) {
		this.spMsg = spMsg;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
}

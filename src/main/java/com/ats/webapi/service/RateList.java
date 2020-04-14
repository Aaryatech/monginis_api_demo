package com.ats.webapi.service;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

import com.ats.webapi.model.Rates;
public class RateList {

	List<Rates> rates;
	ErrorMessage errorMessage;
	public List<Rates> getRates() {
		return rates;
	}
	public void setRates(List<Rates> rates) {
		this.rates = rates;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
}

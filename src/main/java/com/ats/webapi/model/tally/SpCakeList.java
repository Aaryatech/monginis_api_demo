package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class SpCakeList implements Serializable{

	List<SpecialCake> specialCakeList;
	
	ErrorMessage errorMessage;

	public List<SpecialCake> getSpecialCakeList() {
		return specialCakeList;
	}

	public void setSpecialCakeList(List<SpecialCake> specialCakeList) {
		this.specialCakeList = specialCakeList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "SpCakeList [specialCakeList=" + specialCakeList + ", errorMessage=" + errorMessage + "]";
	}
	
	
	
}

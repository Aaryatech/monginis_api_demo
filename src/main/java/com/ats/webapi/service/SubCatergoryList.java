package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.SubCategory;

public class SubCatergoryList {

	List<SubCategory> subCategory;
	
	ErrorMessage errorMessage;

	public List<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
	
}

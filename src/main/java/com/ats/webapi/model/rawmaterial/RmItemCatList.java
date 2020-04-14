package com.ats.webapi.model.rawmaterial;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class RmItemCatList implements Serializable{
	
	List<GetRmItemCategory> rmItemCategoryList;

	ErrorMessage errorMessage;

	public List<GetRmItemCategory> getRmItemCategoryList() {
		return rmItemCategoryList;
	}

	public void setRmItemCategoryList(List<GetRmItemCategory> rmItemCategoryList) {
		this.rmItemCategoryList = rmItemCategoryList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
}

package com.ats.webapi.model.spprod;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class TypeList implements Serializable{

	private List<MType> typeList;
	
	private ErrorMessage errorMessage;

	public List<MType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<MType> typeList) {
		this.typeList = typeList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "TypeList [typeList=" + typeList + ", errorMessage=" + errorMessage + "]";
	}
	
	
}

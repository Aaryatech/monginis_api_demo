package com.ats.webapi.model.gatesale;

import java.util.List;

import javax.persistence.Entity;

import com.ats.webapi.model.ErrorMessage;


public class OtherSupplierList {

	private List<OtherSupplier> otherSupplierList;
	
	ErrorMessage errorMessage;

	public List<OtherSupplier> getOtherSupplierList() {
		return otherSupplierList;
	}

	public void setOtherSupplierList(List<OtherSupplier> otherSupplierList) {
		this.otherSupplierList = otherSupplierList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "OtherSupplierList [otherSupplierList=" + otherSupplierList + ", errorMessage=" + errorMessage + "]";
	}
    
}

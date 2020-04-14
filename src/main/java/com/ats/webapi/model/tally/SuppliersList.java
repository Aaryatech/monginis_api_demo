package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.SupplierMaster.SupplierDetails;

public class SuppliersList implements Serializable{

	List<SupplierDetails> supplierList;
	
	ErrorMessage errorMessage;

	public List<SupplierDetails> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<SupplierDetails> supplierList) {
		this.supplierList = supplierList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}

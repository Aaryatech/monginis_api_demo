package com.ats.webapi.model.SupplierMaster;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class SupPaymentTermsList implements Serializable {

	List<SupPaymentTerms> SupPaymentTermsList;
	
	ErrorMessage errorMessage;

	public List<SupPaymentTerms> getSupPaymentTermsList() {
		return SupPaymentTermsList;
	}

	public void setSupPaymentTermsList(List<SupPaymentTerms> supPaymentTermsList) {
		SupPaymentTermsList = supPaymentTermsList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}

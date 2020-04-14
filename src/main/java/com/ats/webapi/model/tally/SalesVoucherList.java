package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class SalesVoucherList implements Serializable{

	List<SalesVoucher> salesVoucherList;
	
	ErrorMessage errorMessage;

	public List<SalesVoucher> getSalesVoucherList() {
		return salesVoucherList;
	}

	public void setSalesVoucherList(List<SalesVoucher> salesVoucherList) {
		this.salesVoucherList = salesVoucherList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "SalesVoucherList [salesVoucherList=" + salesVoucherList + ", errorMessage=" + errorMessage + "]";
	}
	
	
}

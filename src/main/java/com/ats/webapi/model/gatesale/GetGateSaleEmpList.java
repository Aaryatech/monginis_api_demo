package com.ats.webapi.model.gatesale;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class GetGateSaleEmpList implements Serializable{

	List<GetGateSaleEmp> getGateSaleEmpList;
	
	ErrorMessage errorMessage;

	public List<GetGateSaleEmp> getGetGateSaleEmpList() {
		return getGateSaleEmpList;
	}

	public void setGetGateSaleEmpList(List<GetGateSaleEmp> getGateSaleEmpList) {
		this.getGateSaleEmpList = getGateSaleEmpList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "GetGateSaleEmpList [getGateSaleEmpList=" + getGateSaleEmpList + ", errorMessage=" + errorMessage + "]";
	}
}

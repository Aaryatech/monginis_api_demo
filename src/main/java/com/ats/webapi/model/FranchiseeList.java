package com.ats.webapi.model;

import java.util.List;

public class FranchiseeList {

	List<Franchisee> franchiseeList=null;
	ErrorMessage errorMessage=null;
	public List<Franchisee> getFranchiseeList() {
		return franchiseeList;
	}
	public void setFranchiseeList(List<Franchisee> franchiseeList) {
		this.franchiseeList = franchiseeList;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "FranchiseeList [franchiseeList=" + franchiseeList + ", errorMessage=" + errorMessage + "]";
	}
	
}

package com.ats.webapi.repository;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.MainModule;

public class ModuleJsonArray {
	List<MainModule> mainModuleList;
	ErrorMessage errorMessage;
	public List<MainModule> getMainModuleList() {
		return mainModuleList;
	}
	public void setMainModuleList(List<MainModule> mainModuleList) {
		this.mainModuleList = mainModuleList;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}

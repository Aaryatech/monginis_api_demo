package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.MainModuleWithSubModule;

public class ModulesList {
	List<MainModuleWithSubModule> mainModuleWithSubModule;
	
	ErrorMessage errorMessage;

	public List<MainModuleWithSubModule> getMainModuleWithSubModule() {
		return mainModuleWithSubModule;
	}

	public void setMainModuleWithSubModule(List<MainModuleWithSubModule> mainModuleWithSubModule) {
		this.mainModuleWithSubModule = mainModuleWithSubModule;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}

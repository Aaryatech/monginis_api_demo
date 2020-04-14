package com.ats.webapi.model;

import java.util.List;

public class AllMenuJsonResponse {

	private List<AllMenus> menuConfigurationPage;

	private ErrorMessage errorMessage;
	
	
	public List<AllMenus> getMenuConfigurationPage() {
		return menuConfigurationPage;
	}
	public void setMenuConfigurationPage(List<AllMenus> menuConfigurationPage) {
		this.menuConfigurationPage = menuConfigurationPage;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}

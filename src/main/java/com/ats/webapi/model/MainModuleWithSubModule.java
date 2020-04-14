package com.ats.webapi.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ats.webapi.model.MainModule;
import com.ats.webapi.model.SubModule;

public class MainModuleWithSubModule{

	@Autowired
	private MainModule mainModule;
	private List<SubModule> subModuleList;
	
	public MainModule getMainModule() {
		return mainModule;
	}
	public void setMainModule(MainModule mainModule) {
		this.mainModule = mainModule;
	}
	public List<SubModule> getSubModuleList() {
		return subModuleList;
	}
	public void setSubModuleList(List<SubModule> subModuleList) {
		this.subModuleList = subModuleList;
	}
	
}

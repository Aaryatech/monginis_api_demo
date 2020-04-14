package com.ats.webapi.model;

import java.util.List;

public class AccessRightModuleList {

	
	List<AccessRightModule> accessRightModuleList;
	
	Info info;

	public List<AccessRightModule> getAccessRightModuleList() {
		return accessRightModuleList;
	}

	public void setAccessRightModuleList(List<AccessRightModule> accessRightModuleList) {
		this.accessRightModuleList = accessRightModuleList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "AccessRightModuleList [accessRightModuleList=" + accessRightModuleList + ", info=" + info + "]";
	}
	
	
}

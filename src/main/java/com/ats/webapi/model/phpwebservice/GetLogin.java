package com.ats.webapi.model.phpwebservice;

import java.util.List;

public class GetLogin {
	
	String status;

	Admin admin;
	
	List<Flavor> flavor;

	public String getStatus() {
		return status;
	}

	public Admin getAdmin() {
		return admin;
	}

	public List<Flavor> getFlavor() {
		return flavor;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setFlavor(List<Flavor> flavor) {
		this.flavor = flavor;
	}

	
	@Override
	public String toString() {
		
		return "GetLogin [status=" + status + ", admin=" + admin + ", flavor=" + flavor + "]";
	}
	
	
	
}

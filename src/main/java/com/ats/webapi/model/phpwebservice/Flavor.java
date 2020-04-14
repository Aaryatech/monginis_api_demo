package com.ats.webapi.model.phpwebservice;

public class Flavor {

	
	private String spe_id;
	private String spe_name;
	private String del_status;
	public String getSpe_id() {
		return spe_id;
	}
	public String getSpe_name() {
		return spe_name;
	}
	public String getDel_status() {
		return del_status;
	}
	public void setSpe_id(String spe_id) {
		this.spe_id = spe_id;
	}
	public void setSpe_name(String spe_name) {
		this.spe_name = spe_name;
	}
	public void setDel_status(String del_status) {
		this.del_status = del_status;
	}
	@Override
	public String toString() {
		return "Flavor [spe_id=" + spe_id + ", spe_name=" + spe_name + ", del_status=" + del_status + "]";
	}
	
	
	
}

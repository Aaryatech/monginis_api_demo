package com.ats.webapi.model.phpwebservice;

public class Admin {
	
	private boolean error;
	
	private String fr_id;
	
	private String fr_name;
	
	private String fr_image;
	
	private String fr_email;
	
	private String type;

	public boolean isError() {
		return error;
	}

	public String getFr_id() {
		return fr_id;
	}

	public String getFr_name() {
		return fr_name;
	}

	public String getFr_image() {
		return fr_image;
	}

	public String getFr_email() {
		return fr_email;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public void setFr_id(String fr_id) {
		this.fr_id = fr_id;
	}

	public void setFr_name(String fr_name) {
		this.fr_name = fr_name;
	}

	public void setFr_image(String fr_image) {
		this.fr_image = fr_image;
	}

	public void setFr_email(String fr_email) {
		this.fr_email = fr_email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Admin [error=" + error + ", fr_id=" + fr_id + ", fr_name=" + fr_name + ", fr_image=" + fr_image
				+ ", fr_email=" + fr_email + ", type=" + type + "]";
	}

	
}

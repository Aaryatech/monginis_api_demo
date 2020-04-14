package com.ats.webapi.model;

import com.ats.webapi.model.logistics.DriverMaster;

public class LoginDriverResponse {

	DriverMaster driver;
	User user;
	private boolean error;
	private String msg;

	public DriverMaster getDriver() {
		return driver;
	}

	public void setDriver(DriverMaster driver) {
		this.driver = driver;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "LoginDriverResponse [driver=" + driver + ", user=" + user + ", error=" + error + ", msg=" + msg + "]";
	}

}

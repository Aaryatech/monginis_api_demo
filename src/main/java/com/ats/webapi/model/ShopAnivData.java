package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShopAnivData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int frId;
	
	private int noOfYears;
	
	private String token;

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "ShopAnivData [frId=" + frId + ", noOfYears=" + noOfYears + ", token=" + token + "]";
	}
	
	
}

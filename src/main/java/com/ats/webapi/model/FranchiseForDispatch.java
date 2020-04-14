package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FranchiseForDispatch implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_route_id")
	private int frRouteId;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="fr_rate")
	private int frRate;
	
	@Column(name="fr_rate_cat")
	private int frRateCat;

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getFrRouteId() {
		return frRouteId;
	}

	public void setFrRouteId(int frRouteId) {
		this.frRouteId = frRouteId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public int getFrRate() {
		return frRate;
	}

	public void setFrRate(int frRate) {
		this.frRate = frRate;
	}

	public int getFrRateCat() {
		return frRateCat;
	}

	public void setFrRateCat(int frRateCat) {
		this.frRateCat = frRateCat;
	}

	@Override
	public String toString() {
		return "FranchiseForDispatch [frId=" + frId + ", frRouteId=" + frRouteId + ", frName=" + frName + ", frRate="
				+ frRate + ", frRateCat=" + frRateCat + "]";
	}
	
	
}

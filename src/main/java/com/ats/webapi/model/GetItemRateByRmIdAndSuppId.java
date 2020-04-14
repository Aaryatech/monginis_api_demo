package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetItemRateByRmIdAndSuppId {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rate_id")
	private int rateId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rate")
	private float rate;
	
	@Column(name="supp_id")
	private int suppId;

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	@Override
	public String toString() {
		return "GetItemRateByRmIdAndSuppId [rateId=" + rateId + ", rmId=" + rmId + ", rmName=" + rmName + ", rate="
				+ rate + ", suppId=" + suppId + "]";
	}
	
	
	

}

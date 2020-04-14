package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RmRateVerificationList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_rate_ver_id")
	private int rmRateVerId;
	
	@Column(name="supp_id")
	private int suppId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="supp_name")
	private String suppName;
	
	@Column(name="rm_name")
	private String rmName;


	public int getRmRateVerId() {
		return rmRateVerId;
	}

	public void setRmRateVerId(int rmRateVerId) {
		this.rmRateVerId = rmRateVerId;
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	@Override
	public String toString() {
		return "RmRateVerificationList [rmRateVerId=" + rmRateVerId + ", suppId=" + suppId + ", rmId=" + rmId
				+ ", suppName=" + suppName + ", rmName=" + rmName + "]";
	}
	 

}

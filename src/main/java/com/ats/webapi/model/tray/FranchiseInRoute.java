package com.ats.webapi.model.tray;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FranchiseInRoute implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="fr_code")
	private String frCode;

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}

	@Override
	public String toString() {
		return "FranchiseInRoute [frId=" + frId + ", frName=" + frName + ", frCode=" + frCode + "]";
	}
	
}

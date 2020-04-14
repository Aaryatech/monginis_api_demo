package com.ats.webapi.model.spprod;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetInstVerifDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inst_verif_d_id")
	private int instVerifDId;

	@Column(name="inst_verif_h_id")
	private int instVerifHId;
	
	@Column(name="inst_id")
	private int instId;
	
	@Column(name="instrument_name")
	private String instrumentName;
	
	@Column(name="bef")
	private int beforeStatus;
	
	@Column(name="aft")
	private int afterStatus;

	
	public int getBeforeStatus() {
		return beforeStatus;
	}

	public void setBeforeStatus(int beforeStatus) {
		this.beforeStatus = beforeStatus;
	}

	public int getAfterStatus() {
		return afterStatus;
	}

	public void setAfterStatus(int afterStatus) {
		this.afterStatus = afterStatus;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public int getInstVerifDId() {
		return instVerifDId;
	}

	public void setInstVerifDId(int instVerifDId) {
		this.instVerifDId = instVerifDId;
	}

	public int getInstVerifHId() {
		return instVerifHId;
	}

	public void setInstVerifHId(int instVerifHId) {
		this.instVerifHId = instVerifHId;
	}

	public int getInstId() {
		return instId;
	}

	public void setInstId(int instId) {
		this.instId = instId;
	}

	@Override
	public String toString() {
		return "GetInstVerifDetail [instVerifDId=" + instVerifDId + ", instVerifHId=" + instVerifHId + ", instId="
				+ instId + ", instrumentName=" + instrumentName + ", beforeStatus=" + beforeStatus + ", afterStatus="
				+ afterStatus + "]";
	}
     
}

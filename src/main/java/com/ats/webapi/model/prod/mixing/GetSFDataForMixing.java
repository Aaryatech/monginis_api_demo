package com.ats.webapi.model.prod.mixing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class GetSFDataForMixing {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sf_did")
	private int sfDid;
	
	

	int total;
	
	@Column(name="rm_type")
	private int rmType;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="uom")
	private String uom;
	
	
	@Column(name="sf_id")
	private int sfId;
	
	@Column(name="rm_name")
	private String rmName;

	public int getSfDid() {
		return sfDid;
	}

	public void setSfDid(int sfDid) {
		this.sfDid = sfDid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getSfId() {
		return sfId;
	}

	public void setSfId(int sfId) {
		this.sfId = sfId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	@Override
	public String toString() {
		return "GetSFDataForMixing [sfDid=" + sfDid + ", total=" + total + ", rmType=" + rmType + ", rmId=" + rmId
				+ ", uom=" + uom + ", sfId=" + sfId + ", rmName=" + rmName + "]";
	}
	
	
}

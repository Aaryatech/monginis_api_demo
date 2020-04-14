package com.ats.webapi.model.prod.mixing;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetSpDetailForBom implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_cake_detailed_id")
	private int spCakeDetailedId;
	
	@Column(name="sp_id")
	private int spId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_type")
	private int rmType;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="total")
	private int total;

	public int getSpCakeDetailedId() {
		return spCakeDetailedId;
	}

	public void setSpCakeDetailedId(int spCakeDetailedId) {
		this.spCakeDetailedId = spCakeDetailedId;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
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

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "GetSpMixingForBom [spCakeDetailedId=" + spCakeDetailedId + ", spId=" + spId + ", rmId=" + rmId
				+ ", rmName=" + rmName + ", rmType=" + rmType + ", uom=" + uom + ", total=" + total + "]";
	}
	
	
}

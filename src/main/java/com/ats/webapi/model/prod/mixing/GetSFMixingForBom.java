package com.ats.webapi.model.prod.mixing;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetSFMixingForBom implements Serializable {
	
/*	sf_id
	rm_id
	rm_name
	rm_type
	rm_unit
	total
*/
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sf_did")
	private int sfDid;
	
	@Column(name="sf_id")
	private int sfId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_type")
	private int rmType;
	
	@Column(name="uom")
	private String uom;
	
	float total;

	public int getSfDid() {
		return sfDid;
	}

	public void setSfDid(int sfDid) {
		this.sfDid = sfDid;
	}

	public int getSfId() {
		return sfId;
	}

	public void setSfId(int sfId) {
		this.sfId = sfId;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "GetSFMixingForBom [sfDid=" + sfDid + ", sfId=" + sfId + ", rmId=" + rmId + ", rmName=" + rmName
				+ ", rmType=" + rmType + ", uom=" + uom + ", total=" + total + "]";
	}
	
	

}

package com.ats.webapi.model.rawmaterial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_item_sf_detail")

public class ItemSfDetail implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sf_did")
	private int sfDid;
	
	@Column(name="sf_id")
	private int sfId;
	
	@Column(name="rm_type")
	private int rmType;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_qty")
	private float rmQty;
	
	@Column(name="rm_unit")
	private int rmUnit;
	
	@Column(name="rm_weight")
	private float rmWeight;
	
	@Column(name="del_status")
	private int delStatus;

	public int getSfDid() {
		return sfDid;
	}

	public int getSfId() {
		return sfId;
	}

	public int getRmId() {
		return rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public float getRmQty() {
		return rmQty;
	}

	public int getRmUnit() {
		return rmUnit;
	}

	public float getRmWeight() {
		return rmWeight;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setSfDid(int sfDid) {
		this.sfDid = sfDid;
	}

	public void setSfId(int sfId) {
		this.sfId = sfId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public void setRmQty(float rmQty) {
		this.rmQty = rmQty;
	}

	public void setRmUnit(int rmUnit) {
		this.rmUnit = rmUnit;
	}

	public void setRmWeight(float rmWeight) {
		this.rmWeight = rmWeight;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

}

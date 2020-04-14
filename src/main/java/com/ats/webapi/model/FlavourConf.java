package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_sp_flavour_conf")
public class FlavourConf implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="flav_id")
	private int flavId;
	
	@Column(name="spf_id")
	private int spfId;
	
	@Column(name="sp_type")
	private int spType;
	
	@Column(name="rate")
	private float rate;
	
	@Column(name="mrp")
	private float mrp;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="sp_id")
	private int spId;

	
	
	public int getSpType() {
		return spType;
	}

	public void setSpType(int spType) {
		this.spType = spType;
	}

	public int getFlavId() {
		return flavId;
	}

	public void setFlavId(int flavId) {
		this.flavId = flavId;
	}

	public int getSpfId() {
		return spfId;
	}

	public void setSpfId(int spfId) {
		this.spfId = spfId;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	@Override
	public String toString() {
		return "FlavourConf [flavId=" + flavId + ", spfId=" + spfId + ", spType=" + spType + ", rate=" + rate + ", mrp="
				+ mrp + ", delStatus=" + delStatus + ", exVar1=" + exVar1 + ", exInt1=" + exInt1 + ", spId=" + spId
				+ "]";
	}

	
}

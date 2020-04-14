package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_mixing_detail")
public class MixingDetailed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mixing_detail_id")
	private int mixing_detailId;

	@Column(name="mixing_id")
	private int mixingId;
	
	@Column(name="sf_id")
	private int sfId;

	@Column(name="sf_name")
	private String sfName;
	
	@Column(name="received_qty")
	private float receivedQty;
	
	@Column(name="production_qty")
	private float productionQty;
	
	@Column(name="mixing_date")
	private Date mixingDate;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_int3")
	private int exInt3;
	
	@Column(name="ex_varchar1")
	private String exVarchar1;
	
	@Column(name="ex_varchar2")
	private String exVarchar2;
	
	@Column(name="ex_varchar3")
	private String exVarchar3;
	
	@Column(name="ex_bool1")
	private int exBool1;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="rejected_qty")
	private float rejectedQty;
	
	@Column(name="original_qty")
	private float originalQty;
	
	@Column(name="auto_order_qty")
	private float autoOrderQty;
	
	
	 
	
	public float getRejectedQty() {
		return rejectedQty;
	}

	public void setRejectedQty(float rejectedQty) {
		this.rejectedQty = rejectedQty;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getMixing_detailId() {
		return mixing_detailId;
	}

	public void setMixing_detailId(int mixing_detailId) {
		this.mixing_detailId = mixing_detailId;
	}

	public int getMixingId() {
		return mixingId;
	}

	public void setMixingId(int mixingId) {
		this.mixingId = mixingId;
	}

	public int getSfId() {
		return sfId;
	}

	public void setSfId(int sfId) {
		this.sfId = sfId;
	}

	public String getSfName() {
		return sfName;
	}

	public void setSfName(String sfName) {
		this.sfName = sfName;
	}

	public float getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(float receivedQty) {
		this.receivedQty = receivedQty;
	}

	public float getProductionQty() {
		return productionQty;
	}

	public void setProductionQty(float productionQty) {
		this.productionQty = productionQty;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getMixingDate() {
		return mixingDate;
	}

	public void setMixingDate(Date mixingDate) {
		this.mixingDate = mixingDate;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public int getExInt3() {
		return exInt3;
	}

	public void setExInt3(int exInt3) {
		this.exInt3 = exInt3;
	}

	public String getExVarchar1() {
		return exVarchar1;
	}

	public void setExVarchar1(String exVarchar1) {
		this.exVarchar1 = exVarchar1;
	}

	public String getExVarchar2() {
		return exVarchar2;
	}

	public void setExVarchar2(String exVarchar2) {
		this.exVarchar2 = exVarchar2;
	}

	public String getExVarchar3() {
		return exVarchar3;
	}

	public void setExVarchar3(String exVarchar3) {
		this.exVarchar3 = exVarchar3;
	}

	public int getExBool1() {
		return exBool1;
	}

	public void setExBool1(int exBool1) {
		this.exBool1 = exBool1;
	}

	public float getOriginalQty() {
		return originalQty;
	}

	public void setOriginalQty(float originalQty) {
		this.originalQty = originalQty;
	}

	public float getAutoOrderQty() {
		return autoOrderQty;
	}

	public void setAutoOrderQty(float autoOrderQty) {
		this.autoOrderQty = autoOrderQty;
	}

	@Override
	public String toString() {
		return "MixingDetailed [mixing_detailId=" + mixing_detailId + ", mixingId=" + mixingId + ", sfId=" + sfId
				+ ", sfName=" + sfName + ", receivedQty=" + receivedQty + ", productionQty=" + productionQty
				+ ", mixingDate=" + mixingDate + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3
				+ ", exVarchar1=" + exVarchar1 + ", exVarchar2=" + exVarchar2 + ", exVarchar3=" + exVarchar3
				+ ", exBool1=" + exBool1 + ", uom=" + uom + ", rejectedQty=" + rejectedQty + ", originalQty="
				+ originalQty + ", autoOrderQty=" + autoOrderQty + "]";
	}


}

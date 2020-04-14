package com.ats.webapi.model.materialrecreport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetMaterialRecieptReportMonthWise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mrn_id")
	private int mrnId;
	
	@Column(name="month")
	private String month;
	
	@Column(name="basic_value")
	private float basicValue;
	
	@Column(name="disc_amt")
	private float discAmt;
	
	@Column(name="other")
	private float other;
	
	@Column(name="freight_amt")
	private float freightAmt;
	
	@Column(name="insurance_amt")
	private float insuranceAmt;
	
	@Column(name="cgst")
	private float cgst;
	
	@Column(name="sgst")
	private float sgst;
	
	@Column(name="igst")
	private float igst;
	
	@Column(name="cess")
	private float cess;
	
	@Column(name="bill_amount")
	private float billAmount;
	
	

	public float getOther() {
		return other;
	}

	public void setOther(float other) {
		this.other = other;
	}

	public float getCess() {
		return cess;
	}

	public void setCess(float cess) {
		this.cess = cess;
	}

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public float getBasicValue() {
		return basicValue;
	}

	public void setBasicValue(float basicValue) {
		this.basicValue = basicValue;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getFreightAmt() {
		return freightAmt;
	}

	public void setFreightAmt(float freightAmt) {
		this.freightAmt = freightAmt;
	}

	public float getInsuranceAmt() {
		return insuranceAmt;
	}

	public void setInsuranceAmt(float insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "GetMaterialRecieptReportMonthWise [mrnId=" + mrnId + ", month=" + month + ", basicValue=" + basicValue
				+ ", discAmt=" + discAmt + ", other=" + other + ", freightAmt=" + freightAmt + ", insuranceAmt="
				+ insuranceAmt + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", cess=" + cess
				+ ", billAmount=" + billAmount + "]";
	}
	
	
	
	 

}

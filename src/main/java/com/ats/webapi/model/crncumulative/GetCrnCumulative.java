package com.ats.webapi.model.crncumulative;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetCrnCumulative implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;
	
	@Column(name = "crn_date")
	private Date crnDate;
	
	@Column(name = "crn_no")
	private String crnNo;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "crn_taxable_amt")
	private float crnTaxableAmt;

	@Column(name = "crn_total_tax")
	private float crnTotalTax;

	@Column(name = "crn_grand_total")
	private float crnGrandTotal;

	@Column(name = "round_off")
	private float roundOff;

	@Column(name = "fr_name")
	private String frName;

	@Column(name = "fr_address")
	private String frAddress;
	
	@Column(name = "fr_gst_no")
	private String frGstNo;

	
	public String getCrnNo() {
		return crnNo;
	}

	public void setCrnNo(String crnNo) {
		this.crnNo = crnNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCrnDate() {
		return crnDate;
	}

	public void setCrnDate(Date crnDate) {
		this.crnDate = crnDate;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public float getCrnTaxableAmt() {
		return crnTaxableAmt;
	}

	public void setCrnTaxableAmt(float crnTaxableAmt) {
		this.crnTaxableAmt = crnTaxableAmt;
	}

	public float getCrnTotalTax() {
		return crnTotalTax;
	}

	public void setCrnTotalTax(float crnTotalTax) {
		this.crnTotalTax = crnTotalTax;
	}

	public float getCrnGrandTotal() {
		return crnGrandTotal;
	}

	public void setCrnGrandTotal(float crnGrandTotal) {
		this.crnGrandTotal = crnGrandTotal;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getFrAddress() {
		return frAddress;
	}

	public void setFrAddress(String frAddress) {
		this.frAddress = frAddress;
	}

	public String getFrGstNo() {
		return frGstNo;
	}

	public void setFrGstNo(String frGstNo) {
		this.frGstNo = frGstNo;
	}

	@Override
	public String toString() {
		return "GetCrnCumulative [id=" + id + ", crnDate=" + crnDate + ", crnNo=" + crnNo + ", frId=" + frId
				+ ", crnTaxableAmt=" + crnTaxableAmt + ", crnTotalTax=" + crnTotalTax + ", crnGrandTotal="
				+ crnGrandTotal + ", roundOff=" + roundOff + ", frName=" + frName + ", frAddress=" + frAddress
				+ ", frGstNo=" + frGstNo + "]";
	}

	
}

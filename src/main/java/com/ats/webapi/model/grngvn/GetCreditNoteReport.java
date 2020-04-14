package com.ats.webapi.model.grngvn;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetCreditNoteReport implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crn_id")
	private int crnId;

	@Column(name = "crn_no")
	private String crnNo;

	@Column(name = "crn_date")
	private Date crnDate;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "crn_taxable_amt")
	private float crnTaxableAmt;

	@Column(name = "crn_total_tax")
	private float crnTotalTax;

	@Column(name = "crn_grand_total")
	private float crnGrandTotal;

	@Column(name = "fr_name")
	private String frName;

	@Column(name = "fr_address")
	private String frAddress;
	
	@Column(name = "fr_gst_no")
	private String frGstNo;
	
	@Column(name = "is_same_state")
	private int isSameState;

	@Column(name = "is_grn")
	private int isGrn;
	
	float sgstSum;
	float cgstSum;
	float igstSum;
	float cessSum;//new1
	public int getCrnId() {
		return crnId;
	}
	public void setCrnId(int crnId) {
		this.crnId = crnId;
	}
	public String getCrnNo() {
		return crnNo;
	}
	public void setCrnNo(String crnNo) {
		this.crnNo = crnNo;
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
	public int getIsSameState() {
		return isSameState;
	}
	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}
	public int getIsGrn() {
		return isGrn;
	}
	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}
	public float getSgstSum() {
		return sgstSum;
	}
	public void setSgstSum(float sgstSum) {
		this.sgstSum = sgstSum;
	}
	public float getCgstSum() {
		return cgstSum;
	}
	public void setCgstSum(float cgstSum) {
		this.cgstSum = cgstSum;
	}
	public float getIgstSum() {
		return igstSum;
	}
	public void setIgstSum(float igstSum) {
		this.igstSum = igstSum;
	}
	
	public float getCessSum() {
		return cessSum;
	}
	public void setCessSum(float cessSum) {
		this.cessSum = cessSum;
	}
	@Override
	public String toString() {
		return "GetCreditNoteReport [crnId=" + crnId + ", crnNo=" + crnNo + ", crnDate=" + crnDate + ", frId=" + frId
				+ ", crnTaxableAmt=" + crnTaxableAmt + ", crnTotalTax=" + crnTotalTax + ", crnGrandTotal="
				+ crnGrandTotal + ", frName=" + frName + ", frAddress=" + frAddress + ", frGstNo=" + frGstNo
				+ ", isSameState=" + isSameState + ", isGrn=" + isGrn + ", sgstSum=" + sgstSum + ", cgstSum=" + cgstSum
				+ ", igstSum=" + igstSum + ", cessSum=" + cessSum + "]";
	}
}

package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GrandTotalCreditnoteWise {
	
	
	@Id
	private int crndId;  
	private int crnId;
	private Date crnDate;
	private String invoiceNo;
	private Date billDate;
	private String frName;
	private String frCode;
	private String frGstNo; 
	private float crnAmt;
	public int getCrndId() {
		return crndId;
	}
	public void setCrndId(int crndId) {
		this.crndId = crndId;
	} 
	public int getCrnId() {
		return crnId;
	}
	public void setCrnId(int crnId) {
		this.crnId = crnId;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCrnDate() {
		return crnDate;
	}
	public void setCrnDate(Date crnDate) {
		this.crnDate = crnDate;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	public String getFrGstNo() {
		return frGstNo;
	}
	public void setFrGstNo(String frGstNo) {
		this.frGstNo = frGstNo;
	}
	public float getCrnAmt() {
		return crnAmt;
	}
	public void setCrnAmt(float crnAmt) {
		this.crnAmt = crnAmt;
	}
	@Override
	public String toString() {
		return "GrandTotalCreditnoteWise [crndId=" + crndId + ", crnId=" + crnId + ", crnDate=" + crnDate
				+ ", invoiceNo=" + invoiceNo + ", billDate=" + billDate + ", frName=" + frName + ", frCode=" + frCode
				+ ", frGstNo=" + frGstNo + ", crnAmt=" + crnAmt + "]";
	}
	 
	
	

}

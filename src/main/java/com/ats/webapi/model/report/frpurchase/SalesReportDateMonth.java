package com.ats.webapi.model.report.frpurchase;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SalesReportDateMonth {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crn_id")
	private int crnId;
	private String crnNo;
	private Date crnDate;
	private int frId;
	String month;

	private Date billDate;
	private float grandTotal;
	private float taxableAmt;
	private float totalTax;
	private float grnGrandTotal;
	private float grnTaxableAmt;
	private float grnTotalTax;
	private float gvnGrandTotal;
	private float gvnTotalTax;
	private float gvnTaxableAmt;

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

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public float getGrnGrandTotal() {
		return grnGrandTotal;
	}

	public void setGrnGrandTotal(float grnGrandTotal) {
		this.grnGrandTotal = grnGrandTotal;
	}

	public float getGrnTaxableAmt() {
		return grnTaxableAmt;
	}

	public void setGrnTaxableAmt(float grnTaxableAmt) {
		this.grnTaxableAmt = grnTaxableAmt;
	}

	public float getGrnTotalTax() {
		return grnTotalTax;
	}

	public void setGrnTotalTax(float grnTotalTax) {
		this.grnTotalTax = grnTotalTax;
	}

	public float getGvnGrandTotal() {
		return gvnGrandTotal;
	}

	public void setGvnGrandTotal(float gvnGrandTotal) {
		this.gvnGrandTotal = gvnGrandTotal;
	}

	public float getGvnTotalTax() {
		return gvnTotalTax;
	}

	public void setGvnTotalTax(float gvnTotalTax) {
		this.gvnTotalTax = gvnTotalTax;
	}

	public float getGvnTaxableAmt() {
		return gvnTaxableAmt;
	}

	public void setGvnTaxableAmt(float gvnTaxableAmt) {
		this.gvnTaxableAmt = gvnTaxableAmt;
	}

	@Override
	public String toString() {
		return "SalesReportDateMonth [crnId=" + crnId + ", crnNo=" + crnNo + ", crnDate=" + crnDate + ", frId=" + frId
				+ ", month=" + month + ", billDate=" + billDate + ", grandTotal=" + grandTotal + ", taxableAmt="
				+ taxableAmt + ", totalTax=" + totalTax + ", grnGrandTotal=" + grnGrandTotal + ", grnTaxableAmt="
				+ grnTaxableAmt + ", grnTotalTax=" + grnTotalTax + ", gvnGrandTotal=" + gvnGrandTotal + ", gvnTotalTax="
				+ gvnTotalTax + ", gvnTaxableAmt=" + gvnTaxableAmt + "]";
	}

}

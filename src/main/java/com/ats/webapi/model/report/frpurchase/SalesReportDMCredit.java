package com.ats.webapi.model.report.frpurchase;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesReportDMCredit {

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

	@Column(name = "grand_total")
	private float grandTotal;

	@Column(name = "taxable_amt")
	private float taxableAmt;

	@Column(name = "crn_total_tax")
	private float crnTotalTax;

	@Column(name = "round_off")
	private float roundOff;

	String month;

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

	public float getCrnTotalTax() {
		return crnTotalTax;
	}

	public void setCrnTotalTax(float crnTotalTax) {
		this.crnTotalTax = crnTotalTax;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "SalesReportDateMonth [crnId=" + crnId + ", crnNo=" + crnNo + ", crnDate=" + crnDate + ", frId=" + frId
				+ ", grandTotal=" + grandTotal + ", taxableAmt=" + taxableAmt + ", crnTotalTax=" + crnTotalTax
				+ ", roundOff=" + roundOff + ", month=" + month + "]";
	}

}

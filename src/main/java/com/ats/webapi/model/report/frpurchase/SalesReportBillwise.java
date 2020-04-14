package com.ats.webapi.model.report.frpurchase;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SalesReportBillwise implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_no")
	private int billNo;
		
	@Column(name="tax_applicable")
	private int taxApplicable;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="grand_total")
	private float grandTotal;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="total_tax")
	private float totalTax;

	@Column(name="sgst_sum")
	private float sgstSum;
	
	@Column(name="cgst_sum")
	private float cgstSum;
	
	@Column(name="igst_sum")
	private float igstSum;
	
	@Column(name="round_off")
	private float roundOff;
	
	@Column(name="fr_city")
	private String frCity;
	 
	@Column(name="fr_gst_no")
	private String frGstNo;
	 
	 @Column(name="is_same_state")
	private int isSameState;
	 
	 String month;

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getTaxApplicable() {
		return taxApplicable;
	}

	public void setTaxApplicable(int taxApplicable) {
		this.taxApplicable = taxApplicable;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
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

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public String getFrCity() {
		return frCity;
	}

	public void setFrCity(String frCity) {
		this.frCity = frCity;
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

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "SalesReportBillwise [billNo=" + billNo + ", taxApplicable=" + taxApplicable + ", invoiceNo=" + invoiceNo
				+ ", frName=" + frName + ", billDate=" + billDate + ", frId=" + frId + ", frCode=" + frCode
				+ ", grandTotal=" + grandTotal + ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax + ", sgstSum="
				+ sgstSum + ", cgstSum=" + cgstSum + ", igstSum=" + igstSum + ", roundOff=" + roundOff + ", frCity="
				+ frCity + ", frGstNo=" + frGstNo + ", isSameState=" + isSameState + ", month=" + month + "]";
	}

	
	
}

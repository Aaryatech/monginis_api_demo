package com.ats.webapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_other_bill_header")
public class OtherBillHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_no")
	private int billNo; 
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="tax_applicable")
	private int taxApplicable;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="total_tax")
	private float totalTax;
	
	@Column(name="grand_total")
	private float grandTotal;
	 
	@Column(name="status")
	private int status;
	 
	@Column(name="del_status")
	private int delStatus;
	  
	@Column(name="time")
	private String time;
	
	@Column(name="round_off")
	private float roundOff;
	  
	@Column(name="sgst_sum")
	private float sgstSum;
	
	@Column(name="cgst_sum")
	private float cgstSum;
	
	@Column(name="igst_sum")
	private float igstSum;
	
	@Column(name="disc_amt")
	private float discAmt;
	
	@Column(name="supp_id")
	private int suppId;
	

	@Transient
	List<OtherBillDetail> otherBillDetailList;


	public int getBillNo() {
		return billNo;
	}


	public void setBillNo(int billNo) {
		this.billNo = billNo;
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


	public int getTaxApplicable() {
		return taxApplicable;
	}


	public void setTaxApplicable(int taxApplicable) {
		this.taxApplicable = taxApplicable;
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


	public float getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	 

	public int getDelStatus() {
		return delStatus;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public float getRoundOff() {
		return roundOff;
	}


	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
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


	public List<OtherBillDetail> getOtherBillDetailList() {
		return otherBillDetailList;
	}


	public void setOtherBillDetailList(List<OtherBillDetail> otherBillDetailList) {
		this.otherBillDetailList = otherBillDetailList;
	}


	public float getDiscAmt() {
		return discAmt;
	}


	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}


	public int getSuppId() {
		return suppId;
	}


	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}


	@Override
	public String toString() {
		return "OtherBillHeader [billNo=" + billNo + ", invoiceNo=" + invoiceNo + ", billDate=" + billDate + ", frId="
				+ frId + ", frCode=" + frCode + ", taxApplicable=" + taxApplicable + ", taxableAmt=" + taxableAmt
				+ ", totalTax=" + totalTax + ", grandTotal=" + grandTotal + ", status=" + status + ", delStatus="
				+ delStatus + ", time=" + time + ", roundOff=" + roundOff + ", sgstSum=" + sgstSum + ", cgstSum="
				+ cgstSum + ", igstSum=" + igstSum + ", discAmt=" + discAmt + ", suppId=" + suppId
				+ ", otherBillDetailList=" + otherBillDetailList + "]";
	}
	
	

}

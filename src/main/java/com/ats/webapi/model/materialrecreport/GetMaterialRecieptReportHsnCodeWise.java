package com.ats.webapi.model.materialrecreport;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetMaterialRecieptReportHsnCodeWise {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="mrn_detail_id")
	private int mrnDetailId; 
	
	@Column(name="mrn_no")
	private String mrnNo; 
	
	@Column(name="inv_book_date")
	private Date invBookDate; 
	
	@Column(name="invoice_number")
	private String invoiceNumber; 
	
	@Column(name="supp_name")
	private String suppName; 
	
	@Column(name="hsncd_no")
	private int hsncdNo;
	
	@Column(name="value")
	private float value;
	
	@Column(name="cgst")
	private float cgst;
	
	@Column(name="sgst")
	private float sgst;
	
	@Column(name="igst")
	private float igst;
	
	@Column(name="taxable_amt")
	private float taxableAmt;

	
	
	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getInvBookDate() {
		return invBookDate;
	}

	public void setInvBookDate(Date invBookDate) {
		this.invBookDate = invBookDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public int getHsncdNo() {
		return hsncdNo;
	}

	public void setHsncdNo(int hsncdNo) {
		this.hsncdNo = hsncdNo;
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

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	@Override
	public String toString() {
		return "GetMaterialRecieptReportHsnCodeWise [mrnDetailId=" + mrnDetailId + ", mrnNo=" + mrnNo + ", invBookDate="
				+ invBookDate + ", invoiceNumber=" + invoiceNumber + ", suppName=" + suppName + ", hsncdNo=" + hsncdNo
				+ ", value=" + value + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", taxableAmt="
				+ taxableAmt + "]";
	}

	 
}

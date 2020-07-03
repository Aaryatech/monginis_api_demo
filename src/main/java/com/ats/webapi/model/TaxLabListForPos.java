package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TaxLabListForPos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_detail_no")
	private int sellBillDetailNo;
	 
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="igst_rs")
	private float igstRs;
	
	@Column(name="sgst_rs")
	private float sgstRs;
	
	@Column(name="cgst_rs")
	private float cgstRs;

	public int getSellBillDetailNo() {
		return sellBillDetailNo;
	}

	public void setSellBillDetailNo(int sellBillDetailNo) {
		this.sellBillDetailNo = sellBillDetailNo;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	@Override
	public String toString() {
		return "TaxLabListForPos [sellBillDetailNo=" + sellBillDetailNo + ", taxableAmt=" + taxableAmt + ", cgstPer="
				+ cgstPer + ", igstPer=" + igstPer + ", sgstPer=" + sgstPer + ", igstRs=" + igstRs + ", sgstRs="
				+ sgstRs + ", cgstRs=" + cgstRs + "]";
	}
	
	

}

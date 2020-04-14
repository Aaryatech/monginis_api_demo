package com.ats.webapi.model;

 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GrnGvnReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_gvn_id")
	private int grnGvnId;

	@Column(name = "grn_gvn_date")
	private Date grnGvnDate;
	  
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "tax_rate")
	private float taxRate;

	@Column(name = "taxable_amt")
	private float taxableAmt;

	@Column(name = "total_tax")
	private float totalTax;

	@Column(name = "grn_gvn_amt")
	private float grnGvnAmt;
	
	@Column(name = "apr_taxable_amt")
	private float aprTaxableAmt;
	
	@Column(name = "apr_sgst_rs")
	private float aprSgstRs;
	
	@Column(name = "apr_cgst_rs")
	private float aprCgstRs;

	@Column(name = "apr_igst_rs")
	private float aprIgstRs;

	@Column(name = "apr_grand_total")
	private float aprGrandTotal;

	public int getGrnGvnId() {
		return grnGvnId;
	}

	public void setGrnGvnId(int grnGvnId) {
		this.grnGvnId = grnGvnId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGrnGvnDate() {
		return grnGvnDate;
	}

	public void setGrnGvnDate(Date grnGvnDate) {
		this.grnGvnDate = grnGvnDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
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
 
	public float getGrnGvnAmt() {
		return grnGvnAmt;
	}

	public void setGrnGvnAmt(float grnGvnAmt) {
		this.grnGvnAmt = grnGvnAmt;
	}

	public float getAprTaxableAmt() {
		return aprTaxableAmt;
	}

	public void setAprTaxableAmt(float aprTaxableAmt) {
		this.aprTaxableAmt = aprTaxableAmt;
	}

	public float getAprSgstRs() {
		return aprSgstRs;
	}

	public void setAprSgstRs(float aprSgstRs) {
		this.aprSgstRs = aprSgstRs;
	}

	public float getAprCgstRs() {
		return aprCgstRs;
	}

	public void setAprCgstRs(float aprCgstRs) {
		this.aprCgstRs = aprCgstRs;
	}

	public float getAprIgstRs() {
		return aprIgstRs;
	}

	public void setAprIgstRs(float aprIgstRs) {
		this.aprIgstRs = aprIgstRs;
	}

	public float getAprGrandTotal() {
		return aprGrandTotal;
	}

	public void setAprGrandTotal(float aprGrandTotal) {
		this.aprGrandTotal = aprGrandTotal;
	}

	@Override
	public String toString() {
		return "GrnGvnReport [grnGvnId=" + grnGvnId + ", grnGvnDate=" + grnGvnDate + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", taxRate=" + taxRate + ", taxableAmt=" + taxableAmt + ", totalTax="
				+ totalTax + ", grnGvnAmt=" + grnGvnAmt + ", aprTaxableAmt=" + aprTaxableAmt + ", aprSgstRs="
				+ aprSgstRs + ", aprCgstRs=" + aprCgstRs + ", aprIgstRs=" + aprIgstRs + ", aprGrandTotal="
				+ aprGrandTotal + "]";
	}
	
	
	
 

}

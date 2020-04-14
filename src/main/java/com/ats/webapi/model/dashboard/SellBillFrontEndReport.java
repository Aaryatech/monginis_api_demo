package com.ats.webapi.model.dashboard;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SellBillFrontEndReport {
	
	@Id
	Date billDate;
	
	float taxableAmt;
	
	float totalTax;
	
	float grandTotal;

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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

	@Override
	public String toString() {
		return "SellBillFrontEndReport [billDate=" + billDate + ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax
				+ ", grandTotal=" + grandTotal + "]";
	}
	

}

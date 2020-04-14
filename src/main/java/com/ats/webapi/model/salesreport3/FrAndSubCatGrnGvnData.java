package com.ats.webapi.model.salesreport3;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrAndSubCatGrnGvnData {
	
	@Id
	private int crndId;
	private int subCatId;
	private int frId;
	private float amt;
	private int qty;
	private float taxableAmt;
	private float taxAmt;
	private String frName;
	private String subCatName;
	private int month;
	private String year;
	public int getCrndId() {
		return crndId;
	}
	public void setCrndId(int crndId) {
		this.crndId = crndId;
	}
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getTaxableAmt() {
		return taxableAmt;
	}
	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	public float getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "FrAndSubCatGrnGvnData [crndId=" + crndId + ", subCatId=" + subCatId + ", frId=" + frId + ", amt=" + amt
				+ ", qty=" + qty + ", taxableAmt=" + taxableAmt + ", taxAmt=" + taxAmt + ", frName=" + frName
				+ ", subCatName=" + subCatName + ", month=" + month + ", year=" + year + "]";
	}
	
	
	

}

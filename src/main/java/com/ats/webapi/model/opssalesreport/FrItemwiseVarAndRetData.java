package com.ats.webapi.model.opssalesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrItemwiseVarAndRetData {

	@Id
	private int crndId;
	private int itemId;
	private String itemName;
	private int subCatId;
	private String subCatName;
	private int frId;
	private int catId;
	private float amt;
	private int qty;
	private float taxableAmt;
	private float taxAmt;
	private int month;
	private String year;
	public int getCrndId() {
		return crndId;
	}
	public void setCrndId(int crndId) {
		this.crndId = crndId;
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
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
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
		return "FrItemwiseVarAndRetData [crndId=" + crndId + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", subCatId=" + subCatId + ", subCatName=" + subCatName + ", frId=" + frId + ", catId=" + catId
				+ ", amt=" + amt + ", qty=" + qty + ", taxableAmt=" + taxableAmt + ", taxAmt=" + taxAmt + ", month="
				+ month + ", year=" + year + "]";
	}
	
	
	
	
	
	
	
	
}

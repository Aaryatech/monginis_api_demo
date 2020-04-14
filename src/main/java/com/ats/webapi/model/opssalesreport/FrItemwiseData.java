package com.ats.webapi.model.opssalesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrItemwiseData {

	@Id
	private int billDetailNo;
	private int subCatId;
	private String subCatName;
	private int frId;
	private int itemId;
	private String itemName;
	private int catId;
	private float soldAmt;
	private int soldQty;
	private float taxableAmt;
	private float taxAmt;
	private int month;
	private String year;
	public int getBillDetailNo() {
		return billDetailNo;
	}
	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
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
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public float getSoldAmt() {
		return soldAmt;
	}
	public void setSoldAmt(float soldAmt) {
		this.soldAmt = soldAmt;
	}
	public int getSoldQty() {
		return soldQty;
	}
	public void setSoldQty(int soldQty) {
		this.soldQty = soldQty;
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
		return "FrItemwiseData [billDetailNo=" + billDetailNo + ", subCatId=" + subCatId + ", subCatName=" + subCatName
				+ ", frId=" + frId + ", itemId=" + itemId + ", itemName=" + itemName + ", catId=" + catId + ", soldAmt="
				+ soldAmt + ", soldQty=" + soldQty + ", taxableAmt=" + taxableAmt + ", taxAmt=" + taxAmt + ", month="
				+ month + ", year=" + year + "]";
	}
	
	
	
}

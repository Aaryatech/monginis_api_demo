package com.ats.webapi.model.yearlyreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SoldData {

	@Id
	private int billDetailNo;
	private int subCatId;
	private int frId;
	private float soldAmt;
	private int soldQty;
	private float taxableAmt;
	private float taxAmt;
	private String frName;
	private String subCatName;
	private int month;
	private String year;

	private int catId;
	private int itemId;
	private String itemName;

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

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
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

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
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

	@Override
	public String toString() {
		return "SoldData [billDetailNo=" + billDetailNo + ", subCatId=" + subCatId + ", frId=" + frId + ", soldAmt="
				+ soldAmt + ", soldQty=" + soldQty + ", taxableAmt=" + taxableAmt + ", taxAmt=" + taxAmt + ", frName="
				+ frName + ", subCatName=" + subCatName + ", month=" + month + ", year=" + year + ", catId=" + catId
				+ ", itemId=" + itemId + ", itemName=" + itemName + "]";
	}

}

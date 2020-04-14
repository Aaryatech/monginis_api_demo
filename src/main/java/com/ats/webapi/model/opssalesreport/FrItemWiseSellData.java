package com.ats.webapi.model.opssalesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrItemWiseSellData {

	@Id
	private int sellBillDetailNo;
	private int subCatId;
	private String subCatName;
	private int frId;
	private int itemId;
	private String itemName;
	private int catId;
	private float soldAmt;
	private int soldQty;
	private int month;
	private String year;
	public int getSellBillDetailNo() {
		return sellBillDetailNo;
	}
	public void setSellBillDetailNo(int sellBillDetailNo) {
		this.sellBillDetailNo = sellBillDetailNo;
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
		return "FrItemWiseSellData [sellBillDetailNo=" + sellBillDetailNo + ", subCatId=" + subCatId + ", subCatName="
				+ subCatName + ", frId=" + frId + ", itemId=" + itemId + ", itemName=" + itemName + ", catId=" + catId
				+ ", soldAmt=" + soldAmt + ", soldQty=" + soldQty + ", month=" + month + ", year=" + year + "]";
	}

	
	
}

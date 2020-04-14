package com.ats.webapi.model.salesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCatItemFrBill {

	@Id
	private int billDetailNo;
	private int frId;
	private String frName;
	private int itemId;
	private String itemName;
	private int subCatId;
	private String subCatName;
	private int catId;
	private int billQty;
	private float billTotal;
	private float billTaxableAmt;
	private float billTotalTax;

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
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

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getBillQty() {
		return billQty;
	}

	public void setBillQty(int billQty) {
		this.billQty = billQty;
	}

	public float getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}

	public float getBillTaxableAmt() {
		return billTaxableAmt;
	}

	public void setBillTaxableAmt(float billTaxableAmt) {
		this.billTaxableAmt = billTaxableAmt;
	}

	public float getBillTotalTax() {
		return billTotalTax;
	}

	public void setBillTotalTax(float billTotalTax) {
		this.billTotalTax = billTotalTax;
	}

	@Override
	public String toString() {
		return "SubCatItemFrBill [billDetailNo=" + billDetailNo + ", frId=" + frId + ", frName=" + frName + ", itemId="
				+ itemId + ", itemName=" + itemName + ", subCatId=" + subCatId + ", subCatName=" + subCatName
				+ ", catId=" + catId + ", billQty=" + billQty + ", billTotal=" + billTotal + ", billTaxableAmt="
				+ billTaxableAmt + ", billTotalTax=" + billTotalTax + "]";
	}

}

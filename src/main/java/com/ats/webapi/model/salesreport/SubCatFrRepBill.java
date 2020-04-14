package com.ats.webapi.model.salesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCatFrRepBill {

	@Id
	private String id;
	private int billDetailNo;
	private int subCatId;

	private int frId;
	private String frName;

	private String subCatName;

	private float soldQty;
	private float soldAmt;
	
	private int catId;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public float getSoldQty() {
		return soldQty;
	}

	public void setSoldQty(float soldQty) {
		this.soldQty = soldQty;
	}

	public float getSoldAmt() {
		return soldAmt;
	}

	public void setSoldAmt(float soldAmt) {
		this.soldAmt = soldAmt;
	}
	
	

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	@Override
	public String toString() {
		return "SubCatFrRepBill [id=" + id + ", billDetailNo=" + billDetailNo + ", subCatId=" + subCatId + ", frId="
				+ frId + ", frName=" + frName + ", subCatName=" + subCatName + ", soldQty=" + soldQty + ", soldAmt="
				+ soldAmt + ", catId=" + catId + "]";
	}

	

}

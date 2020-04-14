package com.ats.webapi.model.salesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCatBillRep {

	@Id
	private int subCatId;
	private int catId;

	private String subCatName;

	private float soldQty;
	private float soldAmt;

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
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

	@Override
	public String toString() {
		return "SubCatBillRep [subCatId=" + subCatId + ", catId=" + catId + ", subCatName=" + subCatName + ", soldQty="
				+ soldQty + ", soldAmt=" + soldAmt + "]";
	}

}

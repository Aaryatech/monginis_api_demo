package com.ats.webapi.model.salesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCatReport {

	@Id
	private int subCatId;
	private int catId;

	private String subCatName;

	private float soldQty;
	private float soldAmt;
	private float varQty;
	private float varAmt;

	private float retQty;
	private float retAmt;

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

	public float getVarQty() {
		return varQty;
	}

	public void setVarQty(float varQty) {
		this.varQty = varQty;
	}

	public float getVarAmt() {
		return varAmt;
	}

	public void setVarAmt(float varAmt) {
		this.varAmt = varAmt;
	}

	public float getRetQty() {
		return retQty;
	}

	public void setRetQty(float retQty) {
		this.retQty = retQty;
	}

	public float getRetAmt() {
		return retAmt;
	}

	public void setRetAmt(float retAmt) {
		this.retAmt = retAmt;
	}

	@Override
	public String toString() {
		return "SubCatReport [subCatId=" + subCatId + ", catId=" + catId + ", subCatName=" + subCatName + ", soldQty="
				+ soldQty + ", soldAmt=" + soldAmt + ", varQty=" + varQty + ", varAmt=" + varAmt + ", retQty=" + retQty
				+ ", retAmt=" + retAmt + "]";
	}

}

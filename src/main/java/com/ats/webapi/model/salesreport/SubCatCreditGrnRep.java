package com.ats.webapi.model.salesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCatCreditGrnRep {

	@Id
	private String id;
	private int subCatId;
	private int catId;
	private String subCatName;
	private float varQty;
	private float varAmt;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SubCatCreditGrnRep [id=" + id + ", subCatId=" + subCatId + ", catId=" + catId + ", subCatName="
				+ subCatName + ", varQty=" + varQty + ", varAmt=" + varAmt + "]";
	}

	
	

}

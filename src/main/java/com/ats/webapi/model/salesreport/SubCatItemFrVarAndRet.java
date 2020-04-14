package com.ats.webapi.model.salesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCatItemFrVarAndRet {

	@Id
	private int crndId;
	private int itemId;
	private int frId;
	private int subCatId;
	private int catId;
	private int varQty;
	private float varAmt;
	private float varTaxableAmt;
	private float varTotalTax;

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

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

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

	public int getVarQty() {
		return varQty;
	}

	public void setVarQty(int varQty) {
		this.varQty = varQty;
	}

	public float getVarAmt() {
		return varAmt;
	}

	public void setVarAmt(float varAmt) {
		this.varAmt = varAmt;
	}

	public float getVarTaxableAmt() {
		return varTaxableAmt;
	}

	public void setVarTaxableAmt(float varTaxableAmt) {
		this.varTaxableAmt = varTaxableAmt;
	}

	public float getVarTotalTax() {
		return varTotalTax;
	}

	public void setVarTotalTax(float varTotalTax) {
		this.varTotalTax = varTotalTax;
	}

	@Override
	public String toString() {
		return "SubCatItemFrVariation [crndId=" + crndId + ", itemId=" + itemId + ", frId=" + frId + ", subCatId="
				+ subCatId + ", catId=" + catId + ", varQty=" + varQty + ", varAmt=" + varAmt + ", varTaxableAmt="
				+ varTaxableAmt + ", varTotalTax=" + varTotalTax + "]";
	}

}

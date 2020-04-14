package com.ats.webapi.model.ownerapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditNoteDetailDisplayFroApp {

	@Id
	private int crndId;
	private int crnId;
	private int billNo;
	private String billDate;
	private int itemId;
	private int grnGvnId;
	private int isGrn;
	private int grnType;
	private String grnGvnDate;
	private int grnGvnQty;
	private float taxableAmt;
	private float totalTax;
	private float grnGvnAmt;
	private float cgstPer;
	private float sgstPer;
	private float igstPer;
	private float cgstRs;
	private float sgstRs;
	private float igstRs;
	private float cessRs;
	private int delStatus;
	private Integer exInt1;
	private Integer exInt2;
	private Integer exInt3;

	private Float exFloat1;
	private Float exFloat2;
	private Float exFloat3;

	private String exVarchar1;
	private String exVarchar2;
	private String exVarchar3;

	private int catId;
	private float baseRate;
	private float cessPer;

	private String refInvoiceNo;
	private String refInvoiceDate;
	private String grngvnSrno;
	private int grnGvnHeaderId;

	private String catName;
	private String itemName;

	public int getCrndId() {
		return crndId;
	}

	public void setCrndId(int crndId) {
		this.crndId = crndId;
	}

	public int getCrnId() {
		return crnId;
	}

	public void setCrnId(int crnId) {
		this.crnId = crnId;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getGrnGvnId() {
		return grnGvnId;
	}

	public void setGrnGvnId(int grnGvnId) {
		this.grnGvnId = grnGvnId;
	}

	public int getIsGrn() {
		return isGrn;
	}

	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	public String getGrnGvnDate() {
		return grnGvnDate;
	}

	public void setGrnGvnDate(String grnGvnDate) {
		this.grnGvnDate = grnGvnDate;
	}

	public int getGrnGvnQty() {
		return grnGvnQty;
	}

	public void setGrnGvnQty(int grnGvnQty) {
		this.grnGvnQty = grnGvnQty;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public float getGrnGvnAmt() {
		return grnGvnAmt;
	}

	public void setGrnGvnAmt(float grnGvnAmt) {
		this.grnGvnAmt = grnGvnAmt;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getCessRs() {
		return cessRs;
	}

	public void setCessRs(float cessRs) {
		this.cessRs = cessRs;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public Integer getExInt1() {
		return exInt1;
	}

	public void setExInt1(Integer exInt1) {
		this.exInt1 = exInt1;
	}

	public Integer getExInt2() {
		return exInt2;
	}

	public void setExInt2(Integer exInt2) {
		this.exInt2 = exInt2;
	}

	public Float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(Float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public Float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(Float exFloat2) {
		this.exFloat2 = exFloat2;
	}

	public Float getExFloat3() {
		return exFloat3;
	}

	public void setExFloat3(Float exFloat3) {
		this.exFloat3 = exFloat3;
	}

	public String getExVarchar1() {
		return exVarchar1;
	}

	public void setExVarchar1(String exVarchar1) {
		this.exVarchar1 = exVarchar1;
	}

	public String getExVarchar2() {
		return exVarchar2;
	}

	public void setExVarchar2(String exVarchar2) {
		this.exVarchar2 = exVarchar2;
	}

	public String getExVarchar3() {
		return exVarchar3;
	}

	public void setExVarchar3(String exVarchar3) {
		this.exVarchar3 = exVarchar3;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public float getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(float baseRate) {
		this.baseRate = baseRate;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public String getRefInvoiceNo() {
		return refInvoiceNo;
	}

	public void setRefInvoiceNo(String refInvoiceNo) {
		this.refInvoiceNo = refInvoiceNo;
	}

	public String getRefInvoiceDate() {
		return refInvoiceDate;
	}

	public void setRefInvoiceDate(String refInvoiceDate) {
		this.refInvoiceDate = refInvoiceDate;
	}

	public String getGrngvnSrno() {
		return grngvnSrno;
	}

	public void setGrngvnSrno(String grngvnSrno) {
		this.grngvnSrno = grngvnSrno;
	}

	public int getGrnGvnHeaderId() {
		return grnGvnHeaderId;
	}

	public void setGrnGvnHeaderId(int grnGvnHeaderId) {
		this.grnGvnHeaderId = grnGvnHeaderId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getExInt3() {
		return exInt3;
	}

	public void setExInt3(Integer exInt3) {
		this.exInt3 = exInt3;
	}

	@Override
	public String toString() {
		return "CreditNoteDetailDisplayFroApp [crndId=" + crndId + ", crnId=" + crnId + ", billNo=" + billNo
				+ ", billDate=" + billDate + ", itemId=" + itemId + ", grnGvnId=" + grnGvnId + ", isGrn=" + isGrn
				+ ", grnType=" + grnType + ", grnGvnDate=" + grnGvnDate + ", grnGvnQty=" + grnGvnQty + ", taxableAmt="
				+ taxableAmt + ", totalTax=" + totalTax + ", grnGvnAmt=" + grnGvnAmt + ", cgstPer=" + cgstPer
				+ ", sgstPer=" + sgstPer + ", igstPer=" + igstPer + ", cgstRs=" + cgstRs + ", sgstRs=" + sgstRs
				+ ", igstRs=" + igstRs + ", cessRs=" + cessRs + ", delStatus=" + delStatus + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2
				+ ", exFloat3=" + exFloat3 + ", exVarchar1=" + exVarchar1 + ", exVarchar2=" + exVarchar2
				+ ", exVarchar3=" + exVarchar3 + ", catId=" + catId + ", baseRate=" + baseRate + ", cessPer=" + cessPer
				+ ", refInvoiceNo=" + refInvoiceNo + ", refInvoiceDate=" + refInvoiceDate + ", grngvnSrno=" + grngvnSrno
				+ ", grnGvnHeaderId=" + grnGvnHeaderId + ", catName=" + catName + ", itemName=" + itemName + "]";
	}

}

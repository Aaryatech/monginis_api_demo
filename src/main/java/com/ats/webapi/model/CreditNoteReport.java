package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CreditNoteReport {
	
	@Id
	private int crndId;
	private int crnId;
	private int billNo;
	private Date billDate;
	private int itemId;
	private int grnGvnId;
	private Date grnGvnDate;
	private float grnGvnQty;
	private float taxableAmt;
	private float totalTax;
	private float grnGvnAmt;
	private float cgstPer;
	private float sgstPer;
	private float igstPer;
	private float baseRate;
	private String refInvoiceNo;
	private String grngvnSrno;
	private Date crnDate;
	private String crnNo;
	private String itemName;
	private String frName;
	private int frId;
	private String itemUom;
	
	@Transient
	private float peneltyAmt;
	
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
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
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
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGrnGvnDate() {
		return grnGvnDate;
	}
	public void setGrnGvnDate(Date grnGvnDate) {
		this.grnGvnDate = grnGvnDate;
	}
	public float getGrnGvnQty() {
		return grnGvnQty;
	}
	public void setGrnGvnQty(float grnGvnQty) {
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
	public float getBaseRate() {
		return baseRate;
	}
	public void setBaseRate(float baseRate) {
		this.baseRate = baseRate;
	}
	public String getRefInvoiceNo() {
		return refInvoiceNo;
	}
	public void setRefInvoiceNo(String refInvoiceNo) {
		this.refInvoiceNo = refInvoiceNo;
	}
	public String getGrngvnSrno() {
		return grngvnSrno;
	}
	public void setGrngvnSrno(String grngvnSrno) {
		this.grngvnSrno = grngvnSrno;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCrnDate() {
		return crnDate;
	}
	public void setCrnDate(Date crnDate) {
		this.crnDate = crnDate;
	}
	public String getCrnNo() {
		return crnNo;
	}
	public void setCrnNo(String crnNo) {
		this.crnNo = crnNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	
	public float getPeneltyAmt() {
		return peneltyAmt;
	}
	public void setPeneltyAmt(float peneltyAmt) {
		this.peneltyAmt = peneltyAmt;
	}
	public String getItemUom() {
		return itemUom;
	}
	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}
	@Override
	public String toString() {
		return "CreditNoteReport [crndId=" + crndId + ", crnId=" + crnId + ", billNo=" + billNo + ", billDate="
				+ billDate + ", itemId=" + itemId + ", grnGvnId=" + grnGvnId + ", grnGvnDate=" + grnGvnDate
				+ ", grnGvnQty=" + grnGvnQty + ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax + ", grnGvnAmt="
				+ grnGvnAmt + ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer + ", igstPer=" + igstPer + ", baseRate="
				+ baseRate + ", refInvoiceNo=" + refInvoiceNo + ", grngvnSrno=" + grngvnSrno + ", crnDate=" + crnDate
				+ ", crnNo=" + crnNo + ", itemName=" + itemName + ", frName=" + frName + ", frId=" + frId + ", itemUom="
				+ itemUom + ", peneltyAmt=" + peneltyAmt + "]";
	} 
	
	

}

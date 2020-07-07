package com.ats.webapi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_credit_note_pos")
public class CreditNotePos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int crnDetailNo;
	private int crnNo;
	private String crnInvoiceNo;
	private int billNo;
	private int billDetailNo;
	private String billInvoice;
	private String crnDate;
	private int itemId;
	private String itemName;
	private float crnQty;
	private float billQty;
	private float rate;
	private float discAmt;
	private float billTotal;
	private float returnPer;
	private float taxableAmt;
	private float cgstPer;
	private float cgstAmt;
	private float sgstPer;
	private float sgstAmt;
	private float igstPer;
	private float igstAmt;
	private float cessPer;
	private float cessAmt;
	private float grandTotal;
	private int delStatus;
	private int status;
	private int userId;
	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	private float exFloat1;
	private float exFloat2;
	private int custId;
	private int isStockable;

	public int getCrnDetailNo() {
		return crnDetailNo;
	}

	public void setCrnDetailNo(int crnDetailNo) {
		this.crnDetailNo = crnDetailNo;
	}

	public int getCrnNo() {
		return crnNo;
	}

	public void setCrnNo(int crnNo) {
		this.crnNo = crnNo;
	}

	public String getCrnInvoiceNo() {
		return crnInvoiceNo;
	}

	public void setCrnInvoiceNo(String crnInvoiceNo) {
		this.crnInvoiceNo = crnInvoiceNo;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public String getBillInvoice() {
		return billInvoice;
	}

	public void setBillInvoice(String billInvoice) {
		this.billInvoice = billInvoice;
	}

	public String getCrnDate() {
		return crnDate;
	}

	public void setCrnDate(String crnDate) {
		this.crnDate = crnDate;
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

	

	public float getCrnQty() {
		return crnQty;
	}

	public void setCrnQty(float crnQty) {
		this.crnQty = crnQty;
	}

	public float getBillQty() {
		return billQty;
	}

	public void setBillQty(float billQty) {
		this.billQty = billQty;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getReturnPer() {
		return returnPer;
	}

	public void setReturnPer(float returnPer) {
		this.returnPer = returnPer;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getCgstAmt() {
		return cgstAmt;
	}

	public void setCgstAmt(float cgstAmt) {
		this.cgstAmt = cgstAmt;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getSgstAmt() {
		return sgstAmt;
	}

	public void setSgstAmt(float sgstAmt) {
		this.sgstAmt = sgstAmt;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getIgstAmt() {
		return igstAmt;
	}

	public void setIgstAmt(float igstAmt) {
		this.igstAmt = igstAmt;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public float getCessAmt() {
		return cessAmt;
	}

	public void setCessAmt(float cessAmt) {
		this.cessAmt = cessAmt;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}
	
	

	public float getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}
	
	
	
	

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getIsStockable() {
		return isStockable;
	}

	public void setIsStockable(int isStockable) {
		this.isStockable = isStockable;
	}
	
	

	@Override
	public String toString() {
		return "CreditNotePos [crnDetailNo=" + crnDetailNo + ", crnNo=" + crnNo + ", crnInvoiceNo=" + crnInvoiceNo
				+ ", billNo=" + billNo + ", billDetailNo=" + billDetailNo + ", billInvoice=" + billInvoice
				+ ", crnDate=" + crnDate + ", itemId=" + itemId + ", itemName=" + itemName + ", crnQty=" + crnQty
				+ ", billQty=" + billQty + ", rate=" + rate + ", discAmt=" + discAmt + ", billTotal=" + billTotal
				+ ", returnPer=" + returnPer + ", taxableAmt=" + taxableAmt + ", cgstPer=" + cgstPer + ", cgstAmt="
				+ cgstAmt + ", sgstPer=" + sgstPer + ", sgstAmt=" + sgstAmt + ", igstPer=" + igstPer + ", igstAmt="
				+ igstAmt + ", cessPer=" + cessPer + ", cessAmt=" + cessAmt + ", grandTotal=" + grandTotal
				+ ", delStatus=" + delStatus + ", status=" + status + ", userId=" + userId + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exFloat1=" + exFloat1
				+ ", exFloat2=" + exFloat2 + ", custId=" + custId + ", isStockable=" + isStockable + "]";
	}

}

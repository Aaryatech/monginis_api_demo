package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditNotePosHeaderDisp {

	@Id
	private int crnDetailNo;
	private int crnNo;
	private String crnInvoiceNo;
	private String billInvoice;
	private String crnDate;
	private float taxableAmt;
	private float grandTotal;
	private int isStockable;
	private int userId;
	private int custId;
	private String custName;
	private String userName;

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

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getIsStockable() {
		return isStockable;
	}

	public void setIsStockable(int isStockable) {
		this.isStockable = isStockable;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "CreditNotePosHeaderDisp [crnDetailNo=" + crnDetailNo + ", crnNo=" + crnNo + ", crnInvoiceNo="
				+ crnInvoiceNo + ", billInvoice=" + billInvoice + ", crnDate=" + crnDate + ", taxableAmt=" + taxableAmt
				+ ", grandTotal=" + grandTotal + ", isStockable=" + isStockable + ", userId=" + userId + ", custId="
				+ custId + ", custName=" + custName + ", userName=" + userName + "]";
	}

}

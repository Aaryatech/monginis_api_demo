package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ItemReportDetail {

	@Id
	private int billDetailNo;
	private int billNo;
	private int itemId;
	private float billQty;
	private float orderQty;
	private String itemName;

	private String invoiceNo;

	private Date billDate;

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getBillQty() {
		return billQty;
	}

	public void setBillQty(float billQty) {
		this.billQty = billQty;
	}

	public float getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(float orderQty) {
		this.orderQty = orderQty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	@Override
	public String toString() {
		return "ItemReportDetail [billDetailNo=" + billDetailNo + ", billNo=" + billNo + ", itemId=" + itemId
				+ ", billQty=" + billQty + ", orderQty=" + orderQty + ", itemName=" + itemName + ", invoiceNo="
				+ invoiceNo + ", billDate=" + billDate + "]";
	}

}

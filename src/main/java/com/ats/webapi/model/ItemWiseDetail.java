package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ItemWiseDetail implements Serializable{

	
	private String billNo;
	
	@Column(name="item_id")
	private int itemId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_no")
	private int billDetailNo;
	
	@Column(name="rate")
	private float rate;
	
	private int qty;
	
	private float total;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="grn_type")
	private int grnType;

	@Column(name="expiry_date")
	private Date expiryDate;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	

}

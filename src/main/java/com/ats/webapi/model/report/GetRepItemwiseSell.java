package com.ats.webapi.model.report;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetRepItemwiseSell {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_detail_no")
	private int sellBillNo;
	
	@Column(name="fr_id")
	private int frId;
	
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	private int qty;
	
	private float amount;

	public int getSellBillNo() {
		return sellBillNo;
	}

	public void setSellBillNo(int sellBillNo) {
		this.sellBillNo = sellBillNo;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
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

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	@Override
	public String toString() {
		return "GetRepItemwiseSell [sellBillNo=" + sellBillNo + ", frId=" + frId + ", billDate=" + billDate
				+ ", frName=" + frName + ", itemId=" + itemId + ", itemName=" + itemName + ", catId=" + catId
				+ ", catName=" + catName + ", qty=" + qty + ", amount=" + amount + "]";
	}

	 
	
}

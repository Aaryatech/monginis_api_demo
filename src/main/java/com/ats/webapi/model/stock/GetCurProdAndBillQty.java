package com.ats.webapi.model.stock;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetCurProdAndBillQty implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="item_name")
	private String itemName;
	
	
	int prodQty;
	int rejectedQty;
	int billQty;
	
	
	int damagedQty;//ie gateSaleQty
	
	
	public int getDamagedQty() {
		return damagedQty;
	}
	public void setDamagedQty(int damagedQty) {
		this.damagedQty = damagedQty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getProdQty() {
		return prodQty;
	}
	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}
	public int getRejectedQty() {
		return rejectedQty;
	}
	public void setRejectedQty(int rejectedQty) {
		this.rejectedQty = rejectedQty;
	}
	public int getBillQty() {
		return billQty;
	}
	public void setBillQty(int billQty) {
		this.billQty = billQty;
	}
	
	@Override
	public String toString() {
		return "GetCurProdAndBillQty [id=" + id + ", itemName=" + itemName + ", prodQty=" + prodQty + ", rejectedQty="
				+ rejectedQty + ", billQty=" + billQty + ",  damagedQty=" + damagedQty
				+ "]";
	}
	
	
}

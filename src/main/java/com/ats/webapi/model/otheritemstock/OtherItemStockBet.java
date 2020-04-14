package com.ats.webapi.model.otheritemstock;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OtherItemStockBet {
	
	@Id
	private int id;
	private String itemId;
	private String itemName;
	private String frName;
	
	
	private float firstOpening;
	private float damagedStock;
	private float firstPurchase;
	private float firstSell;
	
	private float purchaseQty;
	private float sellQty;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	public float getFirstOpening() {
		return firstOpening;
	}
	public void setFirstOpening(float firstOpening) {
		this.firstOpening = firstOpening;
	}
	public float getDamagedStock() {
		return damagedStock;
	}
	public void setDamagedStock(float damagedStock) {
		this.damagedStock = damagedStock;
	}
	public float getFirstPurchase() {
		return firstPurchase;
	}
	public void setFirstPurchase(float firstPurchase) {
		this.firstPurchase = firstPurchase;
	}
	public float getFirstSell() {
		return firstSell;
	}
	public void setFirstSell(float firstSell) {
		this.firstSell = firstSell;
	}
	public float getPurchaseQty() {
		return purchaseQty;
	}
	public void setPurchaseQty(float purchaseQty) {
		this.purchaseQty = purchaseQty;
	}
	public float getSellQty() {
		return sellQty;
	}
	public void setSellQty(float sellQty) {
		this.sellQty = sellQty;
	}
	@Override
	public String toString() {
		return "OtherItemStockBet [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", frName=" + frName
				+ ", firstOpening=" + firstOpening + ", damagedStock=" + damagedStock + ", firstPurchase="
				+ firstPurchase + ", firstSell=" + firstSell + ", purchaseQty=" + purchaseQty + ", sellQty=" + sellQty
				+ "]";
	}
	
	

}

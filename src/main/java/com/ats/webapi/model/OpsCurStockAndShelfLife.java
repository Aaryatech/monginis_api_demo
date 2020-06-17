package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OpsCurStockAndShelfLife {
	
	@Id
	private int id;
	private String itemName;
	private int itemShelfLife;
	private int currentStock;
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
	public int getItemShelfLife() {
		return itemShelfLife;
	}
	public void setItemShelfLife(int itemShelfLife) {
		this.itemShelfLife = itemShelfLife;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	@Override
	public String toString() {
		return "OpsCurStockAndShelfLife [id=" + id + ", itemName=" + itemName + ", itemShelfLife=" + itemShelfLife
				+ ", currentStock=" + currentStock + "]";
	}
	
	

}

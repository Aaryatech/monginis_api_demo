package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DispatchStationItem implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_mrp2")
	private Double itemMrp2;
	
	@Column(name="order_qty")
	private float orderQty;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_name")
	private String frName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Double getItemMrp2() {
		return itemMrp2;
	}

	public void setItemMrp2(Double itemMrp2) {
		this.itemMrp2 = itemMrp2;
	}

	public float getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(float orderQty) {
		this.orderQty = orderQty;
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

	@Override
	public String toString() {
		return "DispatchStationItem [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", itemMrp2="
				+ itemMrp2 + ", orderQty=" + orderQty + ", frId=" + frId + ", frName=" + frName + "]";
	}
	
}

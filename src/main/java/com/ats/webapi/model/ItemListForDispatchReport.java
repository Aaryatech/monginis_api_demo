package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemListForDispatchReport {
	
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
	
	@Column(name="edit_qty")
	private float editQty;

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

	public Double getItemMrp2() {
		return itemMrp2;
	}

	public void setItemMrp2(Double itemMrp2) {
		this.itemMrp2 = itemMrp2;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(float orderQty) {
		this.orderQty = orderQty;
	}

	public float getEditQty() {
		return editQty;
	}

	public void setEditQty(float editQty) {
		this.editQty = editQty;
	}

	@Override
	public String toString() {
		return "ItemListForDispatchReport [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", itemMrp2="
				+ itemMrp2 + ", orderQty=" + orderQty + ", editQty=" + editQty + "]";
	}
	
	

}

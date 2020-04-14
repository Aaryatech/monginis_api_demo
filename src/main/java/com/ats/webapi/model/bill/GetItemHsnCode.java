package com.ats.webapi.model.bill;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetItemHsnCode {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_hsncd")
	private String hsncd;

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

	public String getHsncd() {
		return hsncd;
	}

	public void setHsncd(String hsncd) {
		this.hsncd = hsncd;
	}

	@Override
	public String toString() {
		return "GetItemHsnCode [itemId=" + itemId + ", itemName=" + itemName + ", hsncd=" + hsncd + "]";
	}
	
	
	
}

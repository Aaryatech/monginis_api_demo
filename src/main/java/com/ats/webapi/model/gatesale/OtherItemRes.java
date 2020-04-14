package com.ats.webapi.model.gatesale;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_gatesale_other_item")
public class OtherItemRes implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="supp_id")
	private int suppId;
	
	@Column(name="supp_name")
	private String suppName;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_qty")
	private String itemQty;
	
	@Column(name="item_rate")
	private float itemRate;
	
	@Column(name="del_status")
	private int delStatus;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemQty() {
		return itemQty;
	}

	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}

	public float getItemRate() {
		return itemRate;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "OtherItemRes [itemId=" + itemId + ", suppId=" + suppId + ", suppName=" + suppName + ", itemName="
				+ itemName + ", itemQty=" + itemQty + ", itemRate=" + itemRate + ", delStatus=" + delStatus + "]";
	}
	
	
}

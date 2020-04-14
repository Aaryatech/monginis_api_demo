package com.ats.webapi.model.gatesale;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_gatesale_other_item")
public class OtherItem implements Serializable {

	@Transient
	private String message;
	@Transient
	private boolean isError;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="supp_id")
	private int suppId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_qty")
	private String itemQty;
	
	@Column(name="item_rate")
	private float itemRate;
	
	@Column(name="del_status")
	private int delStatus;
    
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

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
		return "OtherItem [message=" + message + ", isError=" + isError + ", itemId=" + itemId + ", suppId=" + suppId
				+ ", itemName=" + itemName + ", itemQty=" + itemQty + ", itemRate=" + itemRate + ", delStatus="
				+ delStatus + "]";
	}
}

package com.ats.webapi.model.gatesale;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_gatesale_bill_detail")
public class GateSaleBillDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_id")
	private int billDetailId;
	
	@Column(name="bill_id")
	private int billId;
	
	@Column(name="item_id")
	private int itemId;

	
	@Column(name="item_qty")
	private float itemQty;
	
	@Column(name="item_rate")
	private float itemRate;
	
	@Column(name="item_value")
	private float itemValue;

	public int getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getItemQty() {
		return itemQty;
	}

	public void setItemQty(float itemQty) {
		this.itemQty = itemQty;
	}

	public float getItemRate() {
		return itemRate;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}

	public float getItemValue() {
		return itemValue;
	}

	public void setItemValue(float itemValue) {
		this.itemValue = itemValue;
	}

	@Override
	public String toString() {
		return "GateSaleBillDetail [billDetailId=" + billDetailId + ", billId=" + billId + ", itemId=" + itemId
				+ ", itemQty=" + itemQty + ", itemRate=" + itemRate + ", itemValue=" + itemValue + "]";
	}

    
}

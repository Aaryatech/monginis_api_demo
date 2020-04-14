package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class GetOrderDataForPushOrder implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	int orderId;
	
	
	@Column(name="item_id")
	private int itemId;
	
	
	@Column(name="order_qty")
	int orderQty;
	
	@Column(name="fr_id")
	int frId;


	public int getOrderId() {
		return orderId;
	}


	public int getItemId() {
		return itemId;
	}


	public int getOrderQty() {
		return orderQty;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}


	public int getFrId() {
		return frId;
	}


	public void setFrId(int frId) {
		this.frId = frId;
	}

	@Override
	public String toString() {
		return "GetOrderDataForPushOrder [orderId=" + orderId + ", itemId=" + itemId + ", orderQty=" + orderQty
				+ ", frId=" + frId + "]";
	}

}

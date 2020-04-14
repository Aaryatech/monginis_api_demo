package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class POrder {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="edit_qty")
	private int editQty;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getEditQty() {
		return editQty;
	}

	public void setEditQty(int editQty) {
		this.editQty = editQty;
	}

	@Override
	public String toString() {
		return "POrder [orderId=" + orderId + ", editQty=" + editQty + "]";
	}
	
	

}

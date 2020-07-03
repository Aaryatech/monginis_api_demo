package com.ats.webapi.model.posdashboard;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DashAdvanceOrderCounts {
	
	@Id
	private String uid;

	private String orderDate;

	private float total;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
 
	 
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DashAdvanceOrderCounts [uid=" + uid + ", orderDate=" + orderDate + ", total=" + total + "]";
	}

	 
	 
}

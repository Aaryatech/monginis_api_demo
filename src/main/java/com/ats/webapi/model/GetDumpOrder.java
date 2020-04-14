package com.ats.webapi.model;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity(name="GetDumpOrder")
public class GetDumpOrder {
	
	//SELECT t_order.order_id ,t_order.order_date ,t_order.fr_id ,t_order.menu_id ,t_order.order_qty ,t_order.item_id 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;
	
	/*@Column(name="order_date")
	private Date orderDate;
	*/
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="order_qty")
	private int orderQty;
	
	@Column(name="item_id")
	private String itemId;
	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/*@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}*/

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "GetDumpOrder [orderId=" + orderId + ", frId=" + frId + ", menuId=" + menuId + ", orderQty=" + orderQty
				+ ", itemId=" + itemId + "]";
	}

	
	
	

	
}

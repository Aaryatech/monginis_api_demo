package com.ats.webapi.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class GetOrderItemQty implements Serializable{

	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	int orderId;
	
	private int qty;
	
	@Column(name="item_id")
	private String itemId;
	
	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="production_date")
	private Date productionDate;
	
	@Column(name="item_grp1")
	private int itemGrp1;

	@Column(name="item_name")
	private String itemName;

	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getItemGrp1() {
		return itemGrp1;
	}

	public void setItemGrp1(int itemGrp1) {
		this.itemGrp1 = itemGrp1;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	@Override
	public String toString() {
		return "GetOrderItemQty [orderId=" + orderId + ", qty=" + qty + ", itemId=" + itemId + ", menuId=" + menuId
				+ ", productionDate=" + productionDate + ", itemGrp1=" + itemGrp1 + ", itemName=" + itemName + "]";
	}

	 
	 
	
	

	
	
	
	
}

package com.ats.webapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetRegSpCakeOrderQty {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rsp_id")
	int rspId;
	
	private int qty;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="rsp_produ_date")
	private Date productionDate;
	
	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="item_grp1")
	private int itemGrp1;
	
	@Column(name="item_name")
	private String itemName;

	public int getRspId() {
		return rspId;
	}

	public void setRspId(int rspId) {
		this.rspId = rspId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	@Override
	public String toString() {
		return "GetRegSpCakeOrderQty [rspId=" + rspId + ", qty=" + qty + ", itemId=" + itemId + ", productionDate="
				+ productionDate + ", menuId=" + menuId + ", itemGrp1=" + itemGrp1 + ", itemName=" + itemName + "]";
	}

	 
	 
	
}

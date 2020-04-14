package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_production_plan_detail")
public class GetProductionDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="production_detail_id")
	private int productionDetailId;
	


	//@Column(name="production_qty")
	private int qty;
	 
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;

	public int getProductionDetailId() {
		return productionDetailId;
	}

	public void setProductionDetailId(int productionDetailId) {
		this.productionDetailId = productionDetailId;
	}

	 

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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "GetProductionDetail [productionDetailId=" + productionDetailId + ", qty=" + qty + ", itemId=" + itemId
				+ ", itemName=" + itemName + "]";
	}

	 

}

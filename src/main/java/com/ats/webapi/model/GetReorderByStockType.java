package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "m_fr_item_stock")
public class GetReorderByStockType {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fr_stock_id")
	private int frStockId;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="type")
	private int type;
	
	@Column(name="reorder_qty")
	private int reorderQty;

	public int getFrStockId() {
		return frStockId;
	}

	public void setFrStockId(int frStockId) {
		this.frStockId = frStockId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(int reorderQty) {
		this.reorderQty = reorderQty;
	}

	@Override
	public String toString() {
		return "GetReorderByStockType [frStockId=" + frStockId + ", itemId=" + itemId + ", type=" + type
				+ ", reorderQty=" + reorderQty + "]";
	}
	
	

}

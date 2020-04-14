package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_fr_item_stock")
public class GetFrItemStockConfiguration implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fr_stock_id")
	private int frStockId;
	
	@Column(name="item_id")
	private Integer itemId;
	
	@Column(name="type")
	private int type;
	
	@Column(name="min_qty")
	private int minQty;
	
	@Column(name="max_qty")
	private int maxQty;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="reorder_qty")
	private int reorderQty;
	
	
	
	public int getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(int reorderQty) {
		this.reorderQty = reorderQty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getFrStockId() {
		return frStockId;
	}

	public void setFrStockId(int frStockId) {
		this.frStockId = frStockId;
	}

	
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMinQty() {
		return minQty;
	}

	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	@Override
	public String toString() {
		return "GetFrItemStockConfiguration [frStockId=" + frStockId + ", itemId=" + itemId + ", type=" + type
				+ ", minQty=" + minQty + ", maxQty=" + maxQty + ", itemName=" + itemName + ", reorderQty=" + reorderQty
				+ "]";
	}
	

}

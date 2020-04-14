package com.ats.webapi.model;

import java.util.List;

public class FrStockResponse {
	
	// new bean for Jsp;
	private int itemId;
	
	private String itemName;
	
	List<StockDetails> stockDetails;

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

	public List<StockDetails> getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(List<StockDetails> stockDetails) {
		this.stockDetails = stockDetails;
	}

	@Override
	public String toString() {
		return "FrStockResponse [itemId=" + itemId + ", itemName=" + itemName + ", stockDetails=" + stockDetails + "]";
	}
	
	
	

}

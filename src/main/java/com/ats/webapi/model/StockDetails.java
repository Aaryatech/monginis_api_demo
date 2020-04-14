package com.ats.webapi.model;

public class StockDetails {
	//new bean for jsp;
	
	
	private int frStockId;
	private int type;
	private int minQty;
	private int maxQty;
	private int reorderQty;
	
	
	
	public int getReorderQty() {
		return reorderQty;
	}
	public void setReorderQty(int reorderQty) {
		this.reorderQty = reorderQty;
	}
	public int getFrStockId() {
		return frStockId;
	}
	public void setFrStockId(int frStockId) {
		this.frStockId = frStockId;
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
		return "StockDetails [frStockId=" + frStockId + ", type=" + type + ", minQty=" + minQty + ", maxQty=" + maxQty
				+ ", reorderQty=" + reorderQty + "]";
	}
	
	
	
	

}

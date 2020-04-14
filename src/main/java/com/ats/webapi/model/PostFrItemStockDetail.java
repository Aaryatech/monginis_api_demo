package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_fr_opening_stock_detail")
public class PostFrItemStockDetail {

	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="opening_stock_detail_id")
	private int openingStockDetailId;
	
	@Column(name="opening_stock_header_id")
	private int openingStockHeaderId;

	@Column(name="item_id")
	private int 	itemId;
	
	
	
	@Column(name="reg_opening_stock")
	private int regOpeningStock;
	
	@Column(name="sp_opening_stock")
	private int spOpeningStock;
	
	
	@Column(name="physical_stock")
	private int physicalStock;
	
	@Column(name="stock_difference")
	private int stockDifference;
	
	@Column(name="reg_total_purchase")
	private int regTotalPurchase;
	
	@Column(name="sp_total_purchase")
	private int spTotalPurchase;
	
	@Column(name="reg_total_grn_gvn")
	private int regTotalGrnGvn;
	
	@Column(name="reg_total_sell")
	private int regTotalSell;
	
	@Column(name="sp_total_sell")
	private int spTotalSell;
	
	@Column(name="remark")
	private String remark;

	@Transient
	@Column(name="item_name")
	private String itemName;
	@Transient
	@Column(name="item_code")
	private String itemCode;
	
	
	public int getOpeningStockDetailId() {
		return openingStockDetailId;
	}

	public void setOpeningStockDetailId(int openingStockDetailId) {
		this.openingStockDetailId = openingStockDetailId;
	}

	public int getOpeningStockHeaderId() {
		return openingStockHeaderId;
	}

	public void setOpeningStockHeaderId(int openingStockHeaderId) {
		this.openingStockHeaderId = openingStockHeaderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getPhysicalStock() {
		return physicalStock;
	}

	public void setPhysicalStock(int physicalStock) {
		this.physicalStock = physicalStock;
	}

	public int getStockDifference() {
		return stockDifference;
	}

	public void setStockDifference(int stockDifference) {
		this.stockDifference = stockDifference;
	}

	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getRegOpeningStock() {
		return regOpeningStock;
	}

	public void setRegOpeningStock(int regOpeningStock) {
		this.regOpeningStock = regOpeningStock;
	}

	public int getSpOpeningStock() {
		return spOpeningStock;
	}

	public void setSpOpeningStock(int spOpeningStock) {
		this.spOpeningStock = spOpeningStock;
	}

	public int getRegTotalPurchase() {
		return regTotalPurchase;
	}

	public void setRegTotalPurchase(int regTotalPurchase) {
		this.regTotalPurchase = regTotalPurchase;
	}

	public int getSpTotalPurchase() {
		return spTotalPurchase;
	}

	public void setSpTotalPurchase(int spTotalPurchase) {
		this.spTotalPurchase = spTotalPurchase;
	}

	public int getRegTotalGrnGvn() {
		return regTotalGrnGvn;
	}

	public void setRegTotalGrnGvn(int regTotalGrnGvn) {
		this.regTotalGrnGvn = regTotalGrnGvn;
	}

	public int getRegTotalSell() {
		return regTotalSell;
	}

	public void setRegTotalSell(int regTotalSell) {
		this.regTotalSell = regTotalSell;
	}

	public int getSpTotalSell() {
		return spTotalSell;
	}

	public void setSpTotalSell(int spTotalSell) {
		this.spTotalSell = spTotalSell;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Override
	public String toString() {
		return "PostFrItemStockDetail [openingStockDetailId=" + openingStockDetailId + ", openingStockHeaderId="
				+ openingStockHeaderId + ", itemId=" + itemId + ", regOpeningStock=" + regOpeningStock
				+ ", spOpeningStock=" + spOpeningStock + ", physicalStock=" + physicalStock + ", stockDifference="
				+ stockDifference + ", regTotalPurchase=" + regTotalPurchase + ", spTotalPurchase=" + spTotalPurchase
				+ ", regTotalGrnGvn=" + regTotalGrnGvn + ", regTotalSell=" + regTotalSell + ", spTotalSell="
				+ spTotalSell + ", remark=" + remark + ", itemName=" + itemName + ", itemCode=" + itemCode + "]";
	}

	
	
	
}

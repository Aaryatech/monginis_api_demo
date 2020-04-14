package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity
public class FrStockBetweenMonth implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8433993042954020965L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="opening_stock_detail_id")
	private int openingStockDetailId;
	
	
	@Column(name="item_name")
	private String 	itemName;
	
	
	@Column(name="item_id")
	private int 	itemId;
	
	@Column(name="opening_stock")
	private int openingStock;
	
	@Column(name="total_purchase")
	private int totalPurchase;
	
	@Column(name="total_grn_gvn")
	private int totalGrnGvn;
	
	@Column(name="total_sell")
	private int totalSell;

	@Transient
	private int currentStock;
	
	
	@PostLoad
	private void onLoad() {
	    this.currentStock = (openingStock + totalPurchase) - (totalGrnGvn + totalSell );
	}
	
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}

	public int getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(int totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public int getTotalGrnGvn() {
		return totalGrnGvn;
	}

	public void setTotalGrnGvn(int totalGrnGvn) {
		this.totalGrnGvn = totalGrnGvn;
	}

	public int getTotalSell() {
		return totalSell;
	}

	public void setTotalSell(int totalSell) {
		this.totalSell = totalSell;
	}

	public int getOpeningStockDetailId() {
		return openingStockDetailId;
	}

	public void setOpeningStockDetailId(int openingStockDetailId) {
		this.openingStockDetailId = openingStockDetailId;
	}


	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	@Override
	public String toString() {
		return "FrStockBetweenMonth [openingStockDetailId=" + openingStockDetailId + ", itemName=" + itemName
				+ ", itemId=" + itemId + ", openingStock=" + openingStock + ", totalPurchase=" + totalPurchase
				+ ", totalGrnGvn=" + totalGrnGvn + ", totalSell=" + totalSell + ", currentStock=" + currentStock + "]";
	}

	
	
	
}

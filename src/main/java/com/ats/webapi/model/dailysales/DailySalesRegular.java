package com.ats.webapi.model.dailysales;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DailySalesRegular implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="bill_qty")
	private float billQty;
	
	@Column(name="bill_qty_rate")
	private float billQtyRate;
	
	@Column(name="bill_qty_mrp")
	private float billQtyMrp;
	
	@Column(name="grn_gvn_qty")
	private float grnGvnQty;
	
	@Column(name="grn_gvn_amt")
	private float grnGvnAmt;
	
	@Column(name="sell_qty")
	private float sellQty;
	
	@Column(name="sell_qty_rate")
	private float sellQtyRate;
	
	@Column(name="sell_qty_mrp")
	private float sellQtyMrp;
	
	@Column(name="reg_opening_stock")
	private float regOpeningStock;
	
	@Column(name="reg_opening_stock_rate")
	private float regOpeningStockRate;
	
	@Column(name="reg_opening_stock_mrp")
	private float regOpeningStockMrp;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public float getBillQty() {
		return billQty;
	}

	public void setBillQty(float billQty) {
		this.billQty = billQty;
	}

	public float getBillQtyRate() {
		return billQtyRate;
	}

	public void setBillQtyRate(float billQtyRate) {
		this.billQtyRate = billQtyRate;
	}

	public float getBillQtyMrp() {
		return billQtyMrp;
	}

	public void setBillQtyMrp(float billQtyMrp) {
		this.billQtyMrp = billQtyMrp;
	}

	public float getGrnGvnQty() {
		return grnGvnQty;
	}

	public void setGrnGvnQty(float grnGvnQty) {
		this.grnGvnQty = grnGvnQty;
	}

	public float getGrnGvnAmt() {
		return grnGvnAmt;
	}

	public void setGrnGvnAmt(float grnGvnAmt) {
		this.grnGvnAmt = grnGvnAmt;
	}

	public float getSellQty() {
		return sellQty;
	}

	public void setSellQty(float sellQty) {
		this.sellQty = sellQty;
	}

	public float getSellQtyRate() {
		return sellQtyRate;
	}

	public void setSellQtyRate(float sellQtyRate) {
		this.sellQtyRate = sellQtyRate;
	}

	public float getSellQtyMrp() {
		return sellQtyMrp;
	}

	public void setSellQtyMrp(float sellQtyMrp) {
		this.sellQtyMrp = sellQtyMrp;
	}

	public float getRegOpeningStock() {
		return regOpeningStock;
	}

	public void setRegOpeningStock(float regOpeningStock) {
		this.regOpeningStock = regOpeningStock;
	}

	public float getRegOpeningStockRate() {
		return regOpeningStockRate;
	}

	public void setRegOpeningStockRate(float regOpeningStockRate) {
		this.regOpeningStockRate = regOpeningStockRate;
	}

	public float getRegOpeningStockMrp() {
		return regOpeningStockMrp;
	}

	public void setRegOpeningStockMrp(float regOpeningStockMrp) {
		this.regOpeningStockMrp = regOpeningStockMrp;
	}

	@Override
	public String toString() {
		return "DailySalesRegular [catId=" + catId + ", billQty=" + billQty + ", billQtyRate=" + billQtyRate
				+ ", billQtyMrp=" + billQtyMrp + ", grnGvnQty=" + grnGvnQty + ", grnGvnAmt=" + grnGvnAmt + ", sellQty="
				+ sellQty + ", sellQtyRate=" + sellQtyRate + ", sellQtyMrp=" + sellQtyMrp + ", regOpeningStock="
				+ regOpeningStock + ", regOpeningStockRate=" + regOpeningStockRate + ", regOpeningStockMrp="
				+ regOpeningStockMrp + "]";
	}
	
	
}

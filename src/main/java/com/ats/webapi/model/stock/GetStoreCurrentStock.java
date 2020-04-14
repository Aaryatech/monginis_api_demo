package com.ats.webapi.model.stock;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetStoreCurrentStock {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="store_stock_detail_id")
	private int storeStockDetailId;
	
	@Column(name="store_opening_stock")
	float storeOpeningStock;
	
	@Column(name="store_closing_stock")
	float storeClosingStock;
	
	@Column(name="store_stock_date")
	Date storeStockDate;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_code")
	private String rmCode;
	
	@Column(name="rm_min_qty")
	private float rmMinQty;
	
	@Column(name="rm_max_qty")
	private float rmMaxQty;
	
	@Column(name="rm_rol_qty")
	private float rmRolQty;
	
	@Column(name="pur_rec_qty")
	private float purRecQty;
	
	
	@Column(name="bms_issue_qty")
	private float bmsIssueQty;

	
	

	public String getRmCode() {
		return rmCode;
	}


	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}


	public float getRmMinQty() {
		return rmMinQty;
	}


	public void setRmMinQty(float rmMinQty) {
		this.rmMinQty = rmMinQty;
	}


	public float getRmMaxQty() {
		return rmMaxQty;
	}


	public void setRmMaxQty(float rmMaxQty) {
		this.rmMaxQty = rmMaxQty;
	}


	public float getRmRolQty() {
		return rmRolQty;
	}


	public void setRmRolQty(float rmRolQty) {
		this.rmRolQty = rmRolQty;
	}


	public int getStoreStockDetailId() {
		return storeStockDetailId;
	}


	public void setStoreStockDetailId(int storeStockDetailId) {
		this.storeStockDetailId = storeStockDetailId;
	}


	public float getStoreOpeningStock() {
		return storeOpeningStock;
	}


	public void setStoreOpeningStock(float storeOpeningStock) {
		this.storeOpeningStock = storeOpeningStock;
	}


	public float getStoreClosingStock() {
		return storeClosingStock;
	}


	public void setStoreClosingStock(float storeClosingStock) {
		this.storeClosingStock = storeClosingStock;
	}


	public int getRmId() {
		return rmId;
	}


	public void setRmId(int rmId) {
		this.rmId = rmId;
	}


	public String getRmName() {
		return rmName;
	}


	public void setRmName(String rmName) {
		this.rmName = rmName;
	}


	public float getPurRecQty() {
		return purRecQty;
	}


	public void setPurRecQty(float purRecQty) {
		this.purRecQty = purRecQty;
	}


	public float getBmsIssueQty() {
		return bmsIssueQty;
	}


	public void setBmsIssueQty(float bmsIssueQty) {
		this.bmsIssueQty = bmsIssueQty;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getStoreStockDate() {
		return storeStockDate;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setStoreStockDate(Date storeStockDate) {
		this.storeStockDate = storeStockDate;
	}


	@Override
	public String toString() {
		return "GetStoreCurrentStock [storeStockDetailId=" + storeStockDetailId + ", storeOpeningStock="
				+ storeOpeningStock + ", storeClosingStock=" + storeClosingStock + ", storeStockDate=" + storeStockDate
				+ ", rmId=" + rmId + ", rmName=" + rmName + ", purRecQty=" + purRecQty + ", bmsIssueQty=" + bmsIssueQty
				+ "]";
	}


	 
	
	
}

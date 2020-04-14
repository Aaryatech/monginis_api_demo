package com.ats.webapi.model.stock;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_store_stock_detail")
public class StoreStockDetail {

	
 
	  
	  
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="store_stock_detail_id")
	private int storeStockDetailId;
	
	@Column(name="store_stock_id")
	private int storeStockId;
	
	@Column(name="store_stock_date")
	Date storeStockDate;
	
	@Column(name="store_opening_stock")
	float storeOpeningStock;
	
	@Column(name="store_closing_stock")
	float storeClosingStock;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_group")
	private int rmGroup;
	
	@Column(name="rm_uom")
	private int rmUom;
	
	
	@Column(name="pur_rec_qty")
	private float purRecQty;
	
	
	@Column(name="bms_issue_qty")
	private float bmsIssueQty;
	
	
	@Column(name="is_delete")
	int isDelete;
	
	@Column(name="ex_int1")
	int exInt1;
	
	@Column(name="ex_int2")
	int exInt2;
	
	@Column(name="ex_bool")
	int exBool;

	public int getStoreStockDetailId() {
		return storeStockDetailId;
	}

	public void setStoreStockDetailId(int storeStockDetailId) {
		this.storeStockDetailId = storeStockDetailId;
	}

	public int getStoreStockId() {
		return storeStockId;
	}

	public void setStoreStockId(int storeStockId) {
		this.storeStockId = storeStockId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getStoreStockDate() {
		return storeStockDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setStoreStockDate(Date storeStockDate) {
		this.storeStockDate = storeStockDate;
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

	public int getRmGroup() {
		return rmGroup;
	}

	public void setRmGroup(int rmGroup) {
		this.rmGroup = rmGroup;
	}

	public int getRmUom() {
		return rmUom;
	}

	public void setRmUom(int rmUom) {
		this.rmUom = rmUom;
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

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public int getExBool() {
		return exBool;
	}

	public void setExBool(int exBool) {
		this.exBool = exBool;
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

	@Override
	public String toString() {
		return "StoreStockDetail [storeStockDetailId=" + storeStockDetailId + ", storeStockId=" + storeStockId
				+ ", storeStockDate=" + storeStockDate + ", storeOpeningStock=" + storeOpeningStock
				+ ", storeClosingStock=" + storeClosingStock + ", rmId=" + rmId + ", rmName=" + rmName + ", rmGroup="
				+ rmGroup + ", rmUom=" + rmUom + ", purRecQty=" + purRecQty + ", bmsIssueQty=" + bmsIssueQty
				+ ", isDelete=" + isDelete + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exBool=" + exBool + "]";
	}

	 
	
 
}

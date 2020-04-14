package com.ats.webapi.model.stock;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

 

@Entity
@Table(name="t_store_stock_header")
public class StoreStockHeader {

 
	
	
	@Transient
	private boolean isError;
	
	@Transient
	private String message;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="store_stock_id")
	private int storeStockId;
	
	@Column(name="store_stock_date")
	Date storeStockDate;
	
	@Column(name="store_stock_status")
	int storeStockStatus;
	
	@Column(name="ex_int1")
	int exInt1;
	
	@Column(name="ex_int2")
	int exInt2;
	
	@Column(name="ex_boll1")
	int exBoll1;
	
	@Column(name="ex_boll2")
	int exBoll2;
	
	@Transient
	List<StoreStockDetail> storeStockDetailList;

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public int getStoreStockStatus() {
		return storeStockStatus;
	}

	public void setStoreStockStatus(int storeStockStatus) {
		this.storeStockStatus = storeStockStatus;
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

	public int getExBoll1() {
		return exBoll1;
	}

	public void setExBoll1(int exBoll1) {
		this.exBoll1 = exBoll1;
	}

	public int getExBoll2() {
		return exBoll2;
	}

	public void setExBoll2(int exBoll2) {
		this.exBoll2 = exBoll2;
	}

	public List<StoreStockDetail> getStoreStockDetailList() {
		return storeStockDetailList;
	}

	public void setStoreStockDetailList(List<StoreStockDetail> storeStockDetailList) {
		this.storeStockDetailList = storeStockDetailList;
	}

	@Override
	public String toString() {
		return "StoreStockHeader [isError=" + isError + ", message=" + message + ", storeStockId=" + storeStockId
				+ ", storeStockDate=" + storeStockDate + ", storeStockStatus=" + storeStockStatus + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exBoll1=" + exBoll1 + ", exBoll2=" + exBoll2 + ", storeStockDetailList="
				+ storeStockDetailList + "]";
	}

	 
	
	
}

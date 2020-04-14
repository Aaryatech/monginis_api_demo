package com.ats.webapi.model;

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
@Table(name = "t_bms_stock")
public class BmsStockHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bms_stock_id")
	private int bmsStockId;
	
	@Column(name = "bms_stock_date")
	private Date bmsStockDate;

	@Column(name = "bms_status")
	private int bmsStatus;
	
	@Column(name = "rm_type")
	private int rmType;
	
	@Column(name = "ex_int")
	private int exInt;
	
	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_boll")
	private int exBoll;
	
	@Column(name = "ex_boll1")
	private int exBoll1;
	
	@Column(name = "ex_varchar")
	private String exVarchar;
	
	@Transient
	List<BmsStockDetailed> bmsStockDetailed;

	public int getBmsStockId() {
		return bmsStockId;
	}

	public void setBmsStockId(int bmsStockId) {
		this.bmsStockId = bmsStockId;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBmsStockDate() {
		return bmsStockDate;
	}

	public void setBmsStockDate(Date bmsStockDate) {
		this.bmsStockDate = bmsStockDate;
	}

	public int getBmsStatus() {
		return bmsStatus;
	}

	public void setBmsStatus(int bmsStatus) {
		this.bmsStatus = bmsStatus;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

	public int getExInt() {
		return exInt;
	}

	public void setExInt(int exInt) {
		this.exInt = exInt;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExBoll() {
		return exBoll;
	}

	public void setExBoll(int exBoll) {
		this.exBoll = exBoll;
	}

	public int getExBoll1() {
		return exBoll1;
	}

	public void setExBoll1(int exBoll1) {
		this.exBoll1 = exBoll1;
	}

	public String getExVarchar() {
		return exVarchar;
	}

	public void setExVarchar(String exVarchar) {
		this.exVarchar = exVarchar;
	}

	public List<BmsStockDetailed> getBmsStockDetailed() {
		return bmsStockDetailed;
	}

	public void setBmsStockDetailed(List<BmsStockDetailed> bmsStockDetailed) {
		this.bmsStockDetailed = bmsStockDetailed;
	}

	@Override
	public String toString() {
		return "BmsStock [bmsStockId=" + bmsStockId + ", bmsStockDate=" + bmsStockDate + ", bmsStatus=" + bmsStatus
				+ ", rmType=" + rmType + ", exInt=" + exInt + ", exInt1=" + exInt1 + ", exBoll=" + exBoll + ", exBoll1="
				+ exBoll1 + ", exVarchar=" + exVarchar + ", bmsStockDetailed=" + bmsStockDetailed + "]";
	}
	
	

	
}

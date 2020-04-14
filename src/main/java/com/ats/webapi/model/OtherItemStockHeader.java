package com.ats.webapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="other_item_stock_header")
public class OtherItemStockHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int otherStockHeaderId;
	private int frId;
	private int Month;
	private int Year;
	private int delStatus;
	private int status;
	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	private float exFloat1;
	private float exFloat2;
	
	@Transient
	List<OtherItemStockDetail> otherItemStockList;
	
	
	
	public List<OtherItemStockDetail> getOtherItemStockList() {
		return otherItemStockList;
	}
	public void setOtherItemStockList(List<OtherItemStockDetail> otherItemStockList) {
		this.otherItemStockList = otherItemStockList;
	}
	@Column(name="other_stock_header_id")
	public int getOtherStockHeaderId() {
		return otherStockHeaderId;
	}
	public void setOtherStockHeaderId(int otherStockHeaderId) {
		this.otherStockHeaderId = otherStockHeaderId;
	}
	
	@Column(name="fr_id")
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	@Column(name="month")
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	@Column(name="year")
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	@Column(name="del_status")
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	@Column(name="status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "ex_int1")
	public int getExInt1() {
		return exInt1;
	}
	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	
	@Column(name = "ex_int2")
	public int getExInt2() {
		return exInt2;
	}
	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}
	
	@Column(name = "other_stock_detail_id")
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	
	@Column(name = "ex_var1")
	public String getExVar2() {
		return exVar2;
	}
	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}
	
	@Column(name = "ex_float1")
	public float getExFloat1() {
		return exFloat1;
	}
	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}
	
	@Column(name = "ex_float2")
	public float getExFloat2() {
		return exFloat2;
	}
	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}
	@Override
	public String toString() {
		return "OtherItemStockHeader [otherStockHeaderId=" + otherStockHeaderId + ", frId=" + frId + ", Month=" + Month
				+ ", Year=" + Year + ", delStatus=" + delStatus + ", status=" + status + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exFloat1=" + exFloat1
				+ ", exFloat2=" + exFloat2 + ", otherItemStockList=" + otherItemStockList + "]";
	}	
	
	
	
	
}

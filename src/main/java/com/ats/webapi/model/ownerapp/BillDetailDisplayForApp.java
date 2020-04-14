package com.ats.webapi.model.ownerapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillDetailDisplayForApp {

	@Id
	private int billDetailNo;
	private int billNo;
	private int orderId;
	private int menuId;
	private int catId;
	private int itemId;
	private int orderQty;
	private int billQty;
	private float mrp;
	private int rateType;

	private float rate;
	private float baseRate;
	private float taxableAmt;
	private float sgstPer;
	private float sgstRs;
	private float cgstPer;
	private float cgstRs;
	private float igstPer;
	private float igstRs;

	private float totalTax;
	private float grandTotal;
	private String remark;

	private int delStatus;
	private int grnType;
	private String expiryDate;

	private int isGrngvnApplied;
	private float discPer;
	private float cessPer;
	private float cessRs;

	private String catName;
	private String itemName;

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public int getBillQty() {
		return billQty;
	}

	public void setBillQty(int billQty) {
		this.billQty = billQty;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public int getRateType() {
		return rateType;
	}

	public void setRateType(int rateType) {
		this.rateType = rateType;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(float baseRate) {
		this.baseRate = baseRate;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getIsGrngvnApplied() {
		return isGrngvnApplied;
	}

	public void setIsGrngvnApplied(int isGrngvnApplied) {
		this.isGrngvnApplied = isGrngvnApplied;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public float getCessRs() {
		return cessRs;
	}

	public void setCessRs(float cessRs) {
		this.cessRs = cessRs;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "BillDetailDisplayForApp [billDetailNo=" + billDetailNo + ", billNo=" + billNo + ", orderId=" + orderId
				+ ", menuId=" + menuId + ", catId=" + catId + ", itemId=" + itemId + ", orderQty=" + orderQty
				+ ", billQty=" + billQty + ", mrp=" + mrp + ", rateType=" + rateType + ", rate=" + rate + ", baseRate="
				+ baseRate + ", taxableAmt=" + taxableAmt + ", sgstPer=" + sgstPer + ", sgstRs=" + sgstRs + ", cgstPer="
				+ cgstPer + ", cgstRs=" + cgstRs + ", igstPer=" + igstPer + ", igstRs=" + igstRs + ", totalTax="
				+ totalTax + ", grandTotal=" + grandTotal + ", remark=" + remark + ", delStatus=" + delStatus
				+ ", grnType=" + grnType + ", expiryDate=" + expiryDate + ", isGrngvnApplied=" + isGrngvnApplied
				+ ", discPer=" + discPer + ", cessPer=" + cessPer + ", cessRs=" + cessRs + ", catName=" + catName
				+ ", itemName=" + itemName + "]";
	}

}

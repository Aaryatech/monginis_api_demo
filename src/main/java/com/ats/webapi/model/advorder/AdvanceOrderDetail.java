package com.ats.webapi.model.advorder;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_adv_order_detail")
public class AdvanceOrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int advDetailId;

	private int frId;

	private int catId;

	private int subCatId;

	private int menuId;

	private int itemId;

	private float rate;

	private float mrp;

	private float qty;

	private Date orderDate;

	private Date prodDate;

	private Date deliveryDate;

	private String events;

	private String eventsName;

	private float subTotal;

	private float tax1;

	@Column(name = "tax1_amt")
 	private float tax1Amt;

	private float tax2;
	
	@Column(name = "tax2_amt")
 	private float tax2Amt;

	private int isBillGenerated;
	
	private int isSellBillGenerated;

	private int advHeaderId;

	private float discPer;

	private int grnType;

	private int delStatus;

	private int exInt1;

	private int exInt2;

	private String exVar1;

	private String exVar2;

	private float exFloat1;

	private float exFloat2;

	public int getAdvDetailId() {
		return advDetailId;
	}

	public void setAdvDetailId(int advDetailId) {
		this.advDetailId = advDetailId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	 @JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	  @JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	 	public Date getProdDate() {
		return prodDate;
	}

	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}

	
	  @JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	 	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getEventsName() {
		return eventsName;
	}

	public void setEventsName(String eventsName) {
		this.eventsName = eventsName;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getTax1() {
		return tax1;
	}

	public void setTax1(float tax1) {
		this.tax1 = tax1;
	}

	public float getTax1Amt() {
		return tax1Amt;
	}

	public void setTax1Amt(float tax1Amt) {
		this.tax1Amt = tax1Amt;
	}

	public float getTax2() {
		return tax2;
	}

	public void setTax2(float tax2) {
		this.tax2 = tax2;
	}

	public float getTax2Amt() {
		return tax2Amt;
	}

	public void setTax2Amt(float tax2Amt) {
		this.tax2Amt = tax2Amt;
	}

	public int getIsBillGenerated() {
		return isBillGenerated;
	}

	public void setIsBillGenerated(int isBillGenerated) {
		this.isBillGenerated = isBillGenerated;
	}

	public int getAdvHeaderId() {
		return advHeaderId;
	}

	public void setAdvHeaderId(int advHeaderId) {
		this.advHeaderId = advHeaderId;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}
	
	

	public int getIsSellBillGenerated() {
		return isSellBillGenerated;
	}

	public void setIsSellBillGenerated(int isSellBillGenerated) {
		this.isSellBillGenerated = isSellBillGenerated;
	}

	@Override
	public String toString() {
		return "AdvanceOrderDetail [advDetailId=" + advDetailId + ", frId=" + frId + ", catId=" + catId + ", subCatId="
				+ subCatId + ", menuId=" + menuId + ", itemId=" + itemId + ", rate=" + rate + ", mrp=" + mrp + ", qty="
				+ qty + ", orderDate=" + orderDate + ", prodDate=" + prodDate + ", deliveryDate=" + deliveryDate
				+ ", events=" + events + ", eventsName=" + eventsName + ", subTotal=" + subTotal + ", tax1=" + tax1
				+ ", tax1Amt=" + tax1Amt + ", tax2=" + tax2 + ", tax2Amt=" + tax2Amt + ", isBillGenerated="
				+ isBillGenerated + ", isSellBillGenerated=" + isSellBillGenerated + ", advHeaderId=" + advHeaderId
				+ ", discPer=" + discPer + ", grnType=" + grnType + ", delStatus=" + delStatus + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exFloat1=" + exFloat1
				+ ", exFloat2=" + exFloat2 + "]";
	}

	 
}

package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GenerateBill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="fr_id")
	int  frId;
	
	@Column(name="is_positive")
	float  isPositive;
	
	@Column(name="menu_id")
	int  menuId;
	
	@Column(name="item_id")
	int  itemId;
	
	@Column(name="order_qty")
	int  orderQty;
	
	@Column(name="order_rate")
	double  orderRate;
	
	@Column(name="order_mrp")
	double  orderMrp;
	
	@Column(name="fr_name")
	String  frName;
	
	@Column(name="menu_title")
	String  menuTitle;
	
	@Column(name="item_name")
	String  itemName;
	
	@Column(name="item_grp1")
	int  catId;
	
	@Column(name="fr_code")
	String  frCode;
	
	@Column(name="fr_rate_cat")
	int  rateType;
	
	@Column(name="item_grp2")
	int  subCatId;
	
	@Column(name="item_tax1")
	private double itemTax1;
	
	@Column(name="item_tax2")
	private double itemTax2;
	
	@Column(name="item_tax3")
	private double itemTax3;
	
	@Column(name="grn_type")//newly added
	int  grnType;
	

	@Column(name="item_shelf_life")//newly added
	int  itemShelfLife;
	
	@Column(name="is_same_state")//newly added
	int  isSameState;
	
	@Column(name="delivery_date")//newly added
	Date  deliveryDate;
	
	@Column(name="party_name")
	private String  partyName;//new
	
	@Column(name="party_gstin")//new
	private String  partyGstin;
	
	@Column(name="party_address")//new
	private String  partyAddress;
	
	@Column(name="hsn_code")//new
	private String  hsnCode;
	
	@Column(name="cess_per")
	private float cessPer;//new1
	
	
	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyGstin() {
		return partyGstin;
	}

	public void setPartyGstin(String partyGstin) {
		this.partyGstin = partyGstin;
	}

	public String getPartyAddress() {
		return partyAddress;
	}

	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	public int getItemShelfLife() {
		return itemShelfLife;
	}

	public void setItemShelfLife(int itemShelfLife) {
		this.itemShelfLife = itemShelfLife;
	}

	public double getItemTax1() {
		return itemTax1;
	}

	public void setItemTax1(double itemTax1) {
		this.itemTax1 = itemTax1;
	}

	public double getItemTax2() {
		return itemTax2;
	}

	public void setItemTax2(double itemTax2) {
		this.itemTax2 = itemTax2;
	}

	public double getItemTax3() {
		return itemTax3;
	}

	public void setItemTax3(double itemTax3) {
		this.itemTax3 = itemTax3;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}

	public int getRateType() {
		return rateType;
	}

	public void setRateType(int rateType) {
		this.rateType = rateType;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
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

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}


	public double getOrderRate() {
		return orderRate;
	}

	public void setOrderRate(double orderRate) {
		this.orderRate = orderRate;
	}

	public double getOrderMrp() {
		return orderMrp;
	}

	public void setOrderMrp(double orderMrp) {
		this.orderMrp = orderMrp;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(float isPositive) {
		this.isPositive = isPositive;
	}

	public int getIsSameState() {
		return isSameState;
	}

	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}

	@Override
	public String toString() {
		return "GenerateBill [orderId=" + orderId + ", frId=" + frId + ", isPositive=" + isPositive + ", menuId="
				+ menuId + ", itemId=" + itemId + ", orderQty=" + orderQty + ", orderRate=" + orderRate + ", orderMrp="
				+ orderMrp + ", frName=" + frName + ", menuTitle=" + menuTitle + ", itemName=" + itemName + ", catId="
				+ catId + ", frCode=" + frCode + ", rateType=" + rateType + ", subCatId=" + subCatId + ", itemTax1="
				+ itemTax1 + ", itemTax2=" + itemTax2 + ", itemTax3=" + itemTax3 + ", grnType=" + grnType
				+ ", itemShelfLife=" + itemShelfLife + ", isSameState=" + isSameState + ", deliveryDate=" + deliveryDate
				+ ", partyName=" + partyName + ", partyGstin=" + partyGstin + ", partyAddress=" + partyAddress
				+ ", hsnCode=" + hsnCode + ", cessPer=" + cessPer + "]";
	}

	
}

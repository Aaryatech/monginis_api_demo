package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity(name="regularSpCkOrders")
@Immutable
public class RegularSpCkOrders {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rsp_id")
	private int rspId;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="id")
	private int id;
	
	@Column(name="rsp_delivery_dt")
	private String rspDeliveryDt;
	
	@Column(name="rsp_events")
	private String rspEvents;
	
	@Column(name="rsp_events_name")
	private String rspEventsName;
	
	@Column(name="rsp_sub_total")
	private float rspSubTotal;
	
	@Column(name="tax_1")
	private float tax1;
	
	@Column(name="tax_1_amt")
	private float tax1Amt;
	
	@Column(name="tax_2")
	private float tax2;
	
	@Column(name="tax_2_amt")
	private float tax2Amt;
	
	@Column(name="rate")
	private float rate;
	
	@Column(name="mrp")
	private float mrp;
	
	@Column(name="qty")
	private int qty;
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRspDeliveryDt() {
		return rspDeliveryDt;
	}
	public void setRspDeliveryDt(String rspDeliveryDt) {
		this.rspDeliveryDt = rspDeliveryDt;
	}
	public String getRspEvents() {
		return rspEvents;
	}
	public void setRspEvents(String rspEvents) {
		this.rspEvents = rspEvents;
	}
	public String getRspEventsName() {
		return rspEventsName;
	}
	public void setRspEventsName(String rspEventsName) {
		this.rspEventsName = rspEventsName;
	}
	public float getRspSubTotal() {
		return rspSubTotal;
	}
	public void setRspSubTotal(float rspSubTotal) {
		this.rspSubTotal = rspSubTotal;
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
	public int getRspId() {
		return rspId;
	}
	public void setRspId(int rspId) {
		this.rspId = rspId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
}

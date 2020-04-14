package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetRegSpCakeOrders {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rsp_id")
	private int rspId;

	
	@Column(name="fr_name") 
	private String frName;
	
	
	@Column(name="fr_mob") 
	private String frMob;
	
	@Column(name="item_name") 
	private String itemName;
	
	@Column(name="order_date") 
	private Date orderDate;
	
	@Column(name="mrp")
	private float rate;
	
	@Column(name="qty")
	private int qty;
	
 
	
	@Column(name="rsp_sub_total")
	private float rspSubTotal;
	
	@Column(name="rsp_advance_amt")
	private float rspAdvanceAmt;
	
	@Column(name="rsp_remaining_amt")
	private float rspRemainingAmt;
	
	@Column(name="rsp_delivery_dt")
	private Date rspDeliveryDt;
	
	
	
	@Column(name="rsp_place") 
	private String rspPlace;
	

	
	@Column(name="rsp_cust_name") 
	private String rspCustName;
	
	
	
	@Column(name="rsp_cust_mobile_no") 
	private String rspCustMobileNo;



	public String getRspPlace() {
		return rspPlace;
	}



	public void setRspPlace(String rspPlace) {
		this.rspPlace = rspPlace;
	}



	public int getRspId() {
		return rspId;
	}



	public void setRspId(int rspId) {
		this.rspId = rspId;
	}



	public String getFrName() {
		return frName;
	}



	public void setFrName(String frName) {
		this.frName = frName;
	}



	public String getFrMob() {
		return frMob;
	}



	public void setFrMob(String frMob) {
		this.frMob = frMob;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}


	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public float getRate() {
		return rate;
	}



	public void setRate(float rate) {
		this.rate = rate;
	}



	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public float getRspSubTotal() {
		return rspSubTotal;
	}



	public void setRspSubTotal(float rspSubTotal) {
		this.rspSubTotal = rspSubTotal;
	}



	public float getRspAdvanceAmt() {
		return rspAdvanceAmt;
	}



	public void setRspAdvanceAmt(float rspAdvanceAmt) {
		this.rspAdvanceAmt = rspAdvanceAmt;
	}



	public float getRspRemainingAmt() {
		return rspRemainingAmt;
	}



	public void setRspRemainingAmt(float rspRemainingAmt) {
		this.rspRemainingAmt = rspRemainingAmt;
	}


	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRspDeliveryDt() {
		return rspDeliveryDt;
	}


	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setRspDeliveryDt(Date rspDeliveryDt) {
		this.rspDeliveryDt = rspDeliveryDt;
	}



	public String getRspCustName() {
		return rspCustName;
	}



	public void setRspCustName(String rspCustName) {
		this.rspCustName = rspCustName;
	}



	public String getRspCustMobileNo() {
		return rspCustMobileNo;
	}



	public void setRspCustMobileNo(String rspCustMobileNo) {
		this.rspCustMobileNo = rspCustMobileNo;
	}



	@Override
	public String toString() {
		return "GetRegSpCakeOrders [rspId=" + rspId + ", frName=" + frName + ", frMob=" + frMob + ", itemName="
				+ itemName + ", orderDate=" + orderDate + ", rate=" + rate + ", qty=" + qty + ", rspSubTotal="
				+ rspSubTotal + ", rspAdvanceAmt=" + rspAdvanceAmt + ", rspRemainingAmt=" + rspRemainingAmt
				+ ", rspDeliveryDt=" + rspDeliveryDt + ", rspCustName=" + rspCustName + ", rspCustMobileNo="
				+ rspCustMobileNo + "]";
	}

	
 

	
	
}

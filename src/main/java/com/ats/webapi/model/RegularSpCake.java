package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="RegularSpCake")
@Table(name="t_regular_sp_cake")
public class RegularSpCake {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rsp_id")
	private int rspId;
	@Column(name="fr_id")
	private int frId;
    @Column(name="fr_code")
    private String frCode;
    @Column(name="rsp_sub_cat")
    private String rspSubCat;
    @Column(name="item_id")
    private String itemId;
    @Column(name="menu_id")
    private String menuId;
    @Column(name="order_date")
    private Date orderDate;
    @Column(name="rsp_produ_date")
    private Date rspProduDate;
    @Column(name="rsp_delivery_dt")
    private Date rspDeliveryDt;
    @Column(name="rsp_events")
    private String rspEvents;
    @Column(name="rsp_events_name")
    private String rspEventsName;
    @Column(name="rsp_sub_total")
    private float rspSubTotal;
    @Column(name="rsp_advance_amt")
    private float rspAdvanceAmt;
    @Column(name="rsp_remaining_amt")
    private float rspRemainingAmt;
    @Column(name="tax_1")
    private float tax1;
    @Column(name="tax_1_amt")
    private float tax1Amt;
    @Column(name="tax_2")
    private float tax2;
    @Column(name="tax_2_amt")
    private float tax2Amt;
    @Column(name="rsp_cust_name")
    private String rspCustName;
    @Column(name="rsp_cust_mobile_no")
    private String rspCustMobileNo;
    @Column(name="rate")
    private float rate;
    @Column(name="mrp")
    private float mrp;
    @Column(name="rate_cat")
    private int rateCat;
    
    @Column(name="qty")
    private int qty;
    
    @Column(name="is_bill_generated")
    private int isBillGenerated;
    
    private String rspPlace;
    
    
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
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	public String getRspSubCat() {
		return rspSubCat;
	}
	public void setRspSubCat(String rspSubCat) {
		this.rspSubCat = rspSubCat;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRspProduDate() {
		return rspProduDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setRspProduDate(Date rspProduDate) {
		this.rspProduDate = rspProduDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRspDeliveryDt() {
		return rspDeliveryDt;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setRspDeliveryDt(Date rspDeliveryDt) {
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
	public int getRateCat() {
		return rateCat;
	}
	public void setRateCat(int rateCat) {
		this.rateCat = rateCat;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getIsBillGenerated() {
		return isBillGenerated;
	}
	public void setIsBillGenerated(int isBillGenerated) {
		this.isBillGenerated = isBillGenerated;
	}
	
	@Override
	public String toString() {
		return "RegularSpCake [rspId=" + rspId + ", frId=" + frId + ", frCode=" + frCode + ", rspSubCat=" + rspSubCat
				+ ", itemId=" + itemId + ", menuId=" + menuId + ", orderDate=" + orderDate + ", rspProduDate="
				+ rspProduDate + ", rspDeliveryDt=" + rspDeliveryDt + ", rspEvents=" + rspEvents + ", rspEventsName="
				+ rspEventsName + ", rspSubTotal=" + rspSubTotal + ", rspAdvanceAmt=" + rspAdvanceAmt
				+ ", rspRemainingAmt=" + rspRemainingAmt + ", tax1=" + tax1 + ", tax1Amt=" + tax1Amt + ", tax2=" + tax2
				+ ", tax2Amt=" + tax2Amt + ", rspCustName=" + rspCustName + ", rspCustMobileNo=" + rspCustMobileNo
				+ ", rate=" + rate + ", mrp=" + mrp + ", rateCat=" + rateCat + ", qty=" + qty + ", isBillGenerated="
				+ isBillGenerated + "]";
	}
		
	
	
	
}

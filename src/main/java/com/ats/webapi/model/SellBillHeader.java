package com.ats.webapi.model;

import java.io.Serializable;
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
@Table(name ="t_sell_bill_header")
public class SellBillHeader implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_no")
	private int sellBillNo;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="disc_type")
	private int discType;   //new
	
	@Column(name="discount_per")
	private float discountPer;
		
	@Column(name="discount_amt")
	private float discountAmt;
	
	@Column(name="payable_amt")
	private float payableAmt;
	
	@Column(name="total_tax")
	private float totalTax;
	
	@Column(name="grand_total")
	private float grandTotal;
	
	@Column(name="paid_amt")
	private float paidAmt;
	
	@Column(name="remaining_amt")
	private float remainingAmt;
	
	@Column(name="disc_amt_item")
	private float discAmtItem; //new
	
	@Column(name="advance_amt")
	private float advanceAmt;  //new     
	
	@Column(name="payment_mode")
	private int paymentMode;
	
	@Column(name="cust_id")
	private int custId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_gst_no")
	private String userGstNo;
	
	@Column(name="user_phone")
	private String userPhone;
	
	@Column(name="status")
	private int status;
	
	@Column(name="is_dairy_mart_bill")
	private int isDairyMartBill;//new
	
	@Column(name="coupon_no")
	private String couponNo;//new
	
	@Column(name="cust_loyalty_pt_rate")
	private float custLoyaltyPtRate;//new
	
	@Column(name="cust_loyalty_pt")
	private float custLoyaltyPt;//new
	
	@Column(name="del_status")
	private int delStatus;

	@Column(name="bill_type")
	private char billType;
	
	

	@Column(name="ext_int1")
	private int extInt1;
	
	@Column(name="ext_float1")
	private int extFloat1;
	
	@Column(name="ext_int2")
	private int extInt2;
	
	@Column(name="ext_var1")
	private String extVar1;
	
	
 

	

	public String getExtVar1() {
		return extVar1;
	}

	public void setExtVar1(String extVar1) {
		this.extVar1 = extVar1;
	}

	public int getExtFloat1() {
		return extFloat1;
	}

	public void setExtFloat1(int extFloat1) {
		this.extFloat1 = extFloat1;
	}

	public int getExtInt1() {
		return extInt1;
	}

	public void setExtInt1(int extInt1) {
		this.extInt1 = extInt1;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}

	public float getCustLoyaltyPtRate() {
		return custLoyaltyPtRate;
	}

	public void setCustLoyaltyPtRate(float custLoyaltyPtRate) {
		this.custLoyaltyPtRate = custLoyaltyPtRate;
	}

	public float getCustLoyaltyPt() {
		return custLoyaltyPt;
	}

	public void setCustLoyaltyPt(float custLoyaltyPt) {
		this.custLoyaltyPt = custLoyaltyPt;
	}

	public int getDiscType() {
		return discType;
	}

	public void setDiscType(int discType) {
		this.discType = discType;
	}

	public float getDiscAmtItem() {
		return discAmtItem;
	}

	public void setDiscAmtItem(float discAmtItem) {
		this.discAmtItem = discAmtItem;
	}

	public float getAdvanceAmt() {
		return advanceAmt;
	}

	public void setAdvanceAmt(float advanceAmt) {
		this.advanceAmt = advanceAmt;
	}

	public int getIsDairyMartBill() {
		return isDairyMartBill;
	}

	public void setIsDairyMartBill(int isDairyMartBill) {
		this.isDairyMartBill = isDairyMartBill;
	}

	public char getBillType() {
		return billType;
	}

	public void setBillType(char billType) {
		this.billType = billType;
	}

	@Transient
	List<SellBillDetail> sellBillDetailsList;
	
	public List<SellBillDetail> getSellBillDetailsList() {
		return sellBillDetailsList;
	}

	public void setSellBillDetailsList(List<SellBillDetail> sellBillDetailsList) {
		this.sellBillDetailsList = sellBillDetailsList;
	}

	public int getSellBillNo() {
		return sellBillNo;
	}

	public void setSellBillNo(int sellBillNo) {
		this.sellBillNo = sellBillNo;
	}

	
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public Date getBillDate() {
		return billDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "yyyy-MM-dd")
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
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

	public float getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(float paidAmt) {
		this.paidAmt = paidAmt;
	}

	public float getRemainingAmt() {
		return remainingAmt;
	}

	public void setRemainingAmt(float remainingAmt) {
		this.remainingAmt = remainingAmt;
	}

	public int getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGstNo() {
		return userGstNo;
	}

	
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public void setUserGstNo(String userGstNo) {
		this.userGstNo = userGstNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public float getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(float discountPer) {
		this.discountPer = discountPer;
	}

	public float getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(float discountAmt) {
		this.discountAmt = discountAmt;
	}

	public float getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(float payableAmt) {
		this.payableAmt = payableAmt;
	}

	public int getExtInt2() {
		return extInt2;
	}

	public void setExtInt2(int extInt2) {
		this.extInt2 = extInt2;
	}

	@Override
	public String toString() {
		return "SellBillHeader [sellBillNo=" + sellBillNo + ", invoiceNo=" + invoiceNo + ", billDate=" + billDate
				+ ", frId=" + frId + ", frCode=" + frCode + ", taxableAmt=" + taxableAmt + ", discType=" + discType
				+ ", discountPer=" + discountPer + ", discountAmt=" + discountAmt + ", payableAmt=" + payableAmt
				+ ", totalTax=" + totalTax + ", grandTotal=" + grandTotal + ", paidAmt=" + paidAmt + ", remainingAmt="
				+ remainingAmt + ", discAmtItem=" + discAmtItem + ", advanceAmt=" + advanceAmt + ", paymentMode="
				+ paymentMode + ", custId=" + custId + ", userName=" + userName + ", userGstNo=" + userGstNo
				+ ", userPhone=" + userPhone + ", status=" + status + ", isDairyMartBill=" + isDairyMartBill
				+ ", couponNo=" + couponNo + ", custLoyaltyPtRate=" + custLoyaltyPtRate + ", custLoyaltyPt="
				+ custLoyaltyPt + ", delStatus=" + delStatus + ", billType=" + billType + ", extInt1=" + extInt1
				+ ", extFloat1=" + extFloat1 + ", extInt2=" + extInt2 + ", extVar1=" + extVar1
				+ ", sellBillDetailsList=" + sellBillDetailsList + "]";
	}
	

}

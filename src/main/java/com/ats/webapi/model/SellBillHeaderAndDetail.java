package com.ats.webapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SellBillHeaderAndDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_no")
	private int sellBillNo;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="bill_type")
	private char billType;
	
	@Column(name="timestamp")
	private Date timestamp;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="total_tax")
	private float total_tax;
	
	@Column(name="grand_total")
	private float grandTotal;
	
	@Column(name="disc_type")
	private int discType;   //new
	
	@Column(name="discount_per")
	private float discountPer;
		
	@Column(name="discount_amt")
	private float discountAmt;
	
	@Column(name="payable_amt")
	private float payableAmt;
	  
	@Column(name="payment_mode")
	private int paymentMode;
	
	@Column(name="paid_amt")
	private float paidAmt;
	
	@Column(name="remaining_amt")
	private float remainingAmt;
	
	@Column(name="disc_amt_item")
	private float discAmtItem; //new
	
	@Column(name="advance_amt")
	private float advanceAmt;  //new     
	 
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
	
	@Column(name="cust_name")
	private String custName; 
	
	@Column(name="gst_no")
	private String gstNo; 
	
	private int extInt1;
	
	@Transient
	private List<SellBillDetailForPos> list;
	
	@Transient
	private List<TaxLabListForPos> taxlabList;

	
	
	public int getExtInt1() {
		return extInt1;
	}

	public void setExtInt1(int extInt1) {
		this.extInt1 = extInt1;
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
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy") 
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public char getBillType() {
		return billType;
	}

	public void setBillType(char billType) {
		this.billType = billType;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss aa")
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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

	public float getTotal_tax() {
		return total_tax;
	}

	public void setTotal_tax(float total_tax) {
		this.total_tax = total_tax;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getDiscType() {
		return discType;
	}

	public void setDiscType(int discType) {
		this.discType = discType;
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

	public int getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
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

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
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

	public void setUserGstNo(String userGstNo) {
		this.userGstNo = userGstNo;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsDairyMartBill() {
		return isDairyMartBill;
	}

	public void setIsDairyMartBill(int isDairyMartBill) {
		this.isDairyMartBill = isDairyMartBill;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public List<SellBillDetailForPos> getList() {
		return list;
	}

	public void setList(List<SellBillDetailForPos> list) {
		this.list = list;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public List<TaxLabListForPos> getTaxlabList() {
		return taxlabList;
	}

	public void setTaxlabList(List<TaxLabListForPos> taxlabList) {
		this.taxlabList = taxlabList;
	}

	@Override
	public String toString() {
		return "SellBillHeaderAndDetail [sellBillNo=" + sellBillNo + ", invoiceNo=" + invoiceNo + ", billDate="
				+ billDate + ", billType=" + billType + ", timestamp=" + timestamp + ", frId=" + frId + ", frCode="
				+ frCode + ", taxableAmt=" + taxableAmt + ", total_tax=" + total_tax + ", grandTotal=" + grandTotal
				+ ", discType=" + discType + ", discountPer=" + discountPer + ", discountAmt=" + discountAmt
				+ ", payableAmt=" + payableAmt + ", paymentMode=" + paymentMode + ", paidAmt=" + paidAmt
				+ ", remainingAmt=" + remainingAmt + ", discAmtItem=" + discAmtItem + ", advanceAmt=" + advanceAmt
				+ ", custId=" + custId + ", userName=" + userName + ", userGstNo=" + userGstNo + ", userPhone="
				+ userPhone + ", status=" + status + ", isDairyMartBill=" + isDairyMartBill + ", couponNo=" + couponNo
				+ ", custLoyaltyPtRate=" + custLoyaltyPtRate + ", custLoyaltyPt=" + custLoyaltyPt + ", delStatus="
				+ delStatus + ", custName=" + custName + ", gstNo=" + gstNo + ", extInt1=" + extInt1 + ", list=" + list
				+ ", taxlabList=" + taxlabList + "]";
	}
}

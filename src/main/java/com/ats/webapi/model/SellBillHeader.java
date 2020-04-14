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
	
	@Column(name="payment_mode")
	private int paymentMode;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_gst_no")
	private String userGstNo;
	
	@Column(name="user_phone")
	private String userPhone;
	
	@Column(name="status")
	private int status;
	
	@Column(name="del_status")
	private int DelStatus;

	@Column(name="bill_type")
	private char billType;

	
	

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
		return DelStatus;
	}

	public void setDelStatus(int delStatus) {
		DelStatus = delStatus;
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

	@Override
	public String toString() {
		return "SellBillHeader [sellBillNo=" + sellBillNo + ", invoiceNo=" + invoiceNo + ", billDate=" + billDate
				+ ", frId=" + frId + ", frCode=" + frCode + ", taxableAmt=" + taxableAmt + ", discountPer="
				+ discountPer + ", discountAmt=" + discountAmt + ", payableAmt=" + payableAmt + ", totalTax=" + totalTax
				+ ", grandTotal=" + grandTotal + ", paidAmt=" + paidAmt + ", remainingAmt=" + remainingAmt
				+ ", paymentMode=" + paymentMode + ", userName=" + userName + ", userGstNo=" + userGstNo
				+ ", userPhone=" + userPhone + ", status=" + status + ", DelStatus=" + DelStatus
				+ ", sellBillDetailsList=" + sellBillDetailsList + "]";
	}

	
	

}

package com.ats.webapi.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetSellBillHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(name="sell_bill_no")
	private int sellBillNo;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="bill_date")
	private Date billDate;

	@Column(name="taxable_amt")
	private float taxableAmt;
	
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
	
	@Column(name="discount_per")
	private int discountPer;
	
	@Column(name="payable_amt")
	private float payableAmt;

	@Column(name="fr_name")
	private String frName;
	
	@Column(name="bill_type")
	private char billType;
	
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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

	public int getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(int discountPer) {
		this.discountPer = discountPer;
	}

	public float getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(float payableAmt) {
		this.payableAmt = payableAmt;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public char getBillType() {
		return billType;
	}

	public void setBillType(char billType) {
		this.billType = billType;
	}

	@Override
	public String toString() {
		return "GetSellBillHeader [id=" + id + ", sellBillNo=" + sellBillNo + ", invoiceNo=" + invoiceNo + ", billDate="
				+ billDate + ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax + ", grandTotal=" + grandTotal
				+ ", paidAmt=" + paidAmt + ", remainingAmt=" + remainingAmt + ", paymentMode=" + paymentMode
				+ ", discountPer=" + discountPer + ", payableAmt=" + payableAmt + ", frName=" + frName + ", billType="
				+ billType + "]";
	}

	
}

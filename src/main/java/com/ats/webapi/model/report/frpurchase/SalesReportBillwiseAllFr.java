package com.ats.webapi.model.report.frpurchase;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
//bean for sales report no 7//13 Jan 2018
public class SalesReportBillwiseAllFr implements Serializable {
	
/*	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_no")
	private int billNo;*/
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private String id;
	
	
	@Column(name="bill_no")
	private int billNo;
		
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="fr_city")
	private String frCity;
	 
	@Column(name="fr_gst_no")
	private String frGstNo;
	 
	 @Column(name="is_same_state")
	private int isSameState;
	 
	 
	 @Column(name="item_hsncd")
		private String itemHsncd;
		
	 @Column(name="item_tax1")
		private float itemTax1;
		
	 @Column(name="item_tax2")
		private float itemTax2;
		
	 @Column(name="item_tax3")
		private float itemTax3;
	 
	 @Column(name="item_name")
		private String itemName;
	 
	 float taxableAmtSum;
	 float sgstRsSum;
	 float cgstRsSum;
	 float igstRsSum;
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}
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
	public String getFrCity() {
		return frCity;
	}
	public void setFrCity(String frCity) {
		this.frCity = frCity;
	}
	public String getFrGstNo() {
		return frGstNo;
	}
	public void setFrGstNo(String frGstNo) {
		this.frGstNo = frGstNo;
	}
	public int getIsSameState() {
		return isSameState;
	}
	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}
	public String getItemHsncd() {
		return itemHsncd;
	}
	public void setItemHsncd(String itemHsncd) {
		this.itemHsncd = itemHsncd;
	}
	public float getItemTax1() {
		return itemTax1;
	}
	public void setItemTax1(float itemTax1) {
		this.itemTax1 = itemTax1;
	}
	public float getItemTax2() {
		return itemTax2;
	}
	public void setItemTax2(float itemTax2) {
		this.itemTax2 = itemTax2;
	}
	public float getItemTax3() {
		return itemTax3;
	}
	public void setItemTax3(float itemTax3) {
		this.itemTax3 = itemTax3;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getTaxableAmtSum() {
		return taxableAmtSum;
	}
	public void setTaxableAmtSum(float taxableAmtSum) {
		this.taxableAmtSum = taxableAmtSum;
	}
	public float getSgstRsSum() {
		return sgstRsSum;
	}
	public void setSgstRsSum(float sgsstRsSum) {
		this.sgstRsSum = sgsstRsSum;
	}
	public float getCgstRsSum() {
		return cgstRsSum;
	}
	public void setCgstRsSum(float cgstRsSum) {
		this.cgstRsSum = cgstRsSum;
	}
	public float getIgstRsSum() {
		return igstRsSum;
	}
	public void setIgstRsSum(float igstRsSum) {
		this.igstRsSum = igstRsSum;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "SalesReportBillwiseAllFr [id=" + id + ", billNo=" + billNo + ", invoiceNo=" + invoiceNo + ", frName="
				+ frName + ", billDate=" + billDate + ", frId=" + frId + ", frCode=" + frCode + ", frCity=" + frCity
				+ ", frGstNo=" + frGstNo + ", isSameState=" + isSameState + ", itemHsncd=" + itemHsncd + ", itemTax1="
				+ itemTax1 + ", itemTax2=" + itemTax2 + ", itemTax3=" + itemTax3 + ", itemName=" + itemName
				+ ", taxableAmtSum=" + taxableAmtSum + ", sgstRsSum=" + sgstRsSum + ", cgstRsSum=" + cgstRsSum
				+ ", igstRsSum=" + igstRsSum + "]";
	}
	
	
	 
}

package com.ats.webapi.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetGrnItemConfig implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_no")
	private int billDetailNo;
	
		
	@Column(name="item_id")
	private int  itemId;
	
	@Column(name="fr_id")
	private int  frId;
	
	//new grnQty
	@Transient
	private int autoGrnQty;

	@Column(name="item_name")
	private String itemName;
	
	@Column(name="grn_type")
	private int grnType;
	
	@Column(name="bill_no")
	private int billNo;
	
	@Column(name="bill_date_time")
	private String billDateTime;

	@Column(name="rate")
	private float rate;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="mrp")
	private float mrp;
	
	@Column(name="bill_qty")
	private int billQty;

	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="cess_per")
	private float cessPer;//new1
	
	@Column(name="igst_per")
	private float igstPer;
	
	//newly Added
	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	private float discPer;//new field added on 1 Feb 2019
	
	@Column(name="hsn_code")
	private String hsnCode;
    
	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	@PostLoad
	public void onLoad() {
		
		this.autoGrnQty=0;
		
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
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

	public int getBillQty() {
		return billQty;
	}

	public void setBillQty(int billQty) {
		this.billQty = billQty;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}
@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "yyyy-MM-dd")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public int getAutoGrnQty() {
		return autoGrnQty;
	}

	public void setAutoGrnQty(int autoGrnQty) {
		this.autoGrnQty = autoGrnQty;
	}

	public String getBillDateTime() {
		return billDateTime;
	}

	public void setBillDateTime(String billDateTime) {
		this.billDateTime = billDateTime;
	}
    
	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	@Override
	public String toString() {
		return "GetGrnItemConfig [billDetailNo=" + billDetailNo + ", itemId=" + itemId + ", frId=" + frId
				+ ", autoGrnQty=" + autoGrnQty + ", itemName=" + itemName + ", grnType=" + grnType + ", billNo="
				+ billNo + ", billDateTime=" + billDateTime + ", rate=" + rate + ", billDate=" + billDate + ", mrp="
				+ mrp + ", billQty=" + billQty + ", sgstPer=" + sgstPer + ", cgstPer=" + cgstPer + ", cessPer="
				+ cessPer + ", igstPer=" + igstPer + ", menuId=" + menuId + ", catId=" + catId + ", invoiceNo="
				+ invoiceNo + ", discPer=" + discPer + ", hsnCode=" + hsnCode + "]";
	}

	
}

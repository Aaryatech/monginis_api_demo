package com.ats.webapi.model.report;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetCustomerBill {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_detail_no")
		private int sellBillDetailNo;
	
	@Column(name="sell_bill_no")
	private int sellBillNo;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="bill_date")
	private Date billDate;

	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="fr_mob")
	private String frMob;
	
	@Column(name="fr_address")
	private String frAddress;
	
	@Column(name="user_name")
	private String custName;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_hsncd")
	private String hsnCode;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="discount_per")
	private float discountPer;
	
	@Column(name="discount_amt" )
	private float discountAmt;
	
	@Column(name="fr_gst_no")
	private String gstn;
	
	
	@Column(name="grand_total" )
	private float bill_amount;
	
	@Column(name="mrp")
	private float mrp;
	
	@Column(name="qty")
	private int qty;
	
	@Column(name="igst_rs")
	private float igstRs;
	
	@Column(name="cgst_rs")
	private float cgstRs;
	
	@Column(name="sgst_rs")
	private float sgstRs;

	@Transient
	private int intBillAmt;

	@Transient
	private int intDiscAmt;


	private String userGstNo;//new

	private String userPhone;//new
	
	private String billType;//new

	
	@PostLoad
	private void onLoad() {
	    this.intBillAmt = Math.round(bill_amount);
	    this.intDiscAmt = Math.round(discountAmt);
	
	}

	
	public String getBillType() {
		return billType;
	}


	public void setBillType(String billType) {
		this.billType = billType;
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


	public String getHsnCode() {
		return hsnCode;
	}


	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}


	public int getSellBillDetailNo() {
		return sellBillDetailNo;
	}

	public void setSellBillDetailNo(int sellBillDetailNo) {
		this.sellBillDetailNo = sellBillDetailNo;
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

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
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

	public String getFrAddress() {
		return frAddress;
	}

	public void setFrAddress(String frAddress) {
		this.frAddress = frAddress;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public String getGstn() {
		return gstn;
	}

	public void setGstn(String gstn) {
		this.gstn = gstn;
	}

	public float getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(float bill_amount) {
		this.bill_amount = bill_amount;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
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


	public int getIntBillAmt() {
		return intBillAmt;
	}


	public void setIntBillAmt(int intBillAmt) {
		this.intBillAmt = intBillAmt;
	}


	public int getIntDiscAmt() {
		return intDiscAmt;
	}


	public void setIntDiscAmt(int intDiscAmt) {
		this.intDiscAmt = intDiscAmt;
	}


	@Override
	public String toString() {
		return "GetCustomerBill [sellBillDetailNo=" + sellBillDetailNo + ", sellBillNo=" + sellBillNo + ", invoiceNo="
				+ invoiceNo + ", billDate=" + billDate + ", frId=" + frId + ", frName=" + frName + ", frMob=" + frMob
				+ ", frAddress=" + frAddress + ", custName=" + custName + ", itemId=" + itemId + ", hsnCode=" + hsnCode
				+ ", itemName=" + itemName + ", taxableAmt=" + taxableAmt + ", cgstPer=" + cgstPer + ", sgstPer="
				+ sgstPer + ", igstPer=" + igstPer + ", discountPer=" + discountPer + ", discountAmt=" + discountAmt
				+ ", gstn=" + gstn + ", bill_amount=" + bill_amount + ", mrp=" + mrp + ", qty=" + qty + ", igstRs="
				+ igstRs + ", cgstRs=" + cgstRs + ", sgstRs=" + sgstRs + ", intBillAmt=" + intBillAmt + ", intDiscAmt="
				+ intDiscAmt + ", userGstNo=" + userGstNo + ", userPhone=" + userPhone + ", billType=" + billType + "]";
	}

    

		  
}

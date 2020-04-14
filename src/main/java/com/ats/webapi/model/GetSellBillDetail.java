package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetSellBillDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_detail_no")
	private int sellBillDetailNo;
	
	@Column(name="sell_bill_no")
	private int sellBillNo;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="mrp_base_rate")
	private float mrpBaseRate;
	
	@Column(name="total_tax")
	private float totalTax;

	@Column(name="grand_total")
	private float grandTotal;
	

	@Column(name="mrp")
	private float mrp;
	

	@Column(name="qty")
	private int qty;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="item_name")
	private String itemName;

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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getMrpBaseRate() {
		return mrpBaseRate;
	}

	public void setMrpBaserate(float mrpBaseRate) {
		this.mrpBaseRate = mrpBaseRate;
	}

	@Override
	public String toString() {
		return "GetSellBillDetail [sellBillDetailNo=" + sellBillDetailNo + ", sellBillNo=" + sellBillNo
				+ ", taxableAmt=" + taxableAmt + ", mrpBaseRate=" + mrpBaseRate + ", totalTax=" + totalTax
				+ ", grandTotal=" + grandTotal + ", mrp=" + mrp + ", qty=" + qty + ", sgstPer=" + sgstPer + ", cgstPer="
				+ cgstPer + ", itemName=" + itemName + "]";
	}

	
	
	
}

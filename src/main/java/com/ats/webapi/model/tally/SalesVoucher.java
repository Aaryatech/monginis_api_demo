package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SalesVoucher implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_no")
	private int billDetailNo;
	
	@Column(name="bill_no")
	private int billNo;
	
	@Column(name="invoice_no")
	private String vNo;
	
	@Column(name="bill_date")
	private Date date;
	
	@Transient
	private String vType;

	@Column(name="fr_name")
	private String partyName;

	@Column(name="fr_gst_no")
	private String gstin;

	@Column(name="fr_state")
	private String state;

	@Column(name="item_name")
	private String itemName;
	
	@Column(name="hsn_code")
	private String hsnCode;
	
	@Column(name="bill_qty")
	private int qty;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="base_rate")
	private float rate;
	
	@Column(name="taxable_amt")
	private float amount;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="sgst_rs")
	private float sgstRs;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="cgst_rs")
	private float cgstRs;
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="igst_rs")
	private float igstRs;
	
	@Column(name="cess_per")
	private float cessPer;
	
	@Column(name="cess_rs")
	private float cessRs;
	
	@Column(name="disc_per")
	private float itemDiscPer;
	
	@Column(name="disc_amt")
	private float totalDisc;
	
	@Column(name="round_off")
	private float roundOff;
	
	@Column(name="total_amt")
	private float totalAmt;
	
	@Column(name="bill_total")
	private float billTotal; 
	
	@Column(name="total_taxable_amt")
	private float totalTaxableAmt;
	
	@Column(name="sgst_sum")
	private float sgstSum;
	
	@Column(name="cgst_sum")
	private float cgstSum;
	
	@Column(name="igst_sum")
	private float igstSum;
	
	@Column(name="total_tax")
	private float totalTax;
	
	@Column(name="fr_id")
	private int frId;
	 
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="item_code")
	private String itemCode;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="erp_link")
	private String erpLink;

	@PostLoad
	public void onLoad() {
		this.vType="Sales";
	
	}

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

 
    public String getvNo() {
		return vNo;
	}

	public void setvNo(String vNo) {
		this.vNo = vNo;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public float getCessRs() {
		return cessRs;
	}

	public void setCessRs(float cessRs) {
		this.cessRs = cessRs;
	}

	public float getItemDiscPer() {
		return itemDiscPer;
	}

	public void setItemDiscPer(float itemDiscPer) {
		this.itemDiscPer = itemDiscPer;
	}

	public float getTotalDisc() {
		return totalDisc;
	}

	public void setTotalDisc(float totalDisc) {
		this.totalDisc = totalDisc;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public float getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	 

	public float getTotalTaxableAmt() {
		return totalTaxableAmt;
	}

	public void setTotalTaxableAmt(float totalTaxableAmt) {
		this.totalTaxableAmt = totalTaxableAmt;
	}

	public float getSgstSum() {
		return sgstSum;
	}

	public void setSgstSum(float sgstSum) {
		this.sgstSum = sgstSum;
	}

	public float getCgstSum() {
		return cgstSum;
	}

	public void setCgstSum(float cgstSum) {
		this.cgstSum = cgstSum;
	}

	public float getIgstSum() {
		return igstSum;
	}

	public void setIgstSum(float igstSum) {
		this.igstSum = igstSum;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}

	public String getErpLink() {
		return erpLink;
	}

	public void setErpLink(String erpLink) {
		this.erpLink = erpLink;
	}

	@Override
	public String toString() {
		return "SalesVoucher [billDetailNo=" + billDetailNo + ", billNo=" + billNo + ", vNo=" + vNo + ", date=" + date
				+ ", vType=" + vType + ", partyName=" + partyName + ", gstin=" + gstin + ", state=" + state
				+ ", itemName=" + itemName + ", hsnCode=" + hsnCode + ", qty=" + qty + ", uom=" + uom + ", rate=" + rate
				+ ", amount=" + amount + ", sgstPer=" + sgstPer + ", sgstRs=" + sgstRs + ", cgstPer=" + cgstPer
				+ ", cgstRs=" + cgstRs + ", igstPer=" + igstPer + ", igstRs=" + igstRs + ", cessPer=" + cessPer
				+ ", cessRs=" + cessRs + ", itemDiscPer=" + itemDiscPer + ", totalDisc=" + totalDisc + ", roundOff="
				+ roundOff + ", totalAmt=" + totalAmt + ", billTotal=" + billTotal + ", totalTaxableAmt="
				+ totalTaxableAmt + ", sgstSum=" + sgstSum + ", cgstSum=" + cgstSum + ", igstSum=" + igstSum
				+ ", totalTax=" + totalTax + ", frId=" + frId + ", itemId=" + itemId + ", catId=" + catId
				+ ", itemCode=" + itemCode + ", frCode=" + frCode + ", remark=" + remark + ", erpLink=" + erpLink + "]";
	}
	
	
}

package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.Date; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MaterialReceiptNote implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mrn_detail_id")
	private int mrnDetailId;

	@Column(name="mrn_id")
	private int mrnId;
	
	@Column(name="mrn_no")
	private String mrnNo;
	
	@Column(name="invoice_number")
	private String invoiceNumber;
	
	@Column(name="inv_book_date")
	private Date invoiceBookDate; 
	
	@Column(name="inv_date")
	private Date invoiceDate;
	
	@Column(name="mrn_type")
	private int mrnType;
	
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="supp_name")
	private String supplierName; 
	
	@Column(name="supp_gstin")
	private String suppGstin; 
	
	@Column(name="supp_state")
	private String suppState; 
	  
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="hsn_code")
	private String hsnCode;
	
	@Column(name="rm_uom")
	private String rmUom;
	
	@Column(name="recd_qty")
	private int recdQty;
	
	@Column(name="varified_rate")
	private float varifiedRate;
	
	@Column(name="value")
	private float value;
	
	@Column(name="disc_per")
	private float discPer;
	 
	@Column(name="disc_amt")
	private float discAmt;
	
	@Column(name="amount")
	private float amount;

	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="cgst_rs")
	private float cgstRs;
	
	@Column(name="sgst_rs")
	private float sgstRs;
	
	@Column(name="igst_rs")
	private float igstRs;
	
	@Column(name="cess_rs")
	private float cessRs;
	
	@Column(name="freight_amt")
	private float freightAmt;
	
	@Column(name="insurance_amt")
	private float insuranceAmt;
	
	@Column(name="disc_rs_onbill")
	private float discRsOnbill;
	
	@Column(name="other3")
	private float other3;
	
	@Column(name="other4")
	private float other4;
	
	@Column(name="bill_amount")
	private float billAmount;

	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceBookDate() {
		return invoiceBookDate;
	}

	public void setInvoiceBookDate(Date invoiceBookDate) {
		this.invoiceBookDate = invoiceBookDate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getMrnType() {
		return mrnType;
	}

	public void setMrnType(int mrnType) {
		this.mrnType = mrnType;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
 
	public String getSuppGstin() {
		return suppGstin;
	}

	public void setSuppGstin(String suppGstin) {
		this.suppGstin = suppGstin;
	}

	public String getSuppState() {
		return suppState;
	}

	public void setSuppState(String suppState) {
		this.suppState = suppState;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getRmUom() {
		return rmUom;
	}

	public void setRmUom(String rmUom) {
		this.rmUom = rmUom;
	}

	public int getRecdQty() {
		return recdQty;
	}

	public void setRecdQty(int recdQty) {
		this.recdQty = recdQty;
	}

	public float getVarifiedRate() {
		return varifiedRate;
	}

	public void setVarifiedRate(float varifiedRate) {
		this.varifiedRate = varifiedRate;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getCessRs() {
		return cessRs;
	}

	public void setCessRs(float cessRs) {
		this.cessRs = cessRs;
	}

	public float getFreightAmt() {
		return freightAmt;
	}

	public void setFreightAmt(float freightAmt) {
		this.freightAmt = freightAmt;
	}

	public float getInsuranceAmt() {
		return insuranceAmt;
	}

	public void setInsuranceAmt(float insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
	}

	public float getDiscRsOnbill() {
		return discRsOnbill;
	}

	public void setDiscRsOnbill(float discRsOnbill) {
		this.discRsOnbill = discRsOnbill;
	}

	public float getOther3() {
		return other3;
	}

	public void setOther3(float other3) {
		this.other3 = other3;
	}

	public float getOther4() {
		return other4;
	}

	public void setOther4(float other4) {
		this.other4 = other4;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "MaterialReceiptNote [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", mrnNo=" + mrnNo
				+ ", invoiceNumber=" + invoiceNumber + ", invoiceBookDate=" + invoiceBookDate + ", invoiceDate="
				+ invoiceDate + ", mrnType=" + mrnType + ", supplierId=" + supplierId + ", supplierName=" + supplierName
				+ ", suppGstin=" + suppGstin + ", suppState=" + suppState + ", rmId=" + rmId + ", rmName=" + rmName
				+ ", hsnCode=" + hsnCode + ", rmUom=" + rmUom + ", recdQty=" + recdQty + ", varifiedRate="
				+ varifiedRate + ", value=" + value + ", discPer=" + discPer + ", discAmt=" + discAmt + ", amount="
				+ amount + ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer + ", igstPer=" + igstPer + ", cgstRs="
				+ cgstRs + ", sgstRs=" + sgstRs + ", igstRs=" + igstRs + ", cessRs=" + cessRs + ", freightAmt="
				+ freightAmt + ", insuranceAmt=" + insuranceAmt + ", discRsOnbill=" + discRsOnbill + ", other3="
				+ other3 + ", other4=" + other4 + ", billAmount=" + billAmount + "]";
	}

	 
	
	 
	
}

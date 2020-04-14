package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
// Bean to search order :Listing Bills @Sachin
@Entity
public class GetBillHeader implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_no")
	private int billNo;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="time")
	private String time;

	@Column(name="tax_applicable")
	private int taxApplicable;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="grand_total")
	private float grandTotal;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="total_tax")
	private float totalTax;
	
	@Column(name="status")
	private int status;
	
	
	@Column(name="del_status")
	private int DelStatus;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="party_name")
	private String partyName;
	
	@Column(name="party_address")
	private String partyAddress;
	
	@Column(name="party_gstin")
	private String partyGstin;
	
	private String vehNo;
	
	private String billTime;
	
	private String exVarchar1;
	
	private String exVarchar2;
	
    
	
	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getBillTime() {
		return billTime;
	}

	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}

	public String getExVarchar1() {
		return exVarchar1;
	}

	public void setExVarchar1(String exVarchar1) {
		this.exVarchar1 = exVarchar1;
	}

	public String getExVarchar2() {
		return exVarchar2;
	}

	public void setExVarchar2(String exVarchar2) {
		this.exVarchar2 = exVarchar2;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyAddress() {
		return partyAddress;
	}

	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}

	public String getPartyGstin() {
		return partyGstin;
	}

	public void setPartyGstin(String partyGstin) {
		this.partyGstin = partyGstin;
	}

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

	
	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
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

	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}
	
	public int getTaxApplicable() {
		return taxApplicable;
	}

	public void setTaxApplicable(int taxApplicable) {
		this.taxApplicable = taxApplicable;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "GetBillHeader [billNo=" + billNo + ", frName=" + frName + ", time=" + time + ", taxApplicable="
				+ taxApplicable + ", invoiceNo=" + invoiceNo + ", billDate=" + billDate + ", frId=" + frId + ", frCode="
				+ frCode + ", grandTotal=" + grandTotal + ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax
				+ ", status=" + status + ", DelStatus=" + DelStatus + ", remark=" + remark + ", partyName=" + partyName
				+ ", partyAddress=" + partyAddress + ", partyGstin=" + partyGstin + ", vehNo=" + vehNo + ", billTime="
				+ billTime + ", exVarchar1=" + exVarchar1 + ", exVarchar2=" + exVarchar2 + "]";
	}

	

}

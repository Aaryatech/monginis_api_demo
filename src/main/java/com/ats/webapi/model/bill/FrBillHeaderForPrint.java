package com.ats.webapi.model.bill;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class FrBillHeaderForPrint implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_no")
	private int billNo;
	
	@Column(name="fr_name")
	private String frName;

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
	
	@Column(name="fr_address")
	private String frAddress;
	
	@Column(name="is_same_state")
	private String isSameState;
	
	
	@Column(name="party_name")//new -08 feb 19
	private String partyName;
	
	@Column(name="party_gstin")
	private String partyGstin;//new -08 feb 19
	
	@Column(name="party_address")
	private String partyAddress;//new -08 feb 19
	
	private String vehNo;//new -02 july 19
	private String billTime;//new -02 july 19
	private String exVarchar1;//new -02 july 19
	private String exVarchar2;//new -02 july 19
	
	
	@Transient
	Company company;

	
	
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

	public String getPartyGstin() {
		return partyGstin;
	}

	public void setPartyGstin(String partyGstin) {
		this.partyGstin = partyGstin;
	}

	public String getPartyAddress() {
		return partyAddress;
	}

	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
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

	public String getFrAddress() {
		return frAddress;
	}

	public void setFrAddress(String frAddress) {
		this.frAddress = frAddress;
	}

	public String getIsSameState() {
		return isSameState;
	}

	public void setIsSameState(String isSameState) {
		this.isSameState = isSameState;
	}

	@Override
	public String toString() {
		return "FrBillHeaderForPrint [billNo=" + billNo + ", frName=" + frName + ", taxApplicable=" + taxApplicable
				+ ", invoiceNo=" + invoiceNo + ", billDate=" + billDate + ", frId=" + frId + ", frCode=" + frCode
				+ ", grandTotal=" + grandTotal + ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax + ", status="
				+ status + ", DelStatus=" + DelStatus + ", remark=" + remark + ", frAddress=" + frAddress
				+ ", isSameState=" + isSameState + ", partyName=" + partyName + ", partyGstin=" + partyGstin
				+ ", partyAddress=" + partyAddress + ", vehNo=" + vehNo + ", billTime=" + billTime + ", exVarchar1="
				+ exVarchar1 + ", exVarchar2=" + exVarchar2 + ", company=" + company + "]";
	}

	
}

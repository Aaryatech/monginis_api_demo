package com.ats.webapi.model.ownerapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillHeaderDisplayForApp {

	@Id
	private int billNo;

	private String invoiceNo;
	private String billDate;
	private String billDateTime;
	private int frId;
	private String frCode;
	private int taxApplicable;
	private float taxableAmt;
	private float totalTax;
	private float grandTotal;
	private String remark;
	private int status;
	private int delStatus;
	private String time;
	private float discAmt;
	private int isTallySync;
	private float roundOff;
	private float sgstSum;
	private float cgstSum;
	private float igstSum;
	private String frName;
	private String frAddress;

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

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBillDateTime() {
		return billDateTime;
	}

	public void setBillDateTime(String billDateTime) {
		this.billDateTime = billDateTime;
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

	public int getTaxApplicable() {
		return taxApplicable;
	}

	public void setTaxApplicable(int taxApplicable) {
		this.taxApplicable = taxApplicable;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
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

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getFrAddress() {
		return frAddress;
	}

	public void setFrAddress(String frAddress) {
		this.frAddress = frAddress;
	}

	@Override
	public String toString() {
		return "BillHeaderDisplayForApp [billNo=" + billNo + ", invoiceNo=" + invoiceNo + ", billDate=" + billDate
				+ ", billDateTime=" + billDateTime + ", frId=" + frId + ", frCode=" + frCode + ", taxApplicable="
				+ taxApplicable + ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax + ", grandTotal=" + grandTotal
				+ ", remark=" + remark + ", status=" + status + ", delStatus=" + delStatus + ", time=" + time
				+ ", discAmt=" + discAmt + ", isTallySync=" + isTallySync + ", roundOff=" + roundOff + ", sgstSum="
				+ sgstSum + ", cgstSum=" + cgstSum + ", igstSum=" + igstSum + ", frName=" + frName + ", frAddress="
				+ frAddress + "]";
	}

}

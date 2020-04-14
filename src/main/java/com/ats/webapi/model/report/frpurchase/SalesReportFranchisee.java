package com.ats.webapi.model.report.frpurchase;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SalesReportFranchisee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;

	@Column(name = "bill_no")
	private int billNo;

	@Column(name = "type")
	private String type;

	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "fr_name")
	private String frName;

	@Column(name = "bill_date")
	private Date billDate;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "grand_total")
	private float grandTotal;

	@Column(name = "taxable_amt")
	private float taxableAmt;

	@Column(name = "total_tax")
	private float totalTax;

	@Column(name = "order_ref")
	private String orderRef;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
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

	public String getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	@Override
	public String toString() {
		return "SalesReportFranchisee [id=" + id + ", billNo=" + billNo + ", type=" + type + ", invoiceNo=" + invoiceNo
				+ ", frName=" + frName + ", billDate=" + billDate + ", frId=" + frId + ", grandTotal=" + grandTotal
				+ ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax + ", orderRef=" + orderRef + "]";
	}

}

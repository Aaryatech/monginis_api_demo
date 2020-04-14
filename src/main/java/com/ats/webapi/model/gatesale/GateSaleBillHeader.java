package com.ats.webapi.model.gatesale;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_gatesale_bill_header")
public class GateSaleBillHeader implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_id")
	private int billId;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="category")
	private int category;
	
	@Column(name="is_other")
	private int isOther;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="discount_per")
	private float discountPer;
	
	@Column(name="bill_amt")
	private float billAmt;
	
	@Column(name="discount_amt")
	private float discountAmt;
	
	@Column(name="round_off")
	private float roundOff;
	
	@Column(name="bill_grant_amt")
	private float billGrantAmt;
	
	@Column(name="is_approved")
	private int isApproved;
	
	@Column(name="approved_date")
	private Date approvedDate;
	
	@Column(name="approved_user_id")
	private int approvedUserId;
	
	@Column(name="amt_is_collected")
	private int amtIsCollected;
	
	@Column(name="collected_date")
	private Date collectedDate;
	
	@Column(name="collected_user_id")
	private int collectedUserId;
	
	@Column(name="is_bill_print")
	private int isBillPrint;
	
	@Column(name="initiator_user_id")
	private int initiatorUserId;
	
	@Column(name="del_status")
	private int delStatus;

	@Transient
	List<GateSaleBillDetail> gateSaleBillDetailList;
	
	public List<GateSaleBillDetail> getGateSaleBillDetailList() {
		return gateSaleBillDetailList;
	}

	public void setGateSaleBillDetailList(List<GateSaleBillDetail> gateSaleBillDetailList) {
		this.gateSaleBillDetailList = gateSaleBillDetailList;
	}
    
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getIsOther() {
		return isOther;
	}

	public void setIsOther(int isOther) {
		this.isOther = isOther;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public float getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(float discountPer) {
		this.discountPer = discountPer;
	}

	public float getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}

	public float getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(float discountAmt) {
		this.discountAmt = discountAmt;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public float getBillGrantAmt() {
		return billGrantAmt;
	}

	public void setBillGrantAmt(float billGrantAmt) {
		this.billGrantAmt = billGrantAmt;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getApprovedDate() {
		return approvedDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public int getApprovedUserId() {
		return approvedUserId;
	}

	public void setApprovedUserId(int approvedUserId) {
		this.approvedUserId = approvedUserId;
	}

	public int getAmtIsCollected() {
		return amtIsCollected;
	}

	public void setAmtIsCollected(int amtIsCollected) {
		this.amtIsCollected = amtIsCollected;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCollectedDate() {
		return collectedDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setCollectedDate(Date collectedDate) {
		this.collectedDate = collectedDate;
	}

	public int getCollectedUserId() {
		return collectedUserId;
	}

	public void setCollectedUserId(int collectedUserId) {
		this.collectedUserId = collectedUserId;
	}

	public int getIsBillPrint() {
		return isBillPrint;
	}

	public void setIsBillPrint(int isBillPrint) {
		this.isBillPrint = isBillPrint;
	}

	public int getInitiatorUserId() {
		return initiatorUserId;
	}

	public void setInitiatorUserId(int initiatorUserId) {
		this.initiatorUserId = initiatorUserId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GateSaleBillHeader [billId=" + billId + ", billDate=" + billDate + ", category=" + category
				+ ", isOther=" + isOther + ", invoiceNo=" + invoiceNo + ", custName=" + custName + ", empId=" + empId
				+ ", discountPer=" + discountPer + ", billAmt=" + billAmt + ", discountAmt=" + discountAmt
				+ ", roundOff=" + roundOff + ", billGrantAmt=" + billGrantAmt + ", isApproved=" + isApproved
				+ ", approvedDate=" + approvedDate + ", approvedUserId=" + approvedUserId + ", amtIsCollected="
				+ amtIsCollected + ", collectedDate=" + collectedDate + ", collectedUserId=" + collectedUserId
				+ ", isBillPrint=" + isBillPrint + ", initiatorUserId=" + initiatorUserId + ", delStatus=" + delStatus
				+ ", gateSaleBillDetailList=" + gateSaleBillDetailList + "]";
	}

	

}

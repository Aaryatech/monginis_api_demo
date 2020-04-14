package com.ats.webapi.model.grngvn;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class GetCreditNoteHeaders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crn_id")
	private int crnId;

	@Column(name = "crn_no")
	private String crnNo;

	@Column(name = "crn_date")
	private Date crnDate;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "crn_taxable_amt")
	private float crnTaxableAmt;

	@Column(name = "crn_total_tax")
	private float crnTotalTax;

	@Column(name = "crn_grand_total")
	private float crnGrandTotal;


	@Column(name = "round_off")
	private float roundOff;

	
	@Column(name = "created_date_time")
	private String createdDateTime;

	@Column(name = "is_tally_sync")
	private int isTallySync;
	
	
	@Column(name = "is_deposited")
	int isDeposited; 

	@Column(name = "fr_name")
	private String frName;

	@Column(name = "fr_address")
	private String frAddress;
	
	
	
	@Column(name = "fr_gst_no")
	private String frGstNo;
	
	@Column(name = "is_same_state")
	private int isSameState;

	@Column(name = "is_grn")
	private int isGrn;

	int exInt1;//new for pune billno of bill to show headers
	
	String exVarchar1;//new for pune  invno of bill to show headers
	
	@Column(name = "grn_gvn_sr_no_list")
	private String grnGvnSrNoList;
	
	
	
	
	public String getGrnGvnSrNoList() {
		return grnGvnSrNoList;
	}


	public void setGrnGvnSrNoList(String grnGvnSrNoList) {
		this.grnGvnSrNoList = grnGvnSrNoList;
	}


	public int getExInt1() {
		return exInt1;
	}


	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}


	public String getExVarchar1() {
		return exVarchar1;
	}


	public void setExVarchar1(String exVarchar1) {
		this.exVarchar1 = exVarchar1;
	}


	public int getCrnId() {
		return crnId;
	}


	public void setCrnId(int crnId) {
		this.crnId = crnId;
	}


	public String getCrnNo() {
		return crnNo;
	}


	public void setCrnNo(String crnNo) {
		this.crnNo = crnNo;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCrnDate() {
		return crnDate;
	}


	public void setCrnDate(Date crnDate) {
		this.crnDate = crnDate;
	}


	public int getFrId() {
		return frId;
	}


	public void setFrId(int frId) {
		this.frId = frId;
	}


	public float getCrnTaxableAmt() {
		return crnTaxableAmt;
	}


	public void setCrnTaxableAmt(float crnTaxableAmt) {
		this.crnTaxableAmt = crnTaxableAmt;
	}


	public float getCrnTotalTax() {
		return crnTotalTax;
	}


	public void setCrnTotalTax(float crnTotalTax) {
		this.crnTotalTax = crnTotalTax;
	}


	public float getCrnGrandTotal() {
		return crnGrandTotal;
	}


	public void setCrnGrandTotal(float crnGrandTotal) {
		this.crnGrandTotal = crnGrandTotal;
	}


	public float getRoundOff() {
		return roundOff;
	}


	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}


	public String getCreatedDateTime() {
		return createdDateTime;
	}


	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}


	public int getIsTallySync() {
		return isTallySync;
	}


	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}


	public String getFrName() {
		return frName;
	}


	public void setFrName(String frName) {
		this.frName = frName;
	}


	public int getIsDeposited() {
		return isDeposited;
	}


	public void setIsDeposited(int isDeposited) {
		this.isDeposited = isDeposited;
	}


	public String getFrAddress() {
		return frAddress;
	}


	public void setFrAddress(String frAddress) {
		this.frAddress = frAddress;
	}


	public String getFrGstNo() {
		return frGstNo;
	}


	public void setFrGstNo(String frGstNo) {
		this.frGstNo = frGstNo;
	}


	public int getIsSameState() {
		return isSameState;
	}


	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}


	public int getIsGrn() {
		return isGrn;
	}


	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}


	@Override
	public String toString() {
		return "GetCreditNoteHeaders [crnId=" + crnId + ", crnNo=" + crnNo + ", crnDate=" + crnDate + ", frId=" + frId
				+ ", crnTaxableAmt=" + crnTaxableAmt + ", crnTotalTax=" + crnTotalTax + ", crnGrandTotal="
				+ crnGrandTotal + ", roundOff=" + roundOff + ", createdDateTime=" + createdDateTime + ", isTallySync="
				+ isTallySync + ", isDeposited=" + isDeposited + ", frName=" + frName + ", frAddress=" + frAddress
				+ ", frGstNo=" + frGstNo + ", isSameState=" + isSameState + ", isGrn=" + isGrn + ", exInt1=" + exInt1
				+ ", exVarchar1=" + exVarchar1 + ", grnGvnSrNoList=" + grnGvnSrNoList + "]";
	}

    
}

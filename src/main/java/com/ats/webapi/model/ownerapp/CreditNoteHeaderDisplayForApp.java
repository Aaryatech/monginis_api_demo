package com.ats.webapi.model.ownerapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditNoteHeaderDisplayForApp {

	@Id
	private int crnId;
	private String crnDate;
	private int frId;
	private float crnTaxableAmt;
	private float crnTotalTax;
	private float crnGrandTotal;
	private float crnFinalAmt;
	private float roundOff;
	private int userId;
	private String createdDateTime;
	private int isTallySync;
	private Integer exInt2;
	private Integer exInt3;
	private Integer exInt1;
	private Float exFloat1;
	private Float exFloat2;
	private String exVarchar1;
	private String exVarchar2;
	private Integer exBoolen1;
	private Integer exBoolen2;
	private String crnNo;
	private String grnGvnSrNoList;
	private int isDeposited;
	private int isGrn;

	private String frName;

	public int getCrnId() {
		return crnId;
	}

	public void setCrnId(int crnId) {
		this.crnId = crnId;
	}

	public String getCrnDate() {
		return crnDate;
	}

	public void setCrnDate(String crnDate) {
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

	public float getCrnFinalAmt() {
		return crnFinalAmt;
	}

	public void setCrnFinalAmt(float crnFinalAmt) {
		this.crnFinalAmt = crnFinalAmt;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Integer getExInt2() {
		return exInt2;
	}

	public void setExInt2(Integer exInt2) {
		this.exInt2 = exInt2;
	}

	public Integer getExInt3() {
		return exInt3;
	}

	public void setExInt3(Integer exInt3) {
		this.exInt3 = exInt3;
	}

	public Integer getExInt1() {
		return exInt1;
	}

	public void setExInt1(Integer exInt1) {
		this.exInt1 = exInt1;
	}

	public Float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(Float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public Float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(Float exFloat2) {
		this.exFloat2 = exFloat2;
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

	public Integer getExBoolen1() {
		return exBoolen1;
	}

	public void setExBoolen1(Integer exBoolen1) {
		this.exBoolen1 = exBoolen1;
	}

	public Integer getExBoolen2() {
		return exBoolen2;
	}

	public void setExBoolen2(Integer exBoolen2) {
		this.exBoolen2 = exBoolen2;
	}

	public String getCrnNo() {
		return crnNo;
	}

	public void setCrnNo(String crnNo) {
		this.crnNo = crnNo;
	}

	public String getGrnGvnSrNoList() {
		return grnGvnSrNoList;
	}

	public void setGrnGvnSrNoList(String grnGvnSrNoList) {
		this.grnGvnSrNoList = grnGvnSrNoList;
	}

	public int getIsDeposited() {
		return isDeposited;
	}

	public void setIsDeposited(int isDeposited) {
		this.isDeposited = isDeposited;
	}

	public int getIsGrn() {
		return isGrn;
	}

	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	@Override
	public String toString() {
		return "CreditNoteHeaderDisplayForApp [crnId=" + crnId + ", crnDate=" + crnDate + ", frId=" + frId
				+ ", crnTaxableAmt=" + crnTaxableAmt + ", crnTotalTax=" + crnTotalTax + ", crnGrandTotal="
				+ crnGrandTotal + ", crnFinalAmt=" + crnFinalAmt + ", roundOff=" + roundOff + ", userId=" + userId
				+ ", createdDateTime=" + createdDateTime + ", isTallySync=" + isTallySync + ", exInt2=" + exInt2
				+ ", exInt3=" + exInt3 + ", exInt1=" + exInt1 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2
				+ ", exVarchar1=" + exVarchar1 + ", exVarchar2=" + exVarchar2 + ", exBoolen1=" + exBoolen1
				+ ", exBoolen2=" + exBoolen2 + ", crnNo=" + crnNo + ", grnGvnSrNoList=" + grnGvnSrNoList
				+ ", isDeposited=" + isDeposited + ", isGrn=" + isGrn + ", frName=" + frName + "]";
	}

}

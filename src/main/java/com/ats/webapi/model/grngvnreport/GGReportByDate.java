package com.ats.webapi.model.grngvnreport;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GGReportByDate {
	
	@Id
	private int grnGvnHeaderId;

	private String grngvnSrno;

	private Date grngvnDate;

	private int frId;

	private String frName;

	private int reqQty; 
	 
	private float totalAmt;
	
	private int aprQty;
	
	private int isGrn;
	
	
	private float aprGrandTotal;


	public int getGrnGvnHeaderId() {
		return grnGvnHeaderId;
	}


	public void setGrnGvnHeaderId(int grnGvnHeaderId) {
		this.grnGvnHeaderId = grnGvnHeaderId;
	}


	public String getGrngvnSrno() {
		return grngvnSrno;
	}


	public void setGrngvnSrno(String grngvnSrno) {
		this.grngvnSrno = grngvnSrno;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public Date getGrngvnDate() {
		return grngvnDate;
	}


	public void setGrngvnDate(Date grngvnDate) {
		this.grngvnDate = grngvnDate;
	}


	public int getFrId() {
		return frId;
	}


	public void setFrId(int frId) {
		this.frId = frId;
	}


	public String getFrName() {
		return frName;
	}


	public void setFrName(String frName) {
		this.frName = frName;
	}


	public int getReqQty() {
		return reqQty;
	}


	public void setReqQty(int reqQty) {
		this.reqQty = reqQty;
	}


	public float getTotalAmt() {
		return totalAmt;
	}


	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}


	public int getAprQty() {
		return aprQty;
	}


	public void setAprQty(int aprQty) {
		this.aprQty = aprQty;
	}


	public int getIsGrn() {
		return isGrn;
	}


	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}


	public float getAprGrandTotal() {
		return aprGrandTotal;
	}


	public void setAprGrandTotal(float aprGrandTotal) {
		this.aprGrandTotal = aprGrandTotal;
	}


	@Override
	public String toString() {
		return "GGReportByDate [grnGvnHeaderId=" + grnGvnHeaderId + ", grngvnSrno=" + grngvnSrno + ", grngvnDate="
				+ grngvnDate + ", frId=" + frId + ", frName=" + frName + ", reqQty=" + reqQty + ", totalAmt=" + totalAmt
				+ ", aprQty=" + aprQty + ", isGrn=" + isGrn + ", aprGrandTotal=" + aprGrandTotal + "]";
	}
	
	

}

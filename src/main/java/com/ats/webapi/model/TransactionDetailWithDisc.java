package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TransactionDetailWithDisc {

	@Id
	private int trId;
	private int sellBillNo;
	private Date transactionDate;
	private int payMode;
	private float cashAmt;
	private float cardAmt;
	private int ePayType;
	private float ePayAmt;
	private int discType;
	private int delStatus;
	private int exInt1;
	private int exInt2;
	private float exFloat1;
	private float exFloat2;
	private String exVar1;
	private String exVar2;
	private float discAmt;
	private float discPer;
	
	private String remark;
	

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public int getSellBillNo() {
		return sellBillNo;
	}

	public void setSellBillNo(int sellBillNo) {
		this.sellBillNo = sellBillNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getPayMode() {
		return payMode;
	}

	public void setPayMode(int payMode) {
		this.payMode = payMode;
	}

	public float getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(float cashAmt) {
		this.cashAmt = cashAmt;
	}

	public float getCardAmt() {
		return cardAmt;
	}

	public void setCardAmt(float cardAmt) {
		this.cardAmt = cardAmt;
	}

	public int getePayType() {
		return ePayType;
	}

	public void setePayType(int ePayType) {
		this.ePayType = ePayType;
	}

	public float getePayAmt() {
		return ePayAmt;
	}

	public void setePayAmt(float ePayAmt) {
		this.ePayAmt = ePayAmt;
	}

	public int getDiscType() {
		return discType;
	}

	public void setDiscType(int discType) {
		this.discType = discType;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}
	
	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	@Override
	public String toString() {
		return "TransactionDetailWithDisc [trId=" + trId + ", sellBillNo=" + sellBillNo + ", transactionDate="
				+ transactionDate + ", payMode=" + payMode + ", cashAmt=" + cashAmt + ", cardAmt=" + cardAmt
				+ ", ePayType=" + ePayType + ", ePayAmt=" + ePayAmt + ", discType=" + discType + ", delStatus="
				+ delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exFloat1=" + exFloat1 + ", exFloat2="
				+ exFloat2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", discAmt=" + discAmt + ", discPer="
				+ discPer + ", remark=" + remark + "]";
	}

}

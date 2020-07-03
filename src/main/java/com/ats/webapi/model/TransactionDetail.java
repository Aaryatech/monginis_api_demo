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

@Entity
@Table(name = "t_transaction_detail")
public class TransactionDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tr_id")
	private int trId;

	@Column(name = "sell_bill_no")
	private int sellBillNo;

	@Column(name = "transaction_date")
	private Date transactionDate;

	@Column(name = "pay_mode")
	private int payMode;

	@Column(name = "cash_amt")
	private float cashAmt;

	@Column(name = "card_amt")
	private float cardAmt;

	@Column(name = "e_pay_type")
	private int ePayType;

	@Column(name = "e_pay_amt")
	private float ePayAmt;

	@Column(name = "disc_type")
	private int discType;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_float1")
	private float exFloat1;

	@Column(name = "ex_float2")
	private float exFloat2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

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

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TransactionDetail [trId=" + trId + ", sellBillNo=" + sellBillNo + ", transactionDate=" + transactionDate
				+ ", payMode=" + payMode + ", cashAmt=" + cashAmt + ", cardAmt=" + cardAmt + ", ePayType=" + ePayType
				+ ", ePayAmt=" + ePayAmt + ", discType=" + discType + ", delStatus=" + delStatus + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", remark=" + remark + "]";
	}
}

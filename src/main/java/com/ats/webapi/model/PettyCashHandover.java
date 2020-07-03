package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_fr_pettycash_handover")
public class PettyCashHandover implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cash_handover_id")
	private int cashHandoverId;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="from_user_id")
	private int fromUserId; 
	
	@Column(name="from_username")
	private String fromUsername;
	
	@Column(name="to_user_id")
	private int toUserId;
	
	@Column(name="to_username")
	private String toUsername;
	
	@Column(name="amt_handover")
	private float amtHandover;
	
	@Column(name="actual_amt_handover")
	private float actualAmtHandover;
	
	@Column(name="opening_amt")
	private float openingAmt;
	
	@Column(name="selling_amt")
	private float sellingAmt;
	
	@Column(name="transaction_date")
	private String transactionDate;
	
	@Column(name="closing_date")
	private String closingDate;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="update_datetime")
	private String updateDatetime;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_int3")
	private int exInt3;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	@Column(name="ex_var3")
	private String exVar3;
	
	public int getCashHandoverId() {
		return cashHandoverId;
	}
	public void setCashHandoverId(int cashHandoverId) {
		this.cashHandoverId = cashHandoverId;
	}
	
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public int getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}
	public String getFromUsername() {
		return fromUsername;
	}
	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
	}
	public int getToUserId() {
		return toUserId;
	}
	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}
	public String getToUsername() {
		return toUsername;
	}
	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}
	public float getAmtHandover() {
		return amtHandover;
	}
	public void setAmtHandover(float amtHandover) {
		this.amtHandover = amtHandover;
	}
	public float getActualAmtHandover() {
		return actualAmtHandover;
	}
	public void setActualAmtHandover(float actualAmtHandover) {
		this.actualAmtHandover = actualAmtHandover;
	}	
	public float getOpeningAmt() {
		return openingAmt;
	}
	public void setOpeningAmt(float openingAmt) {
		this.openingAmt = openingAmt;
	}
	public float getSellingAmt() {
		return sellingAmt;
	}
	public void setSellingAmt(float sellingAmt) {
		this.sellingAmt = sellingAmt;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public String getUpdateDatetime() {
		return updateDatetime;
	}
	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
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
	public int getExInt3() {
		return exInt3;
	}
	public void setExInt3(int exInt3) {
		this.exInt3 = exInt3;
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
	public String getExVar3() {
		return exVar3;
	}
	public void setExVar3(String exVar3) {
		this.exVar3 = exVar3;
	}
	@Override
	public String toString() {
		return "PettyCashHandover [cashHandoverId=" + cashHandoverId + ", frId=" + frId + ", fromUserId=" + fromUserId
				+ ", fromUsername=" + fromUsername + ", toUserId=" + toUserId + ", toUsername=" + toUsername
				+ ", amtHandover=" + amtHandover + ", actualAmtHandover=" + actualAmtHandover + ", openingAmt="
				+ openingAmt + ", sellingAmt=" + sellingAmt + ", transactionDate=" + transactionDate + ", closingDate="
				+ closingDate + ", delStatus=" + delStatus + ", updateDatetime=" + updateDatetime + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
				+ ", exVar3=" + exVar3 + "]";
	}
	
}

package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DashboardData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fr_id")
	private int frId;

	@Column(name = "total_sell")
	private float totalSell;

	@Column(name = "sp_cake_total_bill")
	private float spCakeTotalBill;

	@Column(name = "sp_cake_total_book")
	private float spCakeTotalBook;

	@Column(name = "sp_cake_grand_total_book")
	private float spCakeGrandTotalBook;

	@Column(name = "cash_amt")
	private float cashAmt;

	@Column(name = "card_amt")
	private float cardAmt;

	@Column(name = "grn_req_amt")
	private float grnReqAmt;

	@Column(name = "grn_req_ammt")
	private float grnReqAmmt;

	@Column(name = "grn_apr_amt")
	private float grnAprAmt;

	@Column(name = "grn_apr_ammt")
	private float grnAprAmmt;

	@Column(name = "purchase_bill")
	private float purchaseBill;

	@Column(name = "credit_note")
	private float creditNote;

	@Column(name = "target")
	private float target;
	
	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public float getTotalSell() {
		return totalSell;
	}

	public void setTotalSell(float totalSell) {
		this.totalSell = totalSell;
	}

	public float getSpCakeTotalBill() {
		return spCakeTotalBill;
	}

	public void setSpCakeTotalBill(float spCakeTotalBill) {
		this.spCakeTotalBill = spCakeTotalBill;
	}

	public float getSpCakeTotalBook() {
		return spCakeTotalBook;
	}

	public void setSpCakeTotalBook(float spCakeTotalBook) {
		this.spCakeTotalBook = spCakeTotalBook;
	}

	public float getSpCakeGrandTotalBook() {
		return spCakeGrandTotalBook;
	}

	public void setSpCakeGrandTotalBook(float spCakeGrandTotalBook) {
		this.spCakeGrandTotalBook = spCakeGrandTotalBook;
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

	public float getGrnReqAmt() {
		return grnReqAmt;
	}

	public void setGrnReqAmt(float grnReqAmt) {
		this.grnReqAmt = grnReqAmt;
	}

	public float getGrnReqAmmt() {
		return grnReqAmmt;
	}

	public void setGrnReqAmmt(float grnReqAmmt) {
		this.grnReqAmmt = grnReqAmmt;
	}

	public float getGrnAprAmt() {
		return grnAprAmt;
	}

	public void setGrnAprAmt(float grnAprAmt) {
		this.grnAprAmt = grnAprAmt;
	}

	public float getGrnAprAmmt() {
		return grnAprAmmt;
	}

	public void setGrnAprAmmt(float grnAprAmmt) {
		this.grnAprAmmt = grnAprAmmt;
	}

	public float getPurchaseBill() {
		return purchaseBill;
	}

	public void setPurchaseBill(float purchaseBill) {
		this.purchaseBill = purchaseBill;
	}

	public float getCreditNote() {
		return creditNote;
	}

	public void setCreditNote(float creditNote) {
		this.creditNote = creditNote;
	}

	public float getTarget() {
		return target;
	}

	public void setTarget(float target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "DashboardData [frId=" + frId + ", totalSell=" + totalSell + ", spCakeTotalBill=" + spCakeTotalBill
				+ ", spCakeTotalBook=" + spCakeTotalBook + ", spCakeGrandTotalBook=" + spCakeGrandTotalBook
				+ ", cashAmt=" + cashAmt + ", cardAmt=" + cardAmt + ", grnReqAmt=" + grnReqAmt + ", grnReqAmmt="
				+ grnReqAmmt + ", grnAprAmt=" + grnAprAmt + ", grnAprAmmt=" + grnAprAmmt + ", purchaseBill="
				+ purchaseBill + ", creditNote=" + creditNote + ", target=" + target + "]";
	}
	
	
}

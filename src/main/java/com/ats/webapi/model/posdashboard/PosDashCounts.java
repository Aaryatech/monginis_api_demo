package com.ats.webapi.model.posdashboard;

import java.util.List;

 
public class PosDashCounts {

	private float saleAmt;

	private float purchaseAmt;

	private float discountAmt;

	private float creditAmt;

	private float expenseAmt;

	private float advanceAmt;

	private float profitAmt;

	private float cashAmt;

	private float cardAmt;

	private float epayAmt;

	private float noOfBillGenerated;

	List<DashAdvanceOrderCounts> dailyMartList;

	List<DashAdvanceOrderCounts> advOrderList;

	public List<DashAdvanceOrderCounts> getDailyMartList() {
		return dailyMartList;
	}

	public void setDailyMartList(List<DashAdvanceOrderCounts> dailyMartList) {
		this.dailyMartList = dailyMartList;
	}

	public List<DashAdvanceOrderCounts> getAdvOrderList() {
		return advOrderList;
	}

	public void setAdvOrderList(List<DashAdvanceOrderCounts> advOrderList) {
		this.advOrderList = advOrderList;
	}

	public float getSaleAmt() {
		return saleAmt;
	}

	public void setSaleAmt(float saleAmt) {
		this.saleAmt = saleAmt;
	}

	public float getPurchaseAmt() {
		return purchaseAmt;
	}

	public void setPurchaseAmt(float purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}

	public float getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(float discountAmt) {
		this.discountAmt = discountAmt;
	}

	public float getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(float creditAmt) {
		this.creditAmt = creditAmt;
	}

	public float getExpenseAmt() {
		return expenseAmt;
	}

	public void setExpenseAmt(float expenseAmt) {
		this.expenseAmt = expenseAmt;
	}

	public float getAdvanceAmt() {
		return advanceAmt;
	}

	public void setAdvanceAmt(float advanceAmt) {
		this.advanceAmt = advanceAmt;
	}

	public float getProfitAmt() {
		return profitAmt;
	}

	public void setProfitAmt(float profitAmt) {
		this.profitAmt = profitAmt;
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

	public float getEpayAmt() {
		return epayAmt;
	}

	public void setEpayAmt(float epayAmt) {
		this.epayAmt = epayAmt;
	}

	public float getNoOfBillGenerated() {
		return noOfBillGenerated;
	}

	public void setNoOfBillGenerated(float noOfBillGenerated) {
		this.noOfBillGenerated = noOfBillGenerated;
	}

	@Override
	public String toString() {
		return "PosDashCounts [saleAmt=" + saleAmt + ", purchaseAmt=" + purchaseAmt + ", discountAmt=" + discountAmt
				+ ", creditAmt=" + creditAmt + ", expenseAmt=" + expenseAmt + ", advanceAmt=" + advanceAmt
				+ ", profitAmt=" + profitAmt + ", cashAmt=" + cashAmt + ", cardAmt=" + cardAmt + ", epayAmt=" + epayAmt
				+ ", noOfBillGenerated=" + noOfBillGenerated + "]";
	}

}

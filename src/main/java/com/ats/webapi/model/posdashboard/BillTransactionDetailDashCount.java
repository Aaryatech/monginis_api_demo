package com.ats.webapi.model.posdashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillTransactionDetailDashCount {
	
	@Id
 	private String uid;
	
	private String cashAmt;
	
	
	private String cardAmt;
	
	private String ePayAmt;
 
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
 
	public String getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(String cashAmt) {
		this.cashAmt = cashAmt;
	}

	public String getCardAmt() {
		return cardAmt;
	}

	public void setCardAmt(String cardAmt) {
		this.cardAmt = cardAmt;
	}

	public String getePayAmt() {
		return ePayAmt;
	}

	public void setePayAmt(String ePayAmt) {
		this.ePayAmt = ePayAmt;
	}

	@Override
	public String toString() {
		return "BillTransactionDetailDashCount [uid=" + uid + ", cashAmt=" + cashAmt + ", cardAmt=" + cardAmt
				+ ", ePayAmt=" + ePayAmt + "]";
	}

	 

}

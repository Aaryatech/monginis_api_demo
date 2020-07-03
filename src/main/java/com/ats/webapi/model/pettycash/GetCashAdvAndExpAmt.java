package com.ats.webapi.model.pettycash;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetCashAdvAndExpAmt {

	@Id
	private String id;
	private float trCashAmt;
	private float advAmt;
	private float expAmt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getTrCashAmt() {
		return trCashAmt;
	}

	public void setTrCashAmt(float trCashAmt) {
		this.trCashAmt = trCashAmt;
	}

	public float getAdvAmt() {
		return advAmt;
	}

	public void setAdvAmt(float advAmt) {
		this.advAmt = advAmt;
	}

	public float getExpAmt() {
		return expAmt;
	}

	public void setExpAmt(float expAmt) {
		this.expAmt = expAmt;
	}

	@Override
	public String toString() {
		return "GetCashAdvAndExpAmt [id=" + id + ", trCashAmt=" + trCashAmt + ", advAmt=" + advAmt + ", expAmt="
				+ expAmt + "]";
	}

}

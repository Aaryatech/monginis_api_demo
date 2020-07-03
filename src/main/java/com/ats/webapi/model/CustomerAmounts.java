package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerAmounts {

	
	@Id
	private int custId;
	
	private String creaditAmt;
	
	private String advanceAmt;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCreaditAmt() {
		return creaditAmt;
	}

	public void setCreaditAmt(String creaditAmt) {
		this.creaditAmt = creaditAmt;
	}

	public String getAdvanceAmt() {
		return advanceAmt;
	}

	public void setAdvanceAmt(String advanceAmt) {
		this.advanceAmt = advanceAmt;
	}

	@Override
	public String toString() {
		return "CustomerAmounts [custId=" + custId + ", creaditAmt=" + creaditAmt + ", advanceAmt=" + advanceAmt + "]";
	}

	 

	 
	 
	
	
	
	
}

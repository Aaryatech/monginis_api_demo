package com.ats.webapi.model.posdashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class SellBillHeaderDashCounts {
	
	@Id
 	private String uid;
	
	private float  sellAmt;
	
	private float discAmt;
	
	private float noBillGen;		
	
	private float advanceAmt;
	
	private float  creditAmt;
	
	private float profitAmt;

 
	 
	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	public float getSellAmt() {
		return sellAmt;
	}



	public void setSellAmt(float sellAmt) {
		this.sellAmt = sellAmt;
	}



	public float getDiscAmt() {
		return discAmt;
	}



	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}



	public float getNoBillGen() {
		return noBillGen;
	}



	public void setNoBillGen(float noBillGen) {
		this.noBillGen = noBillGen;
	}



	public float getAdvanceAmt() {
		return advanceAmt;
	}



	public void setAdvanceAmt(float advanceAmt) {
		this.advanceAmt = advanceAmt;
	}



	public float getCreditAmt() {
		return creditAmt;
	}



	public void setCreditAmt(float creditAmt) {
		this.creditAmt = creditAmt;
	}



	public float getProfitAmt() {
		return profitAmt;
	}



	public void setProfitAmt(float profitAmt) {
		this.profitAmt = profitAmt;
	}



	@Override
	public String toString() {
		return "SellBillHeaderDashCounts [uid=" + uid + ", sellAmt=" + sellAmt + ", discAmt=" + discAmt + ", noBillGen="
				+ noBillGen + ", advanceAmt=" + advanceAmt + ", creditAmt=" + creditAmt + ", profitAmt=" + profitAmt
				+ "]";
	}

	 
	 
}

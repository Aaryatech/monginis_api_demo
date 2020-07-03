package com.ats.webapi.model.posdashboard;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CreaditAmtDash {

	
	
	@Id
 	private String uid;
	 
	
	private String  creditAmt;


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getCreditAmt() {
		return creditAmt;
	}


	public void setCreditAmt(String creditAmt) {
		this.creditAmt = creditAmt;
	}


	@Override
	public String toString() {
		return "CreaditAmtDash [uid=" + uid + ", creditAmt=" + creditAmt + ", getUid()=" + getUid()
				+ ", getCreditAmt()=" + getCreditAmt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}

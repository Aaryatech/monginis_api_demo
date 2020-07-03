package com.ats.webapi.model.posdashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillHeaderDashCount {
	
	
	@Id
	private String uid;
	
	private String chAmt;
	
	private String purchaeAmt;

	public String getUid() {
		return uid;
	}
 
 

	public String getChAmt() {
		return chAmt;
	}



	public void setChAmt(String chAmt) {
		this.chAmt = chAmt;
	}



	public String getPurchaeAmt() {
		return purchaeAmt;
	}



	public void setPurchaeAmt(String purchaeAmt) {
		this.purchaeAmt = purchaeAmt;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}


	@Override
	public String toString() {
		return "BillHeaderDashCount [uid=" + uid + ", chAmt=" + chAmt + ", purchaeAmt=" + purchaeAmt + "]";
	}
 
	

}

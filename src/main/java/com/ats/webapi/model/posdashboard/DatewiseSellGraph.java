package com.ats.webapi.model.posdashboard;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DatewiseSellGraph {
	
	@Id
    private String uid;
	
	private Date sellDate;
	
	
	private String  sellAmount;


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public Date getSellDate() {
		return sellDate;
	}


	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}


	public String getSellAmount() {
		return sellAmount;
	}


	public void setSellAmount(String sellAmount) {
		this.sellAmount = sellAmount;
	}


	@Override
	public String toString() {
		return "DatewiseSellGraph [uid=" + uid + ", sellDate=" + sellDate + ", sellAmount=" + sellAmount + "]";
	}
	
	
	

}

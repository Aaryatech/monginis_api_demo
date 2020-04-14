package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_bill_header")
public class UpdatePBDateTime implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_no")
	private int billNo;
	
	 
	@Column(name="time")
	private String time;


	public int getBillNo() {
		return billNo;
	}


	public String getTime() {
		return time;
	}


	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "UpdatePBDateTime [billNo=" + billNo + ", time=" + time + "]";
	}

	
	
}

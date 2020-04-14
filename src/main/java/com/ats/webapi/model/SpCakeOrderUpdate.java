package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_sp_cake") 
public class SpCakeOrderUpdate implements Serializable{

	@Id
	@Column(name="sp_order_no")
	private int spOrderNo;
	
	@Column(name="sp_booked_for_name")
	private String spBookedForName;
	
	@Column(name="is_allocated")
	private int isAllocated;

	public int getSpOrderNo() {
		return spOrderNo;
	}

	public void setSpOrderNo(int spOrderNo) {
		this.spOrderNo = spOrderNo;
	}

	public String getSpBookedForName() {
		return spBookedForName;
	}

	public void setSpBookedForName(String spBookedForName) {
		this.spBookedForName = spBookedForName;
	}

	public int getIsAllocated() {
		return isAllocated;
	}

	public void setIsAllocated(int isAllocated) {
		this.isAllocated = isAllocated;
	}

	@Override
	public String toString() {
		return "SpCakeOrderUpdate [spOrderNo=" + spOrderNo + ", spBookedForName=" + spBookedForName + ", isAllocated="
				+ isAllocated + "]";
	}
	
	
}

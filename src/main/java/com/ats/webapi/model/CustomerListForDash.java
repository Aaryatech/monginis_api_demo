package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerListForDash {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;

	@Column(name = "sp_cust_name")
	private String spCustName;

	@Column(name = "sp_cust_mob_no")
	private String spCustMobNo;

	@Column(name = "sp_grand_total")
	private float spGrandTotal;

	@Column(name = "sp_book_for_mob_no")
	private String spBookForMobNo;
	
	@Column(name = "sp_selected_weight")
	private float spSelectedWeight;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSpCustName() {
		return spCustName;
	}

	public void setSpCustName(String spCustName) {
		this.spCustName = spCustName;
	}

	public String getSpCustMobNo() {
		return spCustMobNo;
	}

	public void setSpCustMobNo(String spCustMobNo) {
		this.spCustMobNo = spCustMobNo;
	}

	public float getSpGrandTotal() {
		return spGrandTotal;
	}

	public void setSpGrandTotal(float spGrandTotal) {
		this.spGrandTotal = spGrandTotal;
	}

	public String getSpBookForMobNo() {
		return spBookForMobNo;
	}

	public void setSpBookForMobNo(String spBookForMobNo) {
		this.spBookForMobNo = spBookForMobNo;
	}

	public float getSpSelectedWeight() {
		return spSelectedWeight;
	}

	public void setSpSelectedWeight(float spSelectedWeight) {
		this.spSelectedWeight = spSelectedWeight;
	}

	@Override
	public String toString() {
		return "CustomerListForDash [id=" + id + ", spCustName=" + spCustName + ", spCustMobNo=" + spCustMobNo
				+ ", spGrandTotal=" + spGrandTotal + ", spBookForMobNo=" + spBookForMobNo + ", spSelectedWeight="
				+ spSelectedWeight + "]";
	}
	
	

}

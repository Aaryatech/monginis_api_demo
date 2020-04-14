package com.ats.webapi.model.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetRepMenuwiseSell {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_detail_no")
		private int sellBillNo;
	
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_name")
	private String frName;
	
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	private int qty;
	
	private float amount;

	public int getSellBillNo() {
		return sellBillNo;
	}

	public void setSellBillNo(int sellBillNo) {
		this.sellBillNo = sellBillNo;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "GetRepMenuwiseSell [sellBillNo=" + sellBillNo + ", frId=" + frId + ", frName=" + frName + ", catId="
				+ catId + ", catName=" + catName + ", qty=" + qty + ", amount=" + amount + "]";
	}
	
	 
}

package com.ats.webapi.model.dailysales;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpDailySales { 
	
	@Id
	private int id;
	
	private float qty;
	
	private float rate;
	
	private float mrp;
	
	private float advance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public float getAdvance() {
		return advance;
	}

	public void setAdvance(float advance) {
		this.advance = advance;
	}

	@Override
	public String toString() {
		return "SpDailySales [id=" + id + ", qty=" + qty + ", rate=" + rate + ", mrp=" + mrp + ", advance=" + advance
				+ "]";
	}
	
}

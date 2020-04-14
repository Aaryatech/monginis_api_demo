package com.ats.webapi.model.pettycash;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpCakeAdv {
	@Id
	 private int id;
	 private float mrp;
	 private float advance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "SpCakeAdv [id=" + id + ", mrp=" + mrp + ", advance=" + advance + "]";
	}
	 
}

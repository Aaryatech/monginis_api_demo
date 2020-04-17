package com.ats.webapi.model.saledashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CatWiseSaleTotal {

	@Id
	private int catId;
	private String catName;
	private float total;

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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "CatWiseSaleTotal [catId=" + catId + ", catName=" + catName + ", total=" + total + "]";
	}

}

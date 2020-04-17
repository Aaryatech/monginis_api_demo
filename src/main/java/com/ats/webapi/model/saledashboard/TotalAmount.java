package com.ats.webapi.model.saledashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TotalAmount {

	@Id
	private int id;

	private float totalSale;
	private float totalCrn;
	private float netTotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(float totalSale) {
		this.totalSale = totalSale;
	}

	public float getTotalCrn() {
		return totalCrn;
	}

	public void setTotalCrn(float totalCrn) {
		this.totalCrn = totalCrn;
	}

	public float getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(float netTotal) {
		this.netTotal = netTotal;
	}

	@Override
	public String toString() {
		return "TotalAmount [id=" + id + ", totalSale=" + totalSale + ", totalCrn=" + totalCrn + ", netTotal="
				+ netTotal + "]";
	}

}

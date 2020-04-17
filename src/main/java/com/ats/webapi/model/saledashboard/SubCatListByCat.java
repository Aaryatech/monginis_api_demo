package com.ats.webapi.model.saledashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCatListByCat {

	@Id
	private int subCatId;
	private int catId;
	private String subCatName;
	private float sale;
	private float crn;
	private float net;

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public float getSale() {
		return sale;
	}

	public void setSale(float sale) {
		this.sale = sale;
	}

	public float getCrn() {
		return crn;
	}

	public void setCrn(float crn) {
		this.crn = crn;
	}

	public float getNet() {
		return net;
	}

	public void setNet(float net) {
		this.net = net;
	}

	@Override
	public String toString() {
		return "SubCatListByCat [subCatId=" + subCatId + ", catId=" + catId + ", subCatName=" + subCatName + ", sale="
				+ sale + ", crn=" + crn + ", net=" + net + "]";
	}

}

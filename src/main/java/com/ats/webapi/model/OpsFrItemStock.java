package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OpsFrItemStock {

	@Id
	private int id;
	private String itemName;
	private int catId;
	private int subCatId;

	private float opening;
	private float purchase;
	private float crn;
	private float grngvn;
	private float sale;
	private float currentStock;
	private float reorder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public float getOpening() {
		return opening;
	}

	public void setOpening(float opening) {
		this.opening = opening;
	}

	public float getPurchase() {
		return purchase;
	}

	public void setPurchase(float purchase) {
		this.purchase = purchase;
	}

	public float getCrn() {
		return crn;
	}

	public void setCrn(float crn) {
		this.crn = crn;
	}

	public float getGrngvn() {
		return grngvn;
	}

	public void setGrngvn(float grngvn) {
		this.grngvn = grngvn;
	}

	public float getSale() {
		return sale;
	}

	public void setSale(float sale) {
		this.sale = sale;
	}

	public float getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(float currentStock) {
		this.currentStock = currentStock;
	}

	public float getReorder() {
		return reorder;
	}

	public void setReorder(float reorder) {
		this.reorder = reorder;
	}

	@Override
	public String toString() {
		return "OpsFrItemStock [id=" + id + ", itemName=" + itemName + ", catId=" + catId + ", subCatId=" + subCatId
				+ ", opening=" + opening + ", purchase=" + purchase + ", crn=" + crn + ", grngvn=" + grngvn + ", sale="
				+ sale + ", currentStock=" + currentStock + ", reorder=" + reorder + "]";
	}

}

package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_production_plan_detail")
public class PostProductionPlanDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "production_detail_id")
	private int productionDetailId;

	@Column(name = "production_header_id")
	private int productionHeaderId;

	@Column(name = "plan_qty")
	private int planQty;

	@Column(name = "order_qty")
	private int orderQty;

	@Column(name = "opening_qty")
	private int openingQty;

	@Column(name = "rejected_qty")
	private int rejectedQty;

	@Column(name = "production_qty")
	private int productionQty;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "production_batch")
	private String productionBatch;

	@Column(name = "production_date")
	private Date productionDate;

	@Column(name = "remaining_qty")
	private int int4;

	private int int5; // neha

	public int getInt4() {
		return int4;
	}

	public void setInt4(int int4) {
		this.int4 = int4;
	}

	public String getProductionBatch() {
		return productionBatch;
	}

	// @JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setProductionBatch(String productionBatch) {
		this.productionBatch = productionBatch;
	}

	/*
	 * @JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	 * public Date getProductionDate() { return productionDate; }
	 * 
	 * public void setProductionDate(Date productionDate) { this.productionDate =
	 * productionDate; }
	 */

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public int getOpeningQty() {
		return openingQty;
	}

	public void setOpeningQty(int openingQty) {
		this.openingQty = openingQty;
	}

	public int getRejectedQty() {
		return rejectedQty;
	}

	public void setRejectedQty(int rejectedQty) {
		this.rejectedQty = rejectedQty;
	}

	public int getProductionQty() {
		return productionQty;
	}

	public void setProductionQty(int productionQty) {
		this.productionQty = productionQty;
	}

	public int getProductionDetailId() {
		return productionDetailId;
	}

	public void setProductionDetailId(int productionDetailId) {
		this.productionDetailId = productionDetailId;
	}

	public int getProductionHeaderId() {
		return productionHeaderId;
	}

	public void setProductionHeaderId(int productionHeaderId) {
		this.productionHeaderId = productionHeaderId;
	}

	public int getPlanQty() {
		return planQty;
	}

	public void setPlanQty(int planQty) {
		this.planQty = planQty;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getInt5() {
		return int5;
	}

	public void setInt5(int int5) {
		this.int5 = int5;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	@Override
	public String toString() {
		return "PostProductionPlanDetail [productionDetailId=" + productionDetailId + ", productionHeaderId="
				+ productionHeaderId + ", planQty=" + planQty + ", orderQty=" + orderQty + ", openingQty=" + openingQty
				+ ", rejectedQty=" + rejectedQty + ", productionQty=" + productionQty + ", itemId=" + itemId
				+ ", productionBatch=" + productionBatch + ", productionDate=" + productionDate + ", int4=" + int4
				+ ", int5=" + int5 + "]";
	}

}

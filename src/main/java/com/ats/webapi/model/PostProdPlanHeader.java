package com.ats.webapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_production_plan_header")
public class PostProdPlanHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "production_header_id")
	private int productionHeaderId;

	@Column(name = "cat_id")
	private int itemGrp1;

	@Column(name = "time_slot")
	private int timeSlot;

	@Column(name = "production_batch")
	private String productionBatch;

	@Column(name = "production_status")
	private String productionStatus;

	@Column(name = "production_date")
	private Date productionDate;

	@Column(name = "is_mixing")
	private int isMixing;

	@Column(name = "is_bom")
	private int isBom;

	@Column(name = "is_planned")
	private int isPlanned;

	@Column(name = "del_status")
	private int delStatus;

	@Transient
	private List<PostProductionPlanDetail> postProductionPlanDetail;

	public int getIsPlanned() {
		return isPlanned;
	}

	public void setIsPlanned(int isPlanned) {
		this.isPlanned = isPlanned;
	}

	public int getProductionHeaderId() {
		return productionHeaderId;
	}

	public void setProductionHeaderId(int productionHeaderId) {
		this.productionHeaderId = productionHeaderId;
	}

	public String getProductionBatch() {
		return productionBatch;
	}

	public void setProductionBatch(String productionBatch) {
		this.productionBatch = productionBatch;
	}

	public String getProductionStatus() {
		return productionStatus;
	}

	public void setProductionStatus(String productionStatus) {
		this.productionStatus = productionStatus;
	}

	public int getIsMixing() {
		return isMixing;
	}

	public void setIsMixing(int isMixing) {
		this.isMixing = isMixing;
	}

	public int getIsBom() {
		return isBom;
	}

	public void setIsBom(int isBom) {
		this.isBom = isBom;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	/*
	 * @JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	 * public Date getProductionDate() { return productionDate; }
	 * 
	 * @JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	 * public void setProductionDate(Date productionDate) { this.productionDate =
	 * productionDate; }
	 */

	public List<PostProductionPlanDetail> getPostProductionPlanDetail() {
		return postProductionPlanDetail;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProductionDate() {
		return productionDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public void setPostProductionPlanDetail(List<PostProductionPlanDetail> postProductionPlanDetail) {
		this.postProductionPlanDetail = postProductionPlanDetail;
	}

	public int getItemGrp1() {
		return itemGrp1;
	}

	public void setItemGrp1(int itemGrp1) {
		this.itemGrp1 = itemGrp1;
	}

	@Override
	public String toString() {
		return "PostProdPlanHeader [productionHeaderId=" + productionHeaderId + ", itemGrp1=" + itemGrp1 + ", timeSlot="
				+ timeSlot + ", productionBatch=" + productionBatch + ", productionStatus=" + productionStatus
				+ ", productionDate=" + productionDate + ", isMixing=" + isMixing + ", isBom=" + isBom + ", delStatus="
				+ delStatus + ", postProductionPlanDetail=" + postProductionPlanDetail + "]";
	}

}

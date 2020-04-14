package com.ats.webapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_production_plan_header")
public class PostProductionHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="production_header_id")
	private int productionHeaderId;
	 
	@Column(name="cat_id")
	private int itemGrp1;
	
	@Column(name="time_slot")
	private int timeSlot;
	
	@Column(name="production_date")
	private Date productionDate;
	

	@Column(name="is_mixing")
	private int isMixing;

	@Column(name="is_bom")
	private int isBom;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="is_planned")
	private int isPlanned;
	
	@Column(name="production_batch")
	private String productionBatch;
	
	@Column(name="production_status")
	private int productionStatus;
	
	@Transient
	private List<PostProductionDetail> postProductionDetail;

	public int getProductionHeaderId() {
		return productionHeaderId;
	}

	public void setProductionHeaderId(int productionHeaderId) {
		this.productionHeaderId = productionHeaderId;
	}


	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public List<PostProductionDetail> getPostProductionDetail() {
		return postProductionDetail;
	}

	public void setPostProductionDetail(List<PostProductionDetail> postProductionDetail) {
		this.postProductionDetail = postProductionDetail;
	}

	public int getItemGrp1() {
		return itemGrp1;
	}

	public void setItemGrp1(int itemGrp1) {
		this.itemGrp1 = itemGrp1;
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

	public int getIsPlanned() {
		return isPlanned;
	}

	public void setIsPlanned(int isPlanned) {
		this.isPlanned = isPlanned;
	}

	public String getProductionBatch() {
		return productionBatch;
	}

	public void setProductionBatch(String productionBatch) {
		this.productionBatch = productionBatch;
	}

	 

	public int getProductionStatus() {
		return productionStatus;
	}

	public void setProductionStatus(int productionStatus) {
		this.productionStatus = productionStatus;
	}

	@Override
	public String toString() {
		return "PostProductionHeader [productionHeaderId=" + productionHeaderId + ", itemGrp1=" + itemGrp1
				+ ", timeSlot=" + timeSlot + ", productionDate=" + productionDate + ", isMixing=" + isMixing
				+ ", isBom=" + isBom + ", delStatus=" + delStatus + ", isPlanned=" + isPlanned + ", productionBatch="
				+ productionBatch + ", productionStatus=" + productionStatus + ", postProductionDetail="
				+ postProductionDetail + "]";
	}

	 

	
	
	
	
	

}

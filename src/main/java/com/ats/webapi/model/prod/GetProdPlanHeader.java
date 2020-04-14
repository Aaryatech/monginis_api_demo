package com.ats.webapi.model.prod;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class GetProdPlanHeader implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="production_header_id")
	private int productionHeaderId;
	 
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="time_slot")
	private int timeSlot;
	
	@Column(name="production_batch")
	private String productionBatch;
	
	@Column(name="production_status")
	private String productionStatus;
	
	@Column(name="production_date")
	private Date productionDate;
	

	@Column(name="is_mixing")
	private int isMixing;

	@Column(name="is_bom")
	private int isBom;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="cat_name")
	private String  catName;
	
	
	@Column(name="is_planned")
	private int isPlanned;
	

	public int getProductionHeaderId() {
		return productionHeaderId;
	}

	public void setProductionHeaderId(int productionHeaderId) {
		this.productionHeaderId = productionHeaderId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
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

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
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

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getIsPlanned() {
		return isPlanned;
	}

	public void setIsPlanned(int isPlanned) {
		this.isPlanned = isPlanned;
	}
	

}

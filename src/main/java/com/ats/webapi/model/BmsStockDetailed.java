package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_bms_stock_details")
public class BmsStockDetailed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bms_stock_deatil_id")
	private int bmsStockDeatilId;
	
	@Column(name = "bms_stock_id")
	private int bmsStockId;

	@Column(name = "bms_stock_date")
	private Date bmsStockDate;
	
	@Column(name = "rm_type")
	private int rmType;
	
	@Column(name = "rm_id")
	private int rmId;
	
	@Column(name = "rm_name")
	private String rmName;
	
	@Column(name = "rm_uom")
	private int rmUom;

	@Transient
	@Column(name = "uom")
	private String uom;
	
	@Column(name = "bms_opening_stock")
	private float bmsOpeningStock;
	
	@Column(name = "store_rec_qty")
	private float storeRecQty;
	
	@Column(name = "store_rejected_qty")
	private float storeRejectedQty;
	
	@Column(name = "mixing_rec_qty")
	private float mixingRecQty;
	
	@Column(name = "mixing_receive_rejected_qty")
	private float mixingReceiveRejectedQty;
	
	@Column(name = "mixing_issue_qty")
	private float mixingIssueQty;
	
	@Column(name = "mixing_return_qty")
	private float mixingReturnQty;
	
	@Column(name = "mixing_rejected")
	private float mixingRejected;

	@Column(name = "prod_issue_qty")
	private float prodIssueQty;
	
	@Column(name = "prod_return_qty")
	private float prodReturnQty;
	
	@Column(name = "prod_rejected_qty")
	private float prodRejectedQty;
	
	@Column(name = "closing_qty")
	private float closingQty;
	
	@Column(name = "is_del_status")
	private int isDelStatus;
	
	
	
	
	 

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getBmsStockDeatilId() {
		return bmsStockDeatilId;
	}

	public void setBmsStockDeatilId(int bmsStockDeatilId) {
		this.bmsStockDeatilId = bmsStockDeatilId;
	}

	public int getBmsStockId() {
		return bmsStockId;
	}


	public void setBmsStockId(int bmsStockId) {
		this.bmsStockId = bmsStockId;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBmsStockDate() {
		return bmsStockDate;
	}

	public void setBmsStockDate(Date bmsStockDate) {
		this.bmsStockDate = bmsStockDate;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}


	public int getRmUom() {
		return rmUom;
	}

	public void setRmUom(int rmUom) {
		this.rmUom = rmUom;
	}

	public float getBmsOpeningStock() {
		return bmsOpeningStock;
	}

	public void setBmsOpeningStock(float bmsOpeningStock) {
		this.bmsOpeningStock = bmsOpeningStock;
	}

	public float getStoreRecQty() {
		return storeRecQty;
	}

	public void setStoreRecQty(float storeRecQty) {
		this.storeRecQty = storeRecQty;
	}

	public float getStoreRejectedQty() {
		return storeRejectedQty;
	}

	public void setStoreRejectedQty(float storeRejectedQty) {
		this.storeRejectedQty = storeRejectedQty;
	}

	public float getMixingRecQty() {
		return mixingRecQty;
	}

	public void setMixingRecQty(float mixingRecQty) {
		this.mixingRecQty = mixingRecQty;
	}

	public float getMixingReceiveRejectedQty() {
		return mixingReceiveRejectedQty;
	}

	public void setMixingReceiveRejectedQty(float mixingReceiveRejectedQty) {
		this.mixingReceiveRejectedQty = mixingReceiveRejectedQty;
	}

	public float getMixingIssueQty() {
		return mixingIssueQty;
	}

	public void setMixingIssueQty(float mixingIssueQty) {
		this.mixingIssueQty = mixingIssueQty;
	}

	public float getMixingReturnQty() {
		return mixingReturnQty;
	}

	public void setMixingReturnQty(float mixingReturnQty) {
		this.mixingReturnQty = mixingReturnQty;
	}

	public float getMixingRejected() {
		return mixingRejected;
	}

	public void setMixingRejected(float mixingRejected) {
		this.mixingRejected = mixingRejected;
	}


	public float getProdIssueQty() {
		return prodIssueQty;
	}

	public void setProdIssueQty(float prodIssueQty) {
		this.prodIssueQty = prodIssueQty;
	}


	public float getProdReturnQty() {
		return prodReturnQty;
	}


	public void setProdReturnQty(float prodReturnQty) {
		this.prodReturnQty = prodReturnQty;
	}

	public float getProdRejectedQty() {
		return prodRejectedQty;
	}

	public void setProdRejectedQty(float prodRejectedQty) {
		this.prodRejectedQty = prodRejectedQty;
	}

	public float getClosingQty() {
		return closingQty;
	}

	public void setClosingQty(float closingQty) {
		this.closingQty = closingQty;
	}


	public int getIsDelStatus() {
		return isDelStatus;
	}

	public void setIsDelStatus(int isDelStatus) {
		this.isDelStatus = isDelStatus;
	}

	@Override
	public String toString() {
		return "BmsStockDetailed [bmsStockDeatilId=" + bmsStockDeatilId + ", bmsStockId=" + bmsStockId
				+ ", bmsStockDate=" + bmsStockDate + ", rmType=" + rmType + ", rmId=" + rmId + ", rmName=" + rmName
				+ ", rmUom=" + rmUom + ", uom=" + uom + ", bmsOpeningStock=" + bmsOpeningStock + ", storeRecQty="
				+ storeRecQty + ", storeRejectedQty=" + storeRejectedQty + ", mixingRecQty=" + mixingRecQty
				+ ", mixingReceiveRejectedQty=" + mixingReceiveRejectedQty + ", mixingIssueQty=" + mixingIssueQty
				+ ", mixingReturnQty=" + mixingReturnQty + ", mixingRejected=" + mixingRejected + ", prodIssueQty="
				+ prodIssueQty + ", prodReturnQty=" + prodReturnQty + ", prodRejectedQty=" + prodRejectedQty
				+ ", closingQty=" + closingQty + ", isDelStatus=" + isDelStatus + "]";
	}

	 
	
	

}

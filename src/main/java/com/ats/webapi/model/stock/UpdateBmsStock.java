package com.ats.webapi.model.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_bms_stock_details")
public class UpdateBmsStock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bms_stock_detail_id")
	private int bmsStockDeatilId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="bms_stock_id")
	int bmsStockId;
	
	@Column(name="prod_issue_qty")
	float prodIssueQty;
	
	@Column(name="prod_rejected_qty")
	float prodRejectedQty;
	
	@Column(name="prod_return_qty")
	float prodReturnQty;
	
	@Column(name="mixing_issue_qty")
	float mixingIssueQty;
	
	@Column(name="mixing_rejected")
	float mixingRejectedQty; 
	
	

	@Column(name="mixing_return_qty")
	float mixingReturnQty;
	
	@Column(name="store_rec_qty")
	float storeIssueQty; 
	
	@Column(name="store_rejected_qty")
	float storeRejectedQty;
	
	@Column(name="closing_qty")
	float bmsClosingStock;
	
	
	@Column(name="mixing_receive_rejected_qty")//
	float mixingReceiveRejectedQty;

	
	
	@Column(name="mixing_rec_qty")//
	float mixingRecQty;

	
	

	public int getBmsStockDeatilId() {
		return bmsStockDeatilId;
	}

	public void setBmsStockDeatilId(int bmsStockDeatilId) {
		this.bmsStockDeatilId = bmsStockDeatilId;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public int getBmsStockId() {
		return bmsStockId;
	}

	public void setBmsStockId(int bmsStockId) {
		this.bmsStockId = bmsStockId;
	}

	public float getProdIssueQty() {
		return prodIssueQty;
	}

	public void setProdIssueQty(float prodIssueQty) {
		this.prodIssueQty = prodIssueQty;
	}

	public float getProdRejectedQty() {
		return prodRejectedQty;
	}

	public void setProdRejectedQty(float prodRejectedQty) {
		this.prodRejectedQty = prodRejectedQty;
	}

	public float getProdReturnQty() {
		return prodReturnQty;
	}

	public void setProdReturnQty(float prodReturnQty) {
		this.prodReturnQty = prodReturnQty;
	}

	public float getMixingIssueQty() {
		return mixingIssueQty;
	}

	public void setMixingIssueQty(float mixingIssueQty) {
		this.mixingIssueQty = mixingIssueQty;
	}

	public float getMixingRejectedQty() {
		return mixingRejectedQty;
	}

	public void setMixingRejectedQty(float mixingRejectedQty) {
		this.mixingRejectedQty = mixingRejectedQty;
	}

	public float getMixingReturnQty() {
		return mixingReturnQty;
	}

	public void setMixingReturnQty(float mixingReturnQty) {
		this.mixingReturnQty = mixingReturnQty;
	}

	public float getStoreIssueQty() {
		return storeIssueQty;
	}

	public void setStoreIssueQty(float storeIssueQty) {
		this.storeIssueQty = storeIssueQty;
	}

	public float getStoreRejectedQty() {
		return storeRejectedQty;
	}

	public void setStoreRejectedQty(float storeRejectedQty) {
		this.storeRejectedQty = storeRejectedQty;
	}

	public float getBmsClosingStock() {
		return bmsClosingStock;
	}

	public void setBmsClosingStock(float bmsClosingStock) {
		this.bmsClosingStock = bmsClosingStock;
	}

	public float getMixingReceiveRejectedQty() {
		return mixingReceiveRejectedQty;
	}

	public void setMixingReceiveRejectedQty(float mixingReceiveRejectedQty) {
		this.mixingReceiveRejectedQty = mixingReceiveRejectedQty;
	}

	public float getMixingRecQty() {
		return mixingRecQty;
	}

	public void setMixingRecQty(float mixingRecQty) {
		this.mixingRecQty = mixingRecQty;
	}

	@Override
	public String toString() {
		return "UpdateBmsStock [bmsStockDeatilId=" + bmsStockDeatilId + ", rmId=" + rmId + ", bmsStockId=" + bmsStockId
				+ ", prodIssueQty=" + prodIssueQty + ", prodRejectedQty=" + prodRejectedQty + ", prodReturnQty="
				+ prodReturnQty + ", mixingIssueQty=" + mixingIssueQty + ", mixingRejectedQty=" + mixingRejectedQty
				+ ", mixingReturnQty=" + mixingReturnQty + ", storeIssueQty=" + storeIssueQty + ", storeRejectedQty="
				+ storeRejectedQty + ", bmsClosingStock=" + bmsClosingStock + ", mixingReceiveRejectedQty="
				+ mixingReceiveRejectedQty + ", mixingRecQty=" + mixingRecQty + "]";
	}
	
	
}

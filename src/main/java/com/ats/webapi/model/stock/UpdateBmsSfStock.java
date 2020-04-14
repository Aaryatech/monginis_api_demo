package com.ats.webapi.model.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_bms_stock_details")
public class UpdateBmsSfStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bms_stock_detail_id")
	private int bmsStockDeatilId;
	
	@Column(name="rm_id")
	private int sfId;
	
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
	
	@Column(name="closing_qty")
	float bmsClosingStock;

	public int getBmsStockDeatilId() {
		return bmsStockDeatilId;
	}

	public void setBmsStockDeatilId(int bmsStockDeatilId) {
		this.bmsStockDeatilId = bmsStockDeatilId;
	}

	public int getSfId() {
		return sfId;
	}

	public void setSfId(int sfId) {
		this.sfId = sfId;
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

	public float getBmsClosingStock() {
		return bmsClosingStock;
	}

	public void setBmsClosingStock(float bmsClosingStock) {
		this.bmsClosingStock = bmsClosingStock;
	}

	@Override
	public String toString() {
		return "UpdateBmsSfStock [bmsStockDeatilId=" + bmsStockDeatilId + ", sfId=" + sfId + ", bmsStockId="
				+ bmsStockId + ", prodIssueQty=" + prodIssueQty + ", prodRejectedQty=" + prodRejectedQty
				+ ", prodReturnQty=" + prodReturnQty + ", mixingIssueQty=" + mixingIssueQty + ", mixingRejectedQty="
				+ mixingRejectedQty + ", bmsClosingStock=" + bmsClosingStock + "]";
	}

}

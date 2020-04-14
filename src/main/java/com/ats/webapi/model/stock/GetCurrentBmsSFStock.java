package com.ats.webapi.model.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetCurrentBmsSFStock {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sf_id")
	private int sfId;
	

	@Column(name="sf_name")
	private String sfName;
	
	@Column(name="sf_uom_id")
	private int sfUomId;
	
	float prodIssueQty;
	float prodRejectedQty;
	
	float prodReturnQty;
	float mixingIssueQty;
	float mixingRejectedQty; 
	//float mixing_return_qty; not used in sf current stock
	//float store_issue_qty; 
	//float store_rejected_qty;
	float bmsClosingStock;//new for bet Date;
	float bmsOpeningStock;
	public int getSfId() {
		return sfId;
	}
	public void setSfId(int sfId) {
		this.sfId = sfId;
	}
	public String getSfName() {
		return sfName;
	}
	public void setSfName(String sfName) {
		this.sfName = sfName;
	}
	public int getSfUomId() {
		return sfUomId;
	}
	public void setSfUomId(int sfUomId) {
		this.sfUomId = sfUomId;
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
	public float getBmsOpeningStock() {
		return bmsOpeningStock;
	}
	public void setBmsOpeningStock(float bmsoOpeningStock) {
		this.bmsOpeningStock = bmsoOpeningStock;
	}
	@Override
	public String toString() {
		return "GetCurrentBmsSFStock [sfId=" + sfId + ", sfName=" + sfName + ", sfUomId=" + sfUomId + ", prodIssueQty="
				+ prodIssueQty + ", prodRejectedQty=" + prodRejectedQty + ", prodReturnQty=" + prodReturnQty
				+ ", mixingIssueQty=" + mixingIssueQty + ", mixingRejectedQty=" + mixingRejectedQty
				+ ", bmsClosingStock=" + bmsClosingStock + ", bmsOpeningStock=" + bmsOpeningStock + "]";
	}

	
}

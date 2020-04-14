package com.ats.webapi.model.logistics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_logis_serv_detail")
public class ServDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "serv_detail_id")
	private int servDetailId; 
	
	@Column(name = "serv_id")
	private int servId;
	
	@Column(name = "serv_date")
	private Date servDate;

	@Column(name = "serv_type")
	private int servType;  

	@Column(name = "group_id")
	private int groupId;
	
	@Column(name = "spr_id")
	private int sprId;

	@Column(name = "spr_qty")
	private int sprQty;

	@Column(name = "spr_rate")
	private int sprRate;
	
	@Column(name = "spr_taxable_amt")
	private float sprTaxableAmt;

	@Column(name = "spr_tax_amt")
	private float sprTaxAmt;  

	@Column(name = "total")
	private float total;
	
	@Column(name = "disc")
	private float disc;

	@Column(name = "extra_charges")
	private float extraCharges;

	@Column(name = "del_status")
	private int delStatus;

	public int getServDetailId() {
		return servDetailId;
	}

	public void setServDetailId(int servDetailId) {
		this.servDetailId = servDetailId;
	}

	public int getServId() {
		return servId;
	}

	public void setServId(int servId) {
		this.servId = servId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getServDate() {
		return servDate;
	}

	public void setServDate(Date servDate) {
		this.servDate = servDate;
	}

	public int getServType() {
		return servType;
	}

	public void setServType(int servType) {
		this.servType = servType;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getSprId() {
		return sprId;
	}

	public void setSprId(int sprId) {
		this.sprId = sprId;
	}

	public int getSprQty() {
		return sprQty;
	}

	public void setSprQty(int sprQty) {
		this.sprQty = sprQty;
	}

	public int getSprRate() {
		return sprRate;
	}

	public void setSprRate(int sprRate) {
		this.sprRate = sprRate;
	}

	public float getSprTaxableAmt() {
		return sprTaxableAmt;
	}

	public void setSprTaxableAmt(float sprTaxableAmt) {
		this.sprTaxableAmt = sprTaxableAmt;
	}

	public float getSprTaxAmt() {
		return sprTaxAmt;
	}

	public void setSprTaxAmt(float sprTaxAmt) {
		this.sprTaxAmt = sprTaxAmt;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getDisc() {
		return disc;
	}

	public void setDisc(float disc) {
		this.disc = disc;
	}

	public float getExtraCharges() {
		return extraCharges;
	}

	public void setExtraCharges(float extraCharges) {
		this.extraCharges = extraCharges;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "ServDetail [servDetailId=" + servDetailId + ", servId=" + servId + ", servDate=" + servDate
				+ ", servType=" + servType + ", groupId=" + groupId + ", sprId=" + sprId + ", sprQty=" + sprQty
				+ ", sprRate=" + sprRate + ", sprTaxableAmt=" + sprTaxableAmt + ", sprTaxAmt=" + sprTaxAmt + ", total="
				+ total + ", disc=" + disc + ", extraCharges=" + extraCharges + ", delStatus=" + delStatus + "]";
	}
	
	

}

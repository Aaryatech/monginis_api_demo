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
@Table(name = "m_logis_amc")
public class LogisAmc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "amc_id")
	private int amcId; 
	
	@Column(name = "mech_id")
	private int mechId;
	
	@Column(name = "type_id")
	private int typeId;
	
	@Column(name = "dealer_id")
	private int dealerId;
	
	@Column(name = "amc_from_date")
	private Date amcFromDate;

	@Column(name = "amc_to_date")
	private Date amcToDate;

	@Column(name = "amc_alert_freq")
	private int amcAlertFreq;
	
	@Column(name = "amc_alert_date")
	private Date amcAlertDate;
	
	@Column(name = "bill_no")
	private String billNo; 
	
	@Column(name = "amc_taxable_amt")
	private float amcTaxableAmt; 
	
	@Column(name = "amc_tax_amt")
	private float amcTaxAmt;

	@Column(name = "amc_total")
	private float amcTotal;

	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "mech_name")
	private String mechName;

	@Column(name = "dealer_name")
	private String dealerName;

	public int getAmcId() {
		return amcId;
	}

	public void setAmcId(int amcId) {
		this.amcId = amcId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAmcFromDate() {
		return amcFromDate;
	}

	public void setAmcFromDate(Date amcFromDate) {
		this.amcFromDate = amcFromDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAmcToDate() {
		return amcToDate;
	}

	public void setAmcToDate(Date amcToDate) {
		this.amcToDate = amcToDate;
	}

	public int getAmcAlertFreq() {
		return amcAlertFreq;
	}

	public void setAmcAlertFreq(int amcAlertFreq) {
		this.amcAlertFreq = amcAlertFreq;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAmcAlertDate() {
		return amcAlertDate;
	}

	public void setAmcAlertDate(Date amcAlertDate) {
		this.amcAlertDate = amcAlertDate;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public float getAmcTaxableAmt() {
		return amcTaxableAmt;
	}

	public void setAmcTaxableAmt(float amcTaxableAmt) {
		this.amcTaxableAmt = amcTaxableAmt;
	}

	public float getAmcTaxAmt() {
		return amcTaxAmt;
	}

	public void setAmcTaxAmt(float amcTaxAmt) {
		this.amcTaxAmt = amcTaxAmt;
	}

	public float getAmcTotal() {
		return amcTotal;
	}

	public void setAmcTotal(float amcTotal) {
		this.amcTotal = amcTotal;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	

	public int getMechId() {
		return mechId;
	}

	public void setMechId(int mechId) {
		this.mechId = mechId;
	}
	
	

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}
	
	

	public String getMechName() {
		return mechName;
	}

	public void setMechName(String mechName) {
		this.mechName = mechName;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	@Override
	public String toString() {
		return "LogisAmc [amcId=" + amcId + ", mechId=" + mechId + ", typeId=" + typeId + ", dealerId=" + dealerId
				+ ", amcFromDate=" + amcFromDate + ", amcToDate=" + amcToDate + ", amcAlertFreq=" + amcAlertFreq
				+ ", amcAlertDate=" + amcAlertDate + ", billNo=" + billNo + ", amcTaxableAmt=" + amcTaxableAmt
				+ ", amcTaxAmt=" + amcTaxAmt + ", amcTotal=" + amcTotal + ", delStatus=" + delStatus + ", mechName="
				+ mechName + ", dealerName=" + dealerName + "]";
	}
	
	

}

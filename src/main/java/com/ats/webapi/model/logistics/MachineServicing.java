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
@Table(name = "m_logis_machine_serv")
public class MachineServicing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mech_serv_id")
	private int mechServId; 
	
	@Column(name = "machine_id")
	private int machineId;
	
	@Column(name = "machine_name")
	private String machineName;
	
	@Column(name = "prsn_name")
	private String prsnName;

	@Column(name = "paid_type")
	private int paidType;

	@Column(name = "dealer_id")
	private int dealerId;
	
	@Column(name = "dealer_name")
	private String dealerName;

	@Column(name = "date")
	private Date date;

	@Column(name = "next_serv_date")
	private Date nextServDate;
	
	@Column(name = "alert_serv_date")
	private Date alertServDate;
	
	@Column(name = "is_alert_required")
	private int isAlertRequired;

	@Column(name = "is_approved")
	private int isApproved;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "serv_type")
	private int servType;

	public int getMechServId() {
		return mechServId;
	}

	public void setMechServId(int mechServId) {
		this.mechServId = mechServId;
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getPrsnName() {
		return prsnName;
	}

	public void setPrsnName(String prsnName) {
		this.prsnName = prsnName;
	}

	public int getPaidType() {
		return paidType;
	}

	public void setPaidType(int paidType) {
		this.paidType = paidType;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getNextServDate() {
		return nextServDate;
	}

	public void setNextServDate(Date nextServDate) {
		this.nextServDate = nextServDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAlertServDate() {
		return alertServDate;
	}

	public void setAlertServDate(Date alertServDate) {
		this.alertServDate = alertServDate;
	}

	public int getIsAlertRequired() {
		return isAlertRequired;
	}

	public void setIsAlertRequired(int isAlertRequired) {
		this.isAlertRequired = isAlertRequired;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	

	public int getServType() {
		return servType;
	}

	public void setServType(int servType) {
		this.servType = servType;
	}

	@Override
	public String toString() {
		return "MachineServicing [mechServId=" + mechServId + ", machineId=" + machineId + ", machineName="
				+ machineName + ", prsnName=" + prsnName + ", paidType=" + paidType + ", dealerId=" + dealerId
				+ ", dealerName=" + dealerName + ", date=" + date + ", nextServDate=" + nextServDate
				+ ", alertServDate=" + alertServDate + ", isAlertRequired=" + isAlertRequired + ", isApproved="
				+ isApproved + ", delStatus=" + delStatus + ", servType=" + servType + "]";
	}

	 
}

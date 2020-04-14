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
@Table(name = "m_logis_machine")
public class MachineMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "machine_id")
	private int machineId; 
	
	@Column(name = "machine_name")
	private String machineName;

	@Column(name = "make_id")
	private int makeId;

	@Column(name = "type_id")
	private int typeId;
	
	@Column(name = "variant_id")
	private int variantId;
	
	@Column(name = "dealer_id")
	private int dealerId;

	@Column(name = "machine_no")
	private String machineNo;

	@Column(name = "color")
	private String color;
	
	@Column(name = "variable_part")
	private String variablePart;
	
	@Column(name = "purchase_date")
	private Date purchaseDate; 
	
	@Column(name = "registration_date")
	private Date registrationDate;

	@Column(name = "cleaning_frq")
	private int cleaningFrq;

	@Column(name = "last_cleaning_date")
	private Date lastCleaningDate;
	
	@Column(name = "next_cleaning_date")
	private Date nextCleaningDate;
	
	@Column(name = "next_alert_date")
	private Date nextAlertDate;

	@Column(name = "alert_freq")
	private int alertFreq;

	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "last_amc_date")
	private Date lastAmcDate;
	
	@Column(name = "next_amc_date")
	private Date nextAmcDate;
	
	@Column(name = "alert_amc_date")
	private Date alertAmcDate;

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

	public int getMakeId() {
		return makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getVariantId() {
		return variantId;
	}

	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVariablePart() {
		return variablePart;
	}

	public void setVariablePart(String variablePart) {
		this.variablePart = variablePart;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getCleaningFrq() {
		return cleaningFrq;
	}

	public void setCleaningFrq(int cleaningFrq) {
		this.cleaningFrq = cleaningFrq;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLastCleaningDate() {
		return lastCleaningDate;
	}

	public void setLastCleaningDate(Date lastCleaningDate) {
		this.lastCleaningDate = lastCleaningDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getNextCleaningDate() {
		return nextCleaningDate;
	}

	public void setNextCleaningDate(Date nextCleaningDate) {
		this.nextCleaningDate = nextCleaningDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getNextAlertDate() {
		return nextAlertDate;
	}

	public void setNextAlertDate(Date nextAlertDate) {
		this.nextAlertDate = nextAlertDate;
	}

	public int getAlertFreq() {
		return alertFreq;
	}

	public void setAlertFreq(int alertFreq) {
		this.alertFreq = alertFreq;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLastAmcDate() {
		return lastAmcDate;
	}

	public void setLastAmcDate(Date lastAmcDate) {
		this.lastAmcDate = lastAmcDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getNextAmcDate() {
		return nextAmcDate;
	}

	public void setNextAmcDate(Date nextAmcDate) {
		this.nextAmcDate = nextAmcDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAlertAmcDate() {
		return alertAmcDate;
	}

	public void setAlertAmcDate(Date alertAmcDate) {
		this.alertAmcDate = alertAmcDate;
	}
	
	

}

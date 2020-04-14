package com.ats.webapi.model.logistics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AlertMachineServicingRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="machine_id")
	private int machineId;
	  
	@Column(name="machine_name")
	private String machineName;
	
	@Column(name="dealer_id")
	private int dealer_id;
	
	@Column(name="dealer_name")
	private String dealerName;
	  
	@Column(name="last_cleaning_date")
	private Date lastCleaningDate;
	
	@Column(name="next_cleaning_date")
	private Date nextCleaningDate;
	
	@Column(name="next_alert_date")
	private Date nextAlertDate;
	
	@Column(name="remaining_day")
	private int remainingDay;

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

	public int getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(int dealer_id) {
		this.dealer_id = dealer_id;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
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

	public int getRemainingDay() {
		return remainingDay;
	}

	public void setRemainingDay(int remainingDay) {
		this.remainingDay = remainingDay;
	}

	@Override
	public String toString() {
		return "AlertMachineServicingRecord [machineId=" + machineId + ", machineName=" + machineName + ", dealer_id="
				+ dealer_id + ", dealerName=" + dealerName + ", lastCleaningDate=" + lastCleaningDate
				+ ", nextCleaningDate=" + nextCleaningDate + ", nextAlertDate=" + nextAlertDate + ", remainingDay="
				+ remainingDay + "]";
	}
	
	

}

package com.ats.webapi.model.logistics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AlertAmcRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	  
	@Column(name="name")
	private String name;
	
	@Column(name="dealer_id")
	private int dealerId;
	
	@Column(name="dealer_name")
	private String dealerName;
	  
	@Column(name="last_amc_date")
	private Date lastAmcDate;
	
	@Column(name="next_amc_date")
	private Date nextAmcDate;
	
	@Column(name="alert_amc_date")
	private Date alertAmcDate;
	
	@Column(name="remaining_day")
	private int remainingDay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getRemainingDay() {
		return remainingDay;
	}

	public void setRemainingDay(int remainingDay) {
		this.remainingDay = remainingDay;
	}

	@Override
	public String toString() {
		return "AlertAmcRecord [id=" + id + ", name=" + name + ", dealerId=" + dealerId + ", dealerName=" + dealerName
				+ ", lastAmcDate=" + lastAmcDate + ", nextAmcDate=" + nextAmcDate + ", alertAmcDate=" + alertAmcDate
				+ ", remainingDay=" + remainingDay + "]";
	}

	
	 

}

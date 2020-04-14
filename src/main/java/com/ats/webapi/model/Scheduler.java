package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "t_scheduler")
public class Scheduler implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sch_id")
	private int schId;

	//@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "sch_date")
	private Date schDate;

	//@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "sch_to_date")
	private Date schTodate;

	@Column(name = "sch_occasion_name")
	private String schOccasionname;

	@Column(name = "sch_message")
	private String schMessage;


	@Column(name = "sch_frdttime")
	private double schFrdttime;

	
	@Column(name = "sch_todttime")
	private double schTodttime;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "del_status")
	private int delStatus;

		
	public int getSchId() {
		return schId;
	}
	
	public void setSchId(int schId) {
		this.schId = schId;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSchDate() {
		return schDate;
	}
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSchTodate() {
		return schTodate;
	}
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setSchTodate(Date schTodate) {
		this.schTodate = schTodate;
	}

	public String getSchOccasionname() {
		return schOccasionname;
	}

	public void setSchOccasionname(String schOccasionname) {
		this.schOccasionname = schOccasionname;
	}

	public String getSchMessage() {
		return schMessage;
	}

	public void setSchMessage(String schMessage) {
		this.schMessage = schMessage;
	}

	public double getSchFrdttime() {
		return schFrdttime;
	}

	public void setSchFrdttime(double schFrdttime) {
		this.schFrdttime = schFrdttime;
	}

	public double getSchTodttime() {
		return schTodttime;
	}

	public void setSchTodttime(double schTodttime) {
		this.schTodttime = schTodttime;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Scheduler [schId=" + schId + ", schDate=" + schDate + ", schTodate=" + schTodate + ", schOccasionname="
				+ schOccasionname + ", schMessage=" + schMessage + ", schFrdttime=" + schFrdttime + ", schTodttime="
				+ schTodttime + ", isActive=" + isActive + ", delStatus=" + delStatus + "]";
	}

}

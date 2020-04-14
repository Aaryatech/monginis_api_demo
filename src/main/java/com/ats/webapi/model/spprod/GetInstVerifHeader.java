package com.ats.webapi.model.spprod;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetInstVerifHeader implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inst_verif_h_id")
	private int instVerifHId;
	
	private Date instVerifDate;
	
	private int userId;
	
	private String userName;
	
	private int stationId;
	
	private String stName;
	
	private int shiftId;
	
	private String shiftName;
	
	private int stStatus;
	
	private String startTime;
	
	private String endTime;
	
	private int delStatus;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	@Transient
	private List<InstVerificationDetail> instVerificationDetailList;
	
	public List<InstVerificationDetail> getInstVerificationDetailList() {
		return instVerificationDetailList;
	}

	public void setInstVerificationDetailList(List<InstVerificationDetail> instVerificationDetailList) {
		this.instVerificationDetailList = instVerificationDetailList;
	}



	public int getInstVerifHId() {
		return instVerifHId;
	}

	public void setInstVerifHId(int instVerifHId) {
		this.instVerifHId = instVerifHId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getInstVerifDate() {
		return instVerifDate;
	}

	public void setInstVerifDate(Date instVerifDate) {
		this.instVerifDate = instVerifDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public int getStStatus() {
		return stStatus;
	}

	public void setStStatus(int stStatus) {
		this.stStatus = stStatus;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

}

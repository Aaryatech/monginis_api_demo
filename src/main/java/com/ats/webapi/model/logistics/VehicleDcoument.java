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
@Table(name = "m_logis_veh_doc")
public class VehicleDcoument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "veh_doc_id")
	private int vehDocId; 
	
	@Column(name = "veh_id")
	private int vehId;
	
	@Column(name = "doc_id")
	private int docId;

	@Column(name = "entry_date")
	private Date entryDate;  

	@Column(name = "doc_date")
	private Date docDate;
	
	@Column(name = "doc_expire_date")
	private Date docExpireDate;  

	@Column(name = "doc_exp_notification_date")
	private Date docExpNotificationDate;
	
	@Column(name = "doc_path")
	private String docPath; 
	
	@Column(name = "current_km")
	private int currentKm;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "remaining_day")
	private int remainingDay;
	

	public int getVehDocId() {
		return vehDocId;
	}

	public void setVehDocId(int vehDocId) {
		this.vehDocId = vehDocId;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDocExpireDate() {
		return docExpireDate;
	}

	public void setDocExpireDate(Date docExpireDate) {
		this.docExpireDate = docExpireDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDocExpNotificationDate() {
		return docExpNotificationDate;
	}

	public void setDocExpNotificationDate(Date docExpNotificationDate) {
		this.docExpNotificationDate = docExpNotificationDate;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public int getCurrentKm() {
		return currentKm;
	}

	public void setCurrentKm(int currentKm) {
		this.currentKm = currentKm;
	}
  
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getRemainingDay() {
		return remainingDay;
	}

	public void setRemainingDay(int remainingDay) {
		this.remainingDay = remainingDay;
	}

	@Override
	public String toString() {
		return "VehicleDcoument [vehDocId=" + vehDocId + ", vehId=" + vehId + ", docId=" + docId + ", entryDate="
				+ entryDate + ", docDate=" + docDate + ", docExpireDate=" + docExpireDate + ", docExpNotificationDate="
				+ docExpNotificationDate + ", docPath=" + docPath + ", currentKm=" + currentKm + ", delStatus="
				+ delStatus + ", remainingDay=" + remainingDay + "]";
	}
	
	
	
	

}

package com.ats.webapi.model.communication;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetComplaintDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="comp_detail_id")
	private int compDetailId;
	
	@Column(name="complaint_id")
	private int complaintId;
	
	@Column(name="message")
	private String message;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="time")
    private String time;
	
	@Column(name="is_admin")
	private int isAdmin;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_name")
    private String frName;

	public int getCompDetailId() {
		return compDetailId;
	}

	public void setCompDetailId(int compDetailId) {
		this.compDetailId = compDetailId;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	@Override
	public String toString() {
		return "GetComplaintDetail [compDetailId=" + compDetailId + ", complaintId=" + complaintId + ", message="
				+ message + ", photo=" + photo + ", date=" + date + ", time=" + time + ", isAdmin=" + isAdmin
				+ ", frId=" + frId + ", frName=" + frName + "]";
	}
	
}

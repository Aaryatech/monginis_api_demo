package com.ats.webapi.model.communication;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_comm_complaint_detail")
public class ComplaintDetail implements Serializable{

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

	@Override
	public String toString() {
		return "ComplaintDetail [compDetailId=" + compDetailId + ", complaintId=" + complaintId + ", message=" + message
				+ ", photo=" + photo + ", date=" + date + ", time=" + time + ", isAdmin=" + isAdmin + ", frId=" + frId
				+ "]";
	}
    
}

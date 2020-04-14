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
public class GetFeedbackDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feedback_detail_id")
    private int feedbackDetailId;
	
	@Column(name="feedback_id")
    private int feedbackId;
	
	@Column(name="message")
    private String message;
	
	@Column(name="is_admin")
    private int isAdmin;
	
	@Column(name="fr_id")
    private int frId;
	
	@Column(name="fr_name")
    private String frName;
	
	@Column(name="photo")
    private String photo;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="time")
    private String time;

	public int getFeedbackDetailId() {
		return feedbackDetailId;
	}

	public void setFeedbackDetailId(int feedbackDetailId) {
		this.feedbackDetailId = feedbackDetailId;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	@Override
	public String toString() {
		return "GetFeedbackDetail [feedbackDetailId=" + feedbackDetailId + ", feedbackId=" + feedbackId + ", message="
				+ message + ", isAdmin=" + isAdmin + ", frId=" + frId + ", frName=" + frName + ", photo=" + photo
				+ ", date=" + date + ", time=" + time + "]";
	}
	
	
}

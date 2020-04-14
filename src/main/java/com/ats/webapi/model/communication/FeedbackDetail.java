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
@Table(name="m_comm_feedback_detail")
public class FeedbackDetail implements Serializable{
	
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
	
	@Column(name="photo")
    private String photo;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="time")
    private String time;

	
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "FeedbackDetail [feedbackDetailId=" + feedbackDetailId + ", feedbackId=" + feedbackId + ", message="
				+ message + ", isAdmin=" + isAdmin + ", frId=" + frId + ", photo=" + photo + ", date=" + date
				+ ", time=" + time + "]";
	}
    
}

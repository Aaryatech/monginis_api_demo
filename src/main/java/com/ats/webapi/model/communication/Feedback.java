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
@Table(name="m_comm_feedback")
public class Feedback implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feedback_id")
	private int feedbackId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="time")
    private String time;
	
	@Column(name="is_closed")
	private int isClosed;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(int isClosed) {
		this.isClosed = isClosed;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", title=" + title + ", photo=" + photo + ", description="
				+ description + ", userId=" + userId + ", date=" + date + ", time=" + time + ", isClosed=" + isClosed
				+ "]";
	}

    
}

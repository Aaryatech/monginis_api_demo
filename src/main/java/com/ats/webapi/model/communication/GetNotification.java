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
public class GetNotification implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="notification_id")
    private int notificationId;
	
	@Column(name="subject")
    private String subject;
	
	@Column(name="user_id")
    private int userId;
	
	@Column(name="user_name")
    private String userName;
	
	@Column(name="description")
    private String description;
	
	@Column(name="photo")
    private String photo;
	
	@Column(name="date")
    private Date date;
	
	@Column(name="time")
    private String time;

	@Column(name="is_closed")
    private int isClosed;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(int isClosed) {
		this.isClosed = isClosed;
	}

	@Override
	public String toString() {
		return "GetNotification [notificationId=" + notificationId + ", subject=" + subject + ", userId=" + userId
				+ ", userName=" + userName + ", description=" + description + ", photo=" + photo + ", date=" + date
				+ ", time=" + time + ", isClosed=" + isClosed + "]";
	}

	
}

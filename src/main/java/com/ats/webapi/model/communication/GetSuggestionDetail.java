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
public class GetSuggestionDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="suggestion_detail_id")
	private int suggestionDetailId;
	
	@Column(name="suggestion_id")
	private int suggestionId;
	
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

	public int getSuggestionDetailId() {
		return suggestionDetailId;
	}

	public void setSuggestionDetailId(int suggestionDetailId) {
		this.suggestionDetailId = suggestionDetailId;
	}

	public int getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(int suggestionId) {
		this.suggestionId = suggestionId;
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
		return "GetSuggestionDetail [suggestionDetailId=" + suggestionDetailId + ", suggestionId=" + suggestionId
				+ ", message=" + message + ", isAdmin=" + isAdmin + ", frId=" + frId + ", frName=" + frName + ", photo="
				+ photo + ", date=" + date + ", time=" + time + "]";
	}
	
	
	
}


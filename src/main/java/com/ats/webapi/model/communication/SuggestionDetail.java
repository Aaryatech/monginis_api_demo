package com.ats.webapi.model.communication;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="m_comm_suggestion_detail")
public class SuggestionDetail implements Serializable{

	
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
	
	@Column(name="photo")
	private String photo;

	@Column(name="date")
	private Date date;
	
	@Column(name="time")
    private String time;
	
	
	public int getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(int suggestionId) {
		this.suggestionId = suggestionId;
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

	public int getSuggestionDetailId() {
		return suggestionDetailId;
	}

	public void setSuggestionDetailId(int suggestionDetailId) {
		this.suggestionDetailId = suggestionDetailId;
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
		return "SuggestionDetail [suggestionDetailId=" + suggestionDetailId + ", suggestionId=" + suggestionId
				+ ", message=" + message + ", isAdmin=" + isAdmin + ", frId=" + frId + ", photo=" + photo + ", date="
				+ date + ", time=" + time + "]";
	}

   
}

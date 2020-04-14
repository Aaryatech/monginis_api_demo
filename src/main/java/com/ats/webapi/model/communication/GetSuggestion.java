package com.ats.webapi.model.communication;

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
public class GetSuggestion implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="suggestion_id")
	private int suggestionId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="time")
    private String time;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_name")
    private String frName;
	
	@Column(name="is_closed")
	private int isClosed;

	@Transient
	private List<GetSuggestionDetail> suggestionDetails;
	
	
	
	public List<GetSuggestionDetail> getSuggestionDetails() {
		return suggestionDetails;
	}

	public void setSuggestionDetails(List<GetSuggestionDetail> suggestionDetails) {
		this.suggestionDetails = suggestionDetails;
	}

	public int getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(int suggestionId) {
		this.suggestionId = suggestionId;
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

	public int getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(int isClosed) {
		this.isClosed = isClosed;
	}

	@Override
	public String toString() {
		return "GetSuggestion [suggestionId=" + suggestionId + ", title=" + title + ", photo=" + photo
				+ ", description=" + description + ", date=" + date + ", time=" + time + ", frId=" + frId + ", frName="
				+ frName + ", isClosed=" + isClosed + ", suggestionDetails=" + suggestionDetails + "]";
	}
    
}

package com.ats.webapi.model.afe;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetAfeScoreHeader {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="afe_score_header_id")
	private int afeScoreHeaderId;

	@Column(name="fr_id")
	private int frId;
	
	@Column(name="score_header_date")
	private Date scoreHeaderDate;
	
	@Column(name="visited_by_id")
	private int visitedById;
	
	@Column(name="visit_person")
	private String visitPerson;
	
	@Column(name="route_id")
	private int routeId;

	@Column(name="total_score")
	private int totalScore;

	@Column(name="status")
	private int status;

	@Column(name="route_name")
	private String routeName;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="fr_code")
	private String frCode;

	public int getAfeScoreHeaderId() {
		return afeScoreHeaderId;
	}

	public void setAfeScoreHeaderId(int afeScoreHeaderId) {
		this.afeScoreHeaderId = afeScoreHeaderId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public Date getScoreHeaderDate() {
		return scoreHeaderDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public void setScoreHeaderDate(Date scoreHeaderDate) {
		this.scoreHeaderDate = scoreHeaderDate;
	}

	public int getVisitedById() {
		return visitedById;
	}

	public void setVisitedById(int visitedById) {
		this.visitedById = visitedById;
	}

	public String getVisitPerson() {
		return visitPerson;
	}

	public void setVisitPerson(String visitPerson) {
		this.visitPerson = visitPerson;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}

	@Override
	public String toString() {
		return "GetAfeScoreHeader [afeScoreHeaderId=" + afeScoreHeaderId + ", frId=" + frId + ", scoreHeaderDate="
				+ scoreHeaderDate + ", visitedById=" + visitedById + ", visitPerson=" + visitPerson + ", routeId="
				+ routeId + ", totalScore=" + totalScore + ", status=" + status + ", routeName=" + routeName
				+ ", frName=" + frName + ", frCode=" + frCode + "]";
	}
	
}

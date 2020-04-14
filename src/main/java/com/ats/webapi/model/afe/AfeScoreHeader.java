package com.ats.webapi.model.afe;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_afe_score_header")
public class AfeScoreHeader {
	
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

	@Column(name="del_status")
	private int delStatus;

	@Column(name="ex_int1")
	private int exInt1;

	@Column(name="ex_int2")
	private int exInt2;

	@Column(name="ex_var1")
	private String exVar1;

	@Column(name="ex_var2")
	private String exVar2;
	
	@Transient
	List<AfeScoreDetail> afeDetail;

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

	public Date getScoreHeaderDate() {
		return scoreHeaderDate;
	}

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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public List<AfeScoreDetail> getAfeDetail() {
		return afeDetail;
	}

	public void setAfeDetail(List<AfeScoreDetail> afeDetail) {
		this.afeDetail = afeDetail;
	}

	@Override
	public String toString() {
		return "AfeScoreHeader [afeScoreHeaderId=" + afeScoreHeaderId + ", frId=" + frId + ", scoreHeaderDate="
				+ scoreHeaderDate + ", visitedById=" + visitedById + ", visitPerson=" + visitPerson + ", routeId="
				+ routeId + ", totalScore=" + totalScore + ", status=" + status + ", delStatus=" + delStatus
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
				+ ", afeDetail=" + afeDetail + "]";
	}

	
}

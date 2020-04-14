package com.ats.webapi.model.afe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetAfeScoreDetail {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="afe_score_detail_id")
	private int afeScoreDetailId;

	
	@Column(name="afe_score_header_id")
	private int afeScoreHeaderId;

	@Column(name="que_id")
	private int queId;
	
	@Column(name="que_point")
	private int quePoint;
	
	@Column(name="score")
	private int score;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="del_status")
	private int delStatus;

	@Column(name="ex_int1")
	private int exInt1;

	@Column(name="ex_var1")
	private String exVar1;
	

	@Column(name="question")
	private String question;


	public int getAfeScoreDetailId() {
		return afeScoreDetailId;
	}


	public void setAfeScoreDetailId(int afeScoreDetailId) {
		this.afeScoreDetailId = afeScoreDetailId;
	}


	public int getAfeScoreHeaderId() {
		return afeScoreHeaderId;
	}


	public void setAfeScoreHeaderId(int afeScoreHeaderId) {
		this.afeScoreHeaderId = afeScoreHeaderId;
	}


	public int getQueId() {
		return queId;
	}


	public void setQueId(int queId) {
		this.queId = queId;
	}


	public int getQuePoint() {
		return quePoint;
	}


	public void setQuePoint(int quePoint) {
		this.quePoint = quePoint;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
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


	public String getExVar1() {
		return exVar1;
	}


	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	@Override
	public String toString() {
		return "GetAfeScoreDetail [afeScoreDetailId=" + afeScoreDetailId + ", afeScoreHeaderId=" + afeScoreHeaderId
				+ ", queId=" + queId + ", quePoint=" + quePoint + ", score=" + score + ", remark=" + remark
				+ ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exVar1=" + exVar1 + ", question=" + question
				+ "]";
	}
	
	
}

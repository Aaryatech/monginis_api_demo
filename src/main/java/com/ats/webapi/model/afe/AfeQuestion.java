package com.ats.webapi.model.afe;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="m_afe_question")

public class AfeQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="que_id")
	private int queId;

	@Column(name="question")
	private String question;
	
	@Column(name="que_type")
	private int queType;
	
	@Column(name="que_point")
	private int quePoint;
	
	@Column(name="que_date")
	private Date queDate;
	
	@Column(name="cat_name")
	private String catName;

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

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getQueType() {
		return queType;
	}

	public void setQueType(int queType) {
		this.queType = queType;
	}

	public int getQuePoint() {
		return quePoint;
	}

	public void setQuePoint(int quePoint) {
		this.quePoint = quePoint;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public Date getQueDate() {
		return queDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

	public void setQueDate(Date queDate) {
		this.queDate = queDate;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
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

	@Override
	public String toString() {
		return "AfeQuestion [queId=" + queId + ", question=" + question + ", queType=" + queType + ", quePoint="
				+ quePoint + ", queDate=" + queDate + ", catName=" + catName + ", delStatus=" + delStatus + ", exInt1="
				+ exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
}

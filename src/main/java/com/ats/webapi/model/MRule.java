package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_rule")
public class MRule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rule_id")
	private int ruleId;
	
	@Column(name="file_name")
	private String fileName;

	@Column(name="date")
	private Date date;
	
	@Column(name="status")
	private int status;

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MRule [ruleId=" + ruleId + ", fileName=" + fileName + ", date=" + date + ", status=" + status + "]";
	}
	
	

}

package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "t_order_log")
public class OrderLog {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="log_id")
	private int logId;
	
	private int frId;
	
	private String json;
	
	private String timestamp;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "OrderLog [logId=" + logId + ", frId=" + frId + ", json=" + json + ", timestamp=" + timestamp + "]";
	}
	
	

}

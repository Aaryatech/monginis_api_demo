package com.ats.webapi.model.spprod;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetAllocStationCk implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_ck_alloc_d_id")
	private int spCkAllocDId;
	
	private int stationId;
	
	private String stName;
	
	private int tSpCakeId;
	
	private String spName;
	
	private String spCode;
	
	private int spId;
	
	private Date reqDate;

	private int isBom;
	
	public int getIsBom() {
		return isBom;
	}

	public void setIsBom(int isBom) {
		this.isBom = isBom;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public int getSpCkAllocDId() {
		return spCkAllocDId;
	}

	public void setSpCkAllocDId(int spCkAllocDId) {
		this.spCkAllocDId = spCkAllocDId;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public int gettSpCakeId() {
		return tSpCakeId;
	}

	public void settSpCakeId(int tSpCakeId) {
		this.tSpCakeId = tSpCakeId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getReqDate() {
		return reqDate;
	} 

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	@Override
	public String toString() {
		return "GetAllocStationCk [spCkAllocDId=" + spCkAllocDId + ", stationId=" + stationId + ", stName=" + stName
				+ ", tSpCakeId=" + tSpCakeId + ", spName=" + spName + ", spCode=" + spCode + ", spId=" + spId
				+ ", reqDate=" + reqDate + "]";
	}

	
}

package com.ats.webapi.model.ownapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_ownerapp_usr")
public class OwnerAppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ownapp_usrid")
	private int ownappUsrid;
	
	private String usrName;
	private String secret; //i.e. Password
	private String mobNo;
	
	private String secQue;
	private String secAns;
	
	private String urlLink;
	private int compId;
	
	private String devToken;

	@Transient
	ResponseCode resCode;
	
	
	
	public String getDevToken() {
		return devToken;
	}
	public void setDevToken(String devToken) {
		this.devToken = devToken;
	}
	public ResponseCode getResCode() {
		return resCode;
	}
	public void setResCode(ResponseCode resCode) {
		this.resCode = resCode;
	}
	public int getOwnappUsrid() {
		return ownappUsrid;
	}
	public void setOwnappUsrid(int ownappUsrid) {
		this.ownappUsrid = ownappUsrid;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getSecQue() {
		return secQue;
	}
	public void setSecQue(String secQue) {
		this.secQue = secQue;
	}
	public String getSecAns() {
		return secAns;
	}
	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}
	public String getUrlLink() {
		return urlLink;
	}
	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	
	@Override
	public String toString() {
		return "OwnerAppUser [ownappUsrid=" + ownappUsrid + ", usrName=" + usrName + ", secret=" + secret + ", mobNo="
				+ mobNo + ", secQue=" + secQue + ", secAns=" + secAns + ", urlLink=" + urlLink + ", compId=" + compId
				+ ", devToken=" + devToken + ", resCode=" + resCode + "]";
	}
	
	
}

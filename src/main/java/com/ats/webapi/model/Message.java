package com.ats.webapi.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "t_message")

public class Message implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="msg_id")
	private int msgId;
	
	//@JsonFormat(pattern = "dd-MM-yyyy")
	//
	//@Temporal(TemporalType.DATE)
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="msg_frdt")
	private Date msgFrdt;
	
	//@JsonFormat(pattern = "dd-MM-yyyy")
	//@Temporal(TemporalType.DATE)
	
	@Column(name="msg_todt")
	private Date msgTodt;
	
	@Column(name="msg_image")
	private String msgImage;
	@Column(name="msg_header")
	private String msgHeader;
	@Column(name="msg_details")
	private String msgDetails;
	@Column(name="is_active")
	private int isActive;
	@Column(name="del_status")
	private int delStatus;
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getMsgFrdt() {
		return msgFrdt;
	}

	public void setMsgFrdt(Date msgFrdt) {
		this.msgFrdt = msgFrdt;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getMsgTodt() {
		return msgTodt;
	}

	public void setMsgTodt(Date msgTodt) {
		this.msgTodt = msgTodt;
	}

	public String getMsgImage() {
		return msgImage;
	}

	public void setMsgImage(String msgImage) {
		this.msgImage = msgImage;
	}

	public String getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(String msgHeader) {
		this.msgHeader = msgHeader;
	}

	public String getMsgDetails() {
		return msgDetails;
	}

	public void setMsgDetails(String msgDetails) {
		this.msgDetails = msgDetails;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", msgFrdt=" + msgFrdt + ", msgTodt=" + msgTodt + ", msgImage=" + msgImage
				+ ", msgHeader=" + msgHeader + ", msgDetails=" + msgDetails + ", isActive=" + isActive + ", delStatus="
				+ delStatus + "]";
	}

	
	
	
}

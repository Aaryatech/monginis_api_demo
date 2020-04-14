package com.ats.webapi.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "m_sp_event")
public class Event implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="spe_id")
	private int speId;
	@Column(name="spe_name")
	private String speName;
	@Column(name="del_status")
	private int delStatus;
	
	public int getSpeId() {
		return speId;
	}
	public void setSpeId(int speId) {
		this.speId = speId;
	}
	public String getSpeName() {
		return speName;
	}
	public void setSpeName(String speName) {
		this.speName = speName;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	@Override
	public String toString() {
		return "Event [speId=" + speId + ", speName=" + speName + ", delStatus=" + delStatus + "]";
	}
	
}

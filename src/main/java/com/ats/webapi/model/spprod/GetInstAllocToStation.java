package com.ats.webapi.model.spprod;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetInstAllocToStation implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inst_alloc_id")
	private int instAllocId;
	
	@Column(name="st_id")
	private int stId;
	
	private String stName;
	
	@Column(name="inst_id")
	private String instId;
	
	@Column(name="del_status")
	private int delStatus;

	public int getInstAllocId() {
		return instAllocId;
	}

	public void setInstAllocId(int instAllocId) {
		this.instAllocId = instAllocId;
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getInstId() {
		return instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GetInstAllocToStation [instAllocId=" + instAllocId + ", stId=" + stId + ", stName=" + stName
				+ ", instId=" + instId + ", delStatus=" + delStatus + "]";
	}
	
	
}

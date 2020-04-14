package com.ats.webapi.model.spprod;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_sp_inst_alloc")
public class InstAllocToStation implements Serializable{

	
	@Transient
	private boolean isError;
	
	@Transient
	private String message;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inst_alloc_id")
	private int instAllocId;
	
	@Column(name="st_id")
	private int stId;
	
	@Column(name="inst_id")
	private String instId;
	
	@Column(name="del_status")
	private int delStatus;

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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
		return "InstAllocToStation [isError=" + isError + ", message=" + message + ", instAllocId=" + instAllocId
				+ ", stId=" + stId + ", instId=" + instId + ", delStatus=" + delStatus + "]";
	}
	
	
	
}

package com.ats.webapi.model.gatesale;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_gatesale_other_supplier")
public class OtherSupplier implements Serializable{

	@Transient
	private String message;
	@Transient
	private boolean isError;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="supp_id")
	private int suppId;
	
	@Column(name="supp_name")
	private String suppName;
	
	@Column(name="supp_addr")
	private String suppAddr;
	
	@Column(name="supp_mob")
	private String suppMob;
	
	@Column(name="del_status")
	private int delStatus;
    
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppAddr() {
		return suppAddr;
	}

	public void setSuppAddr(String suppAddr) {
		this.suppAddr = suppAddr;
	}

	public String getSuppMob() {
		return suppMob;
	}

	public void setSuppMob(String suppMob) {
		this.suppMob = suppMob;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "OtherSupplier [suppId=" + suppId + ", suppName=" + suppName + ", suppAddr=" + suppAddr + ", suppMob="
				+ suppMob + ", delStatus=" + delStatus + "]";
	}
	
	
}

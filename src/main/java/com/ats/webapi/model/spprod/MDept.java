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
@Table(name = "m_cm_dept")
public class MDept implements Serializable
{

	@Transient
	private boolean isError;
	
	@Transient
	private String message;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	private int deptId;
	
	@Column(name = "dept_code")
	private String deptCode;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@Column(name = "is_active")
	private int isActive;
	
	@Column(name = "del_status")
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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	@Override
	public String toString() {
		return "MDept [deptId=" + deptId + ", deptCode=" + deptCode + ", deptName=" + deptName + ", isActive="
				+ isActive + ", delStatus=" + delStatus + "]";
	}

}

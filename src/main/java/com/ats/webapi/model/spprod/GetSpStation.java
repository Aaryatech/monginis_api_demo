package com.ats.webapi.model.spprod;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetSpStation implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="st_id")
	private int stId;
	
	@Column(name="st_name")
	private String stName;
	
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
	@Column(name="st_is_used")
	private int stIsUsed;
	
	@Column(name="st_location")
	private String stLocation;
	
	@Column(name="del_status")
	private int delStatus;

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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getStIsUsed() {
		return stIsUsed;
	}

	public void setStIsUsed(int stIsUsed) {
		this.stIsUsed = stIsUsed;
	}

	public String getStLocation() {
		return stLocation;
	}

	public void setStLocation(String stLocation) {
		this.stLocation = stLocation;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GetSpStation [stId=" + stId + ", stName=" + stName + ", deptId=" + deptId + ", deptName=" + deptName
				+ ", stIsUsed=" + stIsUsed + ", stLocation=" + stLocation + ", delStatus=" + delStatus + "]";
	}
	
	
}

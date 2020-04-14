package com.ats.webapi.model.remarks;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="m_remark")
public class GetAllRemarks implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="remark_id")
		private int remarkId;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="module_id")
	private int moduleId;
	
	@Column(name="sub_module_id")
	private int subModuleId;
	

	@Column(name="is_fr_used")
	private int isFrUsed;
	
	@Column(name="is_active")
	int isActive;

	@Column(name="is_del_status")
	int isDelStatus;

	public int getRemarkId() {
		return remarkId;
	}


	public String getRemark() {
		return remark;
	}


	public int getModuleId() {
		return moduleId;
	}


	public int getSubModuleId() {
		return subModuleId;
	}


	public int getIsFrUsed() {
		return isFrUsed;
	}


	public void setRemarkId(int remarkId) {
		this.remarkId = remarkId;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}


	public void setSubModuleId(int subModuleId) {
		this.subModuleId = subModuleId;
	}


	public void setIsFrUsed(int isFrUsed) {
		this.isFrUsed = isFrUsed;
	}

	public int getIsActive() {
		return isActive;
	}


	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}


	public int getIsDelStatus() {
		return isDelStatus;
	}


	public void setIsDelStatus(int isDelStatus) {
		this.isDelStatus = isDelStatus;
	}


	@Override
	public String toString() {
		return "GetAllRemarks [remarkId=" + remarkId + ", remark=" + remark + ", moduleId=" + moduleId
				+ ", subModuleId=" + subModuleId + ", isFrUsed=" + isFrUsed + ", isActive=" + isActive
				+ ", isDelStatus=" + isDelStatus + "]";
	}


	 
	

}

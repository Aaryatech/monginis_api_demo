package com.ats.webapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_module")
public class AccessRightModule {

	
	
	/*
	 `module_id` int(11) NOT NULL AUTO_INCREMENT,
	  `module_name` text NOT NULL,
	  `module_desc` text NOT NULL,
	  `del_status` tinyint(1) NOT NULL,
	  PRIMARY KEY (`module_id`)
	  
	  */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="module_id")
	private int moduleId;
	
	@Column(name="module_name")
	String moduleName;
	
	@Column(name="module_desc")
	String moduleDesc;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="order_by")
	private int orderBy;
	
	@Transient
	List<AccessRightSubModule> accessRightSubModuleList;

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public List<AccessRightSubModule> getAccessRightSubModuleList() {
		return accessRightSubModuleList;
	}

	public void setAccessRightSubModuleList(List<AccessRightSubModule> accessRightSubModuleList) {
		this.accessRightSubModuleList = accessRightSubModuleList;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "AccessRightModule [moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleDesc=" + moduleDesc
				+ ", delStatus=" + delStatus + ", orderBy=" + orderBy + ", accessRightSubModuleList="
				+ accessRightSubModuleList + "]";
	}

	 
	 
	
	
	
	
}

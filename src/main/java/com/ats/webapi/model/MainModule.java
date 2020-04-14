package com.ats.webapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// sachin comments main module

@Entity
@Table(name = "m_module")
public class MainModule implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="module_id")
	private int moduleId;
	@Column(name="module_name")
	private String moduleName;
	@Column(name="module_desc")
	private String moduleDesc;
	@Column(name="del_status")
	private int delStatus;
	
	//@OneToMany(mappedBy="mainModule",cascade=CascadeType.ALL)
	/*private List<SubModule> subModule=new ArrayList<SubModule>();
	
	public List<SubModule> getSubModule() {
		return subModule;
	}
	public void setSubModule(List<SubModule> subModule) {
		this.subModule = subModule;
	}*/
	
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


	@Override
	public String toString() {
		return "MainModule [moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleDesc=" + moduleDesc
				+ ", delStatus=" + delStatus + "]";
	}


	
	
}

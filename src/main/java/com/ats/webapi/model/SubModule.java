package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name = "m_module_sub")
public class SubModule implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_module_id")
	 private int subModuleId;

	@Column(name="module_id")
	 private int moduleId;
	@Column(name="sub_module_name")
	 private String subModuleName;
	@Column(name="sub_module_desc")
	 private String subModuleDesc;
	@Column(name="is_delete")
	 private int isDelete;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name ="module_id",nullable=false)
	
	/*private MainModule mainModule;
	public MainModule getMainModule() {
		return mainModule;
	}
	public void setMainModule(MainModule mainModule) {
		this.mainModule = mainModule;
	}*/
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	
	public int getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(int subModuleId) {
		this.subModuleId = subModuleId;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	
	public String getSubModuleDesc() {
		return subModuleDesc;
	}
	public void setSubModuleDesc(String subModuleDesc) {
		this.subModuleDesc = subModuleDesc;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "SubModule [subModuleId=" + subModuleId + ", moduleId=" + moduleId + ", subModuleName=" + subModuleName
				+ ", subModuleDesc=" + subModuleDesc + ", isDelete=" + isDelete + "]";
	} 
}

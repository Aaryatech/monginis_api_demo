package com.ats.webapi.model;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_assign_role")
public class AssignRoleDetailList {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_json")
	String roleJson;
	//List<AccessRightModule> accessRightModuleList;

	@Column(name="del_status")
	private int delStatus;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	 
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getRoleJson() {
		return roleJson;
	}

	public void setRoleJson(String roleJson) {
		this.roleJson = roleJson;
	}

	@Override
	public String toString() {
		return "AssignRoleDetailList [roleName=" + roleName + ", roleId=" + roleId + ", roleJson=" + roleJson
				+ ", delStatus=" + delStatus + "]";
	}

	 

	 
	
	
}

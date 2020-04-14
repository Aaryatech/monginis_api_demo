package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
 
public class Department {

 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String deptName;

	 

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



	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
}

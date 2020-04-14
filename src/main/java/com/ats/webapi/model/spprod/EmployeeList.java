package com.ats.webapi.model.spprod;

import java.util.List;

import com.ats.webapi.model.Info;

public class EmployeeList {

	List<GetEmployee> employeeList;
	Info info;
	public List<GetEmployee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<GetEmployee> employeeList) {
		this.employeeList = employeeList;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "EmployeeList [employeeList=" + employeeList + ", info=" + info + "]";
	}
	
}

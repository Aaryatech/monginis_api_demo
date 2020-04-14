package com.ats.webapi.model.gatesale;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="m_emp")
public class GateEmployee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="is_used")
	private int isUsed;
	
	@Column(name="emp_type")
	private int empType;
	
	@Column(name="emp_mobile")
	private String empMobile;

	@Column(name="emp_dob")
	private Date empDob;
	
	@Column(name="emp_doj")
	private Date empDoj;
	
	@Column(name="emp_fam_memb")
	private int empFamMemb;
	
	@Column(name="disc_id")
	private int discId;
	
	@Column(name="monthly_limit")
	private int monthlyLimit;
	
	@Column(name="yearly_limit")
	private int yearlyLimit;
	
	@Column(name="del_status")
	private int delStatus;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getEmpDob() {
		return empDob;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getEmpDoj() {
		return empDoj;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}

	public int getEmpFamMemb() {
		return empFamMemb;
	}

	public void setEmpFamMemb(int empFamMemb) {
		this.empFamMemb = empFamMemb;
	}

	public int getDiscId() {
		return discId;
	}

	public void setDiscId(int discId) {
		this.discId = discId;
	}

	public int getMonthlyLimit() {
		return monthlyLimit;
	}

	public void setMonthlyLimit(int monthlyLimit) {
		this.monthlyLimit = monthlyLimit;
	}

	public int getYearlyLimit() {
		return yearlyLimit;
	}

	public void setYearlyLimit(int yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GateEmployee [empId=" + empId + ", empName=" + empName + ", deptId=" + deptId + ", isUsed=" + isUsed
				+ ", empType=" + empType + ", empMobile=" + empMobile + ", empDob=" + empDob + ", empDoj=" + empDoj
				+ ", empFamMemb=" + empFamMemb + ", discId=" + discId + ", monthlyLimit=" + monthlyLimit
				+ ", yearlyLimit=" + yearlyLimit + ", delStatus=" + delStatus + "]";
	}
	
}

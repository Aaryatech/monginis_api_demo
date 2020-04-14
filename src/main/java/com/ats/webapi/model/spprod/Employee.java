package com.ats.webapi.model.spprod;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="m_emp")
public class Employee implements Serializable{


	@Transient
	private boolean isError;
	
	@Transient
	private String message;
	
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
	
	@Column(name="disc_id")
	private int discId;
	
	@Column(name="emp_dob")
	private Date empDob;
	
	@Column(name="emp_doj")
	private Date empDoj;
	
	@Column(name="emp_fam_memb")
	private int empFamMemb;
	
	@Column(name="monthly_limit")
	private float monthlyLimit;
	
	@Column(name="yearly_limit")
	private float yearlyLimit;
	
	@Column(name="del_status")
	private int delStatus;
	
	
	public int getDiscId() {
		return discId;
	}

	public void setDiscId(int discId) {
		this.discId = discId;
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

	public float getMonthlyLimit() {
		return monthlyLimit;
	}

	public void setMonthlyLimit(float monthlyLimit) {
		this.monthlyLimit = monthlyLimit;
	}

	public float getYearlyLimit() {
		return yearlyLimit;
	}

	public void setYearlyLimit(float yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Employee [isError=" + isError + ", message=" + message + ", empId=" + empId + ", empName=" + empName
				+ ", deptId=" + deptId + ", isUsed=" + isUsed + ", empType=" + empType + ", empMobile=" + empMobile
				+ ", discId=" + discId + ", empDob=" + empDob + ", empDoj=" + empDoj + ", empFamMemb=" + empFamMemb
				+ ", monthlyLimit=" + monthlyLimit + ", yearlyLimit=" + yearlyLimit + ", delStatus=" + delStatus + "]";
	}
   	
}

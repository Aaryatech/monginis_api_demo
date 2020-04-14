package com.ats.webapi.model.spprod;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetEmployee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name")
	private String empName;
	
	private int empType;
	
	private String typeName;
	
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
	@Column(name="is_used")
	private int isUsed;
	
	@Column(name="emp_mobile")
	private String empMobile;
	
	@Column(name="discount_id")
	private int discountId;
	
	@Column(name="discount_head")
	private String discountHead;
	
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

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

    
	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getDiscountHead() {
		return discountHead;
	}

	public void setDiscountHead(String discountHead) {
		this.discountHead = discountHead;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GetEmployee [empId=" + empId + ", empName=" + empName + ", empType=" + empType + ", typeName="
				+ typeName + ", deptId=" + deptId + ", deptName=" + deptName + ", isUsed=" + isUsed + ", empMob="
				+ empMobile + ", discountId=" + discountId + ", discountHead=" + discountHead + ", empDob=" + empDob
				+ ", empDoj=" + empDoj + ", empFamMemb=" + empFamMemb + ", monthlyLimit=" + monthlyLimit
				+ ", yearlyLimit=" + yearlyLimit + ", delStatus=" + delStatus + "]";
	}
}

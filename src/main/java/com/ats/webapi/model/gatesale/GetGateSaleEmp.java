package com.ats.webapi.model.gatesale;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetGateSaleEmp implements Serializable{

	@Transient
	private String message;
	
	@Transient
	private boolean isError;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
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
	
	@Column(name="discount_head")
	private String discountHead;
	
	@Column(name="discount_per")
	private float discountPer;
	
	@Column(name="monthly_limit")
	private int monthlyLimit;
	
	@Column(name="yearly_limit")
	private int yearlyLimit;
	
	@Column(name="monthly_consumed")
	private int monthlyConsumed;
	
	@Column(name="yearly_consumed")
	private int yearlyConsumed;
	
	@Column(name="del_status")
	private int delStatus;

	
	public int getMonthlyConsumed() {
		return monthlyConsumed;
	}

	public void setMonthlyConsumed(int monthlyConsumed) {
		this.monthlyConsumed = monthlyConsumed;
	}

	public int getYearlyConsumed() {
		return yearlyConsumed;
	}

	public void setYearlyConsumed(int yearlyConsumed) {
		this.yearlyConsumed = yearlyConsumed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
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

	public String getDiscountHead() {
		return discountHead;
	}

	public void setDiscountHead(String discountHead) {
		this.discountHead = discountHead;
	}

	public float getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(float discountPer) {
		this.discountPer = discountPer;
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
		return "GetGateSaleEmp [message=" + message + ", isError=" + isError + ", empId=" + empId + ", empName="
				+ empName + ", deptId=" + deptId + ", deptName=" + deptName + ", isUsed=" + isUsed + ", empType="
				+ empType + ", empMobile=" + empMobile + ", empDob=" + empDob + ", empDoj=" + empDoj + ", empFamMemb="
				+ empFamMemb + ", discId=" + discId + ", discountHead=" + discountHead + ", discountPer=" + discountPer
				+ ", monthlyLimit=" + monthlyLimit + ", yearlyLimit=" + yearlyLimit + ", monthlyConsumed="
				+ monthlyConsumed + ", yearlyConsumed=" + yearlyConsumed + ", delStatus=" + delStatus + "]";
	}

	
    
}

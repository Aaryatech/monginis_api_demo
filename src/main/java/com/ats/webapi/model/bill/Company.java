package com.ats.webapi.model.bill;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="m_company")
public class Company implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="comp_id")
	private int compId;
	
	@Column(name="comp_name")
	private String compName;
	
	@Column(name="fact_address")
	private String factAddress;
	
	@Column(name="phone_no1")
	private String phoneNo1;
	
	@Column(name="phone_no2")
	private String phoneNo2;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gstin")
	private String gstin;
	
	@Column(name="state_code")
	private int stateCode;
	
	@Column(name="state")
	private String state;
	
	@Column(name="cinNo")
	private String cinNo;
	
	@Column(name="fda_declaration")
	private String fdaDeclaration;
	
	@Column(name="fda_licence_no")
	private String fdaLicenceNo;
	
	@Column(name="from_date")
	private String fromDate;
	
	@Column(name="to_date")
	private String toDate;

	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="pan_no")
	private String panNo;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	@Column(name="ex_var3")
	private String exVar3;
	
	@Column(name="ex_var4")
	private String exVar4;
	
	@Column(name="ex_var5")
	private String exVar5;
	
	@Column(name="ex_var6")
	private String exVar6;

	
	
	public String getPanNo() {
		return panNo;
	}

	public String getExVar1() {
		return exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public String getExVar3() {
		return exVar3;
	}

	public String getExVar4() {
		return exVar4;
	}

	public String getExVar5() {
		return exVar5;
	}

	public String getExVar6() {
		return exVar6;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public void setExVar3(String exVar3) {
		this.exVar3 = exVar3;
	}

	public void setExVar4(String exVar4) {
		this.exVar4 = exVar4;
	}

	public void setExVar5(String exVar5) {
		this.exVar5 = exVar5;
	}

	public void setExVar6(String exVar6) {
		this.exVar6 = exVar6;
	}

	public int getCompId() {
		return compId;
	}

	public String getCompName() {
		return compName;
	}

	public String getFactAddress() {
		return factAddress;
	}

	public String getPhoneNo1() {
		return phoneNo1;
	}

	public String getPhoneNo2() {
		return phoneNo2;
	}

	public String getEmail() {
		return email;
	}

	public String getGstin() {
		return gstin;
	}

	public int getStateCode() {
		return stateCode;
	}

	public String getState() {
		return state;
	}

	public String getCinNo() {
		return cinNo;
	}

	public String getFdaDeclaration() {
		return fdaDeclaration;
	}

	public String getFdaLicenceNo() {
		return fdaLicenceNo;
	}

	public String getFromDate() {
		return fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public void setFactAddress(String factAddress) {
		this.factAddress = factAddress;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public void setFdaDeclaration(String fdaDeclaration) {
		this.fdaDeclaration = fdaDeclaration;
	}

	public void setFdaLicenceNo(String fdaLicenceNo) {
		this.fdaLicenceNo = fdaLicenceNo;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Company [compId=" + compId + ", compName=" + compName + ", factAddress=" + factAddress + ", phoneNo1="
				+ phoneNo1 + ", phoneNo2=" + phoneNo2 + ", email=" + email + ", gstin=" + gstin + ", stateCode="
				+ stateCode + ", state=" + state + ", cinNo=" + cinNo + ", fdaDeclaration=" + fdaDeclaration
				+ ", fdaLicenceNo=" + fdaLicenceNo + ", fromDate=" + fromDate + ", toDate=" + toDate + ", delStatus="
				+ delStatus + ", panNo=" + panNo + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3
				+ ", exVar4=" + exVar4 + ", exVar5=" + exVar5 + ", exVar6=" + exVar6 + "]";
	}
    
}

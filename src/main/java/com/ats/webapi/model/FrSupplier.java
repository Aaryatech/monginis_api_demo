package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fr_supplier")
public class FrSupplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="supp_id")
	private int suppId;
	
	@Column(name="supp_name")
	private String suppName;

	@Column(name="supp_addr")
	private String suppAddr;
	 
	@Column(name="supp_city")
	private String suppCity;
	
	@Column(name="is_same_state")
	private int isSameState;
	 
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gstn_no")
	private String gstnNo;
	
	@Column(name="pan_no")
	private String panNo;
	
	@Column(name="supp_fda_lic")
	private String suppFdaLic;
	
	@Column(name="supp_credit_days")
	private int suppCreditDays;
	
	@Column(name="del_status")
	private int delStatus;
	 
	@Column(name="fr_id")
	private int frId;

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppAddr() {
		return suppAddr;
	}

	public void setSuppAddr(String suppAddr) {
		this.suppAddr = suppAddr;
	}

	public String getSuppCity() {
		return suppCity;
	}

	public void setSuppCity(String suppCity) {
		this.suppCity = suppCity;
	}

	public int getIsSameState() {
		return isSameState;
	}

	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGstnNo() {
		return gstnNo;
	}

	public void setGstnNo(String gstnNo) {
		this.gstnNo = gstnNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getSuppFdaLic() {
		return suppFdaLic;
	}

	public void setSuppFdaLic(String suppFdaLic) {
		this.suppFdaLic = suppFdaLic;
	}

	public int getSuppCreditDays() {
		return suppCreditDays;
	}

	public void setSuppCreditDays(int suppCreditDays) {
		this.suppCreditDays = suppCreditDays;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	@Override
	public String toString() {
		return "FrSupplier [suppId=" + suppId + ", suppName=" + suppName + ", suppAddr=" + suppAddr + ", suppCity="
				+ suppCity + ", isSameState=" + isSameState + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", gstnNo=" + gstnNo + ", panNo=" + panNo + ", suppFdaLic=" + suppFdaLic + ", suppCreditDays="
				+ suppCreditDays + ", delStatus=" + delStatus + ", frId=" + frId + "]";
	}
	
	

}

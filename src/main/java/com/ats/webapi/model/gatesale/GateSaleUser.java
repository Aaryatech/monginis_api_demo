package com.ats.webapi.model.gatesale;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_gatesale_user")
public class GateSaleUser implements Serializable{

	@Transient
	private String message;
	@Transient
	private boolean isError;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_type")
	private int userType;
	
	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="email_id")
	private String emailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="token")
	private String token;
	
	@Column(name="del_status")
	private int delStatus;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GateSaleUser [message=" + message + ", isError=" + isError + ", userId=" + userId + ", userName="
				+ userName + ", userType=" + userType + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", password=" + password + ", empId=" + empId + ", token=" + token + ", delStatus=" + delStatus + "]";
	}

}

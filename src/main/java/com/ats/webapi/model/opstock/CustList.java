package com.ats.webapi.model.opstock;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CustList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_phone")
	private String userPhone;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_gst_no")
	private String userGstNo;

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGstNo() {
		return userGstNo;
	}

	public void setUserGstNo(String userGstNo) {
		this.userGstNo = userGstNo;
	}

	@Override
	public String toString() {
		return "CustList [userPhone=" + userPhone + ", userName=" + userName + ", userGstNo=" + userGstNo + "]";
	}

}

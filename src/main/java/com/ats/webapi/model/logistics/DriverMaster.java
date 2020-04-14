package com.ats.webapi.model.logistics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_logis_driver")
public class DriverMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driver_id")
	private int driverId;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "mobile1")
	private String mobile1;

	@Column(name = "mobile2")
	private String mobile2;

	@Column(name = "mobile3")
	private String mobile3;

	@Column(name = "driver_dob")
	private Date driverDob;

	@Column(name = "joining_date")
	private Date joiningDate;

	@Column(name = "lic_no")
	private String licNo;

	@Column(name = "lic_expire_date")
	private Date licExpireDate;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "string1")
	private String string1;

	@Column(name = "string2")
	private String string2;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getMobile3() {
		return mobile3;
	}

	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDriverDob() {
		return driverDob;
	}

	public void setDriverDob(Date driverDob) {
		this.driverDob = driverDob;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getLicNo() {
		return licNo;
	}

	public void setLicNo(String licNo) {
		this.licNo = licNo;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLicExpireDate() {
		return licExpireDate;
	}

	public void setLicExpireDate(Date licExpireDate) {
		this.licExpireDate = licExpireDate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	@Override
	public String toString() {
		return "DriverMaster [driverId=" + driverId + ", driverName=" + driverName + ", address1=" + address1
				+ ", address2=" + address2 + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", mobile3=" + mobile3
				+ ", driverDob=" + driverDob + ", joiningDate=" + joiningDate + ", licNo=" + licNo + ", licExpireDate="
				+ licExpireDate + ", delStatus=" + delStatus + ", string1=" + string1 + ", string2=" + string2 + "]";
	}

}

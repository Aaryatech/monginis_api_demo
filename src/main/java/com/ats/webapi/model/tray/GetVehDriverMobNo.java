package com.ats.webapi.model.tray;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetVehDriverMobNo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tran_id")
	private int tranId;
	
	@Column(name="veh_no")
	private String vehNo;
	
	
	@Column(name="driver_name")
	private String driverName;
	
	
	@Column(name="mobile1")
	private String mobile1;
	
	@Column(name="mobile2")
	private String mobile2;
	
	@Column(name="route_name")
	private String routeName;
	
	@Column(name="tran_date")
	private Date tranDate;

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
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

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	@Override
	public String toString() {
		return "GetVehDriverMobNo [tranId=" + tranId + ", vehNo=" + vehNo + ", driverName=" + driverName + ", mobile1="
				+ mobile1 + ", mobile2=" + mobile2 + ", routeName=" + routeName + ", tranDate=" + tranDate + "]";
	}
	

}

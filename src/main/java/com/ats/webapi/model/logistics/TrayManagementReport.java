package com.ats.webapi.model.logistics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TrayManagementReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tran_id")
	private int tranId; 
	
	@Column(name = "tran_date")
	private Date tranDate;
	
	@Column(name = "veh_id")
	private int vehId;
	
	@Column(name = "veh_no")
	private String vehNo;
	
	@Column(name = "drv_id")
	private int drvId;
	
	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "route_id")
	private int routeId;

	@Column(name = "route_name")
	private String routeName;
	
	@Column(name = "veh_running_km")
	private float vehRunningKm;
	
	@Column(name = "diesel")
	private float diesel;

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public int getDrvId() {
		return drvId;
	}

	public void setDrvId(int drvId) {
		this.drvId = drvId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public float getVehRunningKm() {
		return vehRunningKm;
	}

	public void setVehRunningKm(float vehRunningKm) {
		this.vehRunningKm = vehRunningKm;
	}

	public float getDiesel() {
		return diesel;
	}

	public void setDiesel(float diesel) {
		this.diesel = diesel;
	}

	@Override
	public String toString() {
		return "TrayManagementReport [tranId=" + tranId + ", tranDate=" + tranDate + ", vehId=" + vehId + ", vehNo="
				+ vehNo + ", drvId=" + drvId + ", driverName=" + driverName + ", routeId=" + routeId + ", routeName="
				+ routeName + ", vehRunningKm=" + vehRunningKm + ", diesel=" + diesel + "]";
	} 
	
	
	
	 

}

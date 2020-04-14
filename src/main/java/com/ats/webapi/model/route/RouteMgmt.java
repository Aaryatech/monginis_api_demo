package com.ats.webapi.model.route;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_route_tray_mgmt")
public class RouteMgmt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "route_tray_id")
	private int routeTrayId;

	@Column(name = "route_name")
	private String routeName;

	@Column(name = "route_type")
	private int routeType;

	@Column(name = "fr_ids")
	private String frIds;

	@Column(name = "sr_no")
	private int srNo;

	@Column(name = "is_same_day")
	private int isSameDay;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	public int getRouteTrayId() {
		return routeTrayId;
	}

	public void setRouteTrayId(int routeTrayId) {
		this.routeTrayId = routeTrayId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getFrIds() {
		return frIds;
	}

	public void setFrIds(String frIds) {
		this.frIds = frIds;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public int getIsSameDay() {
		return isSameDay;
	}

	public void setIsSameDay(int isSameDay) {
		this.isSameDay = isSameDay;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	@Override
	public String toString() {
		return "RouteMgmt [routeTrayId=" + routeTrayId + ", routeName=" + routeName + ", routeType=" + routeType
				+ ", frIds=" + frIds + ", srNo=" + srNo + ", isSameDay=" + isSameDay + ", delStatus=" + delStatus
				+ ", isActive=" + isActive + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + "]";
	}

	public int getRouteType() {
		return routeType;
	}

	public void setRouteType(int routeType) {
		this.routeType = routeType;
	}

}

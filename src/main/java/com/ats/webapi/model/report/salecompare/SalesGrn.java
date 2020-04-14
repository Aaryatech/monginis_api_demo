package com.ats.webapi.model.report.salecompare;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class SalesGrn {

	@Id
	private int frId;
	
	private	int month;
	
	private	String monthName;
	
	private	String routeName;
	
	private	String frName;
	
	private	int frRouteId;
	
	private	float billTotal;

	public int getFrId() {
		return frId;
	}

	public int getMonth() {
		return month;
	}

	public String getMonthName() {
		return monthName;
	}

	public String getRouteName() {
		return routeName;
	}

	public String getFrName() {
		return frName;
	}

	public int getFrRouteId() {
		return frRouteId;
	}

	public float getBillTotal() {
		return billTotal;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public void setFrRouteId(int frRouteId) {
		this.frRouteId = frRouteId;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}

	@Override
	public String toString() {
		return "SalesGrn [frId=" + frId + ", month=" + month + ", monthName=" + monthName + ", routeName=" + routeName
				+ ", frName=" + frName + ", frRouteId=" + frRouteId + ", billTotal=" + billTotal + "]";
	}
	
	
}

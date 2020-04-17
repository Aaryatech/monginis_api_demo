package com.ats.webapi.model.saledashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RouteWiseSaleForDash {

	@Id
	private int routeId;
	private String routeName;
	private float sale;
	private float saleQty;

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

	public float getSale() {
		return sale;
	}

	public void setSale(float sale) {
		this.sale = sale;
	}

	public float getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(float saleQty) {
		this.saleQty = saleQty;
	}

	@Override
	public String toString() {
		return "RouteWiseSaleForDash [routeId=" + routeId + ", routeName=" + routeName + ", sale=" + sale + ", saleQty="
				+ saleQty + "]";
	}

}

package com.ats.webapi.model;

import java.util.List;

public class SpCakeOrdersList {
	List<SpCakeOrders> spCakeOrders;
	Info info;
	public List<SpCakeOrders> getSpCakeOrders() {
		return spCakeOrders;
	}
	public void setSpCakeOrders(List<SpCakeOrders> spCakeOrders) {
		this.spCakeOrders = spCakeOrders;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "SpCakeOrdersList [spCakeOrders=" + spCakeOrders + ", info=" + info + "]";
	}
	
	

}

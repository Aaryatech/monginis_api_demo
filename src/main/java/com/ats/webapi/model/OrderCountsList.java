package com.ats.webapi.model;

import java.util.List;

public class OrderCountsList {
	List<OrderCounts> orderCount;
	Info info;
	public List<OrderCounts> getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(List<OrderCounts> orderCount) {
		this.orderCount = orderCount;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "OrderCountsList [orderCount=" + orderCount + ", info=" + info + "]";
	}
	
	

}

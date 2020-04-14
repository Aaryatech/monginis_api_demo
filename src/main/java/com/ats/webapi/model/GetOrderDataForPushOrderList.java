package com.ats.webapi.model;

import java.util.List;

public class GetOrderDataForPushOrderList {
	
	List<GetOrderDataForPushOrder> orderDataForPushOrder;
	
	
	Info info;


	public List<GetOrderDataForPushOrder> getOrderDataForPushOrder() {
		return orderDataForPushOrder;
	}


	public Info getInfo() {
		return info;
	}


	public void setOrderDataForPushOrder(List<GetOrderDataForPushOrder> orderDataForPushOrder) {
		this.orderDataForPushOrder = orderDataForPushOrder;
	}


	public void setInfo(Info info) {
		this.info = info;
	}
	
	

}

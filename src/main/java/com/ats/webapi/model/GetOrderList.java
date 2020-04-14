package com.ats.webapi.model;

import java.util.List;

public class GetOrderList {
	 List<GetOrder> getOrder;
	Info info;
	public List<GetOrder> getGetOder() {
		return getOrder;
	}
	public void setGetOrder(List<GetOrder> getOder) {
		this.getOrder = getOder;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "GetOrderList [getOder=" + getOrder + ", info=" + info + "]";
	}
	
	

}

package com.ats.webapi.model;

import java.util.List;

public class SpHistoryExBill {

	List<SpCkOrderHis> spCakeOrder=null;
	
	List<GetRegSpCakeOrders> regularSpCkOrders=null;

	public List<SpCkOrderHis> getSpCakeOrder() {
		return spCakeOrder;
	}

	public void setSpCakeOrder(List<SpCkOrderHis> spCakeOrder) {
		this.spCakeOrder = spCakeOrder;
	}

	public List<GetRegSpCakeOrders> getRegularSpCkOrders() {
		return regularSpCkOrders;
	}

	public void setRegularSpCkOrders(List<GetRegSpCakeOrders> regularSpCkOrders) {
		this.regularSpCkOrders = regularSpCkOrders;
	}
	
	
}

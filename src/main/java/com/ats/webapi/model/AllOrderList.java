package com.ats.webapi.model;

import java.util.List;

public class AllOrderList {

    private List<Order> order = null;

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

	@Override
	public String toString() {
		return "AllOrderList [order=" + order + "]";
	}

    
}

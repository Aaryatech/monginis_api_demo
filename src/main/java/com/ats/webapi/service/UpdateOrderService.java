package com.ats.webapi.service;

import java.util.List;

public interface UpdateOrderService {

	public int updateOrderQty(int orderId,int orderQty);
	public int deleteOrder(List<Integer> orderId);
	}

package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetOrderItemQty;
import com.ats.webapi.model.GetRegSpCakeOrderQty;

public interface GetOrderItemQtyService {

	//GetOrderItemQty getOrderQty(int itemId, String orderDate, int menuId);
	List<GetOrderItemQty> getOrderQty(String productionDate, List<String> menuId);
	
	//GetRegSpCakeOrderQty getRegSpCakeOrderQty(int itemId, String orderDate, int menuId);
	List<GetRegSpCakeOrderQty> getRegSpCakeOrderQty(String productionDate, List<String> menuId);
}

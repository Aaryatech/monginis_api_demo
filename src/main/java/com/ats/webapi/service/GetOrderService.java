package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.GetOrder;
import com.ats.webapi.model.Order;

public interface GetOrderService {
	//public List<Order> findOrder(List<Integer> frId,String itemId,Date date1);
	
	//public List<Order> findOrderForOtherFr(List<Integer> frId,String itemId,Date date1);
	
	
	
	public List<GetOrder> findOrder(List<String>  frId,List<String> menuId,String date);
	
	
	public List<GetOrder> findOrderAllFr(List<String> menuId,String date);
	//public List<GetOrder> findOrder(String itemId);


	public List<GetOrder> findOrderAllFrAndItem(List<String> menuId, String strDate, List<Integer> itemId);


	public List<GetOrder> findOrderByItemId(List<String> frId, List<String> menuId, String strDate,
			List<Integer> itemId);
	
}

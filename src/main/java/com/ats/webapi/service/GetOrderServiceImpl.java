package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetOrder;
import com.ats.webapi.model.Order;
import com.ats.webapi.repository.GetOrderRepository;
import com.ats.webapi.repository.OrdersRepository;
@Service
public class GetOrderServiceImpl implements GetOrderService {
	String jsonOrder="{}";
	Order order;
	@Autowired
	GetOrderRepository orderRepository;
/*	@Override
	public List<GetOrder> findOrder(String itemId) {
		List<GetOrder> orderList;
		//orderList=orderRepository.findAll(itemId);
		return null;
	}*/

	
	@Override
	public List<GetOrder> findOrder(List<String>  frId,List<String> menuId,String date) {
		List<GetOrder> getOrderList=null;
		try {
			getOrderList=orderRepository.findAllNative( frId,menuId, date);
		
		System.out.println("order para 1= "+frId.toString());
		System.out.println("order para 2= "+menuId);
		System.out.println("order para 3 = "+date.toString());
		
		
		}catch (Exception e) {
			System.out.println("inside order service impl ex "+e.getMessage());
		}
		return getOrderList;
	}


	@Override
	public List<GetOrder> findOrderAllFr(List<String> menuId, String date1) {
		List<GetOrder> getOrderList=null;
		try {
			getOrderList=orderRepository.findAllNativeAllFr(menuId, date1);
		
			
		}catch (Exception e) {
			System.out.println("inside order service for all fr impl ex "+e.getMessage());
		}
		return getOrderList;
	}


	@Override
	public List<GetOrder> findOrderAllFrAndItem(List<String> menuId, String date1, List<Integer> itemId) {
		List<GetOrder> getOrderList=null;
		try {
			getOrderList=orderRepository.findAllNativeAllFrByItem(menuId, date1,itemId);
		
			
		}catch (Exception e) {
			System.out.println("inside order service for all fr impl ex "+e.getMessage());
		}
		return getOrderList;
	}


	@Override
	public List<GetOrder> findOrderByItemId(List<String> frId, List<String> menuId, String date,
			List<Integer> itemId) {
		List<GetOrder> getOrderList=null;
		try {
			getOrderList=orderRepository.findAllNativeByItemId( frId,menuId, date,itemId);
		
		
		}catch (Exception e) {
			System.out.println("inside order service impl ex "+e.getMessage());
		}
		return getOrderList;
	}



}

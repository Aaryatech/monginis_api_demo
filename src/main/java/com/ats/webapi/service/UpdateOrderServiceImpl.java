package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.UpdateOrder;
import com.ats.webapi.repository.UpdateOrdersRepository;

@Service
public class UpdateOrderServiceImpl implements UpdateOrderService {
  
	
	UpdateOrder updateOrder;
	@Autowired
	UpdateOrdersRepository updateOrdersRepository;
	

	
	@Override
	public int updateOrderQty(int orderId,int orderQty) {

		int x=	updateOrdersRepository.updateOrderQty(orderId,orderQty);
			
			
			return x;
	}



	@Override
	public int deleteOrder(List<Integer> orderId) {
		int x=	updateOrdersRepository.deleteOrder(orderId);
		
		
		return x;
	}
	
	
}

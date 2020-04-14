package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.OrderCounts;
import com.ats.webapi.repository.OrderCountsRepository;

@Service
public class OrderCountsServiceImpl implements OrderCountsService {
	
	@Autowired
	OrderCountsRepository orderCountRepository;
	

	@Override
	public List<OrderCounts> findOrderCount(String cDate) {
		List<OrderCounts> orderCounts=orderCountRepository.getOrderTotal(cDate);
		
		
		return orderCounts;
	}

}

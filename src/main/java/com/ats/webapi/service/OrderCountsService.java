package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import com.ats.webapi.model.OrderCounts;

public interface OrderCountsService {
	
	List<OrderCounts> findOrderCount(String cDate);

}

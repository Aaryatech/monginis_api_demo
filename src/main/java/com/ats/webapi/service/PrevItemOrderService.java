package com.ats.webapi.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.ats.webapi.model.Order;
import com.ats.webapi.model.Orders;

public interface PrevItemOrderService {

	   public List<Orders> findFrItemOrders( List<Integer>items , String frId, String date, String menuId );

	
}

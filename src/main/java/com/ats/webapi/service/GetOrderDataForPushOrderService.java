package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import com.ats.webapi.model.GetOrderDataForPushOrderList;

public interface GetOrderDataForPushOrderService {

	
	GetOrderDataForPushOrderList getOrderDataForPushOrder(Date cDate,int grnType,List<String> frIdList);
	
}

package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.GetSpCakeOrders;
import com.ats.webapi.model.GetSpCkOrder;
import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersBean;

public interface SpCkOrdersService {
	public List<SpCakeOrdersBean> findSpCakeOrder(List<Integer> spMenuId,List<Integer> frId,String prodDate);
	
	public List<SpCakeOrdersBean> findSpCakeOrderAllFr(List<Integer> spMenuId,String prodDate);

	public List<GetSpCakeOrders> getSpCakeOrder(List<String> spOrderNo);

	public List<GetSpCkOrder> getSpCkOrder(List<String> spOrderNo);
	

}

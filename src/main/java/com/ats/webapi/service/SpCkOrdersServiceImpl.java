package com.ats.webapi.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetSpCakeOrders;
import com.ats.webapi.model.GetSpCkOrder;
import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersBean;
import com.ats.webapi.repository.GetSpCakeOrderRepository;
import com.ats.webapi.repository.GetSpCakeOrdersRepository;
import com.ats.webapi.repository.SpCakeOrdersRepoAdmin;
import com.ats.webapi.repository.SpCakeOrdersRepository;

@Service
public class SpCkOrdersServiceImpl implements SpCkOrdersService {
	
	
	String jsonSpCakeOrder="{}";
	//SpCakeOrders spCakeOrders;
	@Autowired
	SpCakeOrdersRepoAdmin spCakeOrdersRepository;
	
	@Autowired
	GetSpCakeOrdersRepository getSpCakeOrdersRepository;
	
    @Autowired
    GetSpCakeOrderRepository getSpCakeOrderRepository;
    
	@Override
	public List<SpCakeOrdersBean> findSpCakeOrder(List<Integer> spMenuId,List<Integer> frId, String prodDate) {
		List<SpCakeOrdersBean> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.FindAllSpCakeOrder(spMenuId,frId, prodDate);
					
		
		}catch (Exception e) {
			System.out.println("inside sp cake order service impl ex"+e.getMessage());
		}
		return spCakeOrders;
	}


	@Override
	public List<SpCakeOrdersBean> findSpCakeOrderAllFr(List<Integer> spMenuId,String prodDate) {
		
		List<SpCakeOrdersBean> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.FindAllSpCakeOrderAllFr(spMenuId,prodDate);
					
		
		}catch (Exception e) {
			System.out.println("inside sp cake order service impl ex"+e.getMessage());
		}
		return spCakeOrders;
		
		
	}


	@Override
	public List<GetSpCakeOrders> getSpCakeOrder(List<String> spOrderNo) {
		 
	return getSpCakeOrdersRepository.getSpCakeOrders(spOrderNo);
		
	}


	@Override
	public List<GetSpCkOrder> getSpCkOrder(List<String> spOrderNo) {
		
		return getSpCakeOrderRepository.getSpCakeOrder(spOrderNo);
	}
	}



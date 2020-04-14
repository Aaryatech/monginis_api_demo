package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ats.webapi.model.GetDumpOrder;
import com.ats.webapi.model.GetDumpOrderList;
import com.ats.webapi.repository.GetDumpOrderRepository;
@Service
public class GerDumpOrderServiceImpl implements GetDumpOrderService {

	@Autowired
	GetDumpOrderRepository orderDumpRepository;
	@Override
	public List<GetDumpOrder> findFrOrder(List<String> frId, String menuId, String date) {
		
		List<GetDumpOrder> getDumpOrderList=orderDumpRepository.findAllNativeFrOrder( frId,menuId, date);
		
		System.out.println("order  Fr id= "+frId);
		System.out.println("order Menu ID= "+menuId);
		System.out.println("order Date = "+date);
		

		
		
		return getDumpOrderList;
	}

}

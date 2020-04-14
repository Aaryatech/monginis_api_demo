package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetSellBillHeader;
import com.ats.webapi.repository.GetSellBillHeaderRepository;
@Service
public class GetSellBillHeaderServiceImpl implements GetSellBillHeaderService {

	@Autowired
	GetSellBillHeaderRepository getSellBillHeaderRepository;
	@Override
	public List<GetSellBillHeader> getSellBillHeader(String fromDate, String toDate, List<String> frId) {


		List<GetSellBillHeader> getSellBillHeaderList=getSellBillHeaderRepository.getFrSellBillHeader(fromDate, toDate, frId);
		
		
		
		return getSellBillHeaderList;
	}

}

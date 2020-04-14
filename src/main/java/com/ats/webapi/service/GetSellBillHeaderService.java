package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetSellBillHeader;

public interface GetSellBillHeaderService {
	
	List<GetSellBillHeader> getSellBillHeader(String fromDate, String toDate, List<String> frId);

}

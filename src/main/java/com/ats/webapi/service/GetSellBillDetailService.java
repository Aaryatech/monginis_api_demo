package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetSellBillDetail;
public interface GetSellBillDetailService {

	
	List<GetSellBillDetail> getSellBillDetail(int sellBillNo);
}

package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetSellBillDetail;
import com.ats.webapi.repository.GetSellBillDetailRepository;

@Service
public class GetSellBillDetailServiceImpl implements GetSellBillDetailService{

	
	@Autowired
	GetSellBillDetailRepository getSellBillDetailRepository;
	@Override
	public List<GetSellBillDetail> getSellBillDetail(int sellBillNo) {


		List<GetSellBillDetail> getSellBillDetailList=getSellBillDetailRepository.getFrSellBillDetail(sellBillNo);
		
		
		
		return getSellBillDetailList;
	}

}

package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.PostBillDetail;
import com.ats.webapi.repository.GetBillDetailOnlyRepository;

@Service
public class GetBillDetailOnlyServiceImpl implements GetBillDetailOnlyService {
	
	@Autowired
	GetBillDetailOnlyRepository billDetailOnlyRepository;

	@Override
	public PostBillDetail getByBillDetailNo(int billDetailNo) {
	
		PostBillDetail postBillDetail=billDetailOnlyRepository.getByBillDetailNo(billDetailNo);
		
		return postBillDetail;
	}
	
	
	

}

package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.DeleteBill;
import com.ats.webapi.repository.DeleteBillRepository;

@Service
public class DeleteBillServiceImpl implements DeleteBillService{
	
	@Autowired
	DeleteBillRepository deleteBillRepository;

	@Override
	public int deleteBill(int delStatus, int billNo) {
		
		
		int x=deleteBillRepository.deleteBill(1, billNo);
		
		return x;
	}

	

}

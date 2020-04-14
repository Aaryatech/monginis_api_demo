package com.ats.webapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetBillHeader;
import com.ats.webapi.model.GetBillHeaderList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.UpdateBillStatus;


public interface GetBillHeaderService {
	
	GetBillHeaderList getBillHeader(List<String>frId, String fromDate, String toDate);
	
	GetBillHeaderList getBillHeaderForAllFr(String fromDate, String toDate);
	 

	UpdateBillStatus updateBillStatus(UpdateBillStatus updateBillStatus);

	
	
	
}

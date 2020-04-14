package com.ats.webapi.service;

import com.ats.webapi.model.GetBillDetailsList;

public interface GetBillDetailsService {
	
	GetBillDetailsList getBillDetailList(int billNo);
	
}

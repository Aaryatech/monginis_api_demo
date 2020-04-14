package com.ats.webapi.service;

import com.ats.webapi.model.DeleteBill;

public interface BillDetailUpdateService {
	
	DeleteBill updateBillDetail(int billDetailNo,int billQty,float total, float totWithoutTax);
 
}

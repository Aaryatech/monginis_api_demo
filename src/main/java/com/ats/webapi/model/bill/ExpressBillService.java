package com.ats.webapi.model.bill;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.SellBillDataCommon;
import com.ats.webapi.model.SellBillDetail;
import com.ats.webapi.model.SellBillDetailList;
import com.ats.webapi.model.SellBillHeader;

@Service
public interface ExpressBillService {

	SellBillDataCommon showNotDayClosedRecord(int frId);

	SellBillDetailList getSellBillDetails(int billNo);

	SellBillHeader saveSellBillHeader(SellBillHeader sellBillHeader);

	SellBillDetail saveSellBillDetail(SellBillDetail sellBillDetail);

	
	SellBillHeader getSellBillHeaderBysellBillNo(int sellBillNo);
	
	int deleteBillDetail(int sellBillDetailNo);

	GetItemHsnCode getItemHsnCode(int itemId);
	
	
	//delete sell bill Header if its details are empty //10 Feb Sachin
	
	int deleteSellBillHeader(int sellBillNo);
	
	
	
	

	
	
}

package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import com.ats.webapi.model.GetBillsForFr;
import com.ats.webapi.model.GetBillsForFrList;

public interface GetBillsForFrService {
	
	GetBillsForFrList getBillForFr(int frId,Date back15Days,Date curDate);
	
	GetBillsForFrList getBillForFrByDate(int frId,Date billDate);
	
	GetBillsForFrList	getAllBillForManGrnBackEnd(int frId);
	
}

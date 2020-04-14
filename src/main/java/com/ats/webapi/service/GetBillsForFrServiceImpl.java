package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetBillsForFr;
import com.ats.webapi.model.GetBillsForFrList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GetBillsForFrRepository;

@Service
public class GetBillsForFrServiceImpl implements GetBillsForFrService  {
	
	@Autowired
	GetBillsForFrRepository getBillsForFrRepository;

	@Override
	public GetBillsForFrList getBillForFr(int frId,Date back15Days,Date curDate) {
		
		GetBillsForFrList billsForFrList=new GetBillsForFrList();
		try {
		List<GetBillsForFr> getBillForFr=getBillsForFrRepository.getBillForSelectedFr(frId, back15Days, curDate);
		
		Info info=new Info();
		
		if(getBillForFr!=null) {
		
			billsForFrList.setGetBillsForFr(getBillForFr);
			
			info.setError(false);
			info.setMessage("bills for Fr received successfully");
		
		}
		
		else {
			
			info.setError(true);
			info.setMessage("Error !: bills for Fr not received ");
			
		}
		
		billsForFrList.setInfo(info);
		}catch (Exception e) {
			System.out.println("Ex in Getting bIll for Fr Id "+e.getMessage());
			
			e.printStackTrace();
		}
		return billsForFrList;
	}

	@Override
	public GetBillsForFrList getBillForFrByDate(int frId, Date billDate) {
		GetBillsForFrList billsForFrList=new GetBillsForFrList();
		try {
		List<GetBillsForFr> getBillForFr=getBillsForFrRepository.getBillForSelectedFrByDate(frId, billDate);
		
		Info info=new Info();
		
		if(getBillForFr!=null) {
		
			billsForFrList.setGetBillsForFr(getBillForFr);
			
			info.setError(false);
			info.setMessage("bills for Fr received successfully");
		
		}
		
		else {
			
			info.setError(true);
			info.setMessage("Error !: bills for Fr not received ");
			
		}
		
		billsForFrList.setInfo(info);
		}catch (Exception e) {
			System.out.println("Ex in Getting bIll for Fr Id "+e.getMessage());
			
			e.printStackTrace();
		}
		return billsForFrList;
	}

	@Override
	public GetBillsForFrList getAllBillForManGrnBackEnd(int frId) {
		GetBillsForFrList billsForFrList=new GetBillsForFrList();
		try {
			
		List<GetBillsForFr> getBillForFr=getBillsForFrRepository.getAllBillForManGrn(frId);
		
		Info info=new Info();
		
		if(getBillForFr!=null) {
		
			billsForFrList.setGetBillsForFr(getBillForFr);
			
			info.setError(false);
			info.setMessage("bills for Fr received successfully");
		
		}
		
		else {
			
			info.setError(true);
			info.setMessage("Error !: bills for Fr not received ");
			
		}
		
		billsForFrList.setInfo(info);
		}catch (Exception e) {
			System.out.println("Ex in Getting bIll for Fr Id "+e.getMessage());
			
			e.printStackTrace();
		}
		return billsForFrList;
	}


}

package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.SellBillDetail;
import com.ats.webapi.model.SellBillHeader;
import com.ats.webapi.repository.SellBillDetailRepository;
import com.ats.webapi.repository.SellBillHeaderRepository;

@Service
public class SellBillDataServiceImpl implements SellBillDataService{

	@Autowired
	SellBillHeaderRepository sellBillHeaderRepository;
	
	@Autowired
	SellBillDetailRepository sellBillDetailRepository;
	
	public SellBillHeader saveSellBillHeader(SellBillHeader sellBillHeader) {
		
		

		SellBillHeader sellBillHeaderRes=new SellBillHeader();
		
		try {	 
			
		sellBillHeaderRes=sellBillHeaderRepository.save(sellBillHeader);
	     int sellBillNo=sellBillHeaderRes.getSellBillNo();
			 
		           List<SellBillDetail> sellBillDetailList=sellBillHeaderRes.getSellBillDetailsList();
		           List<SellBillDetail> sellBillDetailRes=new ArrayList<SellBillDetail>();
		           if(sellBillDetailList!=null) {
		        	   
		             for(int j=0;j<sellBillDetailList.size();j++) {
			
		             	   SellBillDetail sellBillDetail=sellBillDetailList.get(j);
			
			               sellBillDetail.setSellBillNo(sellBillNo);
						
			               sellBillDetail=sellBillDetailRepository.save(sellBillDetail);
			               sellBillDetailRes.add(sellBillDetail);
		            }
		           }
		       sellBillHeaderRes.setSellBillDetailsList(sellBillDetailRes);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return sellBillHeaderRes;
	}
	

}

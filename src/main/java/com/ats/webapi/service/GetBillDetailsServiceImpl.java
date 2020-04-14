package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetBillDetails;
import com.ats.webapi.model.GetBillDetailsList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GetBillDetailsRepository;

@Service
public class GetBillDetailsServiceImpl implements GetBillDetailsService {
	
	@Autowired
	GetBillDetailsRepository getBillDetailsRepository;

	@Override
	public GetBillDetailsList getBillDetailList(int billNo) {
	
		GetBillDetailsList billDetailsList=new GetBillDetailsList();
		
		List<GetBillDetails> getBillDetails=getBillDetailsRepository.showBillDetails(billNo);
		
		Info info=new Info();
		
		
		if(getBillDetails!=null) {
			
			billDetailsList.setGetBillDetails(getBillDetails);
			
			info.setError(false);
			info.setMessage("Bill details List received successfully");
			
			billDetailsList.setInfo(info);
			
		}
		else {
			
			info.setError(true);
			info.setMessage("Error : Bill Details List not received");
			billDetailsList.setInfo(info);
			
			
		}
		
		
		
		return billDetailsList;
	}
	


}

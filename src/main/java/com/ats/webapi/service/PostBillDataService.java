package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.PostBillDetail;
import com.ats.webapi.model.PostBillHeader;

public interface PostBillDataService {
	
	//List<PostBillDetail> saveBillDetails(List<PostBillDetail> postBillDetail);
	
	List<PostBillHeader> saveBillHeader(List<PostBillHeader> postBillHeader);

	
	List<PostBillHeader> updateBillHeader(List<PostBillHeader> postBillHeader);


}

package com.ats.webapi.service;

import com.ats.webapi.model.PostBillDetail;

public interface GetBillDetailOnlyService {
	
	PostBillDetail getByBillDetailNo(int billDetailNo);

}

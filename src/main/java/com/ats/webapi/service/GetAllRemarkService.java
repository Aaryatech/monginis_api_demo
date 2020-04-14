package com.ats.webapi.service;

import com.ats.webapi.model.remarks.GetAllRemarksList;

public interface GetAllRemarkService {
	
	GetAllRemarksList getAllRemarkFor(int isFrUsed, int moduleId, int subModuleId);
	

}

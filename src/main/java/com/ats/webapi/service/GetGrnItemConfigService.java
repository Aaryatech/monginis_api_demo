package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.GetGrnItemConfigList;

public interface GetGrnItemConfigService {
	
	
	GetGrnItemConfigList getAllGrnItemConfiguration(String cDate,int frId);
	
	GetGrnItemConfigList getGvnItemConfig(int billNo);
	
	//21 March Front end Manual GRN
	GetGrnItemConfigList getItemForManualGrn(int billNo,int frId);

}

package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.FrItemStockConfigure;
import com.ats.webapi.model.FrItemStockConfigureList;

public interface FrItemStockConfigureService {
	
	 public List<FrItemStockConfigure> getFrItemConfigure();

	public int findTotalAvailableSlot();
	public int findProductionTimeSlot();
	
	public int findbykey(String key);
	
	
	 public FrItemStockConfigureList findBySettingKeyList(List<String> settingKeyList);

	public int getPoNo();
 
}
;
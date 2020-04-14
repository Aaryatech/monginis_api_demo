package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetFrItemStockConfiguration;

public interface GetFrItemStockConfigurationService {
	
	public List<GetFrItemStockConfiguration> getAllFrItemConfPost(List<String> itemId);
	
	

}

package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetFrItemStockConfiguration;
import com.ats.webapi.repository.GetFrItemStockConfigurationRepository;

@Service
public class GetFrItemStockConfigurationServiceImpl implements GetFrItemStockConfigurationService {
	
	@Autowired
	GetFrItemStockConfigurationRepository frItemStockConfigurationRepository;

	@Override
	public List<GetFrItemStockConfiguration> getAllFrItemConfPost(List<String> itemId) {
		
List<GetFrItemStockConfiguration> frItemStockConfigurePosts=frItemStockConfigurationRepository.findByItemId(itemId);
		
		
		return frItemStockConfigurePosts;
		
	}

}

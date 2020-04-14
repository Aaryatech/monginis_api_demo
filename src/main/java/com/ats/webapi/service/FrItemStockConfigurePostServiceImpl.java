package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

//import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.FrItemStockConfigurePost;
import com.ats.webapi.model.GetFrItemStockConfiguration;
import com.ats.webapi.repository.FrItemStockConfigurePostRepository;

@Service
public class FrItemStockConfigurePostServiceImpl implements FrItemStockConfigurePostService {
	
	@Autowired
	FrItemStockConfigurePostRepository frItemStockConfigurePostRepository;

	@Override
	public List<FrItemStockConfigurePost> saveFrItemStockConf(List<FrItemStockConfigurePost> frItemStockConfigureList) {
		
		
		List<FrItemStockConfigurePost> returnList=new ArrayList();
		
		for(FrItemStockConfigurePost frItemStock :frItemStockConfigureList){
			
			FrItemStockConfigurePost frItemConf=frItemStockConfigurePostRepository.save(frItemStock);
			returnList.add(frItemConf);
			
		}
		
		
		return returnList;
	}

	/*
	@Override
	public List<GetFrItemStockConfiguration> getAllFrItemConfPost(List<String> itemId) {
		List<GetFrItemStockConfiguration> frItemStockConfigurePosts=frItemStockConfigurePostRepository.findByItemId(itemId);
		
		
		return frItemStockConfigurePosts;
	}
*/
	
}

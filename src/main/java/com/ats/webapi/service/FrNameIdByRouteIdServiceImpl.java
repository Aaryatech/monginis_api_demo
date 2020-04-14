package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.FrNameIdByRouteId;
import com.ats.webapi.model.FrNameIdByRouteIdList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.FrNameIdByRouteIdRepository;

@Service
public class FrNameIdByRouteIdServiceImpl implements FrNameIdByRouteIdService {
	
	@Autowired
	FrNameIdByRouteIdRepository frNameIdByRouteIdRepository;

	@Override
	public FrNameIdByRouteIdList getFrNameIdByRouteId(int routeId) {
		
		FrNameIdByRouteIdList frNameIdByRouteId=new FrNameIdByRouteIdList();
		
		Info info =new Info();
		
		List<FrNameIdByRouteId> frNameIdByRouteIdList=frNameIdByRouteIdRepository.getFrNameIdByRouteId(routeId);
		
		if(frNameIdByRouteIdList!=null && !frNameIdByRouteIdList.isEmpty() ) {
			
			frNameIdByRouteId.setFrNameIdByRouteIds(frNameIdByRouteIdList);
			
			info.setError(false);
			info.setMessage("successfully received fr Name Id List By route Id");
			
			frNameIdByRouteId.setInfo(info);
			
			
		}
		else {
			
			info.setError(true);
			info.setMessage("Error : failed to receive fr Name Id List using route Id");
			frNameIdByRouteId.setInfo(info);
			
		}
		
		
		
	return frNameIdByRouteId;
	
	}
	
	

}

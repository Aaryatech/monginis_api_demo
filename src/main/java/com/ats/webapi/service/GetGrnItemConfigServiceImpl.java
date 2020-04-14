package com.ats.webapi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetGrnItemConfig;
import com.ats.webapi.model.GetGrnItemConfigList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GetGrnItemConfigRepository;

@Service
public class GetGrnItemConfigServiceImpl implements GetGrnItemConfigService {
	
	@Autowired
	GetGrnItemConfigRepository grnItemConfigRepository;
	
	
	
	

	@Override
	public GetGrnItemConfigList getAllGrnItemConfiguration(String cDate,int frId) {
	
		GetGrnItemConfigList getGrnItemConfigList=new GetGrnItemConfigList();
		
		Info info=new Info();
		try {
		
		List<GetGrnItemConfig> getGrnItemConfigs=grnItemConfigRepository.getAllGrnItemConfig(cDate, frId);
		
		if(!getGrnItemConfigs.isEmpty()) {
			
			getGrnItemConfigList.setGetGrnItemConfigs(getGrnItemConfigs);
			
			info.setError(false);
			info.setMessage("success grn confi get");
			
			
		}
		else {
			
			info.setError(true);
			info.setMessage("error grn confi get");
		
			
		}
		
		getGrnItemConfigList.setInfo(info);
		}
		catch (Exception e) {
			System.out.println("exce in service Impl get Grn Item Conf");
		}
		
	return getGrnItemConfigList;
	
	}

	@Override
	public GetGrnItemConfigList getGvnItemConfig(int billNo) {

		GetGrnItemConfigList getGvnItemConfigList=new GetGrnItemConfigList();
		
		Info info=new Info();
		
		List<GetGrnItemConfig> getGvnItemConfigs=grnItemConfigRepository.getGvnItemConfig(billNo);
		
		if(getGvnItemConfigs!=null) {
			
			getGvnItemConfigList.setGetGrnItemConfigs(getGvnItemConfigs);
			
			info.setError(false);
			info.setMessage("success gvn confi get");
			
			
		}
		else {
			
			info.setError(true);
			info.setMessage("error gvn confi get");
		
			
		}
		
		getGvnItemConfigList.setInfo(info);
		
	return getGvnItemConfigList;
	
	}

	@Override
	public GetGrnItemConfigList getItemForManualGrn(int billNo, int frId) {
	
GetGrnItemConfigList getGrnItemConfigList=new GetGrnItemConfigList();
		
		Info info=new Info();
		try {
		
		List<GetGrnItemConfig> getGrnItemConfigs=grnItemConfigRepository.getItemForManGrn(billNo, frId);
		System.err.println("Response front end man grn iTems" +getGrnItemConfigs.toString());
		if(!getGrnItemConfigs.isEmpty()) {
			
			getGrnItemConfigList.setGetGrnItemConfigs(getGrnItemConfigs);
			
			info.setError(false);
			info.setMessage("success grn confi get");
			
			
		}
		else {
			
			info.setError(true);
			info.setMessage("error grn confi get");
		
			
		}
		
		getGrnItemConfigList.setInfo(info);
		}
		catch (Exception e) {
			System.out.println("exce in service Impl get Grn Item Conf");
		}
		
	return getGrnItemConfigList;
		
		
	}
	

}

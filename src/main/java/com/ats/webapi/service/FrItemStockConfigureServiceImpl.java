package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.FrItemStockConfigure;
import com.ats.webapi.model.FrItemStockConfigureList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.FrItemStockConfigureRepository;

@Service
public class FrItemStockConfigureServiceImpl implements FrItemStockConfigureService {
	
	@Autowired
	FrItemStockConfigureRepository frItemStockConfRepo;

	@Override
	public List<FrItemStockConfigure> getFrItemConfigure() {
		
		
		
		List<FrItemStockConfigure> frItemStockConfigures=frItemStockConfRepo.findAll();
		
		return frItemStockConfigures;
	}

	@Override
	public int findTotalAvailableSlot() {
		
		   int totalAvailableSlot=frItemStockConfRepo.findBySettingKey("total_available_slot");
		return totalAvailableSlot;
	}

	@Override
	public int findProductionTimeSlot() {
		int productionTimeSlot=frItemStockConfRepo.findBySettingKey("production_time_slot");
		return productionTimeSlot;
	}

	@Override
	public int findbykey(String key) {
		
		int valuebykey=frItemStockConfRepo.findBySettingKey(key);
		return valuebykey;
		
	}

	@Override
	public FrItemStockConfigureList findBySettingKeyList(List<String> settingKeyList) {
		
		Info info=new Info();
		
		FrItemStockConfigureList settingList=new FrItemStockConfigureList();
		
		try {
		
		List<FrItemStockConfigure> frItemStockConfigures=frItemStockConfRepo.findBySettingKeyIn(settingKeyList);
		
		
		if(!frItemStockConfigures.isEmpty()) {
			
			info.setError(false);
			info.setMessage("Success: Getting SettingValue for BMS Stock");
			
		}
		else {
			info.setError(true);
			info.setMessage("Error: Getting SettingValue for BMS Stock");
			
		}
		
		settingList.setFrItemStockConfigure(frItemStockConfigures);

		settingList.setInfo(info);
		
		}catch (Exception e) {

			System.out.println("Ex in getting setting List for BMS Stock"+e.getMessage());
			e.printStackTrace();
		}
		
		return settingList;
	}

	@Override
	public int getPoNo() {
		int poNo=frItemStockConfRepo.findBySettingKey("po_no");
		return poNo;
	}

}

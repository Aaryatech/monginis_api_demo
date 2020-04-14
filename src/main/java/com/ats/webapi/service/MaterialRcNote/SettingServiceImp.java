package com.ats.webapi.service.MaterialRcNote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.repository.SettingRepository;
@Service
public class SettingServiceImp implements SettingService{

	@Autowired
	SettingRepository settingRepository;
	
	
	@Override
	public int updateValue(int updatevalue) {
		
		int update=settingRepository.udatekeyvalue(updatevalue);
		return update;
	
	}


}

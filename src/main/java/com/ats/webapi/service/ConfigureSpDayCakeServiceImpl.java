package com.ats.webapi.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ConfiguredSpDayCkResponse;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetConfiguredSpDayCk;
import com.ats.webapi.model.SpDayConfigure;
import com.ats.webapi.repository.ConfigureSpDayCakeRepository;
import com.ats.webapi.repository.GetConfSpDayCakeRepository;
@Service
public class ConfigureSpDayCakeServiceImpl implements ConfigureSpDayCakeService{

	@Autowired
	ConfigureSpDayCakeRepository configureSpDayCakeRepository;
	@Autowired
	GetConfSpDayCakeRepository getConfSpDayCakeRepository;
	
	@Override
	public ErrorMessage configureSpDayCake(SpDayConfigure spDayConfigure) {

		ErrorMessage errorMessage=new ErrorMessage();
		SpDayConfigure spDayConfigureRes=configureSpDayCakeRepository.save(spDayConfigure);
		
		if(spDayConfigureRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Special Day Cake Failed to Configure.");
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Special Day Cake Configured Successfully.");
		}
		return errorMessage;
	}

	@Override
	public ConfiguredSpDayCkResponse getConfiguredSpDayCkList() {

		List<GetConfiguredSpDayCk> configuredSpDayCkList=getConfSpDayCakeRepository.findAllByDelStatus(0);
		ConfiguredSpDayCkResponse configuredSpDayCkResponse=new ConfiguredSpDayCkResponse();
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(configuredSpDayCkList!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Configured Special Day Cake List Found Successfully.");
			configuredSpDayCkResponse.setConfiguredSpDayCkList(configuredSpDayCkList);
			configuredSpDayCkResponse.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Configured Special Day Cake List Not Found");
			configuredSpDayCkResponse.setErrorMessage(errorMessage);
		}
		
		return configuredSpDayCkResponse;
	}

	@Override
	public GetConfiguredSpDayCk findConfSpDayCake(int spdayId) {
        
		GetConfiguredSpDayCk getConfiguredSpDayCk=getConfSpDayCakeRepository.findBySpdayId(spdayId);
		return getConfiguredSpDayCk;
	}

	@Override
	public ErrorMessage findConfiguredSpDayCk(int spdayId) {
		ErrorMessage errorMessage=new ErrorMessage();
		SpDayConfigure getConfiguredSpDayCk=configureSpDayCakeRepository.findBySpdayId(spdayId);
		getConfiguredSpDayCk.setDelStatus(1);
		
		SpDayConfigure spDayConfigureRes=configureSpDayCakeRepository.save(getConfiguredSpDayCk);
	    if(spDayConfigureRes==null)
	    {
	    	errorMessage.setError(true);
	    	errorMessage.setMessage("Configured SpDay Cake Deletion Failed");
	    }
	    else
	    {
	    	errorMessage.setError(false);
	    	errorMessage.setMessage("Configured SpDay Cake Deleted Successfully");
	    }
		return errorMessage;
	}

	@Override
	public ConfiguredSpDayCkResponse getSpDayCkList(int frId) {
		ConfiguredSpDayCkResponse configuredSpDayCkResponse=new ConfiguredSpDayCkResponse();

		
		java.sql.Date cDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		System.out.println("date " + cDate);
		
		List<GetConfiguredSpDayCk> configuredSpDayCkList=getConfSpDayCakeRepository.findAllSpDayCake(cDate,frId);
          ErrorMessage errorMessage=new ErrorMessage();
		
		if(configuredSpDayCkList!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Configured Special Day Cake List Found Successfully.");
			configuredSpDayCkResponse.setConfiguredSpDayCkList(configuredSpDayCkList);
			configuredSpDayCkResponse.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Configured Special Day Cake List Not Found");
			configuredSpDayCkResponse.setErrorMessage(errorMessage);
		}
		
		return configuredSpDayCkResponse;
	}

	

}

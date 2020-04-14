package com.ats.webapi.service;
import java.util.List;

import com.ats.webapi.model.Rates;


public interface RateService 
{
	public String save(Rates rate);
	public RateList findAllRates();
	public Rates findRate(int sprId);
	

	
}

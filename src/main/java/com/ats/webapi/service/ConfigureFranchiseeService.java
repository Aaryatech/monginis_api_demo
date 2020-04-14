package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.ConfigureFranchisee;
//import com.ats.webapi.model.FrMenus;
import com.ats.webapi.model.FrMenus;
import com.ats.webapi.model.FrMenusList;

public interface ConfigureFranchiseeService {
	
	public String configureFranchisee(ConfigureFranchisee configureFranchisee);
	public ConfigureFranchisee findFranchiseeById(int setting_id);
	public ConfigureFranchisee updateFrConfig(int setting_id);
    public List<FrMenus> findFrMenus(int frId);
	public List<Integer> findConfiguredMenuId(int frId);
	
	//23 March
	public int updateFrConfForSelectedFr(List<Integer> frIdList, int menuId,String fromTime,String toTime);
	public int updateFrConfForAllFr(int menuId,String fromTime,String toTime);
}

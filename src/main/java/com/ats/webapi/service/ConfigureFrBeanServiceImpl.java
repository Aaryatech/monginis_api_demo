package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ConfigureFrBean;
import com.ats.webapi.repository.ConfigureFrListRepository;
import com.ats.webapi.repository.ConfigureFrRepository;
@Service
public class ConfigureFrBeanServiceImpl  implements ConfigureFrBeanService{
	@Autowired
	ConfigureFrListRepository configureFrList;
	

	@Override
	public List<ConfigureFrBean> findAllConfFr() {
		List<ConfigureFrBean> configureFrBeans=null;
		try {
			
			configureFrBeans=configureFrList.findConfiFrList();
			
		}catch (Exception e) {
			System.out.println("exception in franchisee list conf"+e.getMessage());
		}
		return configureFrBeans;
		
	}

}

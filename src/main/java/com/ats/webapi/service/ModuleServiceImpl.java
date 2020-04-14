package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ats.webapi.model.MainModule;
import com.ats.webapi.model.MainModuleWithSubModule;
import com.ats.webapi.model.SubModule;
import com.ats.webapi.repository.ModuleRepository;
import com.ats.webapi.repository.SubModuleRepository;


@Service("moduleService")
public class ModuleServiceImpl implements ModuleService{
	

	@Autowired
	ModuleRepository moduleRepository ;
	
	@Autowired
	SubModuleRepository subModuleRepository;
	MainModuleWithSubModule mainWithSubModule;
	 List<MainModule> mainModuleList;
	 List<SubModule> subModuleList;
	 List<MainModuleWithSubModule> mainList=null;
	 
	public List<MainModuleWithSubModule> findAll() {
	 mainModuleList=new ArrayList<MainModule>();
	 subModuleList=new ArrayList<SubModule>();
	 mainModuleList=moduleRepository.findByDelStatus(0);;
		   mainList=new ArrayList<MainModuleWithSubModule>();

		for(MainModule main:mainModuleList)
		{
			subModuleList= subModuleRepository.findByModuleId(main.getModuleId());
			System.out.println("inside for loop ,submodule list "+subModuleList.toString());
			mainWithSubModule=new MainModuleWithSubModule();

		mainWithSubModule.setMainModule(main);
			mainWithSubModule.setSubModuleList(subModuleList);
		    mainList.add(mainWithSubModule);
		}
		return mainList;
		
	}
	
	
	

}

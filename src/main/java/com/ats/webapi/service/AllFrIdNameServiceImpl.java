package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.AllFrIdName;
import com.ats.webapi.model.AllFrIdNameList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.AllFrIdNameRepository;

@Service
public class AllFrIdNameServiceImpl implements AllFrIdNameService {
	
	@Autowired
	AllFrIdNameRepository allFrIdNameRepository;

	@Override
	public AllFrIdNameList getFrIdAndName() {
		
		AllFrIdNameList allFrIdNameList=new AllFrIdNameList();
		
		List<AllFrIdName> allFrIdNames=allFrIdNameRepository.getAllFrIdName();
		Info info=new Info();
		
		if(allFrIdNames!=null) {
			allFrIdNameList.setFrIdNamesList(allFrIdNames);
			info.setError(false);
			info.setMessage("Successfully displayed all fr Name and Id");
			allFrIdNameList.setInfo(info);
			
			
		}
		else {
			info.setError(true);
			info.setMessage("error in getting fr Id and Names");
			allFrIdNameList.setInfo(info);
		}
		
		
		
		
		return allFrIdNameList;
	}
	@Override
	public AllFrIdNameList findNonOrderFranchisee(String orderDate, int menuId) {
		
		
AllFrIdNameList allFrIdNameList=new AllFrIdNameList();
		
List<AllFrIdName> allFrIdNames=allFrIdNameRepository.findNonOrders(orderDate, menuId);
	Info info=new Info();
		
		if(allFrIdNames!=null) {
			allFrIdNameList.setFrIdNamesList(allFrIdNames);
			info.setError(false);
			info.setMessage("Successfully displayed of Non Order fr Name and Id");
			allFrIdNameList.setInfo(info);
			
			
		}
		else {
			info.setError(true);
			info.setMessage("error in getting fr Id and Names");
			allFrIdNameList.setInfo(info);
		}
		
		
		
		return allFrIdNameList;
	}

}

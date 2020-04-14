package com.ats.webapi.service;


import com.ats.webapi.model.AllFrIdNameList;

public interface AllFrIdNameService {
	
	AllFrIdNameList getFrIdAndName();

	AllFrIdNameList findNonOrderFranchisee(String orderDate, int menuId);

}

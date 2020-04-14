package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.AccessRightModule;
import com.ats.webapi.model.AssignRoleDetailList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.User;

public interface AccessRightService {

	List<AccessRightModule> getAllModulAndSubModule();

	Info saveAssignRole(AssignRoleDetailList assignRoleDetailList);

	List<AssignRoleDetailList> getAllAccessRole();
	
	Info updateRoleIdByEmpId(int id, int roleId);

	List<User> getAllUser();

	String getRoleJson(int usrId);

	
	
}

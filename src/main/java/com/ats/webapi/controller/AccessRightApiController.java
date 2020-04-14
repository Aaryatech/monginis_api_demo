package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.AccessRightModule;
import com.ats.webapi.model.AccessRightModuleList;
import com.ats.webapi.model.AssignRoleDetailList;
import com.ats.webapi.model.CreatedRoleList;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetUserDetail;
import com.ats.webapi.model.GetUserDetailList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.User;
import com.ats.webapi.repository.GetUserDetailRepo;
import com.ats.webapi.repository.AccessRight.AssignRoleDetailListRepository;
import com.ats.webapi.service.AccessRightService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AccessRightApiController {

	@Autowired
	AccessRightService accessRightService;

	@Autowired
	GetUserDetailRepo userDetail;//22 MArch
		
	@Autowired
	AssignRoleDetailListRepository assignRoleDetailListRepository;
	
	@RequestMapping(value = { "/deleteRole" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRole(@RequestParam int roleId) {

		int isDeleted =assignRoleDetailListRepository.deleteRole(roleId);
		Info info=new Info();
		if(isDeleted==1)
		{
			info.setError(false);
			info.setMessage("Role  Deleted");
		}
		else
		{
			info.setError(true);
			info.setMessage("Role Deletion Failed");
		}
		return info;
	}
	@RequestMapping(value = { "/getUserDetail" }, method = RequestMethod.GET)
	public @ResponseBody GetUserDetailList getUserDetail() {
		
		GetUserDetailList userList=new GetUserDetailList();
		
		List<GetUserDetail> details=userDetail.getUserDetail();
		
		Info info=new Info();
		if(details!=null && !details.isEmpty())
		{
			userList.setUserDetail(details);
			info.setError(false);
			info.setMessage("Success");
		}
		else
		{
			info.setError(true);
			info.setMessage("failed");
		}
		userList.setInfo(info);
		
		System.err.println("User detail response /AccessRightApiController /getUserDetail" +userList.toString());
		return userList;
	}
	
	
	 
	@RequestMapping(value = { "/getAllModuleAndSubModule" }, method = RequestMethod.GET)
	public @ResponseBody AccessRightModuleList getAllModuleAndSubModule() {
		
		AccessRightModuleList accessRightModuleList=new AccessRightModuleList();
		
		
		List<AccessRightModule> accessRightModule=accessRightService.getAllModulAndSubModule();
		
		Info info=new Info();
		if(accessRightModule!=null && !accessRightModule.isEmpty())
		{
			accessRightModuleList.setAccessRightModuleList(accessRightModule);
			info.setError(false);
			info.setMessage("Success");
		}
		else
		{
			 
			info.setError(true);
			info.setMessage("failed");
		}
		accessRightModuleList.setInfo(info);
		return accessRightModuleList;
	}
	
	
	
	
	@RequestMapping(value = { "/saveAssignRole" }, method = RequestMethod.POST)
	public @ResponseBody Info saveAssignRole(@RequestBody AssignRoleDetailList assignRoleDetailList) {
	
		System.out.println(assignRoleDetailList.toString());
		
		Info info=accessRightService.saveAssignRole(assignRoleDetailList);
		 
		
		return new Info();
	}
	
	@RequestMapping(value = { "/getAllAccessRole" }, method = RequestMethod.GET)
	public @ResponseBody CreatedRoleList getAllAccessRole() {
		
		CreatedRoleList createdRoleList=new CreatedRoleList();
		
		
		List<AssignRoleDetailList> assignRoleDetailList=accessRightService.getAllAccessRole();
		
		Info info=new Info();
		if(assignRoleDetailList!=null && !assignRoleDetailList.isEmpty())
		{
			createdRoleList.setAssignRoleDetailList(assignRoleDetailList);
			info.setError(false);
			info.setMessage("Success");
		}
		else
		{
			 
			info.setError(true);
			info.setMessage("failed");
		}
		createdRoleList.setInfo(info);
		return createdRoleList;
	}
	
	@RequestMapping(value = { "/updateEmpRole" }, method = RequestMethod.POST)
	@ResponseBody
	public Info updateEmpRole(@RequestParam("id") int id, @RequestParam("roleId") int roleId)
	{
		return accessRightService.updateRoleIdByEmpId(id, roleId);
	}
	
	
	@RequestMapping(value = { "/getAllUser" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUser() {
		
		 
		
		
		List<User> userList=accessRightService.getAllUser();
		
		 
		return userList;
	}
	
	
	
	
	@RequestMapping(value = { "/getRoleJson" }, method = RequestMethod.POST)
	@ResponseBody
	public String getRoleJson(@RequestParam("usrId") int usrId)
	{
		
		
		return accessRightService.getRoleJson(usrId);
	}
}

package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.AllMenuJsonResponse;
import com.ats.webapi.model.AllMenus;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.repository.MainMenuConfigurationRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MainMenuConfigurationRepository mainMenuConfigurationRepository;
	String jsonUser="{}";
	
	public String saveMenuConfigurationPage(AllMenus menuConfigurationPage) {
		
	AllMenus menuConfigurationPage1;
	ErrorMessage errorMessage;
	if(menuConfigurationPage!=null||menuConfigurationPage.getMenuTitle()!="")
	{
		//AllMenus allMenus=mainMenuConfigurationRepository.getOne(menuConfigurationPage.getMenuTitle());

	//if(menuConfigurationPage.getMenuTitle().equalsIgnoreCase(""))
//	{
		menuConfigurationPage1=mainMenuConfigurationRepository.save(menuConfigurationPage);

     errorMessage=new ErrorMessage();
	errorMessage.setError(false);
	errorMessage.setMessage("Menu inserted Successfully");
	jsonUser = JsonUtil.javaToJson(errorMessage);
	//}
//	else{
	//	errorMessage=new ErrorMessage();

	//	errorMessage.setError(true);
	//	errorMessage.setMessage("Menu already exist.");
	//	jsonUser = JsonUtil.javaToJson(errorMessage);
		
		
	//}
		
	}
	else
	{
		errorMessage=new ErrorMessage();
		errorMessage.setError(true);
		errorMessage.setMessage("Menu already exist");
		jsonUser = JsonUtil.javaToJson(errorMessage);


	}
	return jsonUser;

	}
	
	

	public AllMenus findMenu(int menuId) {

		AllMenus allMenus=mainMenuConfigurationRepository.getOne(menuId);
		return allMenus;
	}
	

	public AllMenuJsonResponse findAllMenu() {
		 List<AllMenus> menus=new ArrayList<AllMenus>();
		 menus=mainMenuConfigurationRepository.findByDelStatusOrderByMenuTitleAsc(0);;
		 AllMenuJsonResponse menuJsonResponse=new AllMenuJsonResponse();

		menuJsonResponse.setMenuConfigurationPage(menus);
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setError(false);
		errorMessage.setMessage("Menus displayed successfully");
		menuJsonResponse.setErrorMessage(errorMessage);
		return menuJsonResponse;
	}
	public List<AllMenus> findAllMenus() {
		 List<AllMenus> menus=new ArrayList<AllMenus>();
		 menus=mainMenuConfigurationRepository.findByDelStatusOrderByMenuTitleAsc(0);;
		return menus;
	}



	@Override
	public AllMenuJsonResponse findMenuByCat(int catId) {
		 List<AllMenus> menus=new ArrayList<AllMenus>();
		 menus=mainMenuConfigurationRepository.findByMainCatId(catId,0);;
		 AllMenuJsonResponse menuJsonResponse=new AllMenuJsonResponse();

		menuJsonResponse.setMenuConfigurationPage(menus);
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setError(false);
		errorMessage.setMessage("Menus displayed successfully");
		menuJsonResponse.setErrorMessage(errorMessage);
		return menuJsonResponse;
	}
}

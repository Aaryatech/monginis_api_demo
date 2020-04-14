package com.ats.webapi.model;

import java.util.List;

public class FranchiseeAndMenuList {
	List<Franchisee> allFranchisee;
List<AllMenus> allMenu;

public List<Franchisee> getAllFranchisee() {
	return allFranchisee;
}
public void setAllFranchisee(List<Franchisee> allFranchisee) {
	this.allFranchisee = allFranchisee;
}
public List<AllMenus> getAllMenu() {
	return allMenu;
}
public void setAllMenu(List<AllMenus> allMenu) {
	this.allMenu = allMenu;
}



}

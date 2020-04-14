package com.ats.webapi.model;

import java.util.List;

public class AllFranchiseeAndMenu {
	List<Franchisee> allFranchisee=null;
	List<AllMenus> allMenu=null;
	List<Item> items=null;
	List<SubCategory> SubCategories=null;
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public List<SubCategory> getSubCategories() {
		return SubCategories;
	}
	public void setSubCategories(List<SubCategory> subCategories) {
		SubCategories = subCategories;
	}
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

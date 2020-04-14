package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetItemByCatId {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="item_grp1")
	private int itemGrp1;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_id")
	private String itemId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getItemGrp1() {
		return itemGrp1;
	}

	public void setItemGrp1(int itemGrp1) {
		this.itemGrp1 = itemGrp1;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	
	
	
	
	
	
	
	

}

package com.ats.webapi.model.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetRmItemSubCat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_cat_id")
	private int subCatId;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="sub_cat_name")
	private String subCatName;
	
	@Column(name="sub_cat_desc")
	private String subCatDesc;
	
	@Column(name="del_status")
	private int delStatus;

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getSubCatDesc() {
		return subCatDesc;
	}

	public void setSubCatDesc(String subCatDesc) {
		this.subCatDesc = subCatDesc;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	
	
}

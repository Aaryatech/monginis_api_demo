package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 

@Entity
public class MiniSubCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mini_cat_id")
	private int miniCatId;
	
	@Column(name="mini_cat_name")
	private String miniCatName;
	 
	@Column(name="sub_cat_id")
	private int subCatId;	
	
	@Column(name="del_status")
	private int delStatus;

	@Column(name="sub_cat_name")
	private String subCatName;
	
	@Column(name="cat_name")
	private String catName;

	public int getMiniCatId() {
		return miniCatId;
	}

	public void setMiniCatId(int miniCatId) {
		this.miniCatId = miniCatId;
	}

	public String getMiniCatName() {
		return miniCatName;
	}

	public void setMiniCatName(String miniCatName) {
		this.miniCatName = miniCatName;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Override
	public String toString() {
		return "MiniSubCategory [miniCatId=" + miniCatId + ", miniCatName=" + miniCatName + ", subCatId=" + subCatId
				+ ", delStatus=" + delStatus + ", subCatName=" + subCatName + ", catName=" + catName + "]";
	}
	
	
	
}

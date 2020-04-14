package com.ats.webapi.model.rawmaterial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm_item_sub_cat")
public class RmItemSubCategory  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_cat_id")
	private int subCatId;
	
	@Column(name="cat_id")
	private int catId;
	
	
	@Column(name="sub_cat_name")
	private String subCatName;
	
	@Column(name="sub_cat_desc")
	private String subCatDesc;
	
	@Column(name="del_status")
	private int delStatus;

	
	
	
	public String getSubCatDesc() {
		return subCatDesc;
	}

	public void setSubCatDesc(String subCatDesc) {
		this.subCatDesc = subCatDesc;
	}

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

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "RmItemSubCategory [subCatId=" + subCatId + ", catId=" + catId + ", subCatName=" + subCatName
				+ ", subCatDesc=" + subCatDesc + ", delStatus=" + delStatus + "]";
	}

	
	
}

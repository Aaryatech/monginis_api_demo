package com.ats.webapi.model.rawmaterial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm_item_cat")
public class RmItemCategory  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="grp_id")
	private int grpId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="cat_desc")
	private String catDesc;
	
	@Column(name="del_status")
	private int delStatus;

	
	
	
	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "RmItemCategory [catId=" + catId + ", catName=" + catName + ", catDesc=" + catDesc + ", delStatus="
				+ delStatus + "]";
	}

	
}

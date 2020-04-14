package com.ats.webapi.model;
 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_section")
public class SectionMaster {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="section_id")
	private int sectionId; 
	
	@Column(name = "section_name")
	private String sectionName; 
	
	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "menu_ids")
	private String menuIds;
	
	@Transient
	List<AllMenus> menuList;
	
	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public List<AllMenus> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<AllMenus> menuList) {
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		return "SectionMaster [sectionId=" + sectionId + ", sectionName=" + sectionName + ", delStatus=" + delStatus
				+ ", menuIds=" + menuIds + ", menuList=" + menuList + "]";
	}
	
	
 

}

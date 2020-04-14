package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="m_category")
public class GetMCategory {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="is_same_day")
    private int isSameDay;
	
	@Column(name="del_status")
    private int delStatus;

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

	public int getIsSameDay() {
		return isSameDay;
	}

	public void setIsSameDay(int isSameDay) {
		this.isSameDay = isSameDay;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	
	
	

}

package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "m_fr_configure")
public class ConfigureFranchisee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="setting_id")
	private int settingId;
	
	@Column(name="fr_id")
	private int frId;

	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="sub_cat_id")
	private int subCatId;
	
	@Column(name="setting_type")
	private int settingType;
	
	@Column(name="from_time")
	private String fromTime;

	@Column(name="to_time")
	private String toTime;

	@Column(name="day")
	private String day;
	
	@Column(name="date")
	private String date;
	
	@Column(name="item_show")
	private String itemShow;

	@Column(name="is_del")
	private int delStatus;
	
	public int getSettingId() {
		return settingId;
	}
    
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setSettingId(int settingId) {
		this.settingId = settingId;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public int getSettingType() {
		return settingType;
	}
	public void setSettingType(int settingType) {
		this.settingType = settingType;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	
	public String getItemShow() {
		return itemShow;
	}
	public void setItemShow(String itemShow) {
		this.itemShow = itemShow;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "ConfigureFranchisee [settingId=" + settingId + ", frId=" + frId + ", menuId=" + menuId + ", catId="
				+ catId + ", subCatId=" + subCatId + ", settingType=" + settingType + ", fromTime=" + fromTime
				+ ", toTime=" + toTime + ", day=" + day + ", date=" + date + ", itemShow=" + itemShow + ", delStatus="
				+ delStatus + "]";
	}
	
		
}

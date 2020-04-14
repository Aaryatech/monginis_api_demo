package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_fr_configure")
public class ConfigureFrBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="setting_id")
	private int settingId;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="setting_type")
	private int settingType;
	
	@Column(name="from_time")
	private String fromTime;
	
	@Column(name="to_time")
	private String toTime;
	
	@Column(name="day")
	private int day;
	
	@Column(name="date")
	private int date;
	
	@Column(name="item_show")
	private String itemShow;
	
	@Column(name="is_del")
	private int delStatus;
	
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="menu_title")
	private String menuTitle;
	
	@Column(name="cat_name")
	private String catName;

	public int getSettingId() {
		return settingId;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
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

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Override
	public String toString() {
		return "ConfigureFrBean [settingId=" + settingId + ", frId=" + frId + ", menuId=" + menuId + ", settingType="
				+ settingType + ", fromTime=" + fromTime + ", toTime=" + toTime + ", day=" + day + ", date=" + date
				+ ", itemShow=" + itemShow + ", delStatus=" + delStatus + ", frName=" + frName + ", menuTitle="
				+ menuTitle + ", catName=" + catName + "]";
	}


	
	
	

}

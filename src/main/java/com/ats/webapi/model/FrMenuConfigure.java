package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_fr_menu_configure")
public class FrMenuConfigure implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "setting_id")
	private int settingId;
	
	
	@Column(name = "fr_id")
	private int frId;

	@Column(name = "menu_id")
	private int menuId;

	@Column(name = "is_del")
	private int isDel;

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

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "FrMenuConfigure [settingId=" + settingId + ", frId=" + frId + ", menuId=" + menuId + ", isDel=" + isDel
				+ "]";
	}
	
	
}

package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckSuppGst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="supp_id")
    private int suppId;
	
	@Column(name="supp_gstin")
    private String suppGstin;
	
	@Column(name="setting_key")
    private String settingKey;
	
    @Column(name="setting_value")
    private int settingValue;

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getSuppGstin() {
		return suppGstin;
	}

	public void setSuppGstin(String suppGstin) {
		this.suppGstin = suppGstin;
	}

	public String getSettingKey() {
		return settingKey;
	}

	public void setSettingKey(String settingKey) {
		this.settingKey = settingKey;
	}

	public int getSettingValue() {
		return settingValue;
	}

	public void setSettingValue(int settingValue) {
		this.settingValue = settingValue;
	}

	@Override
	public String toString() {
		return "CheckSuppGst [suppId=" + suppId + ", suppGstin=" + suppGstin + ", settingKey=" + settingKey
				+ ", settingValue=" + settingValue + "]";
	}
    
    
    
	 

}

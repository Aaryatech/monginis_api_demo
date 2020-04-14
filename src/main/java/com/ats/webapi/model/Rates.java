package com.ats.webapi.model;
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "m_sp_rates")
public class Rates implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="spr_id")
	private int sprId;
	
	@Column(name = "spr_name")
	private String sprName;
	@Column(name="spr_rate")
	private float sprRate;
	@Column(name="spr_add_on_rate")
	private float sprAddOnRate;
	@Column(name="del_status")
	private int delStatus;
	public int getSprId() {
		return sprId;
	}
	public void setSprId(int sprId) {
		this.sprId = sprId;
	}
	public String getSprName() {
		return sprName;
	}
	public void setSprName(String sprName) {
		this.sprName = sprName;
	}
	public float getSprRate() {
		return sprRate;
	}
	public void setSprRate(float sprRate) {
		this.sprRate = sprRate;
	}
	public float getSprAddOnRate() {
		return sprAddOnRate;
	}
	public void setSprAddOnRate(float sprAddOnRate) {
		this.sprAddOnRate = sprAddOnRate;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	@Override
	public String toString() {
		return "Rates [sprId=" + sprId + ", sprName=" + sprName + ", sprRate=" + sprRate + ", sprAddOnRate="
				+ sprAddOnRate + ", delStatus=" + delStatus + "]";
	}
	

}

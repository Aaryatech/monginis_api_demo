package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "m_sp_flavour")
public class Flavour implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="spf_id")
private int spfId;
@Column(name="sp_type")
private int spType;
@Column(name="spf_name")
private String spfName;
@Column(name="spf_adon_rate")
private double spfAdonRate;
@Column(name="del_status")
private int delStatus;


public int getSpfId() {
	return spfId;
}
public void setSpfId(int spfId) {
	this.spfId = spfId;
}
public int getSpType() {
	return spType;
}
public void setSpType(int spType) {
	this.spType = spType;
}
public String getSpfName() {
	return spfName;
}
public void setSpfName(String spfName) {
	this.spfName = spfName;
}
public double getSpfAdonRate() {
	return spfAdonRate;
}
public void setSpfAdonRate(double spfAdonRate) {
	this.spfAdonRate = spfAdonRate;
}
public int getDelStatus() {
	return delStatus;
}
public void setDelStatus(int delStatus) {
	this.delStatus = delStatus;
}
@Override
public String toString() {
	return "Flavour [spfId=" + spfId + ", spType=" + spType + ", spfName=" + spfName + ", spfAdonRate=" + spfAdonRate
			+ ", delStatus=" + delStatus + "]";
}
	

}

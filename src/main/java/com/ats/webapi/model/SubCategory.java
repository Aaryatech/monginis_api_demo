package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "m_cat_sub")
public class SubCategory implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_cat_id")
	private int subCatId;
	@Column(name="sub_cat_name")
	private String subCatName;
	@Column(name="cat_id")
	private int catId;
	@Column(name="del_status")
	private int delStatus;	
	//----remove to do onetomany association mapping-------
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	//----OneToMany--code-----------
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="cat_id",nullable=false)
	private MCategory catId;
	
	
	@JsonIgnore
	public MCategory getCatId() {
		return catId;
	}
	public void setCatId(MCategory catId) {
		this.catId = catId;
	}*/
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
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
		return "SubCategory [subCatId=" + subCatId + ", subCatName=" + subCatName + ", catId=" + catId + ", delStatus="
				+ delStatus + "]";
	}
    
	
	
}

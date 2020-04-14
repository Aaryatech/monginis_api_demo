package com.ats.webapi.model.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_sf_type")
public class GetSfType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
    
	@Column(name="sf_type_name")
	private String sfTypeName;
	
	@Column(name="del_status")
	private int delStatus;

	public int getId() {
		return id;
	}

	
	public int getDelStatus() {
		return delStatus;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}


	public String getSfTypeName() {
		return sfTypeName;
	}


	public void setSfTypeName(String sfTypeName) {
		this.sfTypeName = sfTypeName;
	}
	
}

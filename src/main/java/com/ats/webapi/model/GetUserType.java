package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetUserType {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="type_name")
	private String typeName;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "GetUserType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
	
}

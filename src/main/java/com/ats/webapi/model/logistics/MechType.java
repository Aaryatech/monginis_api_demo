package com.ats.webapi.model.logistics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_logis_machtype")
public class MechType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_id")
	private int typeId; 
	
	@Column(name = "type_name")
	private String typeName; 
	
	@Column(name = "type")
	private int type;
	
	@Column(name = "del_status")
	private int delStatus;

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "MechType [typeId=" + typeId + ", typeName=" + typeName + ", type=" + type + ", delStatus=" + delStatus
				+ "]";
	}
	
	

}

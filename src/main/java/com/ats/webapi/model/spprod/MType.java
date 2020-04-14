package com.ats.webapi.model.spprod;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_emp_type")
public class MType {

	@Transient
	private boolean isError;
	
	@Transient
	private String message;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="sub_type")
	private int subType;
	
	@Column(name="type_name")
	private String typeName;
	
	@Column(name="del_status")
	private int delStatus;

	
	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		this.subType = subType;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Type [isError=" + isError + ", message=" + message + ", typeId=" + typeId + ", typeName=" + typeName
				+ ", delStatus=" + delStatus + "]";
	}
	
	
}

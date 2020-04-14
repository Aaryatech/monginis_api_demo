package com.ats.webapi.model.tray;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_tray_type")
public class TrayType implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="type_name")
	private String typeName;
	
	@Column(name="tray_price")
	private float trayPrice;
	
	private int delStatus;

	
	
	public float getTrayPrice() {
		return trayPrice;
	}

	public void setTrayPrice(float trayPrice) {
		this.trayPrice = trayPrice;
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
		return "TrayType [typeId=" + typeId + ", typeName=" + typeName + ", delStatus=" + delStatus + "]";
	}
	
	
}

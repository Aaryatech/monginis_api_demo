package com.ats.webapi.model.logistics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_logis_alert_vehicle_servicing")
public class AlertVeihcleServicing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "alert_id")
	private int alertId;  
	
	@Column(name = "veh_id")
	private int vehId; 
	
	@Column(name = "veh_no")
	private String vehNo;
	
	@Column(name = "type_id")
	private int typeId;
	
	@Column(name = "type_name")
	private String typeName;
	
	@Column(name = "last_serv_km")
	private int lastServKm;  
	
	@Column(name = "next_serv_km")
	private int nextServKm;   
	
	@Column(name = "alert_serv_km")
	private int alertServKm;

	public int getAlertId() {
		return alertId;
	}

	public void setAlertId(int alertId) {
		this.alertId = alertId;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
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

	public int getLastServKm() {
		return lastServKm;
	}

	public void setLastServKm(int lastServKm) {
		this.lastServKm = lastServKm;
	}

	public int getNextServKm() {
		return nextServKm;
	}

	public void setNextServKm(int nextServKm) {
		this.nextServKm = nextServKm;
	}

	public int getAlertServKm() {
		return alertServKm;
	}

	public void setAlertServKm(int alertServKm) {
		this.alertServKm = alertServKm;
	}

	@Override
	public String toString() {
		return "AlertVeihcleServicing [alertId=" + alertId + ", vehId=" + vehId + ", vehNo=" + vehNo + ", typeId="
				+ typeId + ", typeName=" + typeName + ", lastServKm=" + lastServKm + ", nextServKm=" + nextServKm
				+ ", alertServKm=" + alertServKm + "]";
	}  
	


}

package com.ats.webapi.model.logistics; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_logis_vehtype")
public class VehicalType {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehi_type_id")
	private int vehiTypeId; 
	
	@Column(name = "veh_type_name")
	private String vehTypeName;

	@Column(name = "make_id")
	private int makeId;

	@Column(name = "del_status")
	private int delStatus;

	public int getVehiTypeId() {
		return vehiTypeId;
	}

	public void setVehiTypeId(int vehiTypeId) {
		this.vehiTypeId = vehiTypeId;
	}

	public String getVehTypeName() {
		return vehTypeName;
	}

	public void setVehTypeName(String vehTypeName) {
		this.vehTypeName = vehTypeName;
	}

	public int getMakeId() {
		return makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "VehicalType [vehiTypeId=" + vehiTypeId + ", vehTypeName=" + vehTypeName + ", makeId=" + makeId
				+ ", delStatus=" + delStatus + "]";
	} 
	
	

}

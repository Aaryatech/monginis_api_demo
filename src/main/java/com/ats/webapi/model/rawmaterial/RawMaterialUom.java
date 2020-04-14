package com.ats.webapi.model.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm_uom")
public class RawMaterialUom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uom_id")
	private int uomId;
	
	@Column(name="uom")
	private String uom;

	@Column(name="del_status")
	private int delStatus;
	
	
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Override
	public String toString() {
		return "RawMaterialUom [uomId=" + uomId + ", uom=" + uom + ", delStatus=" + delStatus + "]";
	}
	
}

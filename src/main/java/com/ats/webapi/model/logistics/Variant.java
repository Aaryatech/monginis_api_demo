package com.ats.webapi.model.logistics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_logis_variant")
public class Variant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "variant_id")
	private int variantId;  
	
	@Column(name = "variant_name")
	private String variantName; 
	
	@Column(name = "make_id")
	private int makeId;
	
	@Column(name = "veh_type_id")
	private int vehTypeId;
	
	@Column(name = "del_status")
	private int delStatus;

	public int getVariantId() {
		return variantId;
	}

	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	public int getMakeId() {
		return makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public int getVehTypeId() {
		return vehTypeId;
	}

	public void setVehTypeId(int vehTypeId) {
		this.vehTypeId = vehTypeId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Variant [variantId=" + variantId + ", variantName=" + variantName + ", makeId=" + makeId
				+ ", vehTypeId=" + vehTypeId + ", delStatus=" + delStatus + "]";
	}
	
	

}

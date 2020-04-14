package com.ats.webapi.model.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetUomAndTax {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="tax_id")
	private int taxId;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="tax_desc")
	private String taxDesc;
	
	@Column(name="rm_uom_id")
	private int uomId;

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getTaxDesc() {
		return taxDesc;
	}

	public void setTaxDesc(String taxDesc) {
		this.taxDesc = taxDesc;
	}

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	@Override
	public String toString() {
		return "GetUomAndTax [rmId=" + rmId + ", taxId=" + taxId + ", uom=" + uom + ", taxDesc=" + taxDesc + ", uomId="
				+ uomId + "]";
	}
	
	
}

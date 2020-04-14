package com.ats.webapi.model.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm_tax")
public class RawMaterialTaxDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tax_id")
	private int taxId;
	
	@Column(name="tax_desc")
	private String taxDesc;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="igst_per")
	private float igstPer;

	private int delStatus;
	
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getTaxDesc() {
		return taxDesc;
	}

	public void setTaxDesc(String taxDesc) {
		this.taxDesc = taxDesc;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	@Override
	public String toString() {
		return "RawMaterialGstDetails [taxId=" + taxId + ", taxDesc=" + taxDesc + ", sgstPer=" + sgstPer + ", cgstPer="
				+ cgstPer + ", igstPer=" + igstPer + "]";
	}
	
	
}

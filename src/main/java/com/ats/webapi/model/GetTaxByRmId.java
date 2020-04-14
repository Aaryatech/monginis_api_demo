package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetTaxByRmId {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_id")
    private int rmId;
	
	@Column(name="cgst_per")
    private float cgstPer;
	
	@Column(name="sgst_per")
    private float sgstPer;
	
    @Column(name="igst_per")
    private float igstPer;
    
	@Column(name="tax_id")
	private int taxId;

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	@Override
	public String toString() {
		return "GetTaxByRmId [rmId=" + rmId + ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer + ", igstPer=" + igstPer
				+ ", taxId=" + taxId + "]";
	}

	
}

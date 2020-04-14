package com.ats.webapi.model.purchaseorder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetRmRateAndTax {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_uom_id")
	private int rmUomId;

	
	@Column(name="gst_per")
	private float gstPer;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="igst_per")
	private float igstPer;
	
  
	@Column(name="rm_specification")
	private String specification;
	
	
	@Column(name="rate_tax_extra")
	private float rateTaxExtra;
	
	@Column(name="rate_tax_incl")
	private float rateTaxIncl;

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public int getRmUomId() {
		return rmUomId;
	}

	public void setRmUomId(int rmUomId) {
		this.rmUomId = rmUomId;
	}

	public float getGstPer() {
		return gstPer;
	}

	public void setGstPer(float gstPer) {
		this.gstPer = gstPer;
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

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public float getRateTaxExtra() {
		return rateTaxExtra;
	}

	public void setRateTaxExtra(float rateTaxExtra) {
		this.rateTaxExtra = rateTaxExtra;
	}

	public float getRateTaxIncl() {
		return rateTaxIncl;
	}

	public void setRateTaxIncl(float rateTaxIncl) {
		this.rateTaxIncl = rateTaxIncl;
	}

	@Override
	public String toString() {
		return "GetRmRateAndTax [rmId=" + rmId + ", rmName=" + rmName + ", rmUomId=" + rmUomId + ", gstPer=" + gstPer
				+ ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer + ", igstPer=" + igstPer + ", specification="
				+ specification + ", rateTaxExtra=" + rateTaxExtra + ", rateTaxIncl=" + rateTaxIncl + "]";
	}
	
	
	
}

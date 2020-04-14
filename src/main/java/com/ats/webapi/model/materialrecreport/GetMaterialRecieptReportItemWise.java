package com.ats.webapi.model.materialrecreport;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetMaterialRecieptReportItemWise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_id")
	private String rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="hsncd_no")
	private int hsncdNo;
	
	@Column(name="tax_rate")
	private float taxRate;
	
	@Column(name="recd_qty")
	private float recdQty;
	
	@Column(name="cgst")
	private float cgst;
	
	@Column(name="sgst")
	private float sgst;
	
	@Column(name="igst")
	private float igst;
	
	@Column(name="taxable_amt")
	private float taxableAmt;

	public String getRmId() {
		return rmId;
	}

	public void setRmId(String rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public int getHsncdNo() {
		return hsncdNo;
	}

	public void setHsncdNo(int hsncdNo) {
		this.hsncdNo = hsncdNo;
	}

	public float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

	public float getRecdQty() {
		return recdQty;
	}

	public void setRecdQty(float recdQty) {
		this.recdQty = recdQty;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	@Override
	public String toString() {
		return "GetMaterialRecieptReportItemWise [rmId=" + rmId + ", rmName=" + rmName + ", hsncdNo=" + hsncdNo
				+ ", taxRate=" + taxRate + ", recdQty=" + recdQty + ", cgst=" + cgst + ", sgst=" + sgst + ", igst="
				+ igst + ", taxableAmt=" + taxableAmt + "]";
	}
	
	

}

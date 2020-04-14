package com.ats.webapi.model.tally;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_material_receipt_note_detail")
public class MaterialRecNoteDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mrn_detail_id")
	private int mrnDetailId;
	
	@Column(name="mrn_id")
	private int mrnId;
	
	@Column(name="mrn_no")
	private String mrnNo;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_uom")
	private String rmUom;
	
	@Column(name="recd_qty")
	private int recdQty;
	
	@Column(name="po_rate")
	private float poRate;
	
	@Column(name="value")
	private float value;
	
	@Column(name="disc_per")
	private float discPer;
	
	@Column(name="disc_amt")
	private float discAmt;
	
	@Column(name="gst_per")
	private float gstPer;
	
	@Column(name="freight_per")
	private float freightPer;
	
	@Column(name="freight_amt")
	private float freightAmt;
	
	@Column(name="insurance_per")
	private float insurancePer;
	
	@Column(name="insurance_amt")
	private float insurance_amt;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="cgst_rs")
	private float cgstRs;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="sgst_rs")
	private float sgstRs;
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="igst_rs")
	private float igstRs;
	
	@Column(name="cess_per")
	private float cessPer;
	
	@Column(name="cess_rs")
	private float cessRs;
	
	@Column(name="amount")
	private float amount;

	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

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

	public String getRmUom() {
		return rmUom;
	}

	public void setRmUom(String rmUom) {
		this.rmUom = rmUom;
	}

	public int getRecdQty() {
		return recdQty;
	}

	public void setRecdQty(int recdQty) {
		this.recdQty = recdQty;
	}

	public float getPoRate() {
		return poRate;
	}

	public void setPoRate(float poRate) {
		this.poRate = poRate;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getGstPer() {
		return gstPer;
	}

	public void setGstPer(float gstPer) {
		this.gstPer = gstPer;
	}

	public float getFreightPer() {
		return freightPer;
	}

	public void setFreightPer(float freightPer) {
		this.freightPer = freightPer;
	}

	public float getFreightAmt() {
		return freightAmt;
	}

	public void setFreightAmt(float freightAmt) {
		this.freightAmt = freightAmt;
	}

	public float getInsurancePer() {
		return insurancePer;
	}

	public void setInsurancePer(float insurancePer) {
		this.insurancePer = insurancePer;
	}

	public float getInsurance_amt() {
		return insurance_amt;
	}

	public void setInsurance_amt(float insurance_amt) {
		this.insurance_amt = insurance_amt;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public float getCessRs() {
		return cessRs;
	}

	public void setCessRs(float cessRs) {
		this.cessRs = cessRs;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "MaterialRecNoteDetails [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", mrnNo=" + mrnNo
				+ ", rmId=" + rmId + ", rmName=" + rmName + ", rmUom=" + rmUom + ", recdQty=" + recdQty + ", poRate="
				+ poRate + ", value=" + value + ", discPer=" + discPer + ", discAmt=" + discAmt + ", gstPer=" + gstPer
				+ ", freightPer=" + freightPer + ", freightAmt=" + freightAmt + ", insurancePer=" + insurancePer
				+ ", insurance_amt=" + insurance_amt + ", cgstPer=" + cgstPer + ", cgstRs=" + cgstRs + ", sgstPer="
				+ sgstPer + ", sgstRs=" + sgstRs + ", igstPer=" + igstPer + ", igstRs=" + igstRs + ", cessPer="
				+ cessPer + ", cessRs=" + cessRs + ", amount=" + amount + "]";
	}
}

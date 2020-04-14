package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_material_receipt_note_detail")
public class MaterialRecNoteDetails implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mrn_detail_id")
	private int mrnDetailId; 
	
	@Column(name="mrn_id")
	private int mrnId;
	
	@Column(name="mrn_no")
	private String mrnNo;
	
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_uom")
	private String rmUom;
	
	@Column(name="recd_qty")
	private int recdQty;
	
	@Column(name="po_id")
	private int poId;
	
	@Column(name="po_qty")
	private int poQty;
	
	@Column(name="stock_qty")
	private int stockQty;
	
	@Column(name="rejected_qty")
	private int rejectedQty;
	
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
	
	@Column(name="director_approved")
	private int directorApproved;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="status")
	private int status;
	
	@Column(name="other1")
	private float other1;
	
	@Column(name="other2")
	private float other2;
	
	@Column(name="other3")
	private float other3;
	
	@Column(name="other4")
	private float other4;
	
	@Column(name="varified_rate")
	private float varifiedRate;

	private int grpId;
	
	
	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

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

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
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
    
	public int getRejectedQty() {
		return rejectedQty;
	}

	public void setRejectedQty(int rejectedQty) {
		this.rejectedQty = rejectedQty;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getPoQty() {
		return poQty;
	}

	public void setPoQty(int poQty) {
		this.poQty = poQty;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
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

	public int getDirectorApproved() {
		return directorApproved;
	}

	public void setDirectorApproved(int directorApproved) {
		this.directorApproved = directorApproved;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

	public float getOther1() {
		return other1;
	}

	public void setOther1(float other1) {
		this.other1 = other1;
	}

	public float getOther2() {
		return other2;
	}

	public void setOther2(float other2) {
		this.other2 = other2;
	}

	public float getOther3() {
		return other3;
	}

	public void setOther3(float other3) {
		this.other3 = other3;
	}

	public float getOther4() {
		return other4;
	}

	public void setOther4(float other4) {
		this.other4 = other4;
	}
	
	

	public float getVarifiedRate() {
		return varifiedRate;
	}

	public void setVarifiedRate(float varifiedRate) {
		this.varifiedRate = varifiedRate;
	}

	@Override
	public String toString() {
		return "MaterialRecNoteDetails [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", mrnNo=" + mrnNo
				+ ", supplierId=" + supplierId + ", rmId=" + rmId + ", rmName=" + rmName + ", rmUom=" + rmUom
				+ ", recdQty=" + recdQty + ", poId=" + poId + ", poQty=" + poQty + ", stockQty=" + stockQty
				+ ", rejectedQty=" + rejectedQty + ", poRate=" + poRate + ", value=" + value + ", discPer=" + discPer
				+ ", discAmt=" + discAmt + ", gstPer=" + gstPer + ", freightPer=" + freightPer + ", freightAmt="
				+ freightAmt + ", insurancePer=" + insurancePer + ", insurance_amt=" + insurance_amt + ", cgstPer="
				+ cgstPer + ", cgstRs=" + cgstRs + ", sgstPer=" + sgstPer + ", sgstRs=" + sgstRs + ", igstPer="
				+ igstPer + ", igstRs=" + igstRs + ", cessPer=" + cessPer + ", cessRs=" + cessRs + ", amount=" + amount
				+ ", directorApproved=" + directorApproved + ", delStatus=" + delStatus + ", status=" + status
				+ ", other1=" + other1 + ", other2=" + other2 + ", other3=" + other3 + ", other4=" + other4
				+ ", varifiedRate=" + varifiedRate + "]";
	}
   
}

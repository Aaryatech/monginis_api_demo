package com.ats.webapi.model.tally;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RawMaterialResponse implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	
	@Column(name="rm_code")
	private String rmCode;
	
	@Column(name="grp_name")
	private String grpName;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="sub_cat_name")
	private String subCatName;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="rm_specification")
	private String rmSpecification;
	
	@Column(name="rm_icon")
	private String rmIcon;
	
	@Column(name="rm_weight")
	private int rmWeight;
	
	@Column(name="rm_pack_qty")
	private int rmPackQty;
	
 
	@Column(name="rm_rate")
	private int rmRate;
	
	@Column(name="tax_desc")
	private String taxDescription;
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="rm_min_qty")
	private int rmMinQty;
	
	
	@Column(name="rm_max_qty")
	private int rmMaxQty;
	
	@Column(name="rm_rol_qty")
	private int rmRolQty;
	
	@Column(name="rm_op_rate")
	private int rmOpRate;
	
	@Column(name="rm_op_qty")
	private int rmOpQty;
	
	@Column(name="rm_received_qty")
	private int rmReceivedQty;
	
	@Column(name="rm_iss_qty")
	private int rmIssQty;
	
	@Column(name="rm_rej_qty")
	private int rmRejQty;
	
	@Column(name="rm_clo_qty")
	private int rmCloQty;
	
	@Column(name="rm_is_critical")
	private int rmIsCritical;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="is_tally_sync")
	private int isTallySync;

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

	public String getRmCode() {
		return rmCode;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getRmSpecification() {
		return rmSpecification;
	}

	public void setRmSpecification(String rmSpecification) {
		this.rmSpecification = rmSpecification;
	}

	public String getRmIcon() {
		return rmIcon;
	}

	public void setRmIcon(String rmIcon) {
		this.rmIcon = rmIcon;
	}

	public int getRmWeight() {
		return rmWeight;
	}

	public void setRmWeight(int rmWeight) {
		this.rmWeight = rmWeight;
	}

	public int getRmPackQty() {
		return rmPackQty;
	}

	public void setRmPackQty(int rmPackQty) {
		this.rmPackQty = rmPackQty;
	}

	public int getRmRate() {
		return rmRate;
	}

	public void setRmRate(int rmRate) {
		this.rmRate = rmRate;
	}

	public String getTaxDescription() {
		return taxDescription;
	}

	public void setTaxDescription(String taxDescription) {
		this.taxDescription = taxDescription;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
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

	public int getRmMinQty() {
		return rmMinQty;
	}

	public void setRmMinQty(int rmMinQty) {
		this.rmMinQty = rmMinQty;
	}

	public int getRmMaxQty() {
		return rmMaxQty;
	}

	public void setRmMaxQty(int rmMaxQty) {
		this.rmMaxQty = rmMaxQty;
	}

	public int getRmRolQty() {
		return rmRolQty;
	}

	public void setRmRolQty(int rmRolQty) {
		this.rmRolQty = rmRolQty;
	}

	public int getRmOpRate() {
		return rmOpRate;
	}

	public void setRmOpRate(int rmOpRate) {
		this.rmOpRate = rmOpRate;
	}

	public int getRmOpQty() {
		return rmOpQty;
	}

	public void setRmOpQty(int rmOpQty) {
		this.rmOpQty = rmOpQty;
	}

	public int getRmReceivedQty() {
		return rmReceivedQty;
	}

	public void setRmReceivedQty(int rmReceivedQty) {
		this.rmReceivedQty = rmReceivedQty;
	}

	public int getRmIssQty() {
		return rmIssQty;
	}

	public void setRmIssQty(int rmIssQty) {
		this.rmIssQty = rmIssQty;
	}

	public int getRmRejQty() {
		return rmRejQty;
	}

	public void setRmRejQty(int rmRejQty) {
		this.rmRejQty = rmRejQty;
	}

	public int getRmCloQty() {
		return rmCloQty;
	}

	public void setRmCloQty(int rmCloQty) {
		this.rmCloQty = rmCloQty;
	}

	public int getRmIsCritical() {
		return rmIsCritical;
	}

	public void setRmIsCritical(int rmIsCritical) {
		this.rmIsCritical = rmIsCritical;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	@Override
	public String toString() {
		return "RawMaterialResponse [rmId=" + rmId + ", rmName=" + rmName + ", rmCode=" + rmCode + ", grpName="
				+ grpName + ", catName=" + catName + ", subCatName=" + subCatName + ", uom=" + uom
				+ ", rmSpecification=" + rmSpecification + ", rmIcon=" + rmIcon + ", rmWeight=" + rmWeight
				+ ", rmPackQty=" + rmPackQty + ", rmRate=" + rmRate + ", taxDescription=" + taxDescription
				+ ", igstPer=" + igstPer + ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer + ", rmMinQty=" + rmMinQty
				+ ", rmMaxQty=" + rmMaxQty + ", rmRolQty=" + rmRolQty + ", rmOpRate=" + rmOpRate + ", rmOpQty="
				+ rmOpQty + ", rmReceivedQty=" + rmReceivedQty + ", rmIssQty=" + rmIssQty + ", rmRejQty=" + rmRejQty
				+ ", rmCloQty=" + rmCloQty + ", rmIsCritical=" + rmIsCritical + ", delStatus=" + delStatus
				+ ", isTallySync=" + isTallySync + "]";
	}

	
}

package com.ats.webapi.model.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm")
public class RawMaterialDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	
	@Column(name="rm_code")
	private String rmCode;
	
	@Column(name="grp_id")
	private int grpId;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="sub_cat_id")
	private int subCatId;
	
	@Column(name="rm_uom_id")
	private int rmUomId;
	
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
	
	@Column(name="tax_id")
	private int rmTaxId;
	
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

	
	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmCode() {
		return rmCode;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
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

	public int getRmReceivedQty() {
		return rmReceivedQty;
	}

	public void setRmReceivedQty(int rmReceivedQty) {
		this.rmReceivedQty = rmReceivedQty;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getRmTaxId() {
		return rmTaxId;
	}

	public void setRmTaxId(int rmTaxId) {
		this.rmTaxId = rmTaxId;
	}

	public int getRmUomId() {
		return rmUomId;
	}

	public void setRmUomId(int rmUomId) {
		this.rmUomId = rmUomId;
	}

	@Override
	public String toString() {
		return "RawMaterialDetails [rmId=" + rmId + ", rmName=" + rmName + ", rmCode=" + rmCode + ", grpId=" + grpId
				+ ", catId=" + catId + ", subCatId=" + subCatId + ", rmUomId=" + rmUomId + ", rmSpecification="
				+ rmSpecification + ", rmIcon=" + rmIcon + ", rmWeight=" + rmWeight + ", rmPackQty=" + rmPackQty
				+ ", rmRate=" + rmRate + ", rmTaxId=" + rmTaxId + ", rmMinQty=" + rmMinQty + ", rmMaxQty=" + rmMaxQty
				+ ", rmRolQty=" + rmRolQty + ", rmOpRate=" + rmOpRate + ", rmOpQty=" + rmOpQty + ", rmReceivedQty="
				+ rmReceivedQty + ", rmIssQty=" + rmIssQty + ", rmRejQty=" + rmRejQty + ", rmCloQty=" + rmCloQty
				+ ", rmIsCritical=" + rmIsCritical + ", delStatus=" + delStatus + "]";
	}

	 
	 
	 

 
 

	 

 
	
}

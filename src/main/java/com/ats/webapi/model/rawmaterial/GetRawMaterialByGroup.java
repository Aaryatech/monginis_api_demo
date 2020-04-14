package com.ats.webapi.model.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm")
public class GetRawMaterialByGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="grp_id")
	private int grpId;
	
	@Column(name="grp_name")
	private String grpName;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="sub_cat_id")
	private int subCatId;
	
	@Column(name="sub_cat_name")
	private String sunCatName;
	
	@Column(name="rm_pack_qty")
	private int rmPackQty;
	
	@Column(name="rm_rate")
	private int rmRate;
	
	@Column(name="tax_id")
	private int taxId;
	
	private int bmsRolQty;
	
	private int storeRolQty;

	private float sgstPer;
	
	private float cgstPer;
	
	private float igstPer;
	
	@Column(name="rm_is_critical")
	private int rmIsCritical;

	public int getBmsRolQty() {
		return bmsRolQty;
	}

	public void setBmsRolQty(int bmsRolQty) {
		this.bmsRolQty = bmsRolQty;
	}

	public int getStoreRolQty() {
		return storeRolQty;
	}

	public void setStoreRolQty(int storeRolQty) {
		this.storeRolQty = storeRolQty;
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

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getSunCatName() {
		return sunCatName;
	}

	public void setSunCatName(String sunCatName) {
		this.sunCatName = sunCatName;
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

	public int getRmIsCritical() {
		return rmIsCritical;
	}

	public void setRmIsCritical(int rmIsCritical) {
		this.rmIsCritical = rmIsCritical;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	@Override
	public String toString() {
		return "GetRawMaterialByGroup [rmId=" + rmId + ", rmName=" + rmName + ", grpId=" + grpId + ", grpName="
				+ grpName + ", catId=" + catId + ", catName=" + catName + ", subCatId=" + subCatId + ", sunCatName="
				+ sunCatName + ", rmPackQty=" + rmPackQty + ", rmRate=" + rmRate + ", taxId=" + taxId + ", bmsRolQty="
				+ bmsRolQty + ", storeRolQty=" + storeRolQty + ", sgstPer=" + sgstPer + ", cgstPer=" + cgstPer
				+ ", igstPer=" + igstPer + ", rmIsCritical=" + rmIsCritical + "]";
	}
     
}

package com.ats.webapi.model.tally;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="tallysp")
//@Table(name="m_sp_cake")
public class SpecialCake implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_id")
	private int id;
	
	@Column(name="sp_name")
	private String ItemName;

	@Transient
	private String itemGroup;
	
	@Transient
	private String subGroup;
	
	@Transient
	private String subSubGroup;
	
	@Column(name="sp_hsncd")
	private String hsnCode;
	
	@Column(name="sp_uom")
	private String uom;
	
	@Column(name="sp_tax1")
	private float sgstPer;
	
	@Column(name="sp_tax2")
	private float cgstPer;
	
	@Column(name="sp_tax3")
	private float igstPer;

	@Column(name="sp_cess")
	private float cessPer;
	
	@Column(name="sp_code")
	private String spCode;
	
	@Column(name="sp_rate1")
	private float spRate1;
	
	@Column(name="sp_rate2")
	private float spRate2;
	
	@Column(name="sp_rate3")
	private float spRate3;
	
	@Column(name="mrp_rate1")
	private float mrpRate1;
	
	@Column(name="mrp_rate2")
	private float mrpRate2;
	
	@Column(name="mrp_rate3")
	private float mrpRate3;
	
	@Column(name="erp_link_code")
	private String erpLinkCode;

	@PostLoad
	public void onLoad() {
		this.itemGroup="Special Cake";
		this.subGroup="Special Cake";
		this.subSubGroup="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

	public String getSubSubGroup() {
		return subSubGroup;
	}

	public void setSubSubGroup(String subSubGroup) {
		this.subSubGroup = subSubGroup;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
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

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	public float getSpRate1() {
		return spRate1;
	}

	public void setSpRate1(float spRate1) {
		this.spRate1 = spRate1;
	}

	public float getSpRate2() {
		return spRate2;
	}

	public void setSpRate2(float spRate2) {
		this.spRate2 = spRate2;
	}

	public float getSpRate3() {
		return spRate3;
	}

	public void setSpRate3(float spRate3) {
		this.spRate3 = spRate3;
	}

	public float getMrpRate1() {
		return mrpRate1;
	}

	public void setMrpRate1(float mrpRate1) {
		this.mrpRate1 = mrpRate1;
	}

	public float getMrpRate2() {
		return mrpRate2;
	}

	public void setMrpRate2(float mrpRate2) {
		this.mrpRate2 = mrpRate2;
	}

	public float getMrpRate3() {
		return mrpRate3;
	}

	public void setMrpRate3(float mrpRate3) {
		this.mrpRate3 = mrpRate3;
	}

	public String getErpLinkCode() {
		return erpLinkCode;
	}

	public void setErpLinkCode(String erpLinkCode) {
		this.erpLinkCode = erpLinkCode;
	}

	@Override
	public String toString() {
		return "SpecialCake [id=" + id + ", ItemName=" + ItemName + ", itemGroup=" + itemGroup + ", subGroup="
				+ subGroup + ", subSubGroup=" + subSubGroup + ", hsnCode=" + hsnCode + ", uom=" + uom + ", sgstPer="
				+ sgstPer + ", cgstPer=" + cgstPer + ", igstPer=" + igstPer + ", cessPer=" + cessPer + ", spCode="
				+ spCode + ", spRate1=" + spRate1 + ", spRate2=" + spRate2 + ", spRate3=" + spRate3 + ", mrpRate1="
				+ mrpRate1 + ", mrpRate2=" + mrpRate2 + ", mrpRate3=" + mrpRate3 + ", erpLinkCode=" + erpLinkCode + "]";
	}

	
}

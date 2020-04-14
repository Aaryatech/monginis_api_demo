package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GenerateSpBill {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_order_no")
	private int spOrderNo;
	
	@Column(name="fr_id")
	int  frId;
	
	@Column(name="is_same_state")
	int  isSameState;
	
	@Column(name="menu_id")
	int  menuId;
	
	@Column(name="sp_id")
	int  spId;
			
	@Column(name="sp_backend_rate") //orderRate
	float  spBackendRate;
	
	@Column(name="sp_grand_total") // orderMrp
	float  spGrandTotal;
	
	@Column(name="fr_name")
	String  frName;
	
	@Column(name="menu_title")
	String  menuTitle;
	
	@Column(name="sp_name")
	String  spName;
	
	@Column(name="cat_id")
	int  catId;
	
	@Column(name="fr_code")
	String  frCode;
	
	@Column(name="fr_rate_cat")
	int  rateType;
	
	@Column(name="sub_cat_id")
	int  subCatId;
	
	@Column(name="sp_tax1")
	private double spTax1;
	
	@Column(name="sp_tax2")
	private double spTax2;
	
	@Column(name="sp_tax3")
	private double spTax3;
		
	@Column(name="sp_delivery_date") // delivery Date
	Date  spDeliveryDate;

	@Column(name="disc")
	private float disc;//% of disc added on 6 feb 19 for disc to fr
	
	@Column(name="party_name")
	private String  partyName;//new
	
	@Column(name="party_gstin")//new
	private String  partyGstin;
	
	@Column(name="party_address")//new
	private String  partyAddress;
	
	@Column(name="hsn_code")//new
	private String  hsnCode;
	
	
	public String getHsnCode() {
		return hsnCode;
	}


	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}


	public String getPartyName() {
		return partyName;
	}


	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}


	public String getPartyGstin() {
		return partyGstin;
	}


	public void setPartyGstin(String partyGstin) {
		this.partyGstin = partyGstin;
	}


	public String getPartyAddress() {
		return partyAddress;
	}


	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}


	public float getDisc() {
		return disc;
	}


	public void setDisc(float disc) {
		this.disc = disc;
	}


	public int getSpOrderNo() {
		return spOrderNo;
	}


	public void setSpOrderNo(int spOrderNo) {
		this.spOrderNo = spOrderNo;
	}


	public int getFrId() {
		return frId;
	}


	public void setFrId(int frId) {
		this.frId = frId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getSpId() {
		return spId;
	}


	public void setSpId(int spId) {
		this.spId = spId;
	}

	

	public float getSpBackendRate() {
		return spBackendRate;
	}


	public void setSpBackendRate(float spBackendRate) {
		this.spBackendRate = spBackendRate;
	}


	public float getSpGrandTotal() {
		return spGrandTotal;
	}


	public void setSpGrandTotal(float spGrandTotal) {
		this.spGrandTotal = spGrandTotal;
	}


	public String getFrName() {
		return frName;
	}


	public void setFrName(String frName) {
		this.frName = frName;
	}


	public String getMenuTitle() {
		return menuTitle;
	}


	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}


	public String getSpName() {
		return spName;
	}


	public void setSpName(String spName) {
		this.spName = spName;
	}


	public int getCatId() {
		return catId;
	}


	public void setCatId(int catId) {
		this.catId = catId;
	}


	public String getFrCode() {
		return frCode;
	}


	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}


	public int getRateType() {
		return rateType;
	}


	public void setRateType(int rateType) {
		this.rateType = rateType;
	}


	public int getSubCatId() {
		return subCatId;
	}


	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}


	public double getSpTax1() {
		return spTax1;
	}


	public void setSpTax1(double spTax1) {
		this.spTax1 = spTax1;
	}


	public double getSpTax2() {
		return spTax2;
	}


	public void setSpTax2(double spTax2) {
		this.spTax2 = spTax2;
	}


	public double getSpTax3() {
		return spTax3;
	}


	public void setSpTax3(double spTax3) {
		this.spTax3 = spTax3;
	}


	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpDeliveryDate() {
		return spDeliveryDate;
	}


	public void setSpDeliveryDate(Date spDeliveryDate) {
		this.spDeliveryDate = spDeliveryDate;
	}


	public int getIsSameState() {
		return isSameState;
	}


	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}


	@Override
	public String toString() {
		return "GenerateSpBill [spOrderNo=" + spOrderNo + ", frId=" + frId + ", isSameState=" + isSameState
				+ ", menuId=" + menuId + ", spId=" + spId + ", spBackendRate=" + spBackendRate + ", spGrandTotal="
				+ spGrandTotal + ", frName=" + frName + ", menuTitle=" + menuTitle + ", spName=" + spName + ", catId="
				+ catId + ", frCode=" + frCode + ", rateType=" + rateType + ", subCatId=" + subCatId + ", spTax1="
				+ spTax1 + ", spTax2=" + spTax2 + ", spTax3=" + spTax3 + ", spDeliveryDate=" + spDeliveryDate
				+ ", disc=" + disc + ", partyName=" + partyName + ", partyGstin=" + partyGstin + ", partyAddress="
				+ partyAddress + ", hsnCode=" + hsnCode + "]";
	}
    
    
}

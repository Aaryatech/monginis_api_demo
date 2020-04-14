package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;
@Entity
@Table(name = "m_sp_cake")
public class SpecialCake implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_id")
	private int spId;
	
	@Column(name = "sp_code")
	private String spCode;
	
	@Column(name="sp_name")
	private String spName;
	
	@Column(name="sp_type")
	private int spType;
	
	@Column(name="sp_min_wt")
	private String spMinwt;
	
	@Column(name="sp_max_wt")
	private String spMaxwt;
	
	@Column(name="sp_book_b4")
	private String spBookb4;
	
	@Column(name="spr_id")
	private int sprId;
	
	@Column(name="sp_image")
	private String spImage;
	
	@Column(name="sp_tax1")
	private double spTax1;
	
	@Column(name="sp_tax2")
	private double spTax2;
	
	@Column(name="sp_tax3")
	private double spTax3;
	
	@Column(name="spe_id_list")
	private String speIdlist;
	
	@Column(name="erp_link_code")
	private String erpLinkcode;
	
	@Column(name="is_used")
	private int isUsed;
	
	@Column(name="sp_pho_upload")
	private int spPhoupload;
	
	@Column(name="time_two_appli")
	private int timeTwoappli;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="base_code")
	private String baseCode;
	
	@Column(name="sp_desc")
	private String spDesc;
	
	@Column(name="order_qty")
	private int orderQty;
	
	@Column(name="order_discount")
	private float orderDiscount;
	
	@Column(name="is_cust_choice_ck")
	private int isCustChoiceCk;
	
	@Column(name="is_addon_rate_appli")
	private int isAddonRateAppli;
	
	
	@Column(name="mrp_rate1")
	private float mrpRate1;
	
	@Column(name="mrp_rate2")
	private float mrpRate2;
	
	@Column(name="mrp_rate3")
	private float mrpRate3;
	
	@Column(name="sp_rate1")
	private float spRate1;
	
	@Column(name="sp_rate2")
	private float spRate2;
	
	
	@Column(name="sp_rate3")
	private float spRate3;
	
	@Column(name="is_slot_used")
	private int isSlotUsed;
		
	private int noOfChars;//new 
	
	
	public int getNoOfChars() {
		return noOfChars;
	}
	public void setNoOfChars(int noOfChars) {
		this.noOfChars = noOfChars;
	}
	public int getIsSlotUsed() {
		return isSlotUsed;
	}
	public void setIsSlotUsed(int isSlotUsed) {
		this.isSlotUsed = isSlotUsed;
	}
	public String getSpDesc() {
		return spDesc;
	}
	public void setSpDesc(String spDesc) {
		this.spDesc = spDesc;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	

	
	public float getOrderDiscount() {
		return orderDiscount;
	}
	public void setOrderDiscount(float orderDiscount) {
		this.orderDiscount = orderDiscount;
	}
	public int getIsCustChoiceCk() {
		return isCustChoiceCk;
	}
	public void setIsCustChoiceCk(int isCustChoiceCk) {
		this.isCustChoiceCk = isCustChoiceCk;
	}
	public int getIsAddonRateAppli() {
		return isAddonRateAppli;
	}
	public void setIsAddonRateAppli(int isAddonRateAppli) {
		this.isAddonRateAppli = isAddonRateAppli;
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
	
	public int getSpId() {
		return spId;
	}
	public void setSpId(int spId) {
		this.spId = spId;
	}
	public String getSpCode() {
		return spCode;
	}
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public int getSpType() {
		return spType;
	}
	public void setSpType(int spType) {
		this.spType = spType;
	}
	public String getSpMinwt() {
		return spMinwt;
	}
	public void setSpMinwt(String spMinwt) {
		this.spMinwt = spMinwt;
	}
	public String getSpMaxwt() {
		return spMaxwt;
	}
	public void setSpMaxwt(String spMaxwt) {
		this.spMaxwt = spMaxwt;
	}
	public String getSpBookb4() {
		return spBookb4;
	}
	public void setSpBookb4(String spBookb4) {
		this.spBookb4 = spBookb4;
	}
	public int getSprId() {
		return sprId;
	}
	public void setSprId(int sprId) {
		this.sprId = sprId;
	}
	
	public String getSpImage() {
		return spImage;
	}
	public void setSpImage(String spImage) {
		this.spImage = spImage;
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
	public String getSpeIdlist() {
		return speIdlist;
	}
	public void setSpeIdlist(String speIdlist) {
		this.speIdlist = speIdlist;
	}
	public String getErpLinkcode() {
		return erpLinkcode;
	}
	public void setErpLinkcode(String erpLinkcode) {
		this.erpLinkcode = erpLinkcode;
	}
	public int getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}
	public int getSpPhoupload() {
		return spPhoupload;
	}
	public void setSpPhoupload(int spPhoupload) {
		this.spPhoupload = spPhoupload;
	}
	public int getTimeTwoappli() {
		return timeTwoappli;
	}
	public void setTimeTwoappli(int timeTwoappli) {
		this.timeTwoappli = timeTwoappli;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	public String getBaseCode() {
		return baseCode;
	}
	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}
	@Override
	public String toString() {
		return "SpecialCake [spId=" + spId + ", spCode=" + spCode + ", spName=" + spName + ", spType=" + spType
				+ ", spMinwt=" + spMinwt + ", spMaxwt=" + spMaxwt + ", spBookb4=" + spBookb4 + ", sprId=" + sprId
				+ ", spImage=" + spImage + ", spTax1=" + spTax1 + ", spTax2=" + spTax2 + ", spTax3=" + spTax3
				+ ", speIdlist=" + speIdlist + ", erpLinkcode=" + erpLinkcode + ", isUsed=" + isUsed + ", spPhoupload="
				+ spPhoupload + ", timeTwoappli=" + timeTwoappli + ", delStatus=" + delStatus + ", baseCode=" + baseCode
				+ ", spDesc=" + spDesc + ", orderQty=" + orderQty + ", orderDiscount=" + orderDiscount
				+ ", isCustChoiceCk=" + isCustChoiceCk + ", isAddonRateAppli=" + isAddonRateAppli + ", mrpRate1="
				+ mrpRate1 + ", mrpRate2=" + mrpRate2 + ", mrpRate3=" + mrpRate3 + ", spRate1=" + spRate1 + ", spRate2="
				+ spRate2 + ", spRate3=" + spRate3 + ", isSlotUsed=" + isSlotUsed + ", noOfChars=" + noOfChars + "]";
	}
	 
}

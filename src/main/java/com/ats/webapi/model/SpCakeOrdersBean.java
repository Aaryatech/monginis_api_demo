package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "spCakeOrdersBean")
// bean to be changed frId inserted
@Immutable
public class SpCakeOrdersBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sp_order_no")
	private int spOrderNo;

	@Column(name = "sp_code") // m_sp_cake
	private String spCode;

	@Column(name = "sp_name") // m_sp_cake
	private String spName;

	// @Column(name="sp_flavour")
	private String spfName;

	// @Column(name="sp_events")
	private String spEvents;

	@Column(name = "sp_delivery_date")
	private Date spDeliveryDate;

	// @Column(name="sp_price")
	private float spPrice;

	@Column(name = "sp_total_add_rate")
	private float spTotalAddRate;

	@Column(name = "fr_name") // franchisee table
	private String frName;

	@Column(name = "item_id")
	private String itemId;

	private float spSelectedWeight;
	
	@Column(name = "sp_booked_for_name")
	private String spBookedForName;
	
	@Column(name = "is_allocated")
	private int isAllocated;

	@Column(name = "is_bill_generated")
	private int isBillGenerated;
	
	private int  slipNo;
	
	private String spImage;
	
	
	
	public String getSpImage() {
		return spImage;
	}

	public void setSpImage(String spImage) {
		this.spImage = spImage;
	}

	public int getSlipNo() {
		return slipNo;
	}

	public void setSlipNo(int slipNo) {
		this.slipNo = slipNo;
	}

	public int getIsBillGenerated() {
		return isBillGenerated;
	}

	public void setIsBillGenerated(int isBillGenerated) {
		this.isBillGenerated = isBillGenerated;
	}

	public String getSpBookedForName() {
		return spBookedForName;
	}

	public void setSpBookedForName(String spBookedForName) {
		this.spBookedForName = spBookedForName;
	}

	public int getIsAllocated() {
		return isAllocated;
	}

	public void setIsAllocated(int isAllocated) {
		this.isAllocated = isAllocated;
	}

	public float getSpSelectedWeight() {
		return spSelectedWeight;
	}

	public void setSpSelectedWeight(float spSelectedWeight) {
		this.spSelectedWeight = spSelectedWeight;
	}

	public int getSpOrderNo() {
		return spOrderNo;
	}

	public void setSpOrderNo(int spOrderNo) {
		this.spOrderNo = spOrderNo;
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

	public String getSpfName() {
		return spfName;
	}

	public void setSpfName(String spfName) {
		this.spfName = spfName;
	}

	public String getSpEvents() {
		return spEvents;
	}

	public void setSpEvents(String spEvents) {
		this.spEvents = spEvents;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpDeliveryDate() {
		return spDeliveryDate;
	}

	public void setSpDeliveryDate(Date spDeliveryDate) {
		this.spDeliveryDate = spDeliveryDate;
	}

	public float getSpPrice() {
		return spPrice;
	}

	public void setSpPrice(float spPrice) {
		this.spPrice = spPrice;
	}

	public float getSpTotalAddRate() {
		return spTotalAddRate;
	}

	public void setSpTotalAddRate(float spTotalAddRate) {
		this.spTotalAddRate = spTotalAddRate;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "SpCakeOrdersBean [spOrderNo=" + spOrderNo + ", spCode=" + spCode + ", spName=" + spName + ", spfName="
				+ spfName + ", spEvents=" + spEvents + ", spDeliveryDate=" + spDeliveryDate + ", spPrice=" + spPrice
				+ ", spTotalAddRate=" + spTotalAddRate + ", frName=" + frName + ", itemId=" + itemId
				+ ", spSelectedWeight=" + spSelectedWeight + ", spBookedForName=" + spBookedForName + ", isAllocated="
				+ isAllocated + ", isBillGenerated=" + isBillGenerated + ", slipNo=" + slipNo + ", spImage=" + spImage
				+ "]";
	}

	
}

package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class SpCkOrderHis implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sp_order_no")
	private int spOrderNo;

	@Column(name = "fr_code")
	private String frCode;
	
	@Column(name = "sp_type")
	private int spType;
	
	@Column(name = "sp_id")
	private int spId;
	
	@Column(name = "fr_id")
	private int frId; 

	
	@Column(name = "item_id")
	private String itemId;
	
	@Column(name = "menu_id")
	private int menuId;
	
	@Column(name = "sp_flavour_id")
	private int spFlavourId;
	
	@Column(name = "sp_selected_weight")
	private float spSelectedWeight;
	
	@Column(name = "sp_delivery_place")
	private String spDeliveryPlace;
	
	@Column(name = "sp_min_weight")
	private float spMinWeight;
	
	@Column(name = "sp_max_weight")
	private float spMaxWeight;
	
	@Column(name = "sp_prod_time")
	private int spProdTime;
	
	@Column(name = "sp_est_deli_date")
	private Date spEstDeliDate;
	
	//@Column(name = "sp_prod_date")
	private Date spProdDate;
	
	@Column(name = "sp_events")
	private String spEvents;
	
	@Column(name = "sp_events_name")
	private String spEventsName;
	
	@Column(name = "sp_instructions")
	private String spInstructions;
	
	@Column(name = "sp_delivery_date")
	private Date spDeliveryDate;
	
	@Column(name = "sp_cust_name")
	private String spCustName;
	
	
	@Column(name = "sp_cust_dob")
	private Date spCustDob;
	
	@Column(name = "cust_gstin")//new 16 jan
	private String custGstNo;
	
	@Column(name = "sp_cust_mob_no")
	private String spCustMobNo;
	
	@Column(name = "sp_booked_for_name")
	private String spBookedForName;
	
	@Column(name = "sp_book_for_dob")
	private Date spBookForDob;
	
	@Column(name = "sp_book_for_mob_no")
	private String spBookForMobNo;
	
	@Column(name = "sp_grand_total")
	private float spGrandTotal;
	
	@Column(name = "sp_price")
	private float spPrice;
	
	@Column(name = "sp_total_add_rate")
	private float spTotalAddRate;
	
	@Column(name = "sp_backend_rate")
	private float spBackendRate;
	
	@Column(name = "sp_sub_total")
	private float spSubTotal;
	
	@Column(name = "sp_advance")
	private float spAdvance;
	
	@Column(name = "rm_amount")
	private float rmAmount;
	
	@Column(name = "tax_1")
	private float tax1;
	
	@Column(name = "tax_2")
	private float tax2;
	
	@Column(name = "tax_1_amt")
	private float tax1Amt;
	
	@Column(name = "tax_2_amt")
	private float tax2Amt;
	
	@Column(name = "order_photo")
	private String orderPhoto;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "order_photo2")
	private String orderPhoto2;
	
	@Column(name = "is_slot_used")
	private int isSlotUsed;

    private String spfName;

    private int isBillGenerated;
    
    private String spName;

    

	public int getIsBillGenerated() {
		return isBillGenerated;
	}


	public void setIsBillGenerated(int isBillGenerated) {
		this.isBillGenerated = isBillGenerated;
	}


	public int getSpOrderNo() {
		return spOrderNo;
	}


	public void setSpOrderNo(int spOrderNo) {
		this.spOrderNo = spOrderNo;
	}


	public String getFrCode() {
		return frCode;
	}


	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}


	public int getSpType() {
		return spType;
	}


	public void setSpType(int spType) {
		this.spType = spType;
	}


	public int getSpId() {
		return spId;
	}


	public void setSpId(int spId) {
		this.spId = spId;
	}


	public int getFrId() {
		return frId;
	}


	public void setFrId(int frId) {
		this.frId = frId;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getSpFlavourId() {
		return spFlavourId;
	}


	public void setSpFlavourId(int spFlavourId) {
		this.spFlavourId = spFlavourId;
	}


	public float getSpSelectedWeight() {
		return spSelectedWeight;
	}


	public void setSpSelectedWeight(float spSelectedWeight) {
		this.spSelectedWeight = spSelectedWeight;
	}


	public String getSpDeliveryPlace() {
		return spDeliveryPlace;
	}


	public void setSpDeliveryPlace(String spDeliveryPlace) {
		this.spDeliveryPlace = spDeliveryPlace;
	}


	public float getSpMinWeight() {
		return spMinWeight;
	}


	public void setSpMinWeight(float spMinWeight) {
		this.spMinWeight = spMinWeight;
	}


	public float getSpMaxWeight() {
		return spMaxWeight;
	}


	public void setSpMaxWeight(float spMaxWeight) {
		this.spMaxWeight = spMaxWeight;
	}


	public int getSpProdTime() {
		return spProdTime;
	}


	public void setSpProdTime(int spProdTime) {
		this.spProdTime = spProdTime;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpEstDeliDate() {
		return spEstDeliDate;
	}


	public void setSpEstDeliDate(Date spEstDeliDate) {
		this.spEstDeliDate = spEstDeliDate;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpProdDate() {
		return spProdDate;
	}


	public void setSpProdDate(Date spProdDate) {
		this.spProdDate = spProdDate;
	}


	public String getSpEvents() {
		return spEvents;
	}


	public void setSpEvents(String spEvents) {
		this.spEvents = spEvents;
	}


	public String getSpEventsName() {
		return spEventsName;
	}


	public void setSpEventsName(String spEventsName) {
		this.spEventsName = spEventsName;
	}


	public String getSpInstructions() {
		return spInstructions;
	}


	public void setSpInstructions(String spInstructions) {
		this.spInstructions = spInstructions;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpDeliveryDate() {
		return spDeliveryDate;
	}


	public void setSpDeliveryDate(Date spDeliveryDate) {
		this.spDeliveryDate = spDeliveryDate;
	}


	public String getSpCustName() {
		return spCustName;
	}


	public void setSpCustName(String spCustName) {
		this.spCustName = spCustName;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpCustDob() {
		return spCustDob;
	}


	public void setSpCustDob(Date spCustDob) {
		this.spCustDob = spCustDob;
	}


	public String getSpCustMobNo() {
		return spCustMobNo;
	}


	public void setSpCustMobNo(String spCustMobNo) {
		this.spCustMobNo = spCustMobNo;
	}


	public String getSpBookedForName() {
		return spBookedForName;
	}


	public void setSpBookedForName(String spBookedForName) {
		this.spBookedForName = spBookedForName;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpBookForDob() {
		return spBookForDob;
	}


	public void setSpBookForDob(Date spBookForDob) {
		this.spBookForDob = spBookForDob;
	}


	public String getSpBookForMobNo() {
		return spBookForMobNo;
	}


	public void setSpBookForMobNo(String spBookForMobNo) {
		this.spBookForMobNo = spBookForMobNo;
	}


	public float getSpGrandTotal() {
		return spGrandTotal;
	}


	public void setSpGrandTotal(float spGrandTotal) {
		this.spGrandTotal = spGrandTotal;
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


	public float getSpBackendRate() {
		return spBackendRate;
	}


	public void setSpBackendRate(float spBackendRate) {
		this.spBackendRate = spBackendRate;
	}


	public float getSpSubTotal() {
		return spSubTotal;
	}


	public void setSpSubTotal(float spSubTotal) {
		this.spSubTotal = spSubTotal;
	}


	public float getSpAdvance() {
		return spAdvance;
	}


	public void setSpAdvance(float spAdvance) {
		this.spAdvance = spAdvance;
	}


	public float getRmAmount() {
		return rmAmount;
	}


	public void setRmAmount(float rmAmount) {
		this.rmAmount = rmAmount;
	}


	public float getTax1() {
		return tax1;
	}


	public void setTax1(float tax1) {
		this.tax1 = tax1;
	}


	public float getTax2() {
		return tax2;
	}


	public void setTax2(float tax2) {
		this.tax2 = tax2;
	}


	public float getTax1Amt() {
		return tax1Amt;
	}


	public void setTax1Amt(float tax1Amt) {
		this.tax1Amt = tax1Amt;
	}


	public float getTax2Amt() {
		return tax2Amt;
	}


	public void setTax2Amt(float tax2Amt) {
		this.tax2Amt = tax2Amt;
	}


	public String getOrderPhoto() {
		return orderPhoto;
	}


	public void setOrderPhoto(String orderPhoto) {
		this.orderPhoto = orderPhoto;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderPhoto2() {
		return orderPhoto2;
	}


	public void setOrderPhoto2(String orderPhoto2) {
		this.orderPhoto2 = orderPhoto2;
	}


	public int getIsSlotUsed() {
		return isSlotUsed;
	}


	public void setIsSlotUsed(int isSlotUsed) {
		this.isSlotUsed = isSlotUsed;
	}


	public String getSpfName() {
		return spfName;
	}


	public void setSpfName(String spfName) {
		this.spfName = spfName;
	}


	public String getSpName() {
		return spName;
	}


	public void setSpName(String spName) {
		this.spName = spName;
	}
    

	public String getCustGstNo() {
		return custGstNo;
	}


	public void setCustGstNo(String custGstNo) {
		this.custGstNo = custGstNo;
	}


	@Override
	public String toString() {
		return "SpCkOrderHis [spOrderNo=" + spOrderNo + ", frCode=" + frCode + ", spType=" + spType + ", spId=" + spId
				+ ", frId=" + frId + ", itemId=" + itemId + ", menuId=" + menuId + ", spFlavourId=" + spFlavourId
				+ ", spSelectedWeight=" + spSelectedWeight + ", spDeliveryPlace=" + spDeliveryPlace + ", spMinWeight="
				+ spMinWeight + ", spMaxWeight=" + spMaxWeight + ", spProdTime=" + spProdTime + ", spEstDeliDate="
				+ spEstDeliDate + ", spProdDate=" + spProdDate + ", spEvents=" + spEvents + ", spEventsName="
				+ spEventsName + ", spInstructions=" + spInstructions + ", spDeliveryDate=" + spDeliveryDate
				+ ", spCustName=" + spCustName + ", spCustDob=" + spCustDob + ", custGstNo=" + custGstNo
				+ ", spCustMobNo=" + spCustMobNo + ", spBookedForName=" + spBookedForName + ", spBookForDob="
				+ spBookForDob + ", spBookForMobNo=" + spBookForMobNo + ", spGrandTotal=" + spGrandTotal + ", spPrice="
				+ spPrice + ", spTotalAddRate=" + spTotalAddRate + ", spBackendRate=" + spBackendRate + ", spSubTotal="
				+ spSubTotal + ", spAdvance=" + spAdvance + ", rmAmount=" + rmAmount + ", tax1=" + tax1 + ", tax2="
				+ tax2 + ", tax1Amt=" + tax1Amt + ", tax2Amt=" + tax2Amt + ", orderPhoto=" + orderPhoto + ", orderDate="
				+ orderDate + ", orderPhoto2=" + orderPhoto2 + ", isSlotUsed=" + isSlotUsed + ", spfName=" + spfName
				+ ", isBillGenerated=" + isBillGenerated + ", spName=" + spName + "]";
	}
    
}

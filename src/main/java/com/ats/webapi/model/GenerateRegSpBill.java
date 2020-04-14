package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GenerateRegSpBill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name="rsp_id")
		private int rspId;
	
		@Column(name="fr_id")
		private int frId;
	
		@Column(name="fr_code")
	    private String frCode;
	    
	    @Column(name="item_id")
	    private int itemId;
	
	    @Column(name="menu_id")
	    private int menuId;
	    
	    @Column(name="rate")
	    private float rate;
	    
	    @Column(name="mrp")
	    private float mrp;
	    
	    @Column(name="rate_cat")
	    private int rateCat;
	    
	    @Column(name="qty")
	    private int qty;
	    
	    
	    @Column(name="is_same_state")
	    private int isSameState;
	    
	    
	    @Column(name="rsp_delivery_dt")
	    private Date rspDeliveryDt;
	    
	    
	    @Column(name="fr_name")
		String  frName;
		
	    
	    @Column(name="item_name")
		String  itemName;
	    
	    
		@Column(name="menu_title")
		String  menuTitle;
		
	
		@Column(name="item_grp1")
		int  itemGrp1;
		
		@Column(name="item_grp2")
		int  itemGrp2;
		
	
		@Column(name="item_tax1")
		private double itemTax1;
		
		@Column(name="item_tax2")
		private double itemTax2;
		
		@Column(name="item_tax3")
		private double itemTax3;
	    
		@Column(name="item_shelf_life")
		private int item_shelf_life;

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

		public int getIsSameState() {
			return isSameState;
		}

		public void setIsSameState(int isSameState) {
			this.isSameState = isSameState;
		}

		public int getRspId() {
			return rspId;
		}

		public void setRspId(int rspId) {
			this.rspId = rspId;
		}

		public int getFrId() {
			return frId;
		}

		public void setFrId(int frId) {
			this.frId = frId;
		}

		public String getFrCode() {
			return frCode;
		}

		public void setFrCode(String frCode) {
			this.frCode = frCode;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public int getMenuId() {
			return menuId;
		}

		public void setMenuId(int menuId) {
			this.menuId = menuId;
		}

		public float getRate() {
			return rate;
		}

		public void setRate(float rate) {
			this.rate = rate;
		}

		public float getMrp() {
			return mrp;
		}

		public void setMrp(float mrp) {
			this.mrp = mrp;
		}

		public int getRateCat() {
			return rateCat;
		}

		public void setRateCat(int rateCat) {
			this.rateCat = rateCat;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public Date getRspDeliveryDt() {
			return rspDeliveryDt;
		}

		public void setRspDeliveryDt(Date rspDeliveryDt) {
			this.rspDeliveryDt = rspDeliveryDt;
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

		public int getItemGrp1() {
			return itemGrp1;
		}

		public void setItemGrp1(int itemGrp1) {
			this.itemGrp1 = itemGrp1;
		}

		public int getItemGrp2() {
			return itemGrp2;
		}

		public void setItemGrp2(int itemGrp2) {
			this.itemGrp2 = itemGrp2;
		}

		public double getItemTax1() {
			return itemTax1;
		}

		public void setItemTax1(double itemTax1) {
			this.itemTax1 = itemTax1;
		}

		public double getItemTax2() {
			return itemTax2;
		}

		public void setItemTax2(double itemTax2) {
			this.itemTax2 = itemTax2;
		}

		public double getItemTax3() {
			return itemTax3;
		}

		public void setItemTax3(double itemTax3) {
			this.itemTax3 = itemTax3;
		}

		public int getItem_shelf_life() {
			return item_shelf_life;
		}

		public void setItem_shelf_life(int item_shelf_life) {
			this.item_shelf_life = item_shelf_life;
		}

		
		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		@Override
		public String toString() {
			return "GenerateRegSpBill [rspId=" + rspId + ", frId=" + frId + ", frCode=" + frCode + ", itemId=" + itemId
					+ ", menuId=" + menuId + ", rate=" + rate + ", mrp=" + mrp + ", rateCat=" + rateCat + ", qty=" + qty
					+ ", isSameState=" + isSameState + ", rspDeliveryDt=" + rspDeliveryDt + ", frName=" + frName
					+ ", itemName=" + itemName + ", menuTitle=" + menuTitle + ", itemGrp1=" + itemGrp1 + ", itemGrp2="
					+ itemGrp2 + ", itemTax1=" + itemTax1 + ", itemTax2=" + itemTax2 + ", itemTax3=" + itemTax3
					+ ", item_shelf_life=" + item_shelf_life + ", partyName=" + partyName + ", partyGstin=" + partyGstin
					+ ", partyAddress=" + partyAddress + ", hsnCode=" + hsnCode + "]";
		}

        
}

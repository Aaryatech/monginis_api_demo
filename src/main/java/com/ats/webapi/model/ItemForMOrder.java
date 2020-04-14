package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemForMOrder implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="item_id")
	private String itemId;
	
	@Column(name="item_name")
	private String itemName;

	@Column(name="item_grp1")
	private String itemGrp1;
	
	@Column(name="item_grp2")
	private String itemGrp2;
	
	@Column(name="item_grp3")
	private String itemGrp3;
	
	@Column(name="item_rate1")
	private double itemRate1;
	
	@Column(name="item_rate2")
	private double itemRate2;
	
	@Column(name="item_mrp1")
	private double itemMrp1;
	
	@Column(name="item_mrp2")
	private double itemMrp2;
	
	@Column(name="item_mrp3")
	private double itemMrp3;
	
	@Column(name="item_image")
	private String itemImage;
	
	@Column(name="item_tax1")
	private double itemTax1;
	
	@Column(name="item_tax2")
	private double itemTax2;
	
	@Column(name="item_tax3")
	private double itemTax3;
	
	@Column(name="item_is_used")
	private int itemIsUsed;
	
	@Column(name="item_sort_id")
	private double itemSortId;
	
	@Column(name="grn_two")
	private int grnTwo;
	
	@Column(name="del_status")
	private int delStatus;
		
	@Column(name="item_rate3")
	private double itemRate3;
	
	@Column(name="min_qty")
	private int minQty;
	
	@Column(name="item_shelf_life")
	private int shelfLife;
	
    private float discPer;

    private int orderQty;
    
    
    
	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemGrp1() {
		return itemGrp1;
	}

	public void setItemGrp1(String itemGrp1) {
		this.itemGrp1 = itemGrp1;
	}

	public String getItemGrp2() {
		return itemGrp2;
	}

	public void setItemGrp2(String itemGrp2) {
		this.itemGrp2 = itemGrp2;
	}

	public String getItemGrp3() {
		return itemGrp3;
	}

	public void setItemGrp3(String itemGrp3) {
		this.itemGrp3 = itemGrp3;
	}

	public double getItemRate1() {
		return itemRate1;
	}

	public void setItemRate1(double itemRate1) {
		this.itemRate1 = itemRate1;
	}

	public double getItemRate2() {
		return itemRate2;
	}

	public void setItemRate2(double itemRate2) {
		this.itemRate2 = itemRate2;
	}

	public double getItemMrp1() {
		return itemMrp1;
	}

	public void setItemMrp1(double itemMrp1) {
		this.itemMrp1 = itemMrp1;
	}

	public double getItemMrp2() {
		return itemMrp2;
	}

	public void setItemMrp2(double itemMrp2) {
		this.itemMrp2 = itemMrp2;
	}

	public double getItemMrp3() {
		return itemMrp3;
	}

	public void setItemMrp3(double itemMrp3) {
		this.itemMrp3 = itemMrp3;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
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

	public int getItemIsUsed() {
		return itemIsUsed;
	}

	public void setItemIsUsed(int itemIsUsed) {
		this.itemIsUsed = itemIsUsed;
	}

	public double getItemSortId() {
		return itemSortId;
	}

	public void setItemSortId(double itemSortId) {
		this.itemSortId = itemSortId;
	}

	public int getGrnTwo() {
		return grnTwo;
	}

	public void setGrnTwo(int grnTwo) {
		this.grnTwo = grnTwo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public double getItemRate3() {
		return itemRate3;
	}

	public void setItemRate3(double itemRate3) {
		this.itemRate3 = itemRate3;
	}

	public int getMinQty() {
		return minQty;
	}

	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}

	public int getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	@Override
	public String toString() {
		return "ItemForMOrder [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", itemGrp1=" + itemGrp1
				+ ", itemGrp2=" + itemGrp2 + ", itemGrp3=" + itemGrp3 + ", itemRate1=" + itemRate1 + ", itemRate2="
				+ itemRate2 + ", itemMrp1=" + itemMrp1 + ", itemMrp2=" + itemMrp2 + ", itemMrp3=" + itemMrp3
				+ ", itemImage=" + itemImage + ", itemTax1=" + itemTax1 + ", itemTax2=" + itemTax2 + ", itemTax3="
				+ itemTax3 + ", itemIsUsed=" + itemIsUsed + ", itemSortId=" + itemSortId + ", grnTwo=" + grnTwo
				+ ", delStatus=" + delStatus + ", itemRate3=" + itemRate3 + ", minQty=" + minQty + ", shelfLife="
				+ shelfLife + ", discPer=" + discPer + ", orderQty=" + orderQty + "]";
	}

	
}

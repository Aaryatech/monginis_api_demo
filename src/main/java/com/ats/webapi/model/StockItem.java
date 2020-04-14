package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockItem implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;

	@Column(name="item_grp1")
	private int itemGrp1;
	
	@Column(name="item_grp2")
	private int itemGrp2;
	
	@Column(name="item_grp3")
	private String itemGrp3;
	
	@Column(name="item_rate1")
	private float itemRate1;
	
	@Column(name="item_rate2")
	private float itemRate2;
	
	@Column(name="item_mrp1")
	private float itemMrp1;
	
	@Column(name="item_mrp2")
	private float itemMrp2;
	
	@Column(name="item_mrp3")
	private float itemMrp3;
	
	@Column(name="item_image")
	private String itemImage;
	
	@Column(name="item_tax1")
	private float itemTax1;
	
	@Column(name="item_tax2")
	private float itemTax2;
	
	@Column(name="item_tax3")
	private float itemTax3;
	
	@Column(name="item_is_used")
	private int itemIsUsed;
	
	@Column(name="item_sort_id")
	private float itemSortId;
	
	@Column(name="grn_two")
	private int grnTwo;
	
	@Column(name="del_status")
	private int delStatus;
		
	@Column(name="item_rate3")
	private float itemRate3;
	
	@Column(name="min_qty")
	private int minQty;
	
	@Column(name="item_shelf_life")
	private int shelfLife;
	
	@Column(name="fr_stock_id")
	private int frStockId;
	
	@Column(name="min_qty_stock")
	private int minQtyStock;
	
	@Column(name="max_qty")
	private int maxQty;
	
	@Column(name="reorder_qty")
	private int reorderQty;
	
	@Column(name="type")
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public String getItemGrp3() {
		return itemGrp3;
	}

	public void setItemGrp3(String itemGrp3) {
		this.itemGrp3 = itemGrp3;
	}

	public float getItemRate1() {
		return itemRate1;
	}

	public void setItemRate1(float itemRate1) {
		this.itemRate1 = itemRate1;
	}

	public float getItemRate2() {
		return itemRate2;
	}

	public void setItemRate2(float itemRate2) {
		this.itemRate2 = itemRate2;
	}

	public float getItemMrp1() {
		return itemMrp1;
	}

	public void setItemMrp1(float itemMrp1) {
		this.itemMrp1 = itemMrp1;
	}

	public float getItemMrp2() {
		return itemMrp2;
	}

	public void setItemMrp2(float itemMrp2) {
		this.itemMrp2 = itemMrp2;
	}

	public float getItemMrp3() {
		return itemMrp3;
	}

	public void setItemMrp3(float itemMrp3) {
		this.itemMrp3 = itemMrp3;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public float getItemTax1() {
		return itemTax1;
	}

	public void setItemTax1(float itemTax1) {
		this.itemTax1 = itemTax1;
	}

	public float getItemTax2() {
		return itemTax2;
	}

	public void setItemTax2(float itemTax2) {
		this.itemTax2 = itemTax2;
	}

	public float getItemTax3() {
		return itemTax3;
	}

	public void setItemTax3(float itemTax3) {
		this.itemTax3 = itemTax3;
	}

	public int getItemIsUsed() {
		return itemIsUsed;
	}

	public void setItemIsUsed(int itemIsUsed) {
		this.itemIsUsed = itemIsUsed;
	}

	public float getItemSortId() {
		return itemSortId;
	}

	public void setItemSortId(float itemSortId) {
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

	public float getItemRate3() {
		return itemRate3;
	}

	public void setItemRate3(float itemRate3) {
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

	public int getFrStockId() {
		return frStockId;
	}

	public void setFrStockId(int frStockId) {
		this.frStockId = frStockId;
	}

	public int getMinQtyStock() {
		return minQtyStock;
	}

	public void setMinQtyStock(int minQtyStock) {
		this.minQtyStock = minQtyStock;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	public int getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(int reorderQty) {
		this.reorderQty = reorderQty;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "StockItem [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", itemGrp1=" + itemGrp1
				+ ", itemGrp2=" + itemGrp2 + ", itemGrp3=" + itemGrp3 + ", itemRate1=" + itemRate1 + ", itemRate2="
				+ itemRate2 + ", itemMrp1=" + itemMrp1 + ", itemMrp2=" + itemMrp2 + ", itemMrp3=" + itemMrp3
				+ ", itemImage=" + itemImage + ", itemTax1=" + itemTax1 + ", itemTax2=" + itemTax2 + ", itemTax3="
				+ itemTax3 + ", itemIsUsed=" + itemIsUsed + ", itemSortId=" + itemSortId + ", grnTwo=" + grnTwo
				+ ", delStatus=" + delStatus + ", itemRate3=" + itemRate3 + ", minQty=" + minQty + ", shelfLife="
				+ shelfLife + ", frStockId=" + frStockId + ", minQtyStock=" + minQtyStock + ", maxQty=" + maxQty
				+ ", reorderQty=" + reorderQty + ", type=" + type + "]";
	}
	
	
}

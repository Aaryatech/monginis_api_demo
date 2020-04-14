package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="other_item_stock_detail")
public class OtherItemStockDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "other_stock_detail_id")
	private int otherStockDetailId;
	
	private int otherStockHeaderId;
	private int otherItemId;
	private int openingStock;
	private int damageStock;
	private int closingStock;
	private int purchaseStock;
	private int salesStock;
	private int delStatus;
	private String exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	private float exFloat1;
	private float exFloat2;
	
	
	public int getOtherStockDetailId() {
		return otherStockDetailId;
	}
	public void setOtherStockDetailId(int otherStockDetailId) {
		this.otherStockDetailId = otherStockDetailId;
	}
	
	@Column(name = "other_stock_header_id")
	public int getOtherStockHeaderId() {
		return otherStockHeaderId;
	}
	public void setOtherStockHeaderId(int otherStockHeaderId) {
		this.otherStockHeaderId = otherStockHeaderId;
	}
	
	@Column(name = "other_item_id")
	public int getOtherItemId() {
		return otherItemId;
	}
	public void setOtherItemId(int otherItemId) {
		this.otherItemId = otherItemId;
	}
	
	@Column(name = " opening_stock ")
	public int getOpeningStock() {
		return openingStock;
	}
	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}
	
	@Column(name = "damage_stock")
	public int getDamageStock() {
		return damageStock;
	}
	public void setDamageStock(int damageStock) {
		this.damageStock = damageStock;
	}
	
	@Column(name = "closing_stock ")
	public int getClosingStock() {
		return closingStock;
	}
	public void setClosingStock(int closingStock) {
		this.closingStock = closingStock;
	}
	
	@Column(name = "purchase_stock")
	public int getPurchaseStock() {
		return purchaseStock;
	}
	public void setPurchaseStock(int purchaseStock) {
		this.purchaseStock = purchaseStock;
	}
	
	@Column(name = "sales_stock ")
	public int getSalesStock() {
		return salesStock;
	}
	public void setSalesStock(int salesStock) {
		this.salesStock = salesStock;
	}
	
	@Column(name = "del_status")
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	@Column(name = "ex_int1")
	public String getExInt1() {
		return exInt1;
	}
	public void setExInt1(String exInt1) {
		this.exInt1 = exInt1;
	}
	
	@Column(name = "ex_int2")
	public int getExInt2() {
		return exInt2;
	}
	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}
	
	@Column(name = "other_stock_detail_id")
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	
	@Column(name = "ex_var1")
	public String getExVar2() {
		return exVar2;
	}
	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}
	
	@Column(name = "ex_float1")
	public float getExFloat1() {
		return exFloat1;
	}
	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}
	
	@Column(name = "ex_float2")
	public float getExFloat2() {
		return exFloat2;
	}
	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}
	@Override
	public String toString() {
		return "other_item_stock_detail [otherStockDetailId=" + otherStockDetailId + ", otherStockHeaderId="
				+ otherStockHeaderId + ", otherItemId=" + otherItemId + ", openingStock=" + openingStock
				+ ", damageStock=" + damageStock + ", closingStock=" + closingStock + ", purchaseStock=" + purchaseStock
				+ ", salesStock=" + salesStock + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2="
				+ exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exFloat1=" + exFloat1 + ", exFloat2="
				+ exFloat2 + "]";
	}
	
	
	
	
}

package com.ats.webapi.model.stock;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="finished_good_stock_detail")
public class FinishedGoodStockDetail implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fin_stock_detail_id")
	int finStockDetailId;
	
	@Column(name = "fin_stock_id")
	int finStockId;
	
	@Column(name = "item_id")
	int itemId;
	

	@Column(name = "cat_id")//new Field 27 Jan 18
	int catId;
	
	@Transient			//new Field 27 Jan 18
	int isDayEndEnable;
	
	@Column(name = "stock_date")
	Date stockDate;
	
	@Column(name = "item_name")
	String itemName;
	
	
	@Column(name = "op_t1")
	float opT1;
	
	@Column(name = "op_t2")
	float opT2;
	
	@Column(name = "op_t3")
	float opT3;
	
	
	@Column(name = "op_total")
	float opTotal;
	
	
	@Column(name = "prod_qty")
	float prodQty;
	
	@Column(name = "rej_qty")
	float rejQty;
	
	@Column(name = "fr_sale_qty")
	float frSaleQty;
	
	@Column(name = "gate_sale_qty")
	float gateSaleQty;
	
	
	@Column(name = "clo_t1")
	float cloT1;
	
	@Column(name = "clo_t2")
	float cloT2;
	
	@Column(name = "clo_t3")
	float cloT3;
	
	@Column(name = "clo_current")
	float cloCurrent;
	
	@Column(name = "total_clo_stk")
	float totalCloStk;
	
	@Column(name = "del_status")
	int delStatus;

	public int getFinStockId() {
		return finStockId;
	}

	public void setFinStockId(int finStockId) {
		this.finStockId = finStockId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getOpT1() {
		return opT1;
	}

	public void setOpT1(float opT1) {
		this.opT1 = opT1;
	}

	public float getOpT2() {
		return opT2;
	}

	public void setOpT2(float opT2) {
		this.opT2 = opT2;
	}

	public float getOpT3() {
		return opT3;
	}

	public void setOpT3(float opT3) {
		this.opT3 = opT3;
	}

	public float getOpTotal() {
		return opTotal;
	}

	public void setOpTotal(float opTotal) {
		this.opTotal = opTotal;
	}

	public float getProdQty() {
		return prodQty;
	}

	public void setProdQty(float prodQty) {
		this.prodQty = prodQty;
	}

	public float getRejQty() {
		return rejQty;
	}

	public void setRejQty(float rejQty) {
		this.rejQty = rejQty;
	}

	public float getFrSaleQty() {
		return frSaleQty;
	}

	public void setFrSaleQty(float frSaleQty) {
		this.frSaleQty = frSaleQty;
	}

	public float getGateSaleQty() {
		return gateSaleQty;
	}

	public void setGateSaleQty(float gateSaleQty) {
		this.gateSaleQty = gateSaleQty;
	}

	public float getCloT1() {
		return cloT1;
	}

	public void setCloT1(float cloT1) {
		this.cloT1 = cloT1;
	}

	public float getCloT2() {
		return cloT2;
	}

	public void setCloT2(float cloT2) {
		this.cloT2 = cloT2;
	}

	public float getCloT3() {
		return cloT3;
	}

	public void setCloT3(float cloT3) {
		this.cloT3 = cloT3;
	}

	public float getCloCurrent() {
		return cloCurrent;
	}

	public void setCloCurrent(float cloCurrent) {
		this.cloCurrent = cloCurrent;
	}

	public float getTotalCloStk() {
		return totalCloStk;
	}

	public void setTotalCloStk(float totalCloStk) {
		this.totalCloStk = totalCloStk;
	}

	public int getFinStockDetailId() {
		return finStockDetailId;
	}

	public void setFinStockDetailId(int finStockDetailId) {
		this.finStockDetailId = finStockDetailId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	

	@Override
	public String toString() {
		return "FinishedGoodStockDetail [finStockDetailId=" + finStockDetailId + ", finStockId=" + finStockId
				+ ", itemId=" + itemId + ", catId=" + catId + ", stockDate="
				+ stockDate + ", itemName=" + itemName + ", opT1=" + opT1 + ", opT2=" + opT2 + ", opT3=" + opT3
				+ ", opTotal=" + opTotal + ", prodQty=" + prodQty + ", rejQty=" + rejQty + ", frSaleQty=" + frSaleQty
				+ ", gateSaleQty=" + gateSaleQty + ", cloT1=" + cloT1 + ", cloT2=" + cloT2 + ", cloT3=" + cloT3
				+ ", cloCurrent=" + cloCurrent + ", totalCloStk=" + totalCloStk + ", delStatus=" + delStatus + "]";
	}


	
}

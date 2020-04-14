package com.ats.webapi.model.prod;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdMixingReqP1 {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_detail_id")
	private int itemDetailId;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="rm_type")
	private int rmType;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="uom")
	private String uom;
	
	
	@Column(name="rm_qty")
	private float rmQty;
	
	@Column(name="no_pieces_per_item")
	private float noPiecesPerItem;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="plan_qty")
	private float planQty;
	@Column(name="order_qty")
	private float orderQty;
	
	@Column(name="mul_factor")
	float mulFactor;
	
	float total;

	public int getItemDetailId() {
		return itemDetailId;
	}

	public void setItemDetailId(int itemDetailId) {
		this.itemDetailId = itemDetailId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public float getRmQty() {
		return rmQty;
	}

	public void setRmQty(float rmQty) {
		this.rmQty = rmQty;
	}

	public float getNoPiecesPerItem() {
		return noPiecesPerItem;
	}

	public void setNoPiecesPerItem(float noPiecesPerItem) {
		this.noPiecesPerItem = noPiecesPerItem;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public float getPlanQty() {
		return planQty;
	}

	public void setPlanQty(float planQty) {
		this.planQty = planQty;
	}

	public float getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(float orderQty) {
		this.orderQty = orderQty;
	}

	public float getMulFactor() {
		return mulFactor;
	}

	public void setMulFactor(float mulFactor) {
		this.mulFactor = mulFactor;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "ProdMixingReqP1 [itemDetailId=" + itemDetailId + ", itemId=" + itemId + ", rmType=" + rmType + ", rmId="
				+ rmId + ", uom=" + uom + ", rmQty=" + rmQty + ", noPiecesPerItem=" + noPiecesPerItem + ", rmName="
				+ rmName + ", planQty=" + planQty + ", orderQty=" + orderQty + ", mulFactor=" + mulFactor + ", total="
				+ total + "]";
	}

}

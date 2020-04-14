package com.ats.webapi.model.rawmaterial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_item_detail")
public class ItemDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_detail_id")
	private int itemDetailId;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Transient
	private String itemName;
	
	@Column(name="no_pieces_per_item")
	private int noOfPiecesPerItem;
	
	@Column(name="rm_type")
	private int rmType;
	
	@Column(name="rm_uom_id")
	private int rmUomId;
	
	@Column(name="rm_qty")
	private float rmQty;
	
	@Column(name="rm_weight")
	private float rmWeight;
	
	@Column(name="del_status")
	private int delStatus;

	
	
	public int getNoOfPiecesPerItem() {
		return noOfPiecesPerItem;
	}

	public void setNoOfPiecesPerItem(int noOfPiecesPerItem) {
		this.noOfPiecesPerItem = noOfPiecesPerItem;
	}

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

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

	public float getRmQty() {
		return rmQty;
	}

	public void setRmQty(float rmQty) {
		this.rmQty = rmQty;
	}

	

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
    
	
	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public int getRmUomId() {
		return rmUomId;
	}

	public void setRmUomId(int rmUomId) {
		this.rmUomId = rmUomId;
	}


	public float getRmWeight() {
		return rmWeight;
	}

	public void setRmWeight(float rmWeight) {
		this.rmWeight = rmWeight;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "ItemDetail [itemDetailId=" + itemDetailId + ", itemId=" + itemId + ", rmId=" + rmId + ", rmName="
				+ rmName + ", itemName=" + itemName + ", noOfPiecesPerItem=" + noOfPiecesPerItem + ", rmType=" + rmType
				+ ", rmUomId=" + rmUomId + ", rmQty=" + rmQty + ", rmWeight=" + rmWeight + ", delStatus=" + delStatus
				+ "]";
	}
   
}

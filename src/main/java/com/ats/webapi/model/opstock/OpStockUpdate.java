package com.ats.webapi.model.opstock;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_opening_stock_update")
public class OpStockUpdate {

	@Transient
	private boolean error;

	@Transient
	private String message;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "op_stock_id")
	private int opStockId;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "cat_id")
	private int catId;

	@Column(name = "sub_cat_id")
	private int subCatId;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "old_qty")
	private float oldQty;

	@Column(name = "new_qty")
	private float newQty;

	@Column(name = "reason")
	private String reason;

	@Column(name = "date")
	private Date date;

	@Column(name = "item_name")
	private String itemName;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getOpStockId() {
		return opStockId;
	}

	public void setOpStockId(int opStockId) {
		this.opStockId = opStockId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public float getOldQty() {
		return oldQty;
	}

	public void setOldQty(float oldQty) {
		this.oldQty = oldQty;
	}

	public float getNewQty() {
		return newQty;
	}

	public void setNewQty(float newQty) {
		this.newQty = newQty;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "OpStockUpdate [error=" + error + ", message=" + message + ", opStockId=" + opStockId + ", itemId="
				+ itemId + ", catId=" + catId + ", subCatId=" + subCatId + ", delStatus=" + delStatus + ", oldQty="
				+ oldQty + ", newQty=" + newQty + ", reason=" + reason + ", date=" + date + ", itemName=" + itemName
				+ "]";
	}

}

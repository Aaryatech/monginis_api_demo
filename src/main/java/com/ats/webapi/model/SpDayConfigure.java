package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_spday_configure")
public class SpDayConfigure implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="spday_id")
	private int spdayId;

	@Column(name = "fr_id")
	private String frId;

	@Column(name = "item_id")
	private String itemId;

	@Column(name = "order_from_date")
	private Date orderFromDate;
	
	@Column(name = "order_to_date")
	private Date orderToDate;
	
	@Column(name = "delivery_to_date")
	private Date deliveryToDate;
	
	@Column(name = "delivery_from_date")
	private Date deliveryFromDate;

	
	@Column(name = "spday_name")
	private String spdayName;
	
	
	@Column(name = "from_time")
	private String fromTime;
	
	@Column(name = "to_time")
	private String toTime;
	
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "menu_id")
	private int menuId;
	
	@Column(name = "cat_id")
	private int catId;
	
	@Column(name = "sub_cat_id")
	private int subCatId;

	public int getSpdayId() {
		return spdayId;
	}

	public void setSpdayId(int spdayId) {
		this.spdayId = spdayId;
	}

	public String getFrId() {
		return frId;
	}

	public void setFrId(String frId) {
		this.frId = frId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Date getOrderFromDate() {
		return orderFromDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderFromDate(Date orderFromDate) {
		this.orderFromDate = orderFromDate;
	}

	public Date getOrderToDate() {
		return orderToDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderToDate(Date orderToDate) {
		this.orderToDate = orderToDate;
	}

	public Date getDeliveryToDate() {
		return deliveryToDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setDeliveryToDate(Date deliveryToDate) {
		this.deliveryToDate = deliveryToDate;
	}

	public Date getDeliveryFromDate() {
		return deliveryFromDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setDeliveryFromDate(Date deliveryFromDate) {
		this.deliveryFromDate = deliveryFromDate;
	}

	public String getSpdayName() {
		return spdayName;
	}

	public void setSpdayName(String spdayName) {
		this.spdayName = spdayName;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
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
	
	
	
}

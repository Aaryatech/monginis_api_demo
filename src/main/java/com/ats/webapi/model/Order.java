package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;


@Entity(name="order")
@Table(name = "t_order")

public class Order implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="order_type")
	private int orderType;
	
	@Column(name="order_sub_type")
	private int orderSubType;
	
	@Column(name="ref_id")
	private int refId;
	
	@Column(name="item_id")
	private String itemId;
	
	@Column(name="order_qty")
	private int orderQty;
	
	@Column(name="order_rate")
	private double orderRate;
	
	@Column(name="order_mrp")
	private double orderMrp;
	
	@Column(name="order_status")
	private int orderStatus;
	
	@Column(name="order_datetime")
	private String orderDatetime;
	
	@Temporal(TemporalType.DATE)
	@Column(name="production_date")
	private Date productionDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="delivery_date")
	private Date deliveryDate;
	
	@Column(name="is_edit")
	private int isEdit;
	
	@Column(name="edit_qty")
	private float editQty;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="is_positive")
	private int isPositive;

	@Column(name="menu_id")
	private int menuId;
	
	
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public int getOrderSubType() {
		return orderSubType;
	}

	public void setOrderSubType(int orderSubType) {
		this.orderSubType = orderSubType;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public double getOrderRate() {
		return orderRate;
	}

	public void setOrderRate(double orderRate) {
		this.orderRate = orderRate;
	}

	public double getOrderMrp() {
		return orderMrp;
	}

	public void setOrderMrp(double orderMrp) {
		this.orderMrp = orderMrp;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDatetime() {
		return orderDatetime;
	}

	public void setOrderDatetime(String orderDatetime) {
		this.orderDatetime = orderDatetime;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(int isEdit) {
		this.isEdit = isEdit;
	}

	public float getEditQty() {
		return editQty;
	}

	public void setEditQty(float editQty) {
		this.editQty = editQty;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(int isPositive) {
		this.isPositive = isPositive;
	}

}

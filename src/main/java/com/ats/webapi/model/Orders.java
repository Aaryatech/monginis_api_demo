package com.ats.webapi.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Orders")
@Table(name = "t_order")
public class Orders {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;

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
	
	@Column(name="production_date")
	private Date productionDate;
	
	@Column(name="delivery_date")
	private Date deliveryDate;
	
	@Column(name="is_edit")
	private int isEdit;
	
	@Column(name="edit_qty")
	private float editQty;

	@Column(name="user_id")
	private int userId;
	
	@Column(name="is_positive")
	private float isPositive;

	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="is_bill_generated")
	private int isBillGenerated;

	@Column(name="grn_type")//newly added
	private int grnType;
	
	
	
	
	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	public int getIsBillGenerated() {
		return isBillGenerated;
	}

	public void setIsBillGenerated(int isBillGenerated) {
		this.isBillGenerated = isBillGenerated;
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

	public float getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(float isPositive) {
		this.isPositive = isPositive;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", frId=" + frId + ", orderType=" + orderType
				+ ", orderSubType=" + orderSubType + ", refId=" + refId + ", itemId=" + itemId + ", orderQty="
				+ orderQty + ", orderRate=" + orderRate + ", orderMrp=" + orderMrp + ", orderStatus=" + orderStatus
				+ ", orderDatetime=" + orderDatetime + ", productionDate=" + productionDate + ", deliveryDate="
				+ deliveryDate + ", isEdit=" + isEdit + ", editQty=" + editQty + ", userId=" + userId + ", isPositive="
				+ isPositive + ", menuId=" + menuId + "]";
	}

		
	
	
		
	
	
}

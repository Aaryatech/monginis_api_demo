package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="getOrder")
//@Table(name = "t_order")
@Immutable
public class GetOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="cat_name")
	private String catName;
	@Column(name="item_name")
	private String itemName;
	
	
	@Column(name="order_qty")
	private int orderQty;
	

	@Column(name="id")
	private int Id;
	
	
	@Column(name="delivery_date")
	private Date deliveryDate;
	
	
	
	
	@Column(name="is_edit")
	private int isEdit;
	
	
	
	@Column(name="is_positive")
	private int isPositive;
	
	
	@Column(name="edit_qty")
	private float editQty;


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getFrName() {
		return frName;
	}


	public void setFrName(String frName) {
		this.frName = frName;
	}


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getOrderQty() {
		return orderQty;
	}


	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}


	


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
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


	public int getIsPositive() {
		return isPositive;
	}


	public void setIsPositive(int isPositive) {
		this.isPositive = isPositive;
	}


	public float getEditQty() {
		return editQty;
	}


	public void setEditQty(float editQty) {
		this.editQty = editQty;
	}


	@Override
	public String toString() {
		return "GetOrder [orderId=" + orderId + ", frName=" + frName + ", catName=" + catName + ", itemName=" + itemName
				+ ", orderQty=" + orderQty + ", Id=" + Id + ", deliveryDate=" + deliveryDate + ", isEdit=" + isEdit
				+ ", isPositive=" + isPositive + ", editQty=" + editQty + "]";
	}



	
}

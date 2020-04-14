package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Variance implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private int id;
	
	@Column(name="item_name")
    private String itemName;
	
	@Column(name="item_id")
    private String itemId;
	
    @Column(name="sp_cake_qty")
    private int spCakeQty;
    
	@Column(name="t_order_qty")
	private int orderQty;
	
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	 
	public int getSpCakeQty() {
		return spCakeQty;
	}

	public void setSpCakeQty(int spCakeQty) {
		this.spCakeQty = spCakeQty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "Variance [id=" + id + ", itemName=" + itemName + ", itemId=" + itemId + ", spCakeQty=" + spCakeQty
				+ ", orderQty=" + orderQty + "]";
	}
	
	
	
	
	
	
	
	
	

}

package com.ats.webapi.model.regcakeasspreport;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegCakeAsSpDispatchReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rsp_id")
		private int rspId;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="rsp_delivery_dt")
	private Date rspDeliveryDt;
	

	@Column(name="fr_name")
	private String frName;
	
	@Column(name="qty")
	int qty;
	
	@Column(name="item_name")
	String itemName;

	public int getRspId() {
		return rspId;
	}

	public void setRspId(int rspId) {
		this.rspId = rspId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Date getRspDeliveryDt() {
		return rspDeliveryDt;
	}

	public void setRspDeliveryDt(Date rspDeliveryDt) {
		this.rspDeliveryDt = rspDeliveryDt;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "RegCakeAsSpDispatchReport [rspId=" + rspId + ", frId=" + frId + ", itemId=" + itemId
				+ ", rspDeliveryDt=" + rspDeliveryDt + ", frName=" + frName + ", qty=" + qty + ", itemName=" + itemName
				+ "]";
	}

}

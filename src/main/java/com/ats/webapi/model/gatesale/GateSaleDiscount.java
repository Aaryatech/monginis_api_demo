package com.ats.webapi.model.gatesale;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_gatesale_discount")
public class GateSaleDiscount implements Serializable{

	@Transient
    private String message;
	@Transient
	private boolean isError;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="discount_id")
	private int discountId;
	
	@Column(name="discount_head")
	private String discountHead;
	
	@Column(name="discount_per")
	private float discountPer;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="user_type")
	private int userType;

	@Column(name="del_status")
	private int delStatus;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}
    
	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getDiscountHead() {
		return discountHead;
	}

	public void setDiscountHead(String discountHead) {
		this.discountHead = discountHead;
	}

	public float getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(float discountPer) {
		this.discountPer = discountPer;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GateSaleDiscount [message=" + message + ", isError=" + isError + ", discountId=" + discountId
				+ ", discountHead=" + discountHead + ", discountPer=" + discountPer + ", catId=" + catId + ", userType="
				+ userType + ", delStatus=" + delStatus + "]";
	}

	
}

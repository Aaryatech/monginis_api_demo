package com.ats.webapi.model.SupplierMaster;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm_payment_terms")
public class SupPaymentTerms implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pay_id")
	private int payId;

	@Column(name="pay_desc")
	private String payDesc;
	
	@Column(name="credit_days")
	private int creditDays;
	
	@Column(name="del_status")
	private int delStatus;

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getPayDesc() {
		return payDesc;
	}

	public void setPayDesc(String payDesc) {
		this.payDesc = payDesc;
	}

	public int getCreditDays() {
		return creditDays;
	}

	public void setCreditDays(int creditDays) {
		this.creditDays = creditDays;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "SupPaymentTerms [payId=" + payId + ", payDesc=" + payDesc + ", creditDays=" + creditDays
				+ ", delStatus=" + delStatus + "]";
	}
	
	
	

}

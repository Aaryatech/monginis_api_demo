package com.ats.webapi.model.tally;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;


@Entity(name="tallyfr")
public class Franchisee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private int customerId;
    
	@Column(name="fr_name")
	private String customerName;
	
	@Column(name="fr_address")
 	private String address1;
	
	@Transient
	private String address2;
	
	
	@Column(name="fr_city")
	private String city;
	
	@Column(name="fr_rate_cat")
	private int frRateCat;

	@Column(name="fr_state")
 	private String state;
	
	@Column(name="fr_gst_no")
 	private String GSTIN;
	
	@Transient
	private String type;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="fr_country")
 	private String country;



	@PostLoad
	public void onLoad() {
		this.type="Sundry Debtor";
		this.address2="";
	}
	
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getGSTIN() {
		return GSTIN;
	}

	public void setGSTIN(String gSTIN) {
		GSTIN = gSTIN;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getFrCode() {
		return frCode;
	}


	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	public int getFrRateCat() {
		return frRateCat;
	}

	public void setFrRateCat(int frRateCat) {
		this.frRateCat = frRateCat;
	}

	
}

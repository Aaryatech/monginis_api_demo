package com.ats.webapi.model.logistics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_logis_dealer")
public class Dealer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dealer_id")
	private int dealerId;  
	
	@Column(name = "dealer_name")
	private String dealerName; 
	
	@Column(name = "dealer_mobile_no")
	private String dealerMobileNo;
	
	@Column(name = "make_id")
	private int makeId;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "dealer_email")
	private String dealerEmail;  
	
	@Column(name = "contact_person")
	private String contactPerson; 
	
	@Column(name = "person_mobile_no")
	private String personMobileNo;
	
	@Column(name = "contact_person_email")
	private String contactPersonEmail;
	
	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "gstn_no")
	private String gstnNo;
	
	@Column(name = "is_same_state")
	private int isSameState;

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerMobileNo() {
		return dealerMobileNo;
	}

	public void setDealerMobileNo(String dealerMobileNo) {
		this.dealerMobileNo = dealerMobileNo;
	}

	public int getMakeId() {
		return makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDealerEmail() {
		return dealerEmail;
	}

	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPersonMobileNo() {
		return personMobileNo;
	}

	public void setPersonMobileNo(String personMobileNo) {
		this.personMobileNo = personMobileNo;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	

	public String getGstnNo() {
		return gstnNo;
	}

	public void setGstnNo(String gstnNo) {
		this.gstnNo = gstnNo;
	}

	public int getIsSameState() {
		return isSameState;
	}

	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerName=" + dealerName + ", dealerMobileNo=" + dealerMobileNo
				+ ", makeId=" + makeId + ", city=" + city + ", dealerEmail=" + dealerEmail + ", contactPerson="
				+ contactPerson + ", personMobileNo=" + personMobileNo + ", contactPersonEmail=" + contactPersonEmail
				+ ", delStatus=" + delStatus + ", gstnNo=" + gstnNo + ", isSameState=" + isSameState + "]";
	}
	
	
	

}

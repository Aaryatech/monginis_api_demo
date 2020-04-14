package com.ats.webapi.model.SupplierMaster;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_supplier")
public class SupplierDetails implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="supp_id")
	private int suppId;
	
	@Column(name="supp_name")
	private String suppName;	
	
	@Column(name="supp_addr")
	private String suppAddr;

	@Column(name="supp_city")
	private String suppCity;
	
	@Column(name="supp_state")
	private String suppState;
	
	@Column(name="supp_country")
	private String suppCountry;
	
	@Column(name="supp_mob1")
	private String suppMob1;
	
	@Column(name="supp_mob2")
	private String suppMob2;
	
	@Column(name="supp_mob3")
	private String suppMob3;
	
	@Column(name="supp_phone1")
	private String suppPhone1;
	
	@Column(name="supp_phone2")
	private String suppPhone2;
	
	@Column(name="supp_email1")
	private String suppEmail1;

	@Column(name="supp_email2")
	private String suppEmail2;

	@Column(name="supp_email3")
	private String suppEmail3;

	@Column(name="supp_email4")
	private String suppEmail4;

	@Column(name="supp_email5")
	private String suppEmail5;
	
	@Column(name="supp_gstin")
	private String suppGstin;
	
	@Column(name="supp_pan_no")
	private String suppPanNo;
	
	@Column(name="supp_fda_lic")
	private String suppFdaLic;
	
	@Column(name="supp_pay_id")
	private int suppPayId;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="supp_credit_days")
	private int suppCreditDays;
	
	@Column(name="supp_c_person")
	private String suppCPerson;

	@Column(name="is_tally_sync")
	private int isTallySync;
	
	
	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppAddr() {
		return suppAddr;
	}

	public void setSuppAddr(String suppAddr) {
		this.suppAddr = suppAddr;
	}

	public String getSuppCity() {
		return suppCity;
	}

	public void setSuppCity(String suppCity) {
		this.suppCity = suppCity;
	}

	public String getSuppState() {
		return suppState;
	}

	public void setSuppState(String suppState) {
		this.suppState = suppState;
	}

	public String getSuppCountry() {
		return suppCountry;
	}

	public void setSuppCountry(String suppCountry) {
		this.suppCountry = suppCountry;
	}

	public String getSuppMob1() {
		return suppMob1;
	}

	public void setSuppMob1(String suppMob1) {
		this.suppMob1 = suppMob1;
	}

	public String getSuppMob2() {
		return suppMob2;
	}

	public void setSuppMob2(String suppMob2) {
		this.suppMob2 = suppMob2;
	}

	public String getSuppMob3() {
		return suppMob3;
	}

	public void setSuppMob3(String suppMob3) {
		this.suppMob3 = suppMob3;
	}

	public String getSuppPhone1() {
		return suppPhone1;
	}

	public void setSuppPhone1(String suppPhone1) {
		this.suppPhone1 = suppPhone1;
	}

	public String getSuppPhone2() {
		return suppPhone2;
	}

	public void setSuppPhone2(String suppPhone2) {
		this.suppPhone2 = suppPhone2;
	}

	public String getSuppEmail1() {
		return suppEmail1;
	}

	public void setSuppEmail1(String suppEmail1) {
		this.suppEmail1 = suppEmail1;
	}

	public String getSuppEmail2() {
		return suppEmail2;
	}

	public void setSuppEmail2(String suppEmail2) {
		this.suppEmail2 = suppEmail2;
	}

	public String getSuppEmail3() {
		return suppEmail3;
	}

	public void setSuppEmail3(String suppEmail3) {
		this.suppEmail3 = suppEmail3;
	}

	public String getSuppEmail4() {
		return suppEmail4;
	}

	public void setSuppEmail4(String suppEmail4) {
		this.suppEmail4 = suppEmail4;
	}

	public String getSuppEmail5() {
		return suppEmail5;
	}

	public void setSuppEmail5(String suppEmail5) {
		this.suppEmail5 = suppEmail5;
	}

	public String getSuppGstin() {
		return suppGstin;
	}

	public void setSuppGstin(String suppGstin) {
		this.suppGstin = suppGstin;
	}

	public String getSuppPanNo() {
		return suppPanNo;
	}

	public void setSuppPanNo(String suppPanNo) {
		this.suppPanNo = suppPanNo;
	}

	public String getSuppFdaLic() {
		return suppFdaLic;
	}

	public void setSuppFdaLic(String suppFdaLic) {
		this.suppFdaLic = suppFdaLic;
	}

	public int getSuppPayId() {
		return suppPayId;
	}

	public void setSuppPayId(int suppPayId) {
		this.suppPayId = suppPayId;
	}

	public int getSuppCreditDays() {
		return suppCreditDays;
	}

	public void setSuppCreditDays(int suppCreditDays) {
		this.suppCreditDays = suppCreditDays;
	}

	public String getSuppCPerson() {
		return suppCPerson;
	}

	public void setSuppCPerson(String suppCPerson) {
		this.suppCPerson = suppCPerson;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "SupplierDetails [suppId=" + suppId + ", suppName=" + suppName + ", suppAddr=" + suppAddr + ", suppCity="
				+ suppCity + ", suppState=" + suppState + ", suppCountry=" + suppCountry + ", suppMob1=" + suppMob1
				+ ", suppMob2=" + suppMob2 + ", suppMob3=" + suppMob3 + ", suppPhone1=" + suppPhone1 + ", suppPhone2="
				+ suppPhone2 + ", suppEmail1=" + suppEmail1 + ", suppEmail2=" + suppEmail2 + ", suppEmail3="
				+ suppEmail3 + ", suppEmail4=" + suppEmail4 + ", suppEmail5=" + suppEmail5 + ", suppGstin=" + suppGstin
				+ ", suppPanNo=" + suppPanNo + ", suppFdaLic=" + suppFdaLic + ", suppPayId=" + suppPayId
				+ ", delStatus=" + delStatus + ", suppCreditDays=" + suppCreditDays + ", suppCPerson=" + suppCPerson
				+ "]";
	}

 

	 
}

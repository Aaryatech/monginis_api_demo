package com.ats.webapi.model.SupplierMaster;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_transporter")
public class Transporter implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tran_id")
	private int tranId;
	
	@Column(name="tran_name")
	private String tranName;
	
	@Column(name="tran_mobile")
	private String tranMobile;
	
	@Column(name="tran_email")
	private String tranEmail;
	
	@Column(name="del_status")
	private int delStatus;

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public String getTranName() {
		return tranName;
	}

	public void setTranName(String tranName) {
		this.tranName = tranName;
	}

	public String getTranMobile() {
		return tranMobile;
	}

	public void setTranMobile(String tranMobile) {
		this.tranMobile = tranMobile;
	}

	public String getTranEmail() {
		return tranEmail;
	}

	public void setTranEmail(String tranEmail) {
		this.tranEmail = tranEmail;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Transporter [tranId=" + tranId + ", tranName=" + tranName + ", tranMobile=" + tranMobile
				+ ", tranEmail=" + tranEmail + ", delStatus=" + delStatus + "]";
	}
	
	
}

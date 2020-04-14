package com.ats.webapi.model.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name ="t_sell_bill_header")
public class GetRepFrDatewiseSell  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_no")
	private int sellBillNo;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="fr_id")
	private int frId;
	
	private String day;
	
	private float cash;
	private float card;
	private float other;
	
	@Column(name="fr_name")
	private String frName;

	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getSellBillNo() {
		return sellBillNo;
	}

	public void setSellBillNo(int sellBillNo) {
		this.sellBillNo = sellBillNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public float getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	public float getCard() {
		return card;
	}

	public void setCard(float card) {
		this.card = card;
	}

	public float getOther() {
		return other;
	}

	public void setOther(float other) {
		this.other = other;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	@Override
	public String toString() {
		return "RepFrDatewiseSell [sellBillNo=" + sellBillNo + ", billDate=" + billDate + ", frId=" + frId + ", cash="
				+ cash + ", card=" + card + ", other=" + other + ", frName=" + frName + "]";
	}
	
	

	
	
}

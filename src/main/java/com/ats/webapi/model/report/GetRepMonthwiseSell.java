package com.ats.webapi.model.report;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="t_sell_bill_header")
public class GetRepMonthwiseSell {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_no")
		private int sellBillNo;
		
		@Column(name="bill_date")
		private Date billDate;
		
		@Column(name="fr_id")
		private int frId;
		
		private String month;
		
		
		private float cash;
		private float card;
		private float other;
		
		@Column(name="fr_name")
		private String frName;

		public int getSellBillNo() {
			return sellBillNo;
		}

		public void setSellBillNo(int sellBillNo) {
			this.sellBillNo = sellBillNo;
		}

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

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		@Override
		public String toString() {
			return "GetRepMonthwiseSellModel [sellBillNo=" + sellBillNo + ", billDate=" + billDate + ", frId=" + frId
					+ ", month=" + month + ", cash=" + cash + ", card=" + card + ", other=" + other + ", frName="
					+ frName + "]";
		}

	 
		

		
		
	}

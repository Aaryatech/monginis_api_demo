package com.ats.webapi.model.stock;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="finished_good_stock")
public class FinishedGoodStock implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fin_stock_id")
	int finStockId;
	
	@Column(name = "timestamp")//new Field 27-01-2018
	String timestamp;
	
	
	@Column(name = "cat_id")
	int catId;
	
	@Column(name = "fin_good_stock_date")
	Date finGoodStockDate;
	
	@Column(name = "fin_good_stock_status")
	int finGoodStockStatus;
	
	
	@Column(name = "del_status")
	int delStatus;
	
	@Transient
	List<FinishedGoodStockDetail> finishedGoodStockDetail;

	public int getFinStockId() {
		return finStockId;
	}

	public void setFinStockId(int finStockId) {
		this.finStockId = finStockId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public Date getFinGoodStockDate() {
		return finGoodStockDate;
	}

	public void setFinGoodStockDate(Date finGoodStockDate) {
		this.finGoodStockDate = finGoodStockDate;
	}

	public int getFinGoodStockStatus() {
		return finGoodStockStatus;
	}

	public void setFinGoodStockStatus(int finGoodStockStatus) {
		this.finGoodStockStatus = finGoodStockStatus;
	}

	public List<FinishedGoodStockDetail> getFinishedGoodStockDetail() {
		return finishedGoodStockDetail;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public void setFinishedGoodStockDetail(List<FinishedGoodStockDetail> finishedGoodStockDetail) {
		this.finishedGoodStockDetail = finishedGoodStockDetail;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "FinishedGoodStock [finStockId=" + finStockId + ", timestamp=" + timestamp + ", catId=" + catId
				+ ", finGoodStockDate=" + finGoodStockDate + ", finGoodStockStatus=" + finGoodStockStatus
				+ ", delStatus=" + delStatus + ", finishedGoodStockDetail=" + finishedGoodStockDetail + "]";
	}


}

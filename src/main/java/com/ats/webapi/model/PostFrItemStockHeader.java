package com.ats.webapi.model;

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
@Table(name = "m_fr_opening_stock_header")
public class PostFrItemStockHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="opening_stock_header_id")
	private int openingStockHeaderId;
	
	@Column(name="month")
	private int month;
	
	@Column(name="year")
	private int year;
	
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="is_month_closed")
	private int isMonthClosed;

	@Transient
	private List<PostFrItemStockDetail>postFrItemStockDetailList;
	

	
	public int getOpeningStockHeaderId() {
		return openingStockHeaderId;
	}

	public void setOpeningStockHeaderId(int openingStockHeaderId) {
		this.openingStockHeaderId = openingStockHeaderId;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getIsMonthClosed() {
		return isMonthClosed;
	}

	public void setIsMonthClosed(int isMonthClosed) {
		this.isMonthClosed = isMonthClosed;
	}

	public List<PostFrItemStockDetail> getPostFrItemStockDetailList() {
		return postFrItemStockDetailList;
	}

	public void setPostFrItemStockDetailList(List<PostFrItemStockDetail> postFrItemStockDetailList) {
		this.postFrItemStockDetailList = postFrItemStockDetailList;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	@Override
	public String toString() {
		return "PostFrItemStockHeader [openingStockHeaderId=" + openingStockHeaderId + ", month=" + month + ", year="
				+ year + ", fromDate=" + fromDate + ", toDate=" + toDate + ", frId=" + frId + ", catId=" + catId
				+ ", isMonthClosed=" + isMonthClosed + ", postFrItemStockDetailList=" + postFrItemStockDetailList + "]";
	}

	
}

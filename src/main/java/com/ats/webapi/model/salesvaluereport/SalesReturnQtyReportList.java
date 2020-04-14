package com.ats.webapi.model.salesvaluereport;

import java.util.List;

public class SalesReturnQtyReportList {
	
	private String month;
	
	private List<SalesReturnQtyDao> salesReturnQtyDaoList;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public List<SalesReturnQtyDao> getSalesReturnQtyDaoList() {
		return salesReturnQtyDaoList;
	}

	public void setSalesReturnQtyDaoList(List<SalesReturnQtyDao> salesReturnQtyDaoList) {
		this.salesReturnQtyDaoList = salesReturnQtyDaoList;
	}

	@Override
	public String toString() {
		return "SalesReturnQtyReportList [month=" + month + ", salesReturnQtyDaoList=" + salesReturnQtyDaoList + "]";
	}
	
	

}

package com.ats.webapi.model.salesvaluereport;

import java.util.List;

public class SalesReturnValueDaoList {

	private String month;
	
	private List<SalesReturnValueDao> salesReturnQtyValueList;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public List<SalesReturnValueDao> getSalesReturnQtyValueList() {
		return salesReturnQtyValueList;
	}

	public void setSalesReturnQtyValueList(List<SalesReturnValueDao> salesReturnQtyValueList) {
		this.salesReturnQtyValueList = salesReturnQtyValueList;
	}

	@Override
	public String toString() {
		return "SalesReturnValueDaoRepository [month=" + month + ", salesReturnQtyValueList=" + salesReturnQtyValueList
				+ "]";
	}
	
	
	
}

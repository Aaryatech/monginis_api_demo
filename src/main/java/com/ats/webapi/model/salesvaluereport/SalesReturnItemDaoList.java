package com.ats.webapi.model.salesvaluereport;

import java.util.List;

public class SalesReturnItemDaoList {

	private String month;

	private List<SalesReturnValueItemDao> salesReturnValueItemDao;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public List<SalesReturnValueItemDao> getSalesReturnValueItemDao() {
		return salesReturnValueItemDao;
	}

	public void setSalesReturnValueItemDao(List<SalesReturnValueItemDao> salesReturnValueItemDao) {
		this.salesReturnValueItemDao = salesReturnValueItemDao;
	}

	@Override
	public String toString() {
		return "SalesReturnItemDaoList [month=" + month + ", salesReturnValueItemDao=" + salesReturnValueItemDao + "]";
	}

}

package com.ats.webapi.model.salesreport3;

import java.util.List;


public class YearlyFrAndSubCatSaleReport {
	
	private String month;
	
	private List<FrAndSubCatSale> frAndSubCatSale;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public List<FrAndSubCatSale> getFrAndSubCatSale() {
		return frAndSubCatSale;
	}

	public void setFrAndSubCatSale(List<FrAndSubCatSale> frAndSubCatSale) {
		this.frAndSubCatSale = frAndSubCatSale;
	}

	@Override
	public String toString() {
		return "YearlyFrAndSubCatSaleReport [month=" + month + ", frAndSubCatSale=" + frAndSubCatSale + "]";
	}

	
	
}

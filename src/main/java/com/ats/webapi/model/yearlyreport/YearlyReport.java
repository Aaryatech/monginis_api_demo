package com.ats.webapi.model.yearlyreport;

import java.util.List;


public class YearlyReport {
	
	private int monthId;
	private String yearId;
	private String dateStr;
	
	List<TempFrList> frList=null;

	public int getMonthId() {
		return monthId;
	}

	public void setMonthId(int monthId) {
		this.monthId = monthId;
	}

	public String getYearId() {
		return yearId;
	}

	public void setYearId(String yearId) {
		this.yearId = yearId;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public List<TempFrList> getFrList() {
		return frList;
	}

	public void setFrList(List<TempFrList> frList) {
		this.frList = frList;
	}

	@Override
	public String toString() {
		return "YearlyReport [monthId=" + monthId + ", yearId=" + yearId + ", dateStr=" + dateStr + ", frList=" + frList
				+ "]";
	}
	
	
	

}

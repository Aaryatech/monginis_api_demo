package com.ats.webapi.model.opssalesreport;

import java.util.List;


public class FrItemWiseYearlyData {
	
	private int monthId;
	private String yearId;
	private String dateStr;
	
	List<TempSubCatWiseItems> dataList=null;

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

	public List<TempSubCatWiseItems> getDataList() {
		return dataList;
	}

	public void setDataList(List<TempSubCatWiseItems> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "FrItemWiseYearlyData [monthId=" + monthId + ", yearId=" + yearId + ", dateStr=" + dateStr
				+ ", dataList=" + dataList + "]";
	}
	
	

}

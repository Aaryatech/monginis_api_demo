package com.ats.webapi.model.salesreport3;

import java.util.List;

import com.ats.webapi.model.salesreport3.FrWiseSubCat;
import com.ats.webapi.model.salesreport3.TempFrWiseSubCat;

public class YearlyFrSubCatData {
	
	private int monthId;
	private String yearId;
	private String dateStr;
	
	List<TempFrWiseSubCat> dataList=null;
	//FrSubCatBillData
	
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
	public List<TempFrWiseSubCat> getDataList() {
		return dataList;
	}
	public void setDataList(List<TempFrWiseSubCat> dataList) {
		this.dataList = dataList;
	}
	@Override
	public String toString() {
		return "YearlyFrSubCatData [monthId=" + monthId + ", yearId=" + yearId + ", dateStr=" + dateStr + ", dataList="
				+ dataList + "]";
	}
	
	
	
	

	

}

package com.ats.webapi.model.report.salecompare;

import java.util.List;

public class SalesComparison {
	
	List<SalesComparisonReport> billTotalList;
	
	List<SalesGrn> grnGvnTotalList;

	public List<SalesComparisonReport> getBillTotalList() {
		return billTotalList;
	}

	public void setBillTotalList(List<SalesComparisonReport> billTotalList) {
		this.billTotalList = billTotalList;
	}

	public List<SalesGrn> getGrnGvnTotalList() {
		return grnGvnTotalList;
	}

	public void setGrnGvnTotalList(List<SalesGrn> grnGvnTotalList) {
		this.grnGvnTotalList = grnGvnTotalList;
	}

	@Override
	public String toString() {
		return "SalesComparison [billTotalList=" + billTotalList + ", grnGvnTotalList=" + grnGvnTotalList + "]";
	}
	

}

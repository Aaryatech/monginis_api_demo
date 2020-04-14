package com.ats.webapi.model.spprod;

import java.util.List;

import com.ats.webapi.model.Info;

public class GetSpAdvTaxReportList {
	
	List<GetSpAdvTaxReport> spAdvTaxReport;
	
	Info info;


	public List<GetSpAdvTaxReport> getSpAdvTaxReport() {
		return spAdvTaxReport;
	}

	public void setSpAdvTaxReport(List<GetSpAdvTaxReport> spAdvTaxReport) {
		this.spAdvTaxReport = spAdvTaxReport;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetSpAdvTaxReporList [spAdvTaxReport=" + spAdvTaxReport + ", info=" + info + "]";
	}
	

}

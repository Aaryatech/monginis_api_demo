package com.ats.webapi.model;

import java.util.List;

public class GetBillDetailsList {
	
	List<GetBillDetails> getBillDetails;
	
	Info info;

	public List<GetBillDetails> getGetBillDetails() {
		return getBillDetails;
	}

	public void setGetBillDetails(List<GetBillDetails> getBillDetails) {
		this.getBillDetails = getBillDetails;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetBillDetailsList [getBillDetails=" + getBillDetails + ", info=" + info + "]";
	}
	
	
	

}

package com.ats.webapi.model;

import java.util.List;

public class GetBillHeaderList {
	
	List<GetBillHeader> getBillHeaders;
	
	Info info;

	public List<GetBillHeader> getGetBillHeaders() {
		return getBillHeaders;
	}

	public void setGetBillHeaders(List<GetBillHeader> getBillHeaders) {
		this.getBillHeaders = getBillHeaders;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetBillHeaderList [getBillHeaders=" + getBillHeaders + ", info=" + info + "]";
	}
	
	

}

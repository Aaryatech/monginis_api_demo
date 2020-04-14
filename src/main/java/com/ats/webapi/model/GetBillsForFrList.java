package com.ats.webapi.model;

import java.util.List;

public class GetBillsForFrList {
	
	List<GetBillsForFr> getBillsForFr;
	
	Info info;

	public List<GetBillsForFr> getGetBillsForFr() {
		return getBillsForFr;
	}

	public void setGetBillsForFr(List<GetBillsForFr> getBillsForFr) {
		this.getBillsForFr = getBillsForFr;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetBillsForFrList [getBillsForFr=" + getBillsForFr + ", info=" + info + "]";
	}
	
		

}

package com.ats.webapi.model.prod.mixing;

import java.util.List;

public class GetTempMixItemDetailList {
	
	@Override
	public String toString() {
		return "GetTempMixItemDetailList [tempMixItemDetail=" + tempMixItemDetail + "]";
	}

	List<GetTempMixItemDetail> tempMixItemDetail;

	public List<GetTempMixItemDetail> getTempMixItemDetail() {
		return tempMixItemDetail;
	}

	public void setTempMixItemDetail(List<GetTempMixItemDetail> tempMixItemDetail) {
		this.tempMixItemDetail = tempMixItemDetail;
	}
	

}

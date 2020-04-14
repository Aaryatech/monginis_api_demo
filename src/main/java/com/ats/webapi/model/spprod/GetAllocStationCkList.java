package com.ats.webapi.model.spprod;

import java.util.List;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.spprod.GetAllocStationCk;

public class GetAllocStationCkList {

	List<GetAllocStationCk> getAllocStationCkList;
	
	Info info;

	public List<GetAllocStationCk> getGetAllocStationCkList() {
		return getAllocStationCkList;
	}

	public void setGetAllocStationCkList(List<GetAllocStationCk> getAllocStationCkList) {
		this.getAllocStationCkList = getAllocStationCkList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetAllocStationCkList [getAllocStationCkList=" + getAllocStationCkList + ", info=" + info + "]";
	}
	
	
}

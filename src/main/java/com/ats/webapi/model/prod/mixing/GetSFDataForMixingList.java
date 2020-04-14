package com.ats.webapi.model.prod.mixing;

import java.util.List;

import com.ats.webapi.model.Info;

public class GetSFDataForMixingList {
	
	List<GetSFDataForMixing> sFDataForMixing;
	
	Info info;

	public List<GetSFDataForMixing> getsFDataForMixing() {
		return sFDataForMixing;
	}

	public void setsFDataForMixing(List<GetSFDataForMixing> sFDataForMixing) {
		this.sFDataForMixing = sFDataForMixing;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetSFDataForMixingList [sFDataForMixing=" + sFDataForMixing + ", info=" + info + "]";
	}
	
	

}

package com.ats.webapi.model.prod.mixing;

import java.util.List;

import com.ats.webapi.model.Info;

public class GetSFPlanDetailForMixingList {
	
	List<GetSFPlanDetailForMixing> sfPlanDetailForMixing;
	
	Info info;

	public List<GetSFPlanDetailForMixing> getSfPlanDetailForMixing() {
		return sfPlanDetailForMixing;
	}

	public void setSfPlanDetailForMixing(List<GetSFPlanDetailForMixing> sfPlanDetailForMixing) {
		this.sfPlanDetailForMixing = sfPlanDetailForMixing;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	
}

package com.ats.webapi.model;

import java.util.List;

public class FrNameIdByRouteIdList {
	
	List<FrNameIdByRouteId> frNameIdByRouteIds;
	
	Info info;

	public List<FrNameIdByRouteId> getFrNameIdByRouteIds() {
		return frNameIdByRouteIds;
	}

	public void setFrNameIdByRouteIds(List<FrNameIdByRouteId> frNameIdByRouteIds) {
		this.frNameIdByRouteIds = frNameIdByRouteIds;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "FrNameIdByRouteIdList [frNameIdByRouteIds=" + frNameIdByRouteIds + ", info=" + info + "]";
	}

	
	
}

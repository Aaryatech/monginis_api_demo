package com.ats.webapi.model;

import java.util.List;

public class FrTargetList {

	private List<FrTarget> frTargetList;
	
	Info info;

	public List<FrTarget> getFrTargetList() {
		return frTargetList;
	}

	public void setFrTargetList(List<FrTarget> frTargetList) {
		this.frTargetList = frTargetList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "FrTargetList [frTargetList=" + frTargetList + ", info=" + info + "]";
	}
	
}

package com.ats.webapi.model;

import java.util.List;

public class SpecialCakeList {
	List<SpecialCake> specialCake;
	Info info;
	
	public List<SpecialCake> getSpecialCake() {
		return specialCake;
	}

	public void setSpecialCake(List<SpecialCake> specialCake) {
		this.specialCake = specialCake;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
}

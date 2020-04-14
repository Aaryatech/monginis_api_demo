package com.ats.webapi.model.prod.mixing;

import java.util.List;

import com.ats.webapi.model.Info;

public class GetSFMixingForBomList {

	List<GetSFMixingForBom> sFMixingForBom;
	
	Info info;

	public List<GetSFMixingForBom> getsFMixingForBom() {
		return sFMixingForBom;
	}

	public void setsFMixingForBom(List<GetSFMixingForBom> sFMixingForBom) {
		this.sFMixingForBom = sFMixingForBom;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
}

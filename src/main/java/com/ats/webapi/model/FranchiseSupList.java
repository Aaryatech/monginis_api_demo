package com.ats.webapi.model;

import java.io.Serializable;
import java.util.List;

public class FranchiseSupList implements Serializable {

	List<GetFranchiseSup> frList;
	
	Info info;

	public List<GetFranchiseSup> getFrList() {
		return frList;
	}

	public void setFrList(List<GetFranchiseSup> frList) {
		this.frList = frList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "FranchiseSupList [info=" + info + "]";
	}
	
	
}

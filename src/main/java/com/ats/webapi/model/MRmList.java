package com.ats.webapi.model;

import java.util.List;

public class MRmList {
	
	private List<MRm> list;
	private Info info;
	
	public List<MRm> getList() {
		return list;
	}
	public void setList(List<MRm> list) {
		this.list = list;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "MRmList [list=" + list + ", info=" + info + "]";
	}
	
	

}

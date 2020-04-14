package com.ats.webapi.model.remarks;

import java.util.List;

import com.ats.webapi.model.Info;

public class GetAllRemarksList {
	
	List<GetAllRemarks> getAllRemarks;
	
	
	Info info=new Info();


	public List<GetAllRemarks> getGetAllRemarks() {
		return getAllRemarks;
	}


	public Info getInfo() {
		return info;
	}


	public void setGetAllRemarks(List<GetAllRemarks> getAllRemarks) {
		this.getAllRemarks = getAllRemarks;
	}


	public void setInfo(Info info) {
		this.info = info;
	}


	@Override
	public String toString() {
		return "GetAllRemarksList [getAllRemarks=" + getAllRemarks + ", info=" + info + "]";
	}
	
	

}

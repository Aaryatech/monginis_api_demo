package com.ats.webapi.model.prod;

import java.util.List;

import com.ats.webapi.model.Info;

public class GetProdPlanDetailList {

	
	List<GetProdPlanDetail> prodPlanDetail;
	Info info;
	public List<GetProdPlanDetail> getProdPlanDetail() {
		return prodPlanDetail;
	}
	public void setProdPlanDetail(List<GetProdPlanDetail> prodPlanDetail) {
		this.prodPlanDetail = prodPlanDetail;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	
	
}

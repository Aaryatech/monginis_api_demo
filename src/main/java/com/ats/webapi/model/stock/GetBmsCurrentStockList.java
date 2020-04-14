package com.ats.webapi.model.stock;

import java.util.List;

import com.ats.webapi.model.Info;

public class GetBmsCurrentStockList {

	List<GetBmsCurrentStock> bmsCurrentStock;

	Info info;

	public List<GetBmsCurrentStock> getBmsCurrentStock() {
		return bmsCurrentStock;
	}

	public void setBmsCurrentStock(List<GetBmsCurrentStock> bmsCurrentStock) {
		this.bmsCurrentStock = bmsCurrentStock;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetBmsCurrentStockList [bmsCurrentStock=" + bmsCurrentStock + ", info=" + info + "]";
	}
	
	
	

}

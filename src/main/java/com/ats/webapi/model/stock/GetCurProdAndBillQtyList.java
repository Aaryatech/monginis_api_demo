package com.ats.webapi.model.stock;

import java.util.List;

import com.ats.webapi.model.Info;

public class GetCurProdAndBillQtyList {
	
	List<GetCurProdAndBillQty> getCurProdAndBillQty;
	Info info;
	public List<GetCurProdAndBillQty> getGetCurProdAndBillQty() {
		return getCurProdAndBillQty;
	}
	public void setGetCurProdAndBillQty(List<GetCurProdAndBillQty> getCurProdAndBillQty) {
		this.getCurProdAndBillQty = getCurProdAndBillQty;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "GetCurProdAndBillQtyList [getCurProdAndBillQty=" + getCurProdAndBillQty + ", info=" + info + "]";
	}
	

}

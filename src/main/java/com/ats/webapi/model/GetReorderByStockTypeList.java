package com.ats.webapi.model;

import java.util.List;

public class GetReorderByStockTypeList {
	
	private List<GetReorderByStockType> GetReorderByStockTypeList;

	public List<GetReorderByStockType> getGetReorderByStockTypeList() {
		return GetReorderByStockTypeList;
	}

	public void setGetReorderByStockTypeList(List<GetReorderByStockType> getReorderByStockTypeList) {
		GetReorderByStockTypeList = getReorderByStockTypeList;
	}

	@Override
	public String toString() {
		return "GetReorderByStockTypeList [GetReorderByStockTypeList=" + GetReorderByStockTypeList + "]";
	}
	
	
	

}

package com.ats.webapi.service.storestock;

import java.util.List;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.stock.GetStoreCurrentStock;
import com.ats.webapi.model.stock.StoreStockDetail;
import com.ats.webapi.model.stock.StoreStockHeader;

public interface StoreStockService {

	StoreStockHeader insertStoreOpStock(StoreStockHeader storeStockHeader);

	List<StoreStockDetail> getMonthWiseStoreStock(String fromDate, String toDate,int grpId);

	List<GetStoreCurrentStock> getCurrentStock(int grpId,int deptId);

	StoreStockHeader getCurrentStockHeader(int subCatId,int status);

	
	
}

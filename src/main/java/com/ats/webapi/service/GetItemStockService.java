package com.ats.webapi.service;

import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.RegularSpecialStockCal;

public interface GetItemStockService {

	RegularSpecialStockCal getRegTotalPurchase(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemId") int itemId);

	int getRegTotalGrnGvn( @Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemId") int itemId);
	
	RegularSpecialStockCal getRegTotalSell( @Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemId") int itemId);
	
	PostFrItemStockDetail getOpeningStock( @Param("frId") int frId, @Param("currentMonth") int currentMonth, @Param("year") int year,@Param("itemId") int itemId , @Param("catId") int catId);
	
	PostFrItemStockDetail getCurrentOpeningStock(@Param("frId") int frId,@Param("itemId") int itemId ,@Param("catId") int catId);

	int getTotalGrnGvnUptoDateTime(@Param("frId") int frId, @Param("fromDateTime") String fromDateTime, @Param("toDateTime") String toDateTime,
			@Param("itemId") int itemId);

	RegularSpecialStockCal	getTotalPurchaseUptoDateTime(@Param("frId") int frId, @Param("fromDateTime") String fromDateTime, @Param("toDateTime") String toDateTime,
			@Param("itemId") int itemId);
	
	RegularSpecialStockCal getTotalSellUpToDateTime(@Param("frId") int frId, @Param("fromDateTime") String fromDateTime, @Param("toDateTime") String toDateTime,
			@Param("itemId") int itemId);
	// purchase of particular date
	RegularSpecialStockCal getTotalPurchaseOfDate(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("itemId") int itemId);
	// sell
	
	RegularSpecialStockCal getRegTotalSellBetweenDateTime(@Param("frId") int frId, @Param("fromDateTime") String fromDate, @Param("toDateTime") String toDate,
			@Param("itemId") int itemId);
}
 
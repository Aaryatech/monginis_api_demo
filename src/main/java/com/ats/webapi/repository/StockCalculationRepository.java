package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ats.webapi.model.RegularSpecialStockCal;

@Repository
public interface StockCalculationRepository extends JpaRepository<RegularSpecialStockCal, Integer> {
	
	@Query(value = "SELECT  COALESCE(SUM(CASE WHEN grn_type != 3 THEN bill_qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN grn_type = 3 THEN bill_qty ELSE 0 END),0) as sp  "
				+ "  FROM t_bill_detail WHERE t_bill_detail.item_id=:itemId AND t_bill_detail.bill_no"
				+ " IN(SELECT t_bill_header.bill_no FROM t_bill_header WHERE t_bill_header.fr_id=:frId  AND t_bill_header.status =2  AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate )", nativeQuery = true)
	RegularSpecialStockCal getTotalPurchase(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("itemId") int itemId);

	@Query(value = "SELECT  COALESCE(SUM(t_grn_gvn.grn_gvn_qty),0) FROM t_grn_gvn WHERE t_grn_gvn.fr_id=:frId AND t_grn_gvn.item_id=:itemId AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	int getRegTotalGrnGvn(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("itemId") int itemId);

	@Query(value = "SELECT COALESCE(SUM(CASE WHEN bill_stock_type = 1 THEN qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN bill_stock_type = 2 THEN qty ELSE 0 END),0) as sp FROM t_sell_bill_detail WHERE t_sell_bill_detail.item_id =:itemId AND "
			+ "t_sell_bill_detail.sell_bill_no IN (SELECT t_sell_bill_header.sell_bill_no FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=:frId AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate)", nativeQuery = true)
	RegularSpecialStockCal getRegTotalSell(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("itemId") int itemId);
		
	// grn/gvn
		@Query(value = "SELECT COALESCE(SUM(t_grn_gvn.grn_gvn_qty),0) FROM t_grn_gvn WHERE t_grn_gvn.fr_id=:frId AND t_grn_gvn.item_id=:itemId AND"
				+ " t_grn_gvn.grn_gvn_entry_datetime BETWEEN :fromDateTime AND :toDateTime ", nativeQuery = true)
		int getTotalGrnGvnUptoDateTime(@Param("frId") int frId, @Param("fromDateTime") String fromDateTime, @Param("toDateTime") String toDateTime,
				@Param("itemId") int itemId);
	// purchase
	@Query(value = "SELECT  COALESCE(SUM(CASE WHEN grn_type != 3  THEN bill_qty ELSE 0 END),0) as reg ,"
			+ " COALESCE(SUM(CASE WHEN grn_type = 3 THEN bill_qty ELSE 0 END),0) as sp  FROM t_bill_detail "
			+ "WHERE t_bill_detail.item_id=:itemId AND t_bill_detail.bill_no IN(SELECT t_bill_header.bill_no "
			+ "FROM t_bill_header WHERE t_bill_header.fr_id=:frId  AND t_bill_header.status =2 "
			+ " AND t_bill_header.bill_date_time BETWEEN :fromDateTime AND :toDateTime )" 
			, nativeQuery = true)
	RegularSpecialStockCal	getTotalPurchaseUptoDateTime(@Param("frId") int frId, @Param("fromDateTime") String fromDateTime, @Param("toDateTime") String toDateTime,
			@Param("itemId") int itemId);
	// sell
	@Query(value = "SELECT COALESCE(SUM(CASE WHEN bill_stock_type = 1 THEN qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN bill_stock_type = 2 THEN qty ELSE 0 END),0) as sp"
			+ " FROM t_sell_bill_detail WHERE t_sell_bill_detail.item_id =:itemId AND t_sell_bill_detail.sell_bill_no "
			+ "IN (SELECT t_sell_bill_header.sell_bill_no FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=:frId AND t_sell_bill_header.timestamp "
			+ "BETWEEN :fromDateTime AND :toDateTime)" + 
			"", nativeQuery = true)
	RegularSpecialStockCal getTotalSellUpToDateTime(@Param("frId") int frId, @Param("fromDateTime") String fromDateTime, @Param("toDateTime") String toDateTime,
			@Param("itemId") int itemId);

	// purchase of particular date
	@Query(value = "	SELECT COALESCE(SUM(CASE WHEN grn_type != 3 AND grn_type!=4 THEN bill_qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN grn_type = 4 THEN bill_qty ELSE 0 END),0) as sp "
			+ "FROM t_bill_detail WHERE t_bill_detail.item_id=:itemId AND "
			+ "t_bill_detail.bill_no "
			+ "IN(SELECT t_bill_header.bill_no FROM t_bill_header WHERE t_bill_header.fr_id=:frId  AND t_bill_header.status =2  AND t_bill_header.bill_date = :fromDate)" + 
			"", nativeQuery = true)
	RegularSpecialStockCal getTotalPurchaseOfDate(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("itemId") int itemId);

	// Sell between date time
	@Query(value = "SELECT COALESCE(SUM(CASE WHEN bill_stock_type = 1 THEN qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN bill_stock_type = 2 THEN qty ELSE 0 END),0) as sp "
			+ "FROM t_sell_bill_detail "
			+ "WHERE t_sell_bill_detail.item_id =:itemId AND t_sell_bill_detail.sell_bill_no IN (SELECT t_sell_bill_header.sell_bill_no "
			+ "FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=:frId AND t_sell_bill_header.timestamp "
			+ " BETWEEN :fromDateTime AND :toDateTime )", nativeQuery = true)
	RegularSpecialStockCal getRegTotalSellBetweenDateTime(@Param("frId") int frId, @Param("fromDateTime") String fromDate, @Param("toDateTime") String toDate,
			@Param("itemId") int itemId);
	/*
	GRN/GVN-
	SELECT  COALESCE(SUM(t_grn_gvn.grn_gvn_qty),0) FROM t_grn_gvn WHERE t_grn_gvn.fr_id=15 AND t_grn_gvn.item_id=123 AND t_grn_gvn.grn_gvn_entry_datetime BETWEEN '2017-11-14 00:00:00' AND '2017-11-15 15:00:00'
	Purchase-
	SELECT  COALESCE(SUM(CASE WHEN grn_type != 3 AND grn_type!=4 THEN bill_qty ELSE 0 END),0) as pur_qty , COALESCE(SUM(CASE WHEN grn_type = 4 THEN bill_qty ELSE 0 END),0) as push_qty  FROM t_bill_detail WHERE t_bill_detail.item_id=147 AND t_bill_detail.bill_no IN(SELECT t_bill_header.bill_no FROM t_bill_header WHERE t_bill_header.fr_id=15  AND t_bill_header.status =2  AND t_bill_header.bill_date_time BETWEEN '2017-11-01 00:00:00' AND '2017-11-23 22:00:00' )
	Sell
	SELECT COALESCE(SUM(CASE WHEN bill_stock_type = 1 THEN qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN bill_stock_type = 2 THEN qty ELSE 0 END),0) as sp FROM t_sell_bill_detail WHERE t_sell_bill_detail.item_id =2 AND t_sell_bill_detail.sell_bill_no IN (SELECT t_sell_bill_header.sell_bill_no FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=15 AND t_sell_bill_header.timestamp BETWEEN '2017-11-01 00:00:00' AND '2017-11-23 23:00:00' )
*/
		
}

package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.StockRegSpSell;

@Repository
public interface StockSellRepository  extends JpaRepository<StockRegSpSell ,Integer>{
	
	@Query(value = "SELECT COALESCE(SUM(CASE WHEN bill_stock_type = 1 THEN qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN bill_stock_type = 2 THEN qty ELSE 0 END),0) as sp FROM t_sell_bill_detail WHERE t_sell_bill_detail.item_id =:itemId AND "
			+ "t_sell_bill_detail.sell_bill_no IN (SELECT t_sell_bill_header.sell_bill_no FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=:frId AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate)", nativeQuery = true)
	StockRegSpSell getRegTotalSell(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("itemId") int itemId);
}

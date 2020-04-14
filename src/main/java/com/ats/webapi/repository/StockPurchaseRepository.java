package com.ats.webapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.StockRegSpPurchase;
public interface StockPurchaseRepository  extends JpaRepository<StockRegSpPurchase, Integer>{
	
	@Query(value = "SELECT COALESCE(t_bill_detail.bill_detail_no,0) as no, COALESCE(SUM(CASE WHEN grn_type != 3 THEN bill_qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN grn_type = 3 THEN bill_qty ELSE 0 END),0) as sp  "
			+ "  FROM t_bill_detail WHERE t_bill_detail.item_id=:itemId AND t_bill_detail.bill_no"
			+ " IN(SELECT t_bill_header.bill_no FROM t_bill_header WHERE t_bill_header.fr_id=:frId  AND t_bill_header.status =2  AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate )", nativeQuery = true)
		StockRegSpPurchase getTotalPurchase(@Param("frId") int frId, @Param("fromDate") String fromDate,
		@Param("toDate") String toDate, @Param("itemId") int itemId);
}

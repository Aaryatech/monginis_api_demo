package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.FrStockBetweenMonth;
import com.ats.webapi.model.GetCurrentStockDetails;


public interface FrStockBetweenMonthRepository extends JpaRepository<GetCurrentStockDetails, Integer> {

	
	@Query(value = "SELECT m_item.id,0 as current_reg_stock,0 as current_sp_stock,0 as re_order_qty,m_item.item_id,m_item.item_name , m_fr_opening_stock_detail.opening_stock_detail_id,m_fr_opening_stock_detail.opening_stock_header_id , COALESCE((SUM(opening_stock)),0) AS opening_stock , COALESCE((SUM(total_purchase)),0) AS total_purchase, COALESCE((SUM(total_grn_gvn)),0) AS total_grn_gvn, "
			+ "COALESCE((SUM(total_sell)),0) AS total_sell FROM m_fr_opening_stock_detail,m_item WHERE m_fr_opening_stock_detail.item_id=m_item.id AND "
			+ " opening_stock_header_id IN(SELECT opening_stock_header_id FROM m_fr_opening_stock_header WHERE  month BETWEEN :fromMonth AND :toMonth AND fr_id=:frId ) AND m_fr_opening_stock_detail.item_id IN(:itemIdList) GROUP BY item_id", nativeQuery = true)
	List<GetCurrentStockDetails> getStockBetweenMonths(@Param("frId") int frId,@Param("fromMonth") int fromMonth,@Param("toMonth") int toMonth, @Param("itemIdList") List<Integer> itemIdList);
	
	
	@Query(value = "Select coalesce(b.opening_stock_header_id,0) as opening_stock_header_id,coalesce(b.opening_stock_detail_id,0) as opening_stock_detail_id,coalesce(b.reg_opening_stock,0) as reg_opening_stock,a.item_rate1 as sp_opening_stock,a.item_mrp1  as sp_total_purchase,a.id,a.item_id,a.item_name,\r\n" + 
			"coalesce(d.grn_grn_qty,0) as reg_total_grn_gvn,coalesce(c.reg,0) as reg_total_purchase,coalesce(e.reg,0) as reg_total_sell,coalesce(e.sp,0) as sp_total_sell,coalesce(f.re_order_qty,0) re_order_qty,\r\n" + 
			"coalesce(coalesce(((b.reg_opening_stock+c.reg)-(d.grn_grn_qty+e.reg)),((c.reg)-(d.grn_grn_qty+e.reg))),0) current_reg_stock,\r\n" + 
			"coalesce(coalesce(((b.sp_opening_stock+c.sp)-(e.sp)),((c.sp)-(e.sp))),0) current_sp_stock\r\n" + 
			"\r\n" + 
			"from (select * from m_item where m_item.item_grp1=:catId order By item_name ASC) a\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT  m_fr_opening_stock_detail.* FROM m_fr_opening_stock_detail  WHERE  m_fr_opening_stock_detail.opening_stock_header_id  IN(SELECT m_fr_opening_stock_header.opening_stock_header_id FROM m_fr_opening_stock_header WHERE m_fr_opening_stock_header.fr_id=:frId   AND m_fr_opening_stock_header.month=:currentMonth AND m_fr_opening_stock_header.year=:year AND m_fr_opening_stock_header.cat_id=:catId) ) b on a.id=b.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT t_bill_detail.item_id, COALESCE(SUM(CASE WHEN grn_type != 3 THEN bill_qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN grn_type = 3 THEN bill_qty ELSE 0 END),0) as sp  FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_no=t_bill_detail.bill_no  and t_bill_header.fr_id=:frId   AND t_bill_header.status=2  AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate group by t_bill_detail.item_id) c on a.id=c.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT  t_grn_gvn.item_id,COALESCE(SUM(t_grn_gvn.grn_gvn_qty),0) as grn_grn_qty FROM t_grn_gvn WHERE t_grn_gvn.fr_id=:frId  AND t_grn_gvn.grn_gvn_date  BETWEEN :fromDate AND :toDate group by  t_grn_gvn.item_id) d on a.id=d.item_id\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT t_sell_bill_detail.item_id,COALESCE(SUM(CASE WHEN bill_stock_type = 1 THEN qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN bill_stock_type = 2 THEN qty ELSE 0 END),0) as sp FROM t_sell_bill_detail WHERE \r\n" + 
			"			t_sell_bill_detail.sell_bill_no IN (SELECT t_sell_bill_header.sell_bill_no FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=:frId  AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate ) group by t_sell_bill_detail.item_id) e on a.id=e.item_id\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT m_fr_item_stock.item_id,coalesce(m_fr_item_stock.reorder_qty,0) re_order_qty from m_fr_item_stock WHERE m_fr_item_stock.type=:type ) f on a.id=f.item_id ", nativeQuery = true)
	List<GetCurrentStockDetails> getMinOpeningStock1(@Param("currentMonth")int currentMonth,@Param("year") int year,@Param("frId") int frId,@Param("catId") int catId,@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("type") int type);
	
	
	@Query(value = "Select coalesce(b.opening_stock_header_id,0) as opening_stock_header_id,coalesce(b.opening_stock_detail_id,0) as opening_stock_detail_id,coalesce(b.reg_opening_stock,0) as reg_opening_stock,a.item_rate1 as sp_opening_stock,a.item_mrp1  as sp_total_purchase,a.id,a.item_id,a.item_name,\r\n" + 
			"coalesce(d.grn_grn_qty,0) as reg_total_grn_gvn,coalesce(c.reg,0) as reg_total_purchase,coalesce(e.reg,0) as reg_total_sell,coalesce(e.sp,0) as sp_total_sell,coalesce(f.re_order_qty,0) re_order_qty,\r\n" + 
			"coalesce(coalesce(((b.reg_opening_stock+c.reg)-(d.grn_grn_qty+e.reg)),((c.reg)-(d.grn_grn_qty+e.reg))),0) current_reg_stock,\r\n" + 
			"coalesce(coalesce(((b.sp_opening_stock+c.sp)-(e.sp)),((c.sp)-(e.sp))),0) current_sp_stock\r\n" + 
			"\r\n" + 
			"from (select * from m_item where m_item.id IN (:itemList) order By item_name ASC) a\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT  m_fr_opening_stock_detail.* FROM m_fr_opening_stock_detail  WHERE  m_fr_opening_stock_detail.opening_stock_header_id  IN(SELECT m_fr_opening_stock_header.opening_stock_header_id FROM m_fr_opening_stock_header WHERE m_fr_opening_stock_header.fr_id=:frId   AND m_fr_opening_stock_header.month=:currentMonth AND m_fr_opening_stock_header.year=:year AND m_fr_opening_stock_header.cat_id=:catId) ) b on a.id=b.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT t_bill_detail.item_id, COALESCE(SUM(CASE WHEN grn_type != 3 THEN bill_qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN grn_type = 3 THEN bill_qty ELSE 0 END),0) as sp  FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_no=t_bill_detail.bill_no  and t_bill_header.fr_id=:frId   AND t_bill_header.status=2  AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate group by t_bill_detail.item_id) c on a.id=c.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT  t_grn_gvn.item_id,COALESCE(SUM(t_grn_gvn.grn_gvn_qty),0) as grn_grn_qty FROM t_grn_gvn WHERE t_grn_gvn.fr_id=:frId  AND t_grn_gvn.grn_gvn_date  BETWEEN :fromDate AND :toDate group by  t_grn_gvn.item_id) d on a.id=d.item_id\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT t_sell_bill_detail.item_id,COALESCE(SUM(CASE WHEN bill_stock_type = 1 THEN qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN bill_stock_type = 2 THEN qty ELSE 0 END),0) as sp FROM t_sell_bill_detail WHERE \r\n" + 
			"			t_sell_bill_detail.sell_bill_no IN (SELECT t_sell_bill_header.sell_bill_no FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=:frId  AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate ) group by t_sell_bill_detail.item_id) e on a.id=e.item_id\r\n" + 
			"LEFT JOIN \r\n" + 
			"(SELECT m_fr_item_stock.item_id,coalesce(m_fr_item_stock.reorder_qty,0) re_order_qty from m_fr_item_stock WHERE m_fr_item_stock.type=:type ) f on a.id=f.item_id", nativeQuery = true)
	List<GetCurrentStockDetails> getMinOpeningStock2(@Param("currentMonth")int currentMonth,@Param("year") int year,@Param("frId") int frId,@Param("catId") int catId,@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("type") int type,@Param("itemList") List<Integer> itemList);
	 
} 

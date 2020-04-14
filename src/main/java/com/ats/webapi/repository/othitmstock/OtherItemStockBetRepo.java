package com.ats.webapi.repository.othitmstock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.otheritemstock.OtherItemStockBet;

public interface OtherItemStockBetRepo  extends JpaRepository<OtherItemStockBet, Integer>{
	
	
	@Query(value=" SELECT m_item.id,m_item.item_name,m_item.item_id, m_franchisee.fr_name, " + 
			"COALESCE((SELECT SUM(other_item_stock_detail.opening_stock) FROM other_item_stock_detail,other_item_stock_header"
			+ " WHERE  m_franchisee.fr_id=other_item_stock_header.fr_id and "
			+ "other_item_stock_header.other_stock_header_id=other_item_stock_detail.other_stock_header_id AND "
			+ "other_item_stock_detail.other_item_id=m_item.id AND other_item_stock_header.month  IN(:month)),0) as first_opening, " + 
			
			" COALESCE((SELECT SUM(other_item_stock_detail.damage_stock) FROM other_item_stock_detail,other_item_stock_header "
			+ " WHERE other_item_stock_header.month IN (:month) AND m_franchisee.fr_id=other_item_stock_header.fr_id and "
			+ " other_item_stock_header.other_stock_header_id=other_item_stock_detail.other_stock_header_id AND "
			+ " other_item_stock_detail.other_item_id=m_item.id AND other_item_stock_header.month  IN(:month)),0) as damaged_stock, " + 
			
			" COALESCE((SELECT SUM(t_other_bill_detail.bill_qty) FROM t_other_bill_header,t_other_bill_detail "
			+ " WHERE t_other_bill_header.bill_no=t_other_bill_detail.bill_no AND t_other_bill_header.fr_id=m_franchisee.fr_id "
			+ " AND t_other_bill_header.bill_date BETWEEN :prevFromDate AND :prevToDate AND t_other_bill_detail.item_id=m_item.id),0) "
			+ " AS first_purchase, " 
			
		+	"  COALESCE((SELECT SUM(t_sell_bill_detail.qty) FROM t_sell_bill_detail,t_sell_bill_header WHERE " + 
			"       t_sell_bill_header.sell_bill_no=t_sell_bill_detail.sell_bill_no AND t_sell_bill_header.fr_id=m_franchisee.fr_id "
			+ " AND t_sell_bill_header.bill_date BETWEEN :prevFromDate AND :prevToDate AND t_sell_bill_detail.item_id=m_item.id),0) "
			+ " AS first_sell," + 
			" COALESCE((SELECT SUM(t_other_bill_detail.bill_qty) FROM t_other_bill_header,t_other_bill_detail WHERE " + 
			"       t_other_bill_header.bill_no=t_other_bill_detail.bill_no AND t_other_bill_header.fr_id=m_franchisee.fr_id "
			+ " AND t_other_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_other_bill_detail.item_id=m_item.id),0) "
			+ " AS purchase_qty," + 
			"  COALESCE((SELECT SUM(t_sell_bill_detail.qty) FROM t_sell_bill_detail,t_sell_bill_header WHERE " + 
			"       t_sell_bill_header.sell_bill_no=t_sell_bill_detail.sell_bill_no AND t_sell_bill_header.fr_id=m_franchisee.fr_id "
			+ " AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_sell_bill_detail.item_id=m_item.id),0) "
			+ " AS sell_qty " + 
			"       FROM m_item,m_franchisee " + 
			"       WHERE m_item.item_grp1=:catId AND m_franchisee.fr_id=:frId  and m_item.item_rate2=:frId and m_item.del_status=0 GROUP by m_item.id",nativeQuery=true)
	List<OtherItemStockBet> getOtherItemStockBet(@Param("catId") int catId,@Param("month") int month, @Param("frId") int frId, 
			@Param("fromDate")String fromDate,@Param("toDate")String toDate,@Param("prevFromDate")String prevFromDate,@Param("prevToDate")String prevToDate);

	
}

package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.OpsCurStockAndShelfLife;

public interface OpsCurStockAndShelfLifeRepo extends JpaRepository<OpsCurStockAndShelfLife, Integer> {

	
	@Query(value = "SELECT\r\n" + 
			"    t1.*,\r\n" + 
			"    (\r\n" + 
			"        COALESCE(t2.reg_opening_stock, 0) + COALESCE(t3.bill_qty, 0)\r\n" + 
			"    ) -(\r\n" + 
			"        COALESCE(t4.grn_grn_qty, 0) + COALESCE(t5.sell_bill_qty, 0)\r\n" + 
			"    ) AS current_stock\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        i.id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        i.item_shelf_life\r\n" + 
			"    FROM\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        i.id IN(:itemList)\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.*\r\n" + 
			"    FROM\r\n" + 
			"        m_fr_opening_stock_detail d,\r\n" + 
			"        m_fr_opening_stock_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.opening_stock_header_id = d.opening_stock_header_id AND h.fr_id =:frId AND h.month =:month AND h.year =:year AND h.cat_id != 5\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.id = t2.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_id,\r\n" + 
			"        SUM(\r\n" + 
			"            CASE WHEN grn_type != 3 THEN d.bill_qty ELSE 0\r\n" + 
			"        END\r\n" + 
			") AS bill_qty\r\n" + 
			"FROM\r\n" + 
			"    t_bill_detail d,\r\n" + 
			"    t_bill_header h\r\n" + 
			"WHERE\r\n" + 
			"    h.bill_no = d.bill_no AND h.fr_id =:frId AND h.status = 2 AND h.bill_date BETWEEN :fromDate AND :toDate \r\n" + 
			"GROUP BY\r\n" + 
			"    d.item_id\r\n" + 
			") t3\r\n" + 
			"ON\r\n" + 
			"    t1.id = t3.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        g.item_id,\r\n" + 
			"        COALESCE(SUM(g.grn_gvn_qty),\r\n" + 
			"        0) AS grn_grn_qty\r\n" + 
			"    FROM\r\n" + 
			"        t_grn_gvn g\r\n" + 
			"    WHERE\r\n" + 
			"        g.fr_id =:frId AND g.grn_gvn_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY\r\n" + 
			"        g.item_id\r\n" + 
			") t4\r\n" + 
			"ON\r\n" + 
			"    t1.id = t4.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_id,\r\n" + 
			"        SUM(\r\n" + 
			"            CASE WHEN d.bill_stock_type = 1 THEN d.qty ELSE 0\r\n" + 
			"        END\r\n" + 
			") AS sell_bill_qty\r\n" + 
			"FROM\r\n" + 
			"    t_sell_bill_detail d,\r\n" + 
			"    t_sell_bill_header h\r\n" + 
			"WHERE\r\n" + 
			"    d.sell_bill_no = h.sell_bill_no AND h.fr_id =:frId AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND d.del_status = 0\r\n" + 
			"GROUP BY\r\n" + 
			"    d.item_id\r\n" + 
			") t5\r\n" + 
			"ON\r\n" + 
			"    t1.id = t5.item_id", nativeQuery = true)
	List<OpsCurStockAndShelfLife> getCurrStockAndShelfLife(@Param("month")int month, @Param("year") int year, @Param("frId") int frId, 
			@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemList") List<Integer> itemList);
	

}

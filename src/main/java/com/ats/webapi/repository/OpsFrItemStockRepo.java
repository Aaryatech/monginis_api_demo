package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.OpsFrItemStock;

public interface OpsFrItemStockRepo extends JpaRepository<OpsFrItemStock ,Integer>{
	
	 @Query(value = "SELECT\r\n" + 
	 		"    t1.*,\r\n" + 
	 		"    COALESCE(t2.reg_opening_stock, 0) AS opening,\r\n" + 
	 		"    COALESCE(t3.reg, 0) AS purchase,\r\n" + 
	 		"    COALESCE(t4.qty, 0) AS crn,\r\n" + 
	 		"    COALESCE(t5.grngvn, 0) AS grngvn,\r\n" + 
	 		"    COALESCE(t6.reg, 0) AS sale,\r\n" + 
	 		"    (\r\n" + 
	 		"        COALESCE(t2.reg_opening_stock, 0) + COALESCE(t3.reg, 0) + COALESCE(t4.qty, 0)\r\n" + 
	 		"    ) -(\r\n" + 
	 		"        COALESCE(t5.grngvn, 0) + COALESCE(t6.reg, 0)\r\n" + 
	 		"    ) AS current_stock,\r\n" + 
	 		"    COALESCE(t7.reorder, 0) AS reorder\r\n" + 
	 		"FROM\r\n" + 
	 		"    (\r\n" + 
	 		"    SELECT\r\n" + 
	 		"        i.id,\r\n" + 
	 		"        i.item_name,\r\n" + 
	 		"        i.item_grp1 AS cat_id,\r\n" + 
	 		"        i.item_grp2 AS sub_cat_id\r\n" + 
	 		"    FROM\r\n" + 
	 		"        m_item i\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        i.del_status = 0 \r\n" + 
	 		") t1\r\n" + 
	 		"LEFT JOIN(\r\n" + 
	 		"    SELECT d.*,\r\n" + 
	 		"        h.fr_id\r\n" + 
	 		"    FROM\r\n" + 
	 		"        m_fr_opening_stock_detail d,\r\n" + 
	 		"        m_fr_opening_stock_header h\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        h.opening_stock_header_id = d.opening_stock_header_id AND h.fr_id IN(:frId)  AND h.month = :month AND h.year = :year AND d.item_id IN(\r\n" + 
	 		"        SELECT\r\n" + 
	 		"            i.id\r\n" + 
	 		"        FROM\r\n" + 
	 		"            m_item i\r\n" + 
	 		"        WHERE\r\n" + 
	 		"            i.del_status = 0\r\n" + 
	 		"    )\r\n" + 
	 		") t2\r\n" + 
	 		"ON\r\n" + 
	 		"    t1.id = t2.item_id\r\n" + 
	 		"LEFT JOIN(\r\n" + 
	 		"    SELECT d.bill_detail_no,\r\n" + 
	 		"        CASE WHEN d.grn_type != 3 THEN SUM(d.bill_qty) ELSE 0\r\n" + 
	 		"END AS reg,\r\n" + 
	 		"CASE WHEN d.grn_type = 3 THEN SUM(d.bill_qty) ELSE 0\r\n" + 
	 		"END AS sp,\r\n" + 
	 		"h.fr_id,\r\n" + 
	 		"d.item_id\r\n" + 
	 		"FROM\r\n" + 
	 		"    t_bill_header h,\r\n" + 
	 		"    t_bill_detail d\r\n" + 
	 		"WHERE\r\n" + 
	 		"    h.bill_date BETWEEN :fromDate AND :toDate AND h.fr_id = :frId AND h.status = 2 AND h.bill_no = d.bill_no AND d.item_id IN(\r\n" + 
	 		"    SELECT\r\n" + 
	 		"        i.id\r\n" + 
	 		"    FROM\r\n" + 
	 		"        m_item i\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        i.del_status = 0 \r\n" + 
	 		")\r\n" + 
	 		"GROUP BY\r\n" + 
	 		"    h.fr_id,\r\n" + 
	 		"    d.item_id\r\n" + 
	 		") t3\r\n" + 
	 		"ON\r\n" + 
	 		"    t1.id = t3.item_id\r\n" + 
	 		"LEFT JOIN(\r\n" + 
	 		"    SELECT COALESCE((SUM(p.crn_qty)),\r\n" + 
	 		"        0) AS qty,\r\n" + 
	 		"        p.item_id\r\n" + 
	 		"    FROM\r\n" + 
	 		"        t_credit_note_pos p\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        p.is_stockable = 1 AND p.ex_int1 = :frId AND p.crn_date BETWEEN :fromDate AND :toDate AND p.item_id IN(\r\n" + 
	 		"        SELECT\r\n" + 
	 		"            i.id\r\n" + 
	 		"        FROM\r\n" + 
	 		"            m_item i\r\n" + 
	 		"        WHERE\r\n" + 
	 		"            i.del_status = 0 \r\n" + 
	 		"    )\r\n" + 
	 		"GROUP BY\r\n" + 
	 		"    p.item_id\r\n" + 
	 		") t4\r\n" + 
	 		"ON\r\n" + 
	 		"    t1.id = t4.item_id\r\n" + 
	 		"LEFT JOIN(\r\n" + 
	 		"    SELECT item_id,\r\n" + 
	 		"        fr_id,\r\n" + 
	 		"        SUM(t_grn_gvn.grn_gvn_qty) AS grngvn\r\n" + 
	 		"    FROM\r\n" + 
	 		"        t_grn_gvn\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        fr_id = :frId AND item_id IN(\r\n" + 
	 		"        SELECT\r\n" + 
	 		"            i.id\r\n" + 
	 		"        FROM\r\n" + 
	 		"            m_item i\r\n" + 
	 		"        WHERE\r\n" + 
	 		"            i.del_status = 0 \r\n" + 
	 		"    ) AND grn_gvn_date BETWEEN :fromDate AND :toDate\r\n" + 
	 		"GROUP BY\r\n" + 
	 		"    fr_id,\r\n" + 
	 		"    item_id\r\n" + 
	 		") t5\r\n" + 
	 		"ON\r\n" + 
	 		"    t1.id = t5.item_id\r\n" + 
	 		"LEFT JOIN(\r\n" + 
	 		"    SELECT ROUND(\r\n" + 
	 		"            (\r\n" + 
	 		"                COALESCE(\r\n" + 
	 		"                    SUM(\r\n" + 
	 		"                        (b.sell_qty * a.rm_qty) / a.no_pieces_per_item\r\n" + 
	 		"                    ),\r\n" + 
	 		"                    0\r\n" + 
	 		"                )\r\n" + 
	 		"            ),\r\n" + 
	 		"            2\r\n" + 
	 		"        ) AS reg,\r\n" + 
	 		"        0 AS sp,\r\n" + 
	 		"        a.item_id\r\n" + 
	 		"    FROM\r\n" + 
	 		"        (\r\n" + 
	 		"        SELECT\r\n" + 
	 		"            item_id,\r\n" + 
	 		"            rm_id,\r\n" + 
	 		"            rm_qty,\r\n" + 
	 		"            no_pieces_per_item\r\n" + 
	 		"        FROM\r\n" + 
	 		"            m_item_detail\r\n" + 
	 		"        WHERE\r\n" + 
	 		"            rm_id IN(\r\n" + 
	 		"            SELECT\r\n" + 
	 		"                i.id\r\n" + 
	 		"            FROM\r\n" + 
	 		"                m_item i\r\n" + 
	 		"            WHERE\r\n" + 
	 		"                i.del_status = 0 \r\n" + 
	 		"        ) AND del_status = 0\r\n" + 
	 		"    ) a\r\n" + 
	 		"LEFT JOIN(\r\n" + 
	 		"    SELECT t_sell_bill_detail.item_id,\r\n" + 
	 		"        COALESCE(\r\n" + 
	 		"            SUM(\r\n" + 
	 		"                CASE WHEN bill_stock_type = 1 THEN qty ELSE 0\r\n" + 
	 		"            END\r\n" + 
	 		"        ),\r\n" + 
	 		"        0\r\n" + 
	 		") AS sell_qty\r\n" + 
	 		"FROM\r\n" + 
	 		"    t_sell_bill_detail\r\n" + 
	 		"WHERE\r\n" + 
	 		"    t_sell_bill_detail.item_id IN(\r\n" + 
	 		"    SELECT\r\n" + 
	 		"        item_id\r\n" + 
	 		"    FROM\r\n" + 
	 		"        m_item_detail\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        rm_id IN(\r\n" + 
	 		"        SELECT\r\n" + 
	 		"            i.id\r\n" + 
	 		"        FROM\r\n" + 
	 		"            m_item i\r\n" + 
	 		"        WHERE\r\n" + 
	 		"            i.del_status = 0 \r\n" + 
	 		"    ) AND del_status = 0\r\n" + 
	 		") AND t_sell_bill_detail.sell_bill_no IN(\r\n" + 
	 		"    SELECT\r\n" + 
	 		"        t_sell_bill_header.sell_bill_no\r\n" + 
	 		"    FROM\r\n" + 
	 		"        t_sell_bill_header\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        t_sell_bill_header.fr_id = :frId AND t_sell_bill_header.del_status = 0 AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate\r\n" + 
	 		")\r\n" + 
	 		"GROUP BY\r\n" + 
	 		"    t_sell_bill_detail.item_id\r\n" + 
	 		") b\r\n" + 
	 		"ON\r\n" + 
	 		"    a.item_id = b.item_id\r\n" + 
	 		"GROUP BY\r\n" + 
	 		"    a.item_id\r\n" + 
	 		") t6\r\n" + 
	 		"ON\r\n" + 
	 		"    t1.id = t6.item_id\r\n" + 
	 		"LEFT JOIN(\r\n" + 
	 		"    SELECT m_fr_item_stock.item_id,\r\n" + 
	 		"        COALESCE(m_fr_item_stock.reorder_qty, 0) AS reorder\r\n" + 
	 		"    FROM\r\n" + 
	 		"        m_fr_item_stock\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        m_fr_item_stock.item_id IN(\r\n" + 
	 		"        SELECT\r\n" + 
	 		"            i.id\r\n" + 
	 		"        FROM\r\n" + 
	 		"            m_item i\r\n" + 
	 		"        WHERE\r\n" + 
	 		"            i.del_status = 0 \r\n" + 
	 		"    ) AND m_fr_item_stock.type = :frStockType\r\n" + 
	 		") t7\r\n" + 
	 		"ON\r\n" + 
	 		"    t1.id = t7.item_id\r\n" + 
	 		"ORDER BY\r\n" + 
	 		"    t1.cat_id,\r\n" + 
	 		"    t1.sub_cat_id,\r\n" + 
	 		"    t1.item_name ", nativeQuery = true)
	
	List<OpsFrItemStock> getOpsFrCurrStock(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("month") int month,@Param("year") int year,@Param("frStockType") int frStockType);

}

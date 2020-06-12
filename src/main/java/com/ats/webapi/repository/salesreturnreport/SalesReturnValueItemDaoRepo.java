package com.ats.webapi.repository.salesreturnreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesvaluereport.SalesReturnValueDao;
import com.ats.webapi.model.salesvaluereport.SalesReturnValueItemDao;

public interface SalesReturnValueItemDaoRepo extends JpaRepository<SalesReturnValueItemDao, Integer> {

	@Query(value = "SELECT\n" + 
			"    s.*,\n" + 
			"    COALESCE(t1.grand_total, 0) AS grand_total,\n" + 
			"    COALESCE(t2.grn_qty, 0) AS grn_qty,\n" + 
			"    COALESCE(t3.gvn_qty, 0) AS gvn_qty\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        CONCAT(:month, i.id) AS id,\n" + 
			"        i.id AS item_id\n" + 
			"    FROM\n" + 
			"        m_item i\n" + 
			"    WHERE\n" + 
			"        i.item_grp2 IN(:subCatId) AND i.del_status = 0\n" + 
			") s\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        d.item_id,\n" + 
			"        SUM(d.grand_total) AS grand_total\n" + 
			"    FROM\n" + 
			"        t_bill_detail d,\n" + 
			"        t_bill_header h\n" + 
			"    WHERE\n" + 
			"        DATE_FORMAT(h.bill_date, '%Y-%m') = :month AND h.del_status = 0 AND h.bill_no = d.bill_no AND d.cat_id != 5\n" + 
			"    GROUP BY\n" + 
			"        d.item_id\n" + 
			") t1\n" + 
			"ON\n" + 
			"    s.item_id = t1.item_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        d.item_id,\n" + 
			"        SUM(d.grn_gvn_amt) AS grn_qty\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.is_grn = 1 AND DATE_FORMAT(h.crn_date, '%Y-%m') = :month AND d.cat_id != 5\n" + 
			"    GROUP BY\n" + 
			"        d.item_id\n" + 
			") t2\n" + 
			"ON\n" + 
			"    s.item_id = t2.item_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        d.item_id,\n" + 
			"        SUM(d.grn_gvn_amt) AS gvn_qty\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.is_grn = 0 AND DATE_FORMAT(h.crn_date, '%Y-%m') = :month AND d.cat_id != 5\n" + 
			"    GROUP BY\n" + 
			"        d.item_id\n" + 
			") t3\n" + 
			"ON\n" + 
			"    s.item_id = t3.item_id ", nativeQuery = true)
	List<SalesReturnValueItemDao> getSalesReturnValueItemReport1(@Param("month") String month,
			@Param("subCatId") List<Integer> subCatId);

	@Query(value = "SELECT\n" + 
			"    s.*,\n" + 
			"    COALESCE(t1.grand_total, 0) AS grand_total,\n" + 
			"    COALESCE(t2.grn_qty, 0) AS grn_qty,\n" + 
			"    COALESCE(t3.gvn_qty, 0) AS gvn_qty\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        CONCAT(:month, sp_id) AS id,\n" + 
			"        sp_id AS item_id\n" + 
			"    FROM\n" + 
			"        m_sp_cake i\n" + 
			"    WHERE\n" + 
			"        i.del_status = 0\n" + 
			") s\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        d.item_id,\n" + 
			"        SUM(d.grand_total) AS grand_total\n" + 
			"    FROM\n" + 
			"        t_bill_detail d,\n" + 
			"        t_bill_header h\n" + 
			"    WHERE\n" + 
			"        DATE_FORMAT(h.bill_date, '%Y-%m') = :month AND h.del_status = 0 AND h.bill_no = d.bill_no AND d.cat_id = 5\n" + 
			"    GROUP BY\n" + 
			"        d.item_id\n" + 
			") t1\n" + 
			"ON\n" + 
			"    s.item_id = t1.item_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        d.item_id,\n" + 
			"        SUM(d.grn_gvn_amt) AS grn_qty\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.is_grn = 1 AND DATE_FORMAT(h.crn_date, '%Y-%m') = :month AND d.cat_id = 5\n" + 
			"    GROUP BY\n" + 
			"        d.item_id\n" + 
			") t2\n" + 
			"ON\n" + 
			"    s.item_id = t2.item_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        d.item_id,\n" + 
			"        SUM(d.grn_gvn_amt) AS gvn_qty\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.is_grn = 0 AND DATE_FORMAT(h.crn_date, '%Y-%m') = :month AND d.cat_id = 5\n" + 
			"    GROUP BY\n" + 
			"        d.item_id\n" + 
			") t3\n" + 
			"ON\n" + 
			"    s.item_id = t3.item_id", nativeQuery = true)
	List<SalesReturnValueItemDao> getSalesReturnValueSpReport1(@Param("month") String month);

}

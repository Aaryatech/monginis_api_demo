package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.SalesRoyaltyConsByCat;

public interface SalesRoyaltyConsByCatRepo extends JpaRepository<SalesRoyaltyConsByCat, Integer> {
	
	@Query(value="SELECT\r\n" + 
			"    UUID() AS uid, i.id, i.cat_id, i.sub_cat_id, i.item_name, i.cat_name, \r\n" + 
			"    COALESCE(t1.bill_qty, 0) AS bill_qty,\r\n" + 
			"    COALESCE(t1.grand_total, 0) AS grand_total,\r\n" + 
			"    COALESCE(t1.taxable_amt, 0) AS taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t2.grn_qty, 0) AS grn_qty,\r\n" + 
			"    COALESCE(t2.grn_grand_total, 0) AS grn_grand_total,\r\n" + 
			"    COALESCE(t2.grn_taxable_amt, 0) AS grn_taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t3.gvn_qty, 0) AS gvn_qty,\r\n" + 
			"    COALESCE(t3.gvn_grand_total, 0) AS gvn_grand_total,\r\n" + 
			"    COALESCE(t3.gvn_taxable_amt, 0) AS gvn_taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t4.grn_qty, 0) AS crn_grn_qty,\r\n" + 
			"    COALESCE(t4.grn_grand_total, 0) AS crn_grn_grand_total,\r\n" + 
			"    COALESCE(t4.grn_taxable_amt, 0) AS crn_grn_taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t5.gvn_qty, 0) AS crn_gvn_qty,\r\n" + 
			"    COALESCE(t5.gvn_grand_total, 0) AS crn_gvn_grand_total,\r\n" + 
			"    COALESCE(t5.gvn_taxable_amt, 0) AS crn_gvn_taxable_amt\r\n" + 
			"    \r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        i.id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        i.item_grp1 AS cat_id,\r\n" + 
			"        c.cat_name,\r\n" + 
			"        i.item_grp2 AS sub_cat_id\r\n" + 
			"    FROM\r\n" + 
			"        m_item i,\r\n" + 
			"        m_category c\r\n" + 
			"    WHERE\r\n" + 
			"        i.item_grp1 IN(:catIdList) AND i.item_grp1 = c.cat_id AND i.item_grp1 != 5\r\n" + 
			"    ORDER BY\r\n" + 
			"        i.item_grp1,\r\n" + 
			"        i.item_grp2,\r\n" + 
			"        i.item_name\r\n" + 
			") i\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_id,\r\n" + 
			"        COALESCE(SUM(d.bill_qty),\r\n" + 
			"        0) AS bill_qty,\r\n" + 
			"        COALESCE(SUM(d.grand_total),\r\n" + 
			"        0) AS grand_total,\r\n" + 
			"        COALESCE(SUM(d.taxable_amt),\r\n" + 
			"        0) AS taxable_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        t_bill_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_date BETWEEN :fromDate AND :toDate AND h.bill_no = d.bill_no AND h.del_status = 0 AND h.fr_id IN(:frIdList) AND d.cat_id != 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			") t1\r\n" + 
			"ON\r\n" + 
			"    i.id = t1.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.apr_qty_acc) as grn_qty,\r\n" + 
			"    SUM(d.apr_taxable_amt) as grn_taxable_amt,\r\n" + 
			"    SUM(d.apr_grand_total) as grn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_grn_gvn d,\r\n" + 
			"        t_grn_gvn_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.grngvn_date BETWEEN :fromDate AND :toDate AND h.grn_gvn_header_id = d.grn_gvn_header_id AND h.is_grn = 1 AND d.cat_id !=5 AND d.del_status = 0 AND d.grn_gvn_status = 6 AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t2 ON i.id = t2.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.apr_qty_acc) as gvn_qty,\r\n" + 
			"    SUM(d.apr_taxable_amt) as gvn_taxable_amt,\r\n" + 
			"    SUM(d.apr_grand_total) as gvn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_grn_gvn d,\r\n" + 
			"        t_grn_gvn_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.grngvn_date BETWEEN :fromDate AND :toDate AND h.grn_gvn_header_id = d.grn_gvn_header_id AND h.is_grn IN(0,2) AND d.cat_id !=5 AND d.del_status = 0 AND d.grn_gvn_status = 6 AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t3 ON i.id = t3.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.grn_gvn_qty) as grn_qty,\r\n" + 
			"    SUM(d.taxable_amt) as grn_taxable_amt,\r\n" + 
			"    SUM(d.grn_gvn_amt) as grn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        t_credit_note_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_date BETWEEN :fromDate AND :toDate AND h.crn_id = d.crn_id AND h.is_grn =1 AND d.cat_id !=5 AND d.del_status = 0  AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t4 ON i.id = t4.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.grn_gvn_qty) as gvn_qty,\r\n" + 
			"    SUM(d.taxable_amt) as gvn_taxable_amt,\r\n" + 
			"    SUM(d.grn_gvn_amt) as gvn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        t_credit_note_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_date BETWEEN :fromDate AND :toDate AND h.crn_id = d.crn_id AND h.is_grn =0 AND d.cat_id !=5 AND d.del_status = 0  AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t5 ON i.id = t5.item_id",nativeQuery=true)
	List<SalesRoyaltyConsByCat> getSaleRoyConsoByCat(@Param("catIdList") List<String> catIdList,@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	@Query(value="SELECT\r\n" + 
			"    UUID() AS uid, i.id, i.cat_id, i.sub_cat_id, i.item_name, i.cat_name, \r\n" + 
			"    COALESCE(t1.bill_qty, 0) AS bill_qty,\r\n" + 
			"    COALESCE(t1.grand_total, 0) AS grand_total,\r\n" + 
			"    COALESCE(t1.taxable_amt, 0) AS taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t2.grn_qty, 0) AS grn_qty,\r\n" + 
			"    COALESCE(t2.grn_grand_total, 0) AS grn_grand_total,\r\n" + 
			"    COALESCE(t2.grn_taxable_amt, 0) AS grn_taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t3.gvn_qty, 0) AS gvn_qty,\r\n" + 
			"    COALESCE(t3.gvn_grand_total, 0) AS gvn_grand_total,\r\n" + 
			"    COALESCE(t3.gvn_taxable_amt, 0) AS gvn_taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t4.grn_qty, 0) AS crn_grn_qty,\r\n" + 
			"    COALESCE(t4.grn_grand_total, 0) AS crn_grn_grand_total,\r\n" + 
			"    COALESCE(t4.grn_taxable_amt, 0) AS crn_grn_taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t5.gvn_qty, 0) AS crn_gvn_qty,\r\n" + 
			"    COALESCE(t5.gvn_grand_total, 0) AS crn_gvn_grand_total,\r\n" + 
			"    COALESCE(t5.gvn_taxable_amt, 0) AS crn_gvn_taxable_amt\r\n" + 
			"    \r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        i.id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        i.item_grp1 AS cat_id,\r\n" + 
			"        c.cat_name,\r\n" + 
			"        i.item_grp2 AS sub_cat_id\r\n" + 
			"    FROM\r\n" + 
			"        m_item i,\r\n" + 
			"        m_category c\r\n" + 
			"    WHERE\r\n" + 
			"        i.item_grp1 IN(:catIdList) AND i.item_grp1 = c.cat_id AND i.item_grp1 != 5\r\n" + 
			"    ORDER BY\r\n" + 
			"        i.item_grp1,\r\n" + 
			"        i.item_grp2,\r\n" + 
			"        i.item_name\r\n" + 
			") i\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_id,\r\n" + 
			"        COALESCE(SUM(d.bill_qty),\r\n" + 
			"        0) AS bill_qty,\r\n" + 
			"        COALESCE(SUM(d.grand_total),\r\n" + 
			"        0) AS grand_total,\r\n" + 
			"        COALESCE(SUM(d.taxable_amt),\r\n" + 
			"        0) AS taxable_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        t_bill_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_date BETWEEN :fromDate AND :toDate AND h.bill_no = d.bill_no AND h.del_status = 0 AND h.fr_id IN(:frIdList) AND d.cat_id != 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			") t1\r\n" + 
			"ON\r\n" + 
			"    i.id = t1.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.apr_qty_acc) as grn_qty,\r\n" + 
			"    SUM(d.apr_taxable_amt) as grn_taxable_amt,\r\n" + 
			"    SUM(d.apr_grand_total) as grn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_grn_gvn d,\r\n" + 
			"        t_grn_gvn_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.grngvn_date BETWEEN :fromDate AND :toDate AND h.grn_gvn_header_id = d.grn_gvn_header_id AND h.is_grn = 1 AND d.cat_id !=5 AND d.del_status = 0 AND d.grn_gvn_status = 6 AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t2 ON i.id = t2.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.apr_qty_acc) as gvn_qty,\r\n" + 
			"    SUM(d.apr_taxable_amt) as gvn_taxable_amt,\r\n" + 
			"    SUM(d.apr_grand_total) as gvn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_grn_gvn d,\r\n" + 
			"        t_grn_gvn_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.grngvn_date BETWEEN :fromDate AND :toDate AND h.grn_gvn_header_id = d.grn_gvn_header_id AND h.is_grn IN(0,2) AND d.cat_id !=5 AND d.del_status = 0 AND d.grn_gvn_status = 6 AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t3 ON i.id = t3.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.grn_gvn_qty) as grn_qty,\r\n" + 
			"    SUM(d.taxable_amt) as grn_taxable_amt,\r\n" + 
			"    SUM(d.grn_gvn_amt) as grn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        t_credit_note_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_date BETWEEN :fromDate AND :toDate AND h.crn_id = d.crn_id AND h.is_grn =1 AND d.cat_id !=5 AND d.del_status = 0  AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t4 ON i.id = t4.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.grn_gvn_qty) as gvn_qty,\r\n" + 
			"    SUM(d.taxable_amt) as gvn_taxable_amt,\r\n" + 
			"    SUM(d.grn_gvn_amt) as gvn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        t_credit_note_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_date BETWEEN :fromDate AND :toDate AND h.crn_id = d.crn_id AND h.is_grn =0 AND d.cat_id !=5 AND d.del_status = 0  AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t5 ON i.id = t5.item_id\r\n" + 
			"\r\n" + 
			"UNION\r\n" + 
			"\r\n" + 
			"SELECT\r\n" + 
			"    UUID() AS uid, i.id, i.cat_id, i.sub_cat_id, i.item_name, i.cat_name, \r\n" + 
			"    COALESCE(t1.bill_qty, 0) AS bill_qty,\r\n" + 
			"    COALESCE(t1.grand_total, 0) AS grand_total,\r\n" + 
			"    COALESCE(t1.taxable_amt, 0) AS taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t2.grn_qty, 0) AS grn_qty,\r\n" + 
			"    COALESCE(t2.grn_grand_total, 0) AS grn_grand_total,\r\n" + 
			"    COALESCE(t2.grn_taxable_amt, 0) AS grn_taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t3.gvn_qty, 0) AS gvn_qty,\r\n" + 
			"    COALESCE(t3.gvn_grand_total, 0) AS gvn_grand_total,\r\n" + 
			"    COALESCE(t3.gvn_taxable_amt, 0) AS gvn_taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t4.grn_qty, 0) AS crn_grn_qty,\r\n" + 
			"    COALESCE(t4.grn_grand_total, 0) AS crn_grn_grand_total,\r\n" + 
			"    COALESCE(t4.grn_taxable_amt, 0) AS crn_grn_taxable_amt,\r\n" + 
			"    \r\n" + 
			"    COALESCE(t5.gvn_qty, 0) AS crn_gvn_qty,\r\n" + 
			"    COALESCE(t5.gvn_grand_total, 0) AS crn_gvn_grand_total,\r\n" + 
			"    COALESCE(t5.gvn_taxable_amt, 0) AS crn_gvn_taxable_amt\r\n" + 
			"    \r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        i.sp_id as id,\r\n" + 
			"        i.sp_name as item_name,\r\n" + 
			"        5 AS cat_id,\r\n" + 
			"        'Special Cake' as cat_name,\r\n" + 
			"        4 AS sub_cat_id\r\n" + 
			"    FROM\r\n" + 
			"        m_sp_cake i\r\n" + 
			"    ORDER BY\r\n" + 
			"        i.sp_name\r\n" + 
			") i\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_id,\r\n" + 
			"        COALESCE(SUM(d.bill_qty),\r\n" + 
			"        0) AS bill_qty,\r\n" + 
			"        COALESCE(SUM(d.grand_total),\r\n" + 
			"        0) AS grand_total,\r\n" + 
			"        COALESCE(SUM(d.taxable_amt),\r\n" + 
			"        0) AS taxable_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        t_bill_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_date BETWEEN :fromDate AND :toDate AND h.bill_no = d.bill_no AND h.del_status = 0 AND h.fr_id IN(:frIdList) AND d.cat_id = 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			") t1\r\n" + 
			"ON\r\n" + 
			"    i.id = t1.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.apr_qty_acc) as grn_qty,\r\n" + 
			"    SUM(d.apr_taxable_amt) as grn_taxable_amt,\r\n" + 
			"    SUM(d.apr_grand_total) as grn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_grn_gvn d,\r\n" + 
			"        t_grn_gvn_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.grngvn_date BETWEEN :fromDate AND :toDate AND h.grn_gvn_header_id = d.grn_gvn_header_id AND h.is_grn = 1 AND d.cat_id =5 AND d.del_status = 0 AND d.grn_gvn_status = 6 AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t2 ON i.id = t2.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.apr_qty_acc) as gvn_qty,\r\n" + 
			"    SUM(d.apr_taxable_amt) as gvn_taxable_amt,\r\n" + 
			"    SUM(d.apr_grand_total) as gvn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_grn_gvn d,\r\n" + 
			"        t_grn_gvn_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.grngvn_date BETWEEN :fromDate AND :toDate AND h.grn_gvn_header_id = d.grn_gvn_header_id AND h.is_grn IN(0,2) AND d.cat_id =5 AND d.del_status = 0 AND d.grn_gvn_status = 6 AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t3 ON i.id = t3.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.grn_gvn_qty) as grn_qty,\r\n" + 
			"    SUM(d.taxable_amt) as grn_taxable_amt,\r\n" + 
			"    SUM(d.grn_gvn_amt) as grn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        t_credit_note_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_date BETWEEN :fromDate AND :toDate AND h.crn_id = d.crn_id AND h.is_grn =1 AND d.cat_id =5 AND d.del_status = 0  AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t4 ON i.id = t4.item_id\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"    SELECT \r\n" + 
			"    d.item_id,\r\n" + 
			"    SUM(d.grn_gvn_qty) as gvn_qty,\r\n" + 
			"    SUM(d.taxable_amt) as gvn_taxable_amt,\r\n" + 
			"    SUM(d.grn_gvn_amt) as gvn_grand_total\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        t_credit_note_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_date BETWEEN :fromDate AND :toDate AND h.crn_id = d.crn_id AND h.is_grn =0 AND d.cat_id =5 AND d.del_status = 0  AND h.fr_id IN(:frIdList) GROUP BY d.item_id\r\n" + 
			") t5 ON i.id = t5.item_id",nativeQuery=true)
	List<SalesRoyaltyConsByCat> getSaleRoyConsoByCatUnion(@Param("catIdList") List<String> catIdList,@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	

}

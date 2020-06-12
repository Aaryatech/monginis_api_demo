package com.ats.webapi.repo.salesreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatItemReport;

public interface SubCatItemReportRepo extends JpaRepository<SubCatItemReport, Integer> {
	
	@Query(value = " SELECT\r\n" + 
			"    t1.bill_detail_no AS crnd_id,\r\n" + 
			"    t1.item_id,\r\n" + 
			"    t1.item_name,\r\n" + 
			"    t1.sub_cat_id,\r\n" + 
			"    t1.cat_id,\r\n" + 
			"    t1.fr_id,\r\n" + 
			"    t1.fr_name,\r\n" + 
			"    t1.sub_cat_name,\r\n" + 
			"    COALESCE(t1.sold_qty, 0) AS sold_qty,\r\n" + 
			"    COALESCE(t1.sold_amt, 0) AS sold_amt,\r\n" + 
			"    COALESCE(t3.var_qty, 0) AS var_qty,\r\n" + 
			"    COALESCE(t3.var_amt, 0) AS var_amt,\r\n" + 
			"    COALESCE(t2.ret_qty, 0) AS ret_qty,\r\n" + 
			"    COALESCE(t2.ret_amt, 0) AS ret_amt\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS id, td.bill_detail_no, SUM(td.grand_total) AS sold_amt,\r\n" + 
			"        SUM(td.bill_qty) AS sold_qty,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        sc.sub_cat_id,\r\n" + 
			"        sc.sub_cat_name,\r\n" + 
			"        f.fr_id,\r\n" + 
			"        m_item.id AS item_id,\r\n" + 
			"        m_item.item_name,\r\n" + 
			"        td.cat_id\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header tb,\r\n" + 
			"        t_bill_detail td,\r\n" + 
			"        m_franchisee f,\r\n" + 
			"        m_cat_sub sc,\r\n" + 
			"        m_item\r\n" + 
			"    WHERE\r\n" + 
			"        tb.del_status = 0 AND tb.fr_id IN(:frIdList) AND tb.bill_no = td.bill_no AND tb.bill_date BETWEEN :fromDate AND :toDate AND f.fr_id = tb.fr_id AND m_item.id = td.item_id AND m_item.item_grp2 = sc.sub_cat_id AND td.cat_id != 5 AND sc.sub_cat_id IN(:subCatIdList)\r\n" + 
			"    GROUP BY\r\n" + 
			"        tb.fr_id,\r\n" + 
			"        m_item.id\r\n" + 
			"    UNION ALL\r\n" + 
			"SELECT\r\n" + 
			"    UUID() AS id, td.bill_detail_no, SUM(td.grand_total) AS sold_amt,\r\n" + 
			"    SUM(td.bill_qty) AS sold_qty,\r\n" + 
			"    f.fr_name,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    f.fr_id,\r\n" + 
			"    m_sp_cake.sp_id AS item_id,\r\n" + 
			"    m_sp_cake.sp_name AS item_name,\r\n" + 
			"    sc.cat_id\r\n" + 
			"FROM\r\n" + 
			"    t_bill_header tb,\r\n" + 
			"    t_bill_detail td,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_sp_cake\r\n" + 
			"WHERE\r\n" + 
			"    tb.del_status = 0 AND tb.fr_id IN(:frIdList) AND tb.bill_no = td.bill_no AND tb.bill_date BETWEEN :fromDate AND :toDate AND f.fr_id = tb.fr_id AND m_sp_cake.sp_id = td.item_id AND td.cat_id = 5 AND sc.cat_id = 5 AND sc.sub_cat_id IN(:subCatIdList)\r\n" + 
			"GROUP BY\r\n" + 
			"    tb.fr_id,\r\n" + 
			"    m_sp_cake.sp_id\r\n" + 
			"ORDER BY\r\n" + 
			"    fr_name,\r\n" + 
			"    sub_cat_id,\r\n" + 
			"    item_name) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS id, d.crnd_id, SUM(d.grn_gvn_amt) AS ret_amt,\r\n" + 
			"        SUM(d.grn_gvn_qty) AS ret_qty,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        sc.sub_cat_id,\r\n" + 
			"        sc.sub_cat_name,\r\n" + 
			"        f.fr_id,\r\n" + 
			"        i.id AS item_id,\r\n" + 
			"        i.item_name\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_header h,\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        m_franchisee f,\r\n" + 
			"        m_cat_sub sc,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND f.fr_id = h.fr_id AND i.id = d.item_id AND i.item_grp2 = sc.sub_cat_id AND d.cat_id != 5 AND h.fr_id IN(:frIdList) AND sc.sub_cat_id IN(:subCatIdList) AND d.is_grn = 1\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.fr_id,\r\n" + 
			"        i.id\r\n" + 
			"    UNION ALL\r\n" + 
			"SELECT\r\n" + 
			"    UUID() AS id, d.crnd_id, SUM(d.grn_gvn_amt) AS ret_amt,\r\n" + 
			"    SUM(d.grn_gvn_qty) AS ret_qty,\r\n" + 
			"    f.fr_name,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    f.fr_id,\r\n" + 
			"    i.sp_id AS item_id,\r\n" + 
			"    i.sp_name\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header h,\r\n" + 
			"    t_credit_note_details d,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_sp_cake i\r\n" + 
			"WHERE\r\n" + 
			"    h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND f.fr_id = h.fr_id AND i.sp_id = d.item_id AND d.cat_id = 5 AND h.fr_id IN(:frIdList) AND sc.cat_id = 5 AND sc.sub_cat_id IN(:subCatIdList) AND d.is_grn = 1\r\n" + 
			"GROUP BY\r\n" + 
			"    h.fr_id,\r\n" + 
			"    i.sp_id\r\n" + 
			"ORDER BY\r\n" + 
			"    fr_name,\r\n" + 
			"    sub_cat_id,\r\n" + 
			"    item_name) t2\r\n" + 
			"ON\r\n" + 
			"    t1.fr_id = t2.fr_id AND t1.item_id = t2.item_id\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        UUID() AS id, d.crnd_id, SUM(d.grn_gvn_amt) AS var_amt,\r\n" + 
			"        SUM(d.grn_gvn_qty) AS var_qty,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        sc.sub_cat_id,\r\n" + 
			"        sc.sub_cat_name,\r\n" + 
			"        f.fr_id,\r\n" + 
			"        i.id AS item_id,\r\n" + 
			"        i.item_name\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_header h,\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        m_franchisee f,\r\n" + 
			"        m_cat_sub sc,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND f.fr_id = h.fr_id AND i.id = d.item_id AND i.item_grp2 = sc.sub_cat_id AND d.cat_id != 5 AND h.fr_id IN(:frIdList) AND sc.sub_cat_id IN(:subCatIdList) AND d.is_grn = 0\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.fr_id,\r\n" + 
			"        i.id\r\n" + 
			"    UNION ALL\r\n" + 
			"SELECT\r\n" + 
			"    UUID() AS id, d.crnd_id, SUM(d.grn_gvn_amt) AS var_amt,\r\n" + 
			"    SUM(d.grn_gvn_qty) AS var_qty,\r\n" + 
			"    f.fr_name,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    f.fr_id,\r\n" + 
			"    i.sp_id AS item_id,\r\n" + 
			"    i.sp_name\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header h,\r\n" + 
			"    t_credit_note_details d,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_sp_cake i\r\n" + 
			"WHERE\r\n" + 
			"    h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND f.fr_id = h.fr_id AND i.sp_id = d.item_id AND d.cat_id = 5 AND h.fr_id IN(:frIdList) AND sc.cat_id = 5 AND sc.sub_cat_id IN(:subCatIdList) AND d.is_grn = 0\r\n" + 
			"GROUP BY\r\n" + 
			"    h.fr_id,\r\n" + 
			"    i.sp_id\r\n" + 
			"ORDER BY\r\n" + 
			"    fr_name,\r\n" + 
			"    sub_cat_id,\r\n" + 
			"    item_name) t3\r\n" + 
			"ON\r\n" + 
			"    t1.fr_id = t3.fr_id AND t1.item_id = t3.item_id ", nativeQuery = true)
	List<SubCatItemReport> getFrWiseSubCatWiseItemWiseData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

}

package com.ats.webapi.repo.salesreport3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.opssalesreport.FrItemwiseVarAndRetData;

public interface FrItemWiseGrnGvnRepo extends JpaRepository<FrItemwiseVarAndRetData, Integer> {
	
	@Query(value = " SELECT\r\n" + 
			"    MONTH(ch.crn_date) AS MONTH,\r\n" + 
			"    YEAR(ch.crn_date) AS YEAR,\r\n" + 
			"    cd.crnd_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    c.cat_id,\r\n" + 
			"    ROUND(SUM(cd.grn_gvn_amt),\r\n" + 
			"    2) AS amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS qty,\r\n" + 
			"    ROUND(SUM(cd.taxable_amt),\r\n" + 
			"    2) AS taxable_amt,\r\n" + 
			"    ROUND(SUM(cd.total_tax),\r\n" + 
			"    2) AS tax_amt\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_category c,\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    cd.crn_id = ch.crn_id AND ch.crn_date BETWEEN :fromDate AND :toDate AND cd.cat_id = c.cat_id AND i.id = cd.item_id AND i.item_grp2 = sc.sub_cat_id AND cd.is_grn = 0 AND cd.cat_id != 5 AND cd.del_status = 0 AND cd.cat_id IN(:catIdList) AND ch.fr_id = :frId\r\n" + 
			"GROUP BY\r\n" + 
			"    i.item_id,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    i.item_grp2,\r\n" + 
			"    MONTH(ch.crn_date),\r\n" + 
			"    YEAR(ch.crn_date)\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    MONTH(ch.crn_date) AS MONTH,\r\n" + 
			"    YEAR(ch.crn_date) AS YEAR,\r\n" + 
			"    cd.crnd_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    sp.sp_name AS item_name,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    c.cat_id,\r\n" + 
			"    ROUND(SUM(cd.grn_gvn_amt),\r\n" + 
			"    2) AS amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS qty,\r\n" + 
			"    ROUND(SUM(cd.taxable_amt),\r\n" + 
			"    2) AS taxable_amt,\r\n" + 
			"    ROUND(SUM(cd.total_tax),\r\n" + 
			"    2) AS tax_amt\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_category c,\r\n" + 
			"    m_sp_cake sp\r\n" + 
			"WHERE\r\n" + 
			"    cd.crn_id = ch.crn_id AND ch.crn_date BETWEEN :fromDate AND :toDate AND cd.cat_id = c.cat_id AND sp.sp_id = cd.item_id AND cd.is_grn = 0 AND cd.cat_id = 5 AND cd.del_status = 0 AND cd.cat_id IN(:catIdList) AND ch.fr_id = :frId\r\n" + 
			"GROUP BY\r\n" + 
			"    sp.sp_id,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    MONTH(ch.crn_date),\r\n" + 
			"    YEAR(ch.crn_date) ", nativeQuery = true)
	List<FrItemwiseVarAndRetData> getVariation(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("catIdList") List<Integer> catIdList,@Param("frId") int frId);

	
	@Query(value = " SELECT\r\n" + 
			"    MONTH(ch.crn_date) AS MONTH,\r\n" + 
			"    YEAR(ch.crn_date) AS YEAR,\r\n" + 
			"    cd.crnd_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    c.cat_id,\r\n" + 
			"    ROUND(SUM(cd.grn_gvn_amt),\r\n" + 
			"    2) AS amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS qty,\r\n" + 
			"    ROUND(SUM(cd.taxable_amt),\r\n" + 
			"    2) AS taxable_amt,\r\n" + 
			"    ROUND(SUM(cd.total_tax),\r\n" + 
			"    2) AS tax_amt\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_category c,\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    cd.crn_id = ch.crn_id AND ch.crn_date BETWEEN :fromDate AND :toDate AND cd.cat_id = c.cat_id AND i.id = cd.item_id AND i.item_grp2 = sc.sub_cat_id AND cd.is_grn = 0 AND cd.cat_id != 5 AND cd.del_status = 0 AND cd.cat_id IN(:catIdList) AND ch.fr_id = :frId\r\n" + 
			"GROUP BY\r\n" + 
			"    i.item_id,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    i.item_grp2,\r\n" + 
			"    MONTH(ch.crn_date),\r\n" + 
			"    YEAR(ch.crn_date)\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    MONTH(ch.crn_date) AS MONTH,\r\n" + 
			"    YEAR(ch.crn_date) AS YEAR,\r\n" + 
			"    cd.crnd_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    sp.sp_name AS item_name,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    c.cat_id,\r\n" + 
			"    ROUND(SUM(cd.grn_gvn_amt),\r\n" + 
			"    2) AS amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS qty,\r\n" + 
			"    ROUND(SUM(cd.taxable_amt),\r\n" + 
			"    2) AS taxable_amt,\r\n" + 
			"    ROUND(SUM(cd.total_tax),\r\n" + 
			"    2) AS tax_amt\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_category c,\r\n" + 
			"    m_sp_cake sp\r\n" + 
			"WHERE\r\n" + 
			"    cd.crn_id = ch.crn_id AND ch.crn_date BETWEEN :fromDate AND :toDate AND cd.cat_id = c.cat_id AND sp.sp_id = cd.item_id AND cd.is_grn = 1 AND cd.cat_id = 5 AND cd.del_status = 0 AND cd.cat_id IN(:catIdList) AND ch.fr_id = :frId\r\n" + 
			"GROUP BY\r\n" + 
			"    sp.sp_id,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    MONTH(ch.crn_date),\r\n" + 
			"    YEAR(ch.crn_date) ", nativeQuery = true)
	List<FrItemwiseVarAndRetData> getReturn(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("catIdList") List<Integer> catIdList,@Param("frId") int frId);


}

package com.ats.webapi.repo.salesreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatItemFrVarAndRet;

public interface SubCatItemFrVarAndRetRepo extends JpaRepository<SubCatItemFrVarAndRet, Integer> {

	
	@Query(value = "  SELECT\r\n" + 
			"	cd.crnd_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"     sc.sub_cat_id,\r\n" + 
			"    c.cat_id,\r\n" + 
			"    ROUND(SUM(cd.grn_gvn_amt),2) AS var_amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS var_qty,\r\n" + 
			"    ROUND(SUM(cd.taxable_amt),2) AS var_taxable_amt,\r\n" + 
			"    ROUND(SUM(cd.total_tax),2) AS var_total_tax\r\n" + 
			"   \r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_category c,\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    cd.crn_id = ch.crn_id AND ch.crn_date BETWEEN :fromDate AND :toDate AND cd.cat_id = c.cat_id AND i.id = cd.item_id AND i.item_grp2 = sc.sub_cat_id AND cd.is_grn = 0  AND cd.cat_id!=5 AND sc.sub_cat_id IN(:subCatId)  AND cd.del_status=0 \r\n" + 
			"GROUP BY\r\n" + 
			"    i.item_id,\r\n" + 
			"    ch.fr_id\r\n" + 
			"    \r\n" + 
			"    \r\n" + 
			"    UNION\r\n" + 
			"    \r\n" + 
			"    SELECT\r\n" + 
			"	cd.crnd_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"     sc.sub_cat_id,\r\n" + 
			"    c.cat_id,\r\n" + 
			"    ROUND(SUM(cd.grn_gvn_amt),2) AS var_amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS var_qty,\r\n" + 
			"    ROUND(SUM(cd.taxable_amt),2) AS var_taxable_amt,\r\n" + 
			"    ROUND(SUM(cd.total_tax),2) AS var_total_tax\r\n" + 
			"   \r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_category c,\r\n" + 
			"    m_sp_cake sp\r\n" + 
			"WHERE\r\n" + 
			"    cd.crn_id = ch.crn_id AND ch.crn_date BETWEEN :fromDate AND :toDate AND cd.cat_id = c.cat_id AND sp.sp_id = cd.item_id AND \r\n" + 
			"    cd.is_grn = 0  AND cd.cat_id=5  AND sc.sub_cat_id IN(:subCatId)  AND cd.del_status=0 \r\n" + 
			"GROUP BY\r\n" + 
			"    sp.sp_id,\r\n" + 
			"    ch.fr_id ", nativeQuery = true)
	List<SubCatItemFrVarAndRet> getVariation(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("subCatId") List<Integer> subCatId);

	
	@Query(value = "  SELECT\r\n" + 
			"	cd.crnd_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"     sc.sub_cat_id,\r\n" + 
			"    c.cat_id,\r\n" + 
			"    ROUND(SUM(cd.grn_gvn_amt),2) AS var_amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS var_qty,\r\n" + 
			"    ROUND(SUM(cd.taxable_amt),2) AS var_taxable_amt,\r\n" + 
			"    ROUND(SUM(cd.total_tax),2) AS var_total_tax\r\n" + 
			"   \r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_category c,\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    cd.crn_id = ch.crn_id AND ch.crn_date BETWEEN :fromDate AND :toDate AND cd.cat_id = c.cat_id AND i.id = cd.item_id AND i.item_grp2 = sc.sub_cat_id AND cd.is_grn = 1  AND cd.cat_id!=5 AND sc.sub_cat_id IN(:subCatId)  AND cd.del_status=0 \r\n" + 
			"GROUP BY\r\n" + 
			"    i.item_id,\r\n" + 
			"    ch.fr_id\r\n" + 
			"    \r\n" + 
			"    \r\n" + 
			"    UNION\r\n" + 
			"    \r\n" + 
			"    SELECT\r\n" + 
			"	cd.crnd_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    ch.fr_id,\r\n" + 
			"     sc.sub_cat_id,\r\n" + 
			"    c.cat_id,\r\n" + 
			"    ROUND(SUM(cd.grn_gvn_amt),2) AS var_amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS var_qty,\r\n" + 
			"    ROUND(SUM(cd.taxable_amt),2) AS var_taxable_amt,\r\n" + 
			"    ROUND(SUM(cd.total_tax),2) AS var_total_tax\r\n" + 
			"   \r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_category c,\r\n" + 
			"    m_sp_cake sp\r\n" + 
			"WHERE\r\n" + 
			"    cd.crn_id = ch.crn_id AND ch.crn_date BETWEEN :fromDate AND :toDate AND cd.cat_id = c.cat_id AND sp.sp_id = cd.item_id AND \r\n" + 
			"    cd.is_grn = 1  AND cd.cat_id=5  AND sc.sub_cat_id IN(:subCatId)  AND cd.del_status=0 \r\n" + 
			"GROUP BY\r\n" + 
			"    sp.sp_id,\r\n" + 
			"    ch.fr_id ", nativeQuery = true)
	List<SubCatItemFrVarAndRet> getReturn(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("subCatId") List<Integer> subCatId);

	
}

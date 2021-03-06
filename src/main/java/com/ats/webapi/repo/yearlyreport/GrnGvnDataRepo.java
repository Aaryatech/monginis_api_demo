package com.ats.webapi.repo.yearlyreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.yearlyreport.GrnGvnData;

public interface GrnGvnDataRepo extends JpaRepository<GrnGvnData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    cd.crnd_id,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    f.fr_id,\r\n" + 
			"    SUM(cd.grn_gvn_amt) AS amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS qty,\r\n" + 
			"    SUM(cd.taxable_amt) AS taxable_amt,\r\n" + 
			"    SUM(cd.total_tax) AS tax_amt,\r\n" + 
			"    f.fr_name,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    MONTH(ch.crn_date) AS MONTH,\r\n" + 
			"    YEAR(ch.crn_date) AS YEAR,\r\n" + 
			"    cd.cat_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    i.item_name\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    ch.crn_id = cd.crn_id AND cd.del_status = 0 AND ch.crn_date BETWEEN :fromDate AND :toDate AND f.fr_id = ch.fr_id AND i.id = cd.item_id AND i.item_grp2 = sc.sub_cat_id AND cd.cat_id != 5 AND ch.fr_id IN(:frIdList) AND cd.cat_id IN(:catIdList) AND cd.is_grn = 0\r\n" + 
			"GROUP BY\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    i.item_grp2\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    cd.crnd_id,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    f.fr_id,\r\n" + 
			"    SUM(cd.grn_gvn_amt) AS amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS qty,\r\n" + 
			"    SUM(cd.taxable_amt) AS taxable_amt,\r\n" + 
			"    SUM(cd.total_tax) AS tax_amt,\r\n" + 
			"    f.fr_name,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    MONTH(ch.crn_date) AS MONTH,\r\n" + 
			"    YEAR(ch.crn_date) AS YEAR,\r\n" + 
			"    cd.cat_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    sp.sp_name AS item_name\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_sp_cake sp\r\n" + 
			"WHERE\r\n" + 
			"    ch.crn_id = cd.crn_id AND cd.del_status = 0 AND ch.crn_date BETWEEN :fromDate AND :toDate AND f.fr_id = ch.fr_id AND sp.sp_id = cd.item_id AND cd.cat_id = sc.cat_id AND cd.cat_id = 5 AND ch.fr_id IN(:frIdList) AND cd.cat_id IN(:catIdList) AND cd.is_grn = 0\r\n" + 
			"GROUP BY\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    sp.sp_id ", nativeQuery = true)
	List<GrnGvnData> getVariationData(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList, @Param("catIdList") List<Integer> catIdList);

	
	@Query(value = "SELECT\r\n" + 
			"    cd.crnd_id,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    f.fr_id,\r\n" + 
			"    SUM(cd.grn_gvn_amt) AS amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS qty,\r\n" + 
			"    SUM(cd.taxable_amt) AS taxable_amt,\r\n" + 
			"    SUM(cd.total_tax) AS tax_amt,\r\n" + 
			"    f.fr_name,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    MONTH(ch.crn_date) AS MONTH,\r\n" + 
			"    YEAR(ch.crn_date) AS YEAR,\r\n" + 
			"    cd.cat_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    i.item_name\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    ch.crn_id = cd.crn_id AND cd.del_status = 0 AND ch.crn_date BETWEEN :fromDate AND :toDate AND f.fr_id = ch.fr_id AND i.id = cd.item_id AND i.item_grp2 = sc.sub_cat_id AND cd.cat_id != 5 AND ch.fr_id IN(:frIdList) AND cd.cat_id IN(:catIdList) AND cd.is_grn = 1\r\n" + 
			"GROUP BY\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    i.item_grp2\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    cd.crnd_id,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    f.fr_id,\r\n" + 
			"    SUM(cd.grn_gvn_amt) AS amt,\r\n" + 
			"    SUM(cd.grn_gvn_qty) AS qty,\r\n" + 
			"    SUM(cd.taxable_amt) AS taxable_amt,\r\n" + 
			"    SUM(cd.total_tax) AS tax_amt,\r\n" + 
			"    f.fr_name,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    MONTH(ch.crn_date) AS MONTH,\r\n" + 
			"    YEAR(ch.crn_date) AS YEAR,\r\n" + 
			"    cd.cat_id,\r\n" + 
			"    cd.item_id,\r\n" + 
			"    sp.sp_name AS item_name\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header ch,\r\n" + 
			"    t_credit_note_details cd,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    m_sp_cake sp\r\n" + 
			"WHERE\r\n" + 
			"    ch.crn_id = cd.crn_id AND cd.del_status = 0 AND ch.crn_date BETWEEN :fromDate AND :toDate AND f.fr_id = ch.fr_id AND sp.sp_id = cd.item_id AND cd.cat_id = sc.cat_id AND cd.cat_id = 5 AND ch.fr_id IN(:frIdList) AND cd.cat_id IN(:catIdList) AND cd.is_grn = 1\r\n" + 
			"GROUP BY\r\n" + 
			"    ch.fr_id,\r\n" + 
			"    sp.sp_id ", nativeQuery = true)
	List<GrnGvnData> getReturnData(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList, @Param("catIdList") List<Integer> catIdList);

}

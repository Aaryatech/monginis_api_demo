package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.CrnDetailsSummary;

@Repository
public interface CrnDetailSummaryRepository extends JpaRepository<CrnDetailsSummary, Integer>{

	@Query(value="  SELECT detail.hsn_code AS item_hsncd,\n" + 
			"        CASE \n" + 
			"            WHEN detail.cat_id=5 THEN 'Special Cake'\n" + 
			"            ELSE (SELECT\n" + 
			"                m_category.cat_name \n" + 
			"            from\n" + 
			"                m_category \n" + 
			"            where\n" + 
			"                m_category.cat_id=detail.cat_id) \n" + 
			"        END AS item_hsncdesc,\n" + 
			"         SUM(detail.grn_gvn_qty) as grn_gvn_qty,\n" + 
			"         SUM(detail.taxable_amt) as taxable_amt,\n" + 
			"         detail.cgst_per as cgst_per,\n" + 
			"         SUM(detail.cgst_rs) as cgst_rs,\n" + 
			"         detail.sgst_per as sgst_per,\n" + 
			"         SUM(detail.sgst_rs) as sgst_rs,\n" + 
			"         detail.igst_per as igst_per,\n" + 
			"         SUM(detail.igst_rs) as igst_rs,\n" + 
			"          detail.cess_per as cess_per,\n" + 
			"         SUM(detail.cess_rs) as cess_rs\n" + 
			"        \n" + 
			"    FROM\n" + 
			"        t_credit_note_details detail \n" + 
			"    WHERE\n" + 
			"        detail.crn_id IN (:crnId)  group by item_hsncd",nativeQuery=true)
	List<CrnDetailsSummary> getCrnDetailsSummaryById(@Param("crnId")List<String> crnId);

}

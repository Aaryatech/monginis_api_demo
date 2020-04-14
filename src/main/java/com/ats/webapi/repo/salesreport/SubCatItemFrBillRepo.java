package com.ats.webapi.repo.salesreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatItemFrBill;

public interface SubCatItemFrBillRepo extends JpaRepository<SubCatItemFrBill, Integer> {

	@Query(value = "   SELECT\r\n" + 
			"    bd.bill_detail_no,\r\n" + 
			"    bh.fr_id,\r\n" + 
			"    f.fr_name,\r\n" + 
			"    i.id AS item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.item_grp2 AS sub_cat_id,\r\n" + 
			"    subcat.sub_cat_name,\r\n" + 
			"    bd.cat_id,\r\n" + 
			"    SUM(bd.bill_qty) as bill_qty,\r\n" + 
			"    ROUND(SUM(bd.grand_total),2) as bill_total,\r\n" + 
			"    ROUND(SUM(bd.taxable_amt),2) as bill_taxable_amt,\r\n" + 
			"    ROUND(SUM(bd.total_tax),2) as bill_total_tax\r\n" + 
			"FROM\r\n" + 
			"    t_bill_header bh,\r\n" + 
			"    t_bill_detail bd,\r\n" + 
			"    m_item i,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_cat_sub subcat\r\n" + 
			"WHERE\r\n" + 
			"    bd.bill_no = bh.bill_no AND i.id = bd.item_id AND bh.fr_id=f.fr_id AND subcat.sub_cat_id=i.item_grp2 AND bd.cat_id!=5 AND bh.del_status=0 AND bh.bill_date BETWEEN :fromDate AND :toDate AND subcat.sub_cat_id IN(:subCatId) \r\n" + 
			"GROUP BY\r\n" + 
			"    i.id,\r\n" + 
			"    bh.fr_id\r\n" + 
			"    \r\n" + 
			"    UNION\r\n" + 
			"    \r\n" + 
			"    SELECT\r\n" + 
			"	    bd.bill_detail_no,\r\n" + 
			"	    bh.fr_id,\r\n" + 
			"         f.fr_name,\r\n" + 
			"	    sp.sp_id AS item_id,\r\n" + 
			"        sp.sp_name AS item_name,\r\n" + 
			"	    catsub.sub_cat_id AS sub_cat_id,\r\n" + 
			"        catsub.sub_cat_name,\r\n" + 
			"	    bd.cat_id,\r\n" + 
			"	    SUM(bd.bill_qty) as bill_qty,\r\n" + 
			"	    ROUND(SUM(bd.grand_total),2) as bill_total,\r\n" + 
			"	    ROUND(SUM(bd.taxable_amt),2) as bill_taxable_amt,\r\n" + 
			"	    ROUND(SUM(bd.total_tax),2) as bill_total_tax\r\n" + 
			"	FROM\r\n" + 
			"	    t_bill_header bh,\r\n" + 
			"	    t_bill_detail bd,\r\n" + 
			"	    m_sp_cake sp,\r\n" + 
			"	    m_cat_sub catsub,\r\n" + 
			"        m_franchisee f\r\n" + 
			"	WHERE\r\n" + 
			"	    bd.bill_no = bh.bill_no AND sp.sp_id = bd.item_id AND bd.cat_id = catsub.cat_id AND bh.fr_id=f.fr_id AND bd.cat_id=5  AND bh.del_status=0 AND bh.bill_date BETWEEN :fromDate AND :toDate AND catsub.sub_cat_id IN(:subCatId)\r\n" + 
			"	GROUP BY\r\n" + 
			"	    sp.sp_id,\r\n" + 
			"	    bh.fr_id ", nativeQuery = true)
	List<SubCatItemFrBill> getData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("subCatId") List<Integer> subCatId);
	
	
	/*
	@Query(value = "   SELECT\r\n" + 
			"    bd.bill_detail_no,\r\n" + 
			"    bh.fr_id,\r\n" + 
			"    f.fr_name,\r\n" + 
			"    i.id AS item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.item_grp2 AS sub_cat_id,\r\n" + 
			"    subcat.sub_cat_name,\r\n" + 
			"    bd.cat_id,\r\n" + 
			"    SUM(bd.bill_qty) as bill_qty,\r\n" + 
			"    ROUND(SUM(bd.grand_total),2) as bill_total,\r\n" + 
			"    ROUND(SUM(bd.taxable_amt),2) as bill_taxable_amt,\r\n" + 
			"    ROUND(SUM(bd.total_tax),2) as bill_total_tax\r\n" + 
			"FROM\r\n" + 
			"    t_bill_header bh,\r\n" + 
			"    t_bill_detail bd,\r\n" + 
			"    m_item i,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_cat_sub subcat\r\n" + 
			"WHERE\r\n" + 
			"    bd.bill_no = bh.bill_no AND i.id = bd.item_id AND bh.fr_id=f.fr_id AND subcat.sub_cat_id=i.item_grp2 AND bd.cat_id!=5 AND bh.del_status=0 AND bh.bill_date BETWEEN :fromDate AND :toDate AND subcat.sub_cat_id IN(:subCatId) \r\n" + 
			"GROUP BY\r\n" + 
			"    i.id,\r\n" + 
			"    bh.fr_id\r\n" + 
			"    \r\n" + 
			"    UNION\r\n" + 
			"    \r\n" + 
			"    SELECT\r\n" + 
			"	    bd.bill_detail_no,\r\n" + 
			"	    bh.fr_id,\r\n" + 
			"         f.fr_name,\r\n" + 
			"	    sp.sp_id AS item_id,\r\n" + 
			"        sp.sp_name AS item_name,\r\n" + 
			"	    catsub.sub_cat_id AS sub_cat_id,\r\n" + 
			"        catsub.sub_cat_name,\r\n" + 
			"	    bd.cat_id,\r\n" + 
			"	    SUM(bd.bill_qty) as bill_qty,\r\n" + 
			"	    ROUND(SUM(bd.grand_total),2) as bill_total,\r\n" + 
			"	    ROUND(SUM(bd.taxable_amt),2) as bill_taxable_amt,\r\n" + 
			"	    ROUND(SUM(bd.total_tax),2) as bill_total_tax\r\n" + 
			"	FROM\r\n" + 
			"	    t_bill_header bh,\r\n" + 
			"	    t_bill_detail bd,\r\n" + 
			"	    m_sp_cake sp,\r\n" + 
			"	    m_cat_sub catsub,\r\n" + 
			"        m_franchisee f\r\n" + 
			"	WHERE\r\n" + 
			"	    bd.bill_no = bh.bill_no AND sp.sp_id = bd.item_id AND bd.cat_id = catsub.cat_id AND bh.fr_id=f.fr_id AND bd.cat_id=5  AND bh.del_status=0 AND bh.bill_date BETWEEN :fromDate AND :toDate AND catsub.sub_cat_id IN(:subCatId)\r\n" + 
			"	GROUP BY\r\n" + 
			"	    sp.sp_id,\r\n" + 
			"	    bh.fr_id ", nativeQuery = true)
	List<SubCatItemFrBill> getMonthlyData(@Param("month") String month,@Param("subCatIds") List<Integer> subCatIds,@Param("frIds") List<Integer> frIds);

*/
	
}

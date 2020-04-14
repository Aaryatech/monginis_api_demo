package com.ats.webapi.repo.salesreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatReport;

public interface SubCatReportRepo extends JpaRepository<SubCatReport, Integer> {

	@Query(value = "   SELECT SUM(td.grand_total) AS sold_amt, SUM(td.bill_qty) AS sold_qty  , SUM(td.bill_qty) AS ret_qty , SUM(td.bill_qty) AS ret_amt , SUM(td.bill_qty) AS var_qty , SUM(td.bill_qty) AS var_amt ,sc.sub_cat_id,sc.sub_cat_name,c.cat_id FROM t_bill_header tb, t_bill_detail  td  ,m_cat_sub sc ,m_category c,m_item i  WHERE tb.del_status=0  AND tb.bill_no=td.bill_no AND tb.bill_date BETWEEN :fromDate  AND :toDate  AND td.cat_id=c.cat_id AND i.item_id=td.item_id AND i.item_grp2=sc.sub_cat_id GROUP BY i.item_grp2 ", nativeQuery = true)
	List<SubCatReport> getData(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}

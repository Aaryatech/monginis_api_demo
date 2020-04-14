package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.spprod.GetSpAdvTaxReport;

public interface GetSpAdvTaxReporRepo extends JpaRepository<GetSpAdvTaxReport, Integer> {
	

	@Query(value="SELECT tsp.sp_order_no,tsp.sp_book_for_mob_no as invoice_no,tsp.tax_1 AS tax1,tsp.tax_2 AS tax2,tsp.tax_1_amt AS tax1Amt,tsp.tax_2_amt AS tax2Amt,"
			+ " tsp.sp_grand_total as total,tsp.sp_delivery_date as del_date," + 
			" tsp.sp_advance,tsp.rm_amount,tsp.sp_grand_total, ((tsp.sp_grand_total*100)/(100+tsp.tax_1+tsp.tax_2)) as base_mrp,msp.sp_name,spsup.sp_hsncd " + 
			" FROM t_sp_cake tsp,m_sp_cake msp,m_spcake_sup spsup " + 
			" WHERE tsp.sp_delivery_date BETWEEN :fromDate AND :toDate AND tsp.fr_id=:frId" + 
			"	AND tsp.sp_id=msp.sp_id AND spsup.sp_id=tsp.sp_id AND " + 
			" tsp.del_status=0 "
			,nativeQuery=true)
	List<GetSpAdvTaxReport> getSpAdTaxReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}

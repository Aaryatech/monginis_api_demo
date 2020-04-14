package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.MonthWiseReport;

@Repository
public interface MonthWiseReportRepository extends JpaRepository<MonthWiseReport, Long> {

	
	@Query(value="select h.bill_no, CONCAT(MONTHNAME(h.bill_date),'-',(YEAR(h.bill_date))) as month, SUM(d.taxable_amt) AS taxable_amt,SUM(d.igst_rs) AS igst_rs,SUM(d.cgst_rs) as cgst_rs,SUM(d.sgst_rs) as sgst_rs,SUM(d.grand_total) AS grand_total from t_bill_header h,t_bill_detail d where h.bill_no=d.bill_no AND h.fr_id=:frId and h.del_status=0 and d.del_status=0 AND h.bill_date BETWEEN :fromDate AND :toDate group by month(h.bill_date), h.fr_id order by h.bill_date",nativeQuery=true)
	List<MonthWiseReport> findMonthWiseReport(@Param("frId")int frId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="select\n" + 
			"        h.crn_id as bill_no,\n" + 
			"        CONCAT(MONTHNAME(h.crn_date),\n" + 
			"        '-',\n" + 
			"        (YEAR(h.crn_date))) as month,\n" + 
			"        SUM(d.taxable_amt) AS taxable_amt,\n" + 
			"        CASE WHEN f.is_same_state=0\n" + 
			"        	THEN \n" + 
			"       			 SUM(d.igst_rs)\n" + 
			"       		ELSE\n" + 
			"       			 0\n" + 
			"        END AS igst_rs,\n" + 
			"        \n" + 
			"        CASE WHEN f.is_same_state=0\n" + 
			"        	THEN \n" + 
			"       			 0 \n" + 
			"       		ELSE\n" + 
			"       			SUM(d.cgst_rs) \n" + 
			"        END AS cgst_rs,\n" + 
			"        \n" + 
			"        CASE WHEN f.is_same_state=0\n" + 
			"        	THEN \n" + 
			"       			 0 \n" + 
			"       		ELSE\n" + 
			"       			SUM(d.sgst_rs) \n" + 
			"        END AS sgst_rs, \n" + 
			"        SUM(d.grn_gvn_amt) AS grand_total \n" + 
			"    from\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d ,\n" + 
			"        m_franchisee f\n" + 
			"    where\n" + 
			"        h.crn_id=d.crn_id \n" + 
			"        AND h.fr_id=:frId \n" + 
			"        and d.del_status=0 \n" + 
			"        AND h.crn_date BETWEEN :fromDate AND :toDate \n" + 
			"        and f.fr_id=h.fr_id\n" + 
			"    group by\n" + 
			"        month(h.crn_date),\n" + 
			"        h.fr_id \n" + 
			"    order by\n" + 
			"        h.crn_date",nativeQuery=true)
	List<MonthWiseReport> findMonthWiseReportGrn(@Param("frId")int frId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	

}

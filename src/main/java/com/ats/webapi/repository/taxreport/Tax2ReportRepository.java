package com.ats.webapi.repository.taxreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.taxreport.Tax2Report;

@Repository
public interface Tax2ReportRepository extends JpaRepository<Tax2Report, Integer> {

	@Query(value = "select t_bill_header.invoice_no,t_bill_header.bill_date,m_franchisee.fr_name,m_franchisee.fr_gst_no, t_bill_header.bill_no,ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=0),0),2) AS taxable_amt_zero,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=5),0),2) AS taxable_amt_five,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=12),0),2) AS taxable_amt_twelve,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=18),0),2) AS taxable_amt_eighteen,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=28),0),2) AS taxable_amt_twenty_eight,\n"
			+ "t_bill_header.taxable_amt,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=0),0),2) AS sgst_amt_zero,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=5),0),2) AS sgst_amt_five,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=12),0),2) AS sgst_amt_twelve,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=18),0),2) AS sgst_amt_eighteen,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=28),0),2) AS sgst_amt_twenty_eight,\n"
			+ "t_bill_header.sgst_sum,\n" + "\n"
			+ " ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=0),0),2) AS cgst_amt_zero,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=5),0),2) AS cgst_amt_five,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=12),0),2) AS cgst_amt_twelve,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=18),0),2) AS cgst_amt_eighteen,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=28),0),2) AS cgst_amt_twenty_eight,\n"
			+ "t_bill_header.cgst_sum\n"
			+ " from  t_bill_header,m_franchisee where  t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND m_franchisee.fr_id=t_bill_header.fr_id and t_bill_header.del_status=0  order by t_bill_header.bill_no\n"
			+ "", nativeQuery = true)
	List<Tax2Report> getTax2Report(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "select t_bill_header.invoice_no,t_bill_header.bill_date,m_franchisee.fr_name,m_franchisee.fr_gst_no, t_bill_header.bill_no,ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=0),0),2) AS taxable_amt_zero,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=5),0),2) AS taxable_amt_five,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=12),0),2) AS taxable_amt_twelve,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=18),0),2) AS taxable_amt_eighteen,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=28),0),2) AS taxable_amt_twenty_eight,\n"
			+ "t_bill_header.taxable_amt,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=0),0),2) AS sgst_amt_zero,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=5),0),2) AS sgst_amt_five,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=12),0),2) AS sgst_amt_twelve,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=18),0),2) AS sgst_amt_eighteen,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=28),0),2) AS sgst_amt_twenty_eight,\n"
			+ "t_bill_header.sgst_sum,\n" + "\n"
			+ " ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=0),0),2) AS cgst_amt_zero,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=5),0),2) AS cgst_amt_five,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=12),0),2) AS cgst_amt_twelve,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=18),0),2) AS cgst_amt_eighteen,\n"
			+ "ROUND(COALESCE((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_detail   WHERE t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+sgst_per=28),0),2) AS cgst_amt_twenty_eight,\n"
			+ "t_bill_header.cgst_sum\n"
			+ " from  t_bill_header,m_franchisee where  t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND m_franchisee.fr_id=t_bill_header.fr_id AND m_franchisee.fr_id=:frId  order by t_bill_header.bill_no\n"
			+ "", nativeQuery = true)
	List<Tax2Report> getTax2ReportByFrId(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}

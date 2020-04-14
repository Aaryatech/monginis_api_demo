package com.ats.webapi.repository.taxreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.taxreport.Tax1Report;

@Repository
public interface Tax1ReportRepository extends JpaRepository<Tax1Report, Integer> {

/*	@Query(value = "select t_bill_detail.bill_detail_no,t_bill_header.invoice_no,t_bill_header.bill_date,m_franchisee.fr_name,m_franchisee.fr_gst_no, t_bill_detail.bill_no, t_bill_detail.cgst_per,t_bill_detail.sgst_per,t_bill_detail.cgst_per+sgst_per as tax_per,ROUND(SUM(t_bill_detail.taxable_amt),2) as taxable_amt,ROUND(SUM(t_bill_detail.cgst_rs),2) as cgst_amt,ROUND(SUM(t_bill_detail.sgst_rs),2) as sgst_amt,ROUND(SUM(t_bill_detail.total_tax),2) as total_tax,ROUND(SUM(t_bill_detail.grand_total),2) as grand_total from  t_bill_detail,t_bill_header,m_franchisee where t_bill_header.bill_no=t_bill_detail.bill_no AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND m_franchisee.fr_id=t_bill_header.fr_id  group by t_bill_detail. cgst_per+sgst_per,bill_no order by t_bill_detail.bill_no,tax_per", nativeQuery = true)
	List<Tax1Report> getTax1Report(@Param("fromDate") String fromDate, @Param("toDate") String toDate);*/
	
	@Query(value = "select t_bill_detail.bill_detail_no,t_bill_header.invoice_no,t_bill_header.bill_date,m_franchisee.fr_name,m_franchisee.fr_gst_no, t_bill_detail.bill_no, t_bill_detail.cgst_per,t_bill_detail.sgst_per,t_bill_detail.cgst_per+sgst_per as tax_per,ROUND(SUM(t_bill_detail.taxable_amt),2) as taxable_amt,ROUND(SUM(t_bill_detail.cgst_rs),2) as cgst_amt,ROUND(SUM(t_bill_detail.sgst_rs),2) as sgst_amt,ROUND(SUM(t_bill_detail.total_tax),2) as total_tax,ROUND(SUM(t_bill_detail.grand_total),2) as grand_total from  t_bill_detail,t_bill_header,m_franchisee where t_bill_header.bill_no=t_bill_detail.bill_no AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND m_franchisee.fr_id=t_bill_header.fr_id and t_bill_detail.del_status=0 and t_bill_header.del_status=0  group by t_bill_detail. cgst_per+sgst_per,bill_no order by t_bill_detail.bill_no,tax_per", nativeQuery = true)
	List<Tax1Report> getTax1Report(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "select t_bill_detail.bill_detail_no,t_bill_header.invoice_no,t_bill_header.bill_date,m_franchisee.fr_name,m_franchisee.fr_gst_no, t_bill_detail.bill_no, t_bill_detail.cgst_per,t_bill_detail.sgst_per,t_bill_detail.cgst_per+sgst_per as tax_per,ROUND(SUM(t_bill_detail.taxable_amt),2) as taxable_amt,ROUND(SUM(t_bill_detail.cgst_rs),2) as cgst_amt,ROUND(SUM(t_bill_detail.sgst_rs),2) as sgst_amt,ROUND(SUM(t_bill_detail.total_tax),2) as total_tax,ROUND(SUM(t_bill_detail.grand_total),2) as grand_total from  t_bill_detail,t_bill_header,m_franchisee where t_bill_header.bill_no=t_bill_detail.bill_no AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND m_franchisee.fr_id=t_bill_header.fr_id AND m_franchisee.fr_id=:frId and t_bill_detail.del_status=0 and t_bill_header.del_status=0 group by t_bill_detail. cgst_per+sgst_per,bill_no order by t_bill_detail.bill_no,tax_per", nativeQuery = true)
	List<Tax1Report> getTax1ReportByFrId(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}

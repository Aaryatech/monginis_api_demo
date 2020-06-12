package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.SalesReportBillwise;
import com.ats.webapi.model.report.frpurchase.SalesReportDateMonth;

public interface SalesReportDateMonthRepo extends JpaRepository<SalesReportDateMonth, Integer> {

	
	@Query(value="SELECT\r\n" + 
			"    t1.bill_no AS crn_id,\r\n" + 
			"    '' AS crn_no,\r\n" + 
			"    t1.bill_date AS crn_date,\r\n" + 
			"    t1.fr_id,\r\n" + 
			"    t1.month,\r\n" + 
			"    t1.bill_date,\r\n" + 
			"    COALESCE(t1.grand_total, 0) AS grand_total,\r\n" + 
			"    COALESCE(t1.taxable_amt, 0) AS taxable_amt,\r\n" + 
			"    COALESCE(t1.total_tax, 0) AS total_tax,\r\n" + 
			"    COALESCE(t2.grand_total, 0) AS grn_grand_total,\r\n" + 
			"    COALESCE(t2.taxable_amt, 0) AS grn_taxable_amt,\r\n" + 
			"    COALESCE(t2.crn_total_tax, 0) AS grn_total_tax,\r\n" + 
			"    COALESCE(t3.grand_total, 0) AS gvn_grand_total,\r\n" + 
			"    COALESCE(t3.taxable_amt, 0) AS gvn_taxable_amt,\r\n" + 
			"    COALESCE(t3.crn_total_tax, 0) AS gvn_total_tax\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        MONTHNAME(h.bill_date) AS mnt,\r\n" + 
			"        YEAR(h.bill_date) AS yr,\r\n" + 
			"        CONCAT(\r\n" + 
			"            MONTHNAME(h.bill_date),\r\n" + 
			"            '--',\r\n" + 
			"            YEAR(h.bill_date)\r\n" + 
			"        ) AS MONTH,\r\n" + 
			"        h.bill_no,\r\n" + 
			"        h.bill_date,\r\n" + 
			"        h.invoice_no,\r\n" + 
			"        h.fr_id,\r\n" + 
			"        h.fr_code,\r\n" + 
			"        h.tax_applicable,\r\n" + 
			"        SUM(h.taxable_amt) AS taxable_amt,\r\n" + 
			"        SUM(h.total_tax) AS total_tax,\r\n" + 
			"        SUM(h.grand_total) AS grand_total,\r\n" + 
			"        h.round_off,\r\n" + 
			"        SUM(h.sgst_sum) AS sgst_sum,\r\n" + 
			"        SUM(h.cgst_sum) AS cgst_sum,\r\n" + 
			"        SUM(h.igst_sum) AS igst_sum,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        f.fr_city,\r\n" + 
			"        f.fr_gst_no,\r\n" + 
			"        f.is_same_state\r\n" + 
			"    FROM\r\n" + 
			"        m_franchisee f,\r\n" + 
			"        t_bill_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.fr_id = f.fr_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND h.fr_id IN(:frIdList)\r\n" + 
			"    GROUP BY\r\n" + 
			"        MONTH\r\n" + 
			"    ORDER BY\r\n" + 
			"        h.bill_date\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        MONTHNAME(h.crn_date) AS mnt,\r\n" + 
			"        YEAR(h.crn_date) AS yr,\r\n" + 
			"        MONTHNAME(h.crn_date) AS MONTH,\r\n" + 
			"        h.crn_id,\r\n" + 
			"        h.crn_date,\r\n" + 
			"        h.crn_no,\r\n" + 
			"        f.fr_id,\r\n" + 
			"        SUM(h.crn_taxable_amt) AS taxable_amt,\r\n" + 
			"        SUM(h.crn_total_tax) AS crn_total_tax,\r\n" + 
			"        SUM(h.crn_grand_total) AS grand_total,\r\n" + 
			"        SUM(h.round_off) AS round_off\r\n" + 
			"    FROM\r\n" + 
			"        m_franchisee f,\r\n" + 
			"        t_credit_note_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.is_grn = 1 AND h.fr_id = f.fr_id AND h.crn_date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIdList)\r\n" + 
			"    GROUP BY\r\n" + 
			"        MONTH\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.mnt = t2.mnt AND t1.yr = t2.yr\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        MONTHNAME(h.crn_date) AS mnt,\r\n" + 
			"        YEAR(h.crn_date) AS yr,\r\n" + 
			"        MONTHNAME(h.crn_date) AS MONTH,\r\n" + 
			"        h.crn_id,\r\n" + 
			"        h.crn_date,\r\n" + 
			"        h.crn_no,\r\n" + 
			"        f.fr_id,\r\n" + 
			"        SUM(h.crn_taxable_amt) AS taxable_amt,\r\n" + 
			"        SUM(h.crn_total_tax) AS crn_total_tax,\r\n" + 
			"        SUM(h.crn_grand_total) AS grand_total,\r\n" + 
			"        SUM(h.round_off) AS round_off\r\n" + 
			"    FROM\r\n" + 
			"        m_franchisee f,\r\n" + 
			"        t_credit_note_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.is_grn = 0 AND h.fr_id = f.fr_id AND h.crn_date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIdList)\r\n" + 
			"    GROUP BY\r\n" + 
			"        MONTH\r\n" + 
			") t3\r\n" + 
			"ON\r\n" + 
			"    t1.mnt = t3.mnt AND t1.yr = t3.yr",nativeQuery=true)
		
		List<SalesReportDateMonth> getSaleMonthWiseReport(@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
}

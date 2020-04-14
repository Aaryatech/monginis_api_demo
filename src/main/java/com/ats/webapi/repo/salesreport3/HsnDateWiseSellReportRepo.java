package com.ats.webapi.repo.salesreport3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport3.HsnDateWiseSellReport;

public interface HsnDateWiseSellReportRepo extends JpaRepository<HsnDateWiseSellReport, Integer> {

	@Query(value = "SELECT\r\n" + 
			"sh.sell_bill_no as no,\r\n" + 
			"    sd.sell_bill_detail_no,\r\n" + 
			"    sh.invoice_no,\r\n" + 
			"    sh.bill_date,\r\n" + 
			"    sh.user_name,\r\n" + 
			"    sh.user_gst_no,\r\n" + 
			"    sd.remark AS hsn_code,\r\n" + 
			"    sd.qty,\r\n" + 
			"    ROUND(SUM(sd.taxable_amt),\r\n" + 
			"    2) as taxable_amt,\r\n" + 
			"    sd.cgst_per,\r\n" + 
			"    ROUND(SUM(sd.cgst_rs),\r\n" + 
			"    2) as cgst_rs,\r\n" + 
			"    sgst_per,\r\n" + 
			"    ROUND(SUM(sgst_rs),\r\n" + 
			"    2) as sgst_rs,\r\n" + 
			"    ROUND(\r\n" + 
			"        (\r\n" + 
			"            SUM(sd.taxable_amt) + SUM(sd.cgst_rs) + SUM(sd.sgst_rs)\r\n" + 
			"        ),\r\n" + 
			"        2\r\n" + 
			"    ) AS total,\r\n" + 
			"    ROUND(\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            SUM(sd.grand_total)\r\n" + 
			"        FROM\r\n" + 
			"            t_sell_bill_header sh,\r\n" + 
			"            t_sell_bill_detail sd\r\n" + 
			"        WHERE\r\n" + 
			"            sh.sell_bill_no = sd.sell_bill_no AND sh.sell_bill_no = no\r\n" + 
			"    ),\r\n" + 
			"    2\r\n" + 
			"    ) AS bill_total\r\n" + 
			"FROM\r\n" + 
			"    t_sell_bill_header sh,\r\n" + 
			"    t_sell_bill_detail sd\r\n" + 
			"WHERE\r\n" + 
			"    sh.sell_bill_no = sd.sell_bill_no AND sh.del_status = 0 AND sd.del_status = 0 AND sh.bill_date BETWEEN :fromDate AND :toDate AND sh.fr_id=:frId \r\n" + 
			"GROUP BY\r\n" + 
			"    sd.remark,\r\n" + 
			"    sh.sell_bill_no\r\n" + 
			"    ORDER BY sh.sell_bill_no", nativeQuery = true)
	List<HsnDateWiseSellReport> getSellBillData(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("frId") int frId);

}
package com.ats.webapi.repository.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.dashboard.SellBillFrontEndReport;

public interface SellBillFrontEndReportRepo extends JpaRepository<SellBillFrontEndReport, Integer> {
	
	@Query(value=""
			+ " SELECT t_sell_bill_header.bill_date, SUM(t_sell_bill_detail.taxable_amt) AS taxable_amt ,sum(t_sell_bill_detail.total_tax) AS total_tax, "
			+ " SUM(t_sell_bill_detail.grand_total) AS grand_total FROM t_sell_bill_header,t_sell_bill_detail WHERE " + 
			" t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate "
			+ " AND t_sell_bill_header.sell_bill_no=t_sell_bill_detail.sell_bill_no AND t_sell_bill_header.del_status=0 and t_sell_bill_header.fr_id IN(:frIdList) ",nativeQuery=true)
	SellBillFrontEndReport getSellReportByDateAndFr(@Param("fromDate")String fromDate,@Param("toDate")String toDate,@Param("frIdList") List<String> frIdList);
	
	

}

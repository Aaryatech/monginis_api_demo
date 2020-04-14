package com.ats.webapi.repository.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.dashboard.PurBillBackEndReport;

public interface PurBillBackEndReportRepo extends JpaRepository<PurBillBackEndReport, Integer>{
	
	@Query(value=""
			+ "SELECT t_bill_header.bill_date,  SUM(t_bill_header.grand_total)as grand_total, "
			+ " SUM(t_bill_header.taxable_amt)as taxable_amt, "
			+ " SUM(t_bill_header.total_tax)as total_tax "
			+ " FROM t_bill_header WHERE t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 ",nativeQuery=true)
	PurBillBackEndReport getPurReportByDates(@Param("fromDate")String fromDate,@Param("toDate")String toDate);

	
	//for FrontEnd
	@Query(value=""
			+ "SELECT t_bill_header.bill_date,  SUM(t_bill_header.grand_total)as grand_total, "
			+ " SUM(t_bill_header.taxable_amt)as taxable_amt, "
			+ " SUM(t_bill_header.total_tax)as total_tax "
			+ " FROM t_bill_header WHERE t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 "
			+ " AND t_bill_header.fr_id IN(:frIdList)",nativeQuery=true)
	PurBillBackEndReport getPurReportByDateAndFr(@Param("fromDate")String fromDate,@Param("toDate")String toDate,@Param("frIdList")List<String> frIdList);

}

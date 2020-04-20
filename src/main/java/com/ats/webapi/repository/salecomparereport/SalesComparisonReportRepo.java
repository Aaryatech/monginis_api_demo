package com.ats.webapi.repository.salecomparereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.salecompare.SalesComparisonReport;

public interface SalesComparisonReportRepo extends JpaRepository<SalesComparisonReport, Integer> {


	@Query(value=" SELECT MONTH(t_bill_header.bill_date) as month,MONTHNAME(t_bill_header.bill_date) as month_name, m_fr_route.route_name ,m_franchisee.fr_id, m_franchisee.fr_name"
			+ ",m_franchisee.fr_route_id,SUM(t_bill_header.grand_total) AS bill_total FROM `t_bill_header`,m_franchisee,"
			+ "m_fr_route WHERE (SELECT month(bill_date) =:monthNumber and year(bill_date)=:year and  m_franchisee.fr_id =t_bill_header.fr_id and "
			+ "m_fr_route.route_id=m_franchisee.fr_route_id) and t_bill_header.del_status=0 GROUP BY month,m_franchisee.fr_id ",nativeQuery=true)
	List<SalesComparisonReport> getSalesReportComparisonBillTotal(@Param("monthNumber")int monthNumber,@Param("year")int year);
	
	
	@Query(value=" SELECT\n" + 
			"    MONTH(t_bill_header.bill_date) AS MONTH,\n" + 
			"    MONTHNAME(t_bill_header.bill_date) AS month_name,\n" + 
			"    m_fr_route.route_name,\n" + 
			"    m_franchisee.fr_id,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_franchisee.fr_route_id,\n" + 
			"    SUM(t_bill_header.grand_total) AS bill_total\n" + 
			"FROM\n" + 
			"    `t_bill_header`,\n" + 
			"    m_franchisee,\n" + 
			"    m_fr_route\n" + 
			"WHERE\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND m_franchisee.fr_id = t_bill_header.fr_id AND m_fr_route.route_id = m_franchisee.fr_route_id\n" + 
			") AND t_bill_header.del_status = 0\n" + 
			"GROUP BY\n" + 
			"    MONTH\n" + 
			"ORDER BY\n" + 
			"    t_bill_header.bill_date ",nativeQuery=true)
	List<SalesComparisonReport> getSalesReportComparisonBillTotalBetDates(@Param("fromDate")String fromDate,@Param("toDate")String toDate);
	

}

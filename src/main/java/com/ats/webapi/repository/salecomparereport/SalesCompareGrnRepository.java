package com.ats.webapi.repository.salecomparereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.report.salecompare.SalesComparisonReport;
import com.ats.webapi.model.report.salecompare.SalesGrn;
@Repository
public interface SalesCompareGrnRepository extends JpaRepository<SalesGrn, Integer>{


	@Query(value=" SELECT MONTH(t_grn_gvn_header.grngvn_date) as month,monthname(t_grn_gvn_header.grngvn_date) as month_name,"
			+ " m_fr_route.route_name ,m_franchisee.fr_id, m_franchisee.fr_name,m_franchisee.fr_route_id,sum(t_grn_gvn_header.apr_grand_total) "
			+ "as bill_total FROM t_grn_gvn_header,m_franchisee,m_fr_route WHERE (SELECT month(t_grn_gvn_header.grngvn_date)=:monthNumber "
			+ "and year(t_grn_gvn_header.grngvn_date)=:year and t_grn_gvn_header.fr_id=m_franchisee.fr_id and m_fr_route.route_id=m_franchisee.fr_route_id ) "
			+ "GROUP BY month,m_franchisee.fr_id " + 
			"",nativeQuery=true)
	List<SalesGrn> getSalesReportComparisonGrnGvnTotal(@Param("monthNumber")int monthNumber,@Param("year")int year);
	
	
	@Query(value=" SELECT\n" + 
			"    MONTH(t_grn_gvn_header.grngvn_date) AS MONTH,\n" + 
			"    MONTHNAME(t_grn_gvn_header.grngvn_date) AS month_name,\n" + 
			"    m_fr_route.route_name,\n" + 
			"    m_franchisee.fr_id,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_franchisee.fr_route_id,\n" + 
			"    SUM(\n" + 
			"        t_grn_gvn_header.apr_grand_total\n" + 
			"    ) AS bill_total\n" + 
			"FROM\n" + 
			"    t_grn_gvn_header,\n" + 
			"    m_franchisee,\n" + 
			"    m_fr_route\n" + 
			"WHERE\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        t_grn_gvn_header.grngvn_date BETWEEN :fromDate AND :toDate AND t_grn_gvn_header.fr_id = m_franchisee.fr_id AND m_fr_route.route_id = m_franchisee.fr_route_id\n" + 
			")\n" + 
			"GROUP BY\n" + 
			"    MONTH,\n" + 
			"    m_franchisee.fr_id\n" + 
			"ORDER BY\n" + 
			"    t_grn_gvn_header.grngvn_date " + 
			"",nativeQuery=true)
	List<SalesGrn> getSalesReportComparisonGrnGvnTotalBetDates(@Param("fromDate")String fromDate,@Param("toDate")String toDate);


}

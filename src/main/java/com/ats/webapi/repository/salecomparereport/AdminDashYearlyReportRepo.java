package com.ats.webapi.repository.salecomparereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.salecompare.AdminDashYearlyReport;

public interface AdminDashYearlyReportRepo extends JpaRepository<AdminDashYearlyReport, Integer> {


	
	@Query(value="SELECT \r\n" + 
			"t1.*,COALESCE(t2.sale,0) as sale,COALESCE(t3.grn1,0) as grn1,COALESCE(t4.grn2,0) as grn2,COALESCE(t5.grn3,0) as grn3,(COALESCE(t3.grn1,0)+COALESCE(t4.grn2,0)+COALESCE(t5.grn3,0)) as grn_total,COALESCE(t6.gvn,0) as gvn,(COALESCE(t2.sale,0)-(COALESCE(t3.grn1,0)+COALESCE(t4.grn2,0)+COALESCE(t5.grn3,0)+COALESCE(t6.gvn,0))) as net\r\n" + 
			"FROM\r\n" + 
			"(\r\n" + 
			"select \r\n" + 
			"uuid() as  id,\r\n" + 
			"DATE_FORMAT(m1, '%b %Y') as month_str,\r\n" + 
			"MONTH(m1) as month,\r\n" + 
			"YEAR(m1) as year,m1\r\n" + 
			"\r\n" + 
			"from\r\n" + 
			"(\r\n" + 
			"select \r\n" + 
			"(:fromDate - INTERVAL DAYOFMONTH(:fromDate)-1 DAY) \r\n" + 
			"+INTERVAL m MONTH as m1\r\n" + 
			"from\r\n" + 
			"(\r\n" + 
			"select @rownum\\:=@rownum+1 as m from\r\n" + 
			"(select 1 union select 2 union select 3 union select 4) t1,\r\n" + 
			"(select 1 union select 2 union select 3 union select 4) t2,\r\n" + 
			"(select 1 union select 2 union select 3 union select 4) t3,\r\n" + 
			"(select 1 union select 2 union select 3 union select 4) t4,\r\n" + 
			"(select @rownum\\:=-1) t0\r\n" + 
			") d1\r\n" + 
			") d2 \r\n" + 
			"where m1<=:toDate\r\n" + 
			"order by m1\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN \r\n" + 
			"(\r\n" + 
			"    SELECT\r\n" + 
			"    MONTH(t_bill_header.bill_date) AS MONTH,\r\n" + 
			"    SUM(t_bill_header.grand_total) AS sale\r\n" + 
			"FROM\r\n" + 
			"    t_bill_header\r\n" + 
			"WHERE\r\n" + 
			"    t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status = 0\r\n" + 
			"GROUP BY\r\n" + 
			"    MONTH\r\n" + 
			"    \r\n" + 
			") t2 ON t1.month=t2.month\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"SELECT\r\n" + 
			"	MONTH(t_grn_gvn.grn_gvn_date) as month,\r\n" + 
			"    SUM(apr_grand_total) as grn1\r\n" + 
			"FROM\r\n" + 
			"    t_grn_gvn\r\n" + 
			"WHERE\r\n" + 
			"    t_grn_gvn.is_grn = 1 AND t_grn_gvn.grn_type = 0 AND t_grn_gvn.grn_gvn_status = 6 AND  t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY MONTH\r\n" + 
			"\r\n" + 
			") t3 ON t1.month=t3.month\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"SELECT\r\n" + 
			"	MONTH(t_grn_gvn.grn_gvn_date) as month,\r\n" + 
			"    SUM(apr_grand_total) as grn2\r\n" + 
			"FROM\r\n" + 
			"    t_grn_gvn\r\n" + 
			"WHERE\r\n" + 
			"    t_grn_gvn.is_grn = 1 AND t_grn_gvn.grn_type = 1 AND t_grn_gvn.grn_gvn_status = 6 AND  t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY MONTH\r\n" + 
			"\r\n" + 
			") t4 ON t1.month=t4.month\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"SELECT\r\n" + 
			"	MONTH(t_grn_gvn.grn_gvn_date) as month,\r\n" + 
			"    SUM(apr_grand_total) as grn3\r\n" + 
			"FROM\r\n" + 
			"    t_grn_gvn\r\n" + 
			"WHERE\r\n" + 
			"    t_grn_gvn.is_grn = 1 AND t_grn_gvn.grn_type IN(2, 4) AND t_grn_gvn.grn_gvn_status = 6 AND  t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY MONTH\r\n" + 
			"\r\n" + 
			") t5 ON t1.month=t5.month\r\n" + 
			"\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"SELECT\r\n" + 
			"	MONTH(t_grn_gvn.grn_gvn_date) as month,\r\n" + 
			"    SUM(apr_grand_total) as gvn\r\n" + 
			"FROM\r\n" + 
			"    t_grn_gvn\r\n" + 
			"WHERE\r\n" + 
			"    t_grn_gvn.is_grn = 0 AND t_grn_gvn.grn_gvn_status = 6 AND  t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY MONTH\r\n" + 
			"\r\n" + 
			") t6 ON t1.month=t6.month\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"ORDER BY t1.m1\r\n" + 
			" " + 
			"",nativeQuery=true)
	List<AdminDashYearlyReport> getAdminDashYearlyData(@Param("fromDate")String fromDate,@Param("toDate")String toDate);
	


}

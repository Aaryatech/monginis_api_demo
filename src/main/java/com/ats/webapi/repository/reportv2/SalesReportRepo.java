package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.reportv2.SalesReport;

public interface SalesReportRepo extends JpaRepository<SalesReport, Integer> {

	@Query(value = " SELECT    m_franchisee.fr_id,m_franchisee.fr_code,"
			+ "        m_franchisee.fr_name,  m_franchisee.fr_city,"
			+ "COALESCE((SELECT SUM(t_bill_header.grand_total) FROM  t_bill_header  WHERE "
			+ " t_bill_header.bill_date BETWEEN :fromDate AND :toDate  AND t_bill_header.del_status=0 "
			+ "   AND m_franchisee.fr_id=t_bill_header.fr_id ), 0) AS  sale_value,"
			+ " COALESCE((SELECT SUM(t_credit_note_header.crn_grand_total) FROM "
			+ "    t_credit_note_header  WHERE "
			+ "            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "            AND t_credit_note_header.is_grn=1 "
			+ "            AND m_franchisee.fr_id=t_credit_note_header.fr_id), 0) AS  grn_value,"
			+ "        COALESCE((SELECT SUM(t_credit_note_header.crn_grand_total)  FROM "
			+ "            t_credit_note_header WHERE "
			+ "            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "            AND t_credit_note_header.is_grn=0 "
			+ "            AND m_franchisee.fr_id=t_credit_note_header.fr_id), 0) AS  gvn_value FROM "
			+ "        m_franchisee  ORDER BY  m_franchisee.fr_name ", nativeQuery = true)

	List<SalesReport> getSalesReportAllFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT * FROM ( SELECT\n" + 
			"    f.*,\n" + 
			"    COALESCE(t1.grand_total, 0) AS sale_value,\n" + 
			"    COALESCE(t2.grn_value, 0) AS grn_value,\n" + 
			"    COALESCE(t3.gvn_value, 0) AS gvn_value\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        f.fr_id,\n" + 
			"        f.fr_code,\n" + 
			"        f.fr_name,\n" + 
			"        f.fr_city\n" + 
			"    FROM\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"        f.fr_id IN(:frIdList)\n" + 
			"    ORDER BY\n" + 
			"        f.fr_name\n" + 
			") f\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        h.fr_id,\n" + 
			"        SUM(h.grand_total) AS grand_total\n" + 
			"    FROM\n" + 
			"        t_bill_header h\n" + 
			"    WHERE\n" + 
			"        h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0\n" + 
			"    GROUP BY\n" + 
			"        h.fr_id\n" + 
			") t1\n" + 
			"ON\n" + 
			"    f.fr_id = t1.fr_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        h.fr_id,\n" + 
			"        SUM(h.crn_grand_total) AS grn_value\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h\n" + 
			"    WHERE\n" + 
			"        h.crn_date BETWEEN :fromDate AND :toDate AND h.is_grn = 1\n" + 
			"    GROUP BY\n" + 
			"        h.fr_id\n" + 
			") t2\n" + 
			"ON\n" + 
			"    f.fr_id = t2.fr_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        h.fr_id,\n" + 
			"        SUM(h.crn_grand_total) AS gvn_value\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h\n" + 
			"    WHERE\n" + 
			"        h.crn_date BETWEEN :fromDate AND :toDate AND h.is_grn = 0\n" + 
			"    GROUP BY\n" + 
			"        h.fr_id\n" + 
			") t3\n" + 
			"ON\n" + 
			"    f.fr_id = t3.fr_id ) t\n" + 
			"ORDER BY\n" + 
			"    fr_name", nativeQuery = true)

	List<SalesReport> getSalesReportSpecFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			 @Param("frIdList") List<String> frIdList);

}

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

	@Query(value = " SELECT    m_franchisee.fr_id,m_franchisee.fr_code,"
			+ "        m_franchisee.fr_name,  m_franchisee.fr_city,"
			+ "COALESCE((SELECT SUM(t_bill_header.grand_total) FROM  t_bill_header  WHERE "
			+ " t_bill_header.bill_date BETWEEN :fromDate AND :toDate  AND t_bill_header.del_status=0 "
			+ "   AND m_franchisee.fr_id=t_bill_header.fr_id ), 0) AS  sale_value,"
			+ " COALESCE((SELECT SUM(t_credit_note_header.crn_grand_total) FROM "
			+ "    t_credit_note_header  WHERE "
			+ "  t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ " AND t_credit_note_header.is_grn=1 "
			+ " AND m_franchisee.fr_id=t_credit_note_header.fr_id), 0) AS  grn_value,"
			+ "  COALESCE((SELECT SUM(t_credit_note_header.crn_grand_total)  FROM "
			+ "  t_credit_note_header WHERE "
			+ "  t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "  AND t_credit_note_header.is_grn=0 "
			+ " AND m_franchisee.fr_id=t_credit_note_header.fr_id), 0) AS  gvn_value FROM "
			+ " m_franchisee WHERE m_franchisee.fr_id IN (:frIdList)   ORDER BY  m_franchisee.fr_name ", nativeQuery = true)

	List<SalesReport> getSalesReportSpecFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			 @Param("frIdList") List<String> frIdList);

}

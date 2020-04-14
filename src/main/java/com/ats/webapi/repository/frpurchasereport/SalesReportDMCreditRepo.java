package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.SalesReportDMCredit;

public interface SalesReportDMCreditRepo extends JpaRepository<SalesReportDMCredit, Integer> {

	@Query(value = " " + "SELECT\n" + 
			"        MONTHNAME(t_credit_note_header.crn_date)as month,\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"        t_credit_note_header.crn_date,\n" + 
			"        t_credit_note_header.crn_no, \n" + 
			"        m_franchisee.fr_id,\n" + 
			"       \n" + 
			"        SUM(t_credit_note_header.crn_taxable_amt) as taxable_amt ,\n" + 
			"        SUM(t_credit_note_header.crn_total_tax) as crn_total_tax,\n" + 
			"        SUM(t_credit_note_header.crn_grand_total) AS grand_total ,\n" + 
			"        SUM(t_credit_note_header.round_off) as round_off\n" + 
			"    FROM\n" + 
			"        m_franchisee,\n" + 
			"        t_credit_note_header \n" + 
			"    WHERE\n" + 
			"    \n" + 
			"    t_credit_note_header.is_grn=1 AND\n" + 
			"        t_credit_note_header.fr_id=m_franchisee.fr_id \n" + 
			"        AND t_credit_note_header.fr_id IN(\n" + 
			"     :frIdList\n" + 
			"        )  \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN  :fromDate AND :toDate \n" + 
			"    GROUP BY\n" + 
			"        t_credit_note_header.crn_date", nativeQuery = true)

	List<SalesReportDMCredit> getDataGRN(@Param("frIdList") List<String> frIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate
	 );
	
	@Query(value = " " + "SELECT\n" + 
			"        MONTHNAME(t_credit_note_header.crn_date)as month,\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"        t_credit_note_header.crn_date,\n" + 
			"        t_credit_note_header.crn_no, \n" + 
			"        m_franchisee.fr_id,\n" + 
			"       \n" + 
			"        SUM(t_credit_note_header.crn_taxable_amt) as taxable_amt ,\n" + 
			"        SUM(t_credit_note_header.crn_total_tax) as crn_total_tax,\n" + 
			"        SUM(t_credit_note_header.crn_grand_total) AS grand_total ,\n" + 
			"        SUM(t_credit_note_header.round_off) as round_off \n" + 
			"    FROM\n" + 
			"        m_franchisee,\n" + 
			"        t_credit_note_header \n" + 
			"    WHERE\n" + 
			"    \n" + 
			"    t_credit_note_header.is_grn=1 AND\n" + 
			"        t_credit_note_header.fr_id=m_franchisee.fr_id \n" + 
			"        AND t_credit_note_header.fr_id IN(\n" + 
			"     :frIdList\n" + 
			"        )  \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN  :fromDate AND :toDate \n" + 
			"    GROUP BY\n" + 
			"    month ", nativeQuery = true)

	List<SalesReportDMCredit> getDataGRNForMonth(@Param("frIdList") List<String> frIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate
	 );
	
	

	@Query(value = " " + "SELECT\n" + 
			"        MONTHNAME(t_credit_note_header.crn_date)as month,\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"        t_credit_note_header.crn_date,\n" + 
			"        t_credit_note_header.crn_no, \n" + 
			"        m_franchisee.fr_id,\n" + 
			"       \n" + 
			"        SUM(t_credit_note_header.crn_taxable_amt) as taxable_amt ,\n" + 
			"        SUM(t_credit_note_header.crn_total_tax) as crn_total_tax,\n" + 
			"        SUM(t_credit_note_header.crn_grand_total) AS grand_total ,\n" + 
			"        SUM(t_credit_note_header.round_off) as  round_off\n" + 
			"    FROM\n" + 
			"        m_franchisee,\n" + 
			"        t_credit_note_header \n" + 
			"    WHERE\n" + 
			"    \n" + 
			"    t_credit_note_header.is_grn=0 AND\n" + 
			"        t_credit_note_header.fr_id=m_franchisee.fr_id \n" + 
			"        AND t_credit_note_header.fr_id IN(\n" + 
			"     :frIdList\n" + 
			"        )  \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN  :fromDate AND :toDate \n" + 
			"    GROUP BY\n" + 
			"        t_credit_note_header.crn_date", nativeQuery = true)

	List<SalesReportDMCredit> getDataGVN(@Param("frIdList") List<String> frIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate
	 );
	
	@Query(value = " " + "SELECT\n" + 
			"        MONTHNAME(t_credit_note_header.crn_date)as month,\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"        t_credit_note_header.crn_date,\n" + 
			"        t_credit_note_header.crn_no, \n" + 
			"        m_franchisee.fr_id,\n" + 
			"       \n" + 
			"        SUM(t_credit_note_header.crn_taxable_amt) as taxable_amt ,\n" + 
			"        SUM(t_credit_note_header.crn_total_tax) as crn_total_tax,\n" + 
			"        SUM(t_credit_note_header.crn_grand_total) AS grand_total ,\n" + 
			"        SUM(t_credit_note_header.round_off) as round_off \n" + 
			"    FROM\n" + 
			"        m_franchisee,\n" + 
			"        t_credit_note_header \n" + 
			"    WHERE\n" + 
			"    \n" + 
			"    t_credit_note_header.is_grn=0 AND\n" + 
			"        t_credit_note_header.fr_id=m_franchisee.fr_id \n" + 
			"        AND t_credit_note_header.fr_id IN(\n" + 
			"     :frIdList\n" + 
			"        )  \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN  :fromDate AND :toDate \n" + 
			"    GROUP BY\n" + 
			"        month ", nativeQuery = true)

	List<SalesReportDMCredit> getDataGVNForMonth(@Param("frIdList") List<String> frIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate
	 );
//report 1 all Fr

}

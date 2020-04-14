package com.ats.webapi.repository.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.dashboard.CredNoteReport;


public interface CredNoteReportRepo extends JpaRepository<CredNoteReport, Integer>{
	
	
	@Query(value=""
			+ "SELECT t_credit_note_header.crn_date,t_credit_note_header.is_grn," + 
			"sum(t_credit_note_header.crn_grand_total) as crn_grand_total," + 
			
			"sum(t_credit_note_header.crn_taxable_amt) as crn_taxable_amt," + 
		
			"sum(t_credit_note_header.crn_total_tax) as crn_total_tax " + 
			
			" from t_credit_note_header WHERE " + 
			" t_credit_note_header.fr_id IN(:frIdList) " + 
			" AND t_credit_note_header.crn_date BETWEEN :fromDate and :toDate and t_credit_note_header.is_grn IN(:isGrn) " + 
			"",nativeQuery=true)
	CredNoteReport getCreNoteReportForFr(@Param("fromDate")String fromDate,@Param("toDate")String toDate,@Param("frIdList")List<String> frIdList,
			@Param("isGrn")List<String> isGrn);
	
	@Query(value=""
			+ "SELECT t_credit_note_header.crn_date,t_credit_note_header.is_grn," + 
			"sum(t_credit_note_header.crn_grand_total) as crn_grand_total," + 
			
			"sum(t_credit_note_header.crn_taxable_amt) as crn_taxable_amt," + 
		
			"sum(t_credit_note_header.crn_total_tax) as crn_total_tax " + 
			
			" from t_credit_note_header WHERE " + 
			
			"  t_credit_note_header.crn_date BETWEEN :fromDate and :toDate and t_credit_note_header.is_grn IN(:isGrn) " + 
			"",nativeQuery=true)
	CredNoteReport getCreNoteReportAllFr(@Param("fromDate")String fromDate,@Param("toDate")String toDate,
			@Param("isGrn")List<String> isGrn);

	
	

}

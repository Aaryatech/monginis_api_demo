package com.ats.webapi.repository.getcreditnote;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvn.GetCreditNoteReport;

public interface GetCreditNoteReportRepo extends JpaRepository<GetCreditNoteReport, Integer> {

	
	@Query(value="SELECT " + 
			"    ch.crn_id," + 
			"    ch.crn_date," + 
			"    ch.fr_id," + 
			"    ch.crn_taxable_amt," + 
			"    ch.crn_total_tax," + 
			"    ch.crn_grand_total," + 
			"    ch.crn_no," + 
			"    fr.fr_name," + 
			"    fr.fr_address," + 
			"    fr.fr_gst_no," + 
			"    fr.is_same_state," + 
			"    ch.is_grn," + 
			"sum(cnd.sgst_rs)as sgst_sum,sum(cnd.cgst_rs) as cgst_sum,sum(cnd.igst_rs) as igst_sum,sum(cnd.cess_rs) as cess_sum  " + 
			 
			"FROM " + 
			"    m_franchisee fr," + 
			"    t_credit_note_header ch," + 
			"t_credit_note_details cnd " + 
			"WHERE " + 
			"      ch.crn_id IN (:crnIdList) "+
			"    AND  ch.fr_id =fr.fr_id " + 
			"AND cnd.crn_id=ch.crn_id " + 
			"group by ch.crn_id  ",nativeQuery=true)
	
	List<GetCreditNoteReport> getCredNoteReportSelFr(@Param("crnIdList") List<String> crnIdList);
	
	
	@Query(value="SELECT " + 
			"    ch.crn_id," + 
			"    ch.crn_date," + 
			"    ch.fr_id," + 
			"    ch.crn_taxable_amt," + 
			"    ch.crn_total_tax," + 
			"    ch.crn_grand_total," + 
			"    ch.crn_no," + 
			"    fr.fr_name," + 
			"    fr.fr_address," + 
			"    fr.fr_gst_no," + 
			"    fr.is_same_state," + 
			"    ch.is_grn," + 
			"sum(cnd.sgst_rs)as sgst_sum,sum(cnd.cgst_rs) as cgst_sum,sum(cnd.igst_rs) as igst_sum,sum(cnd.cess_rs) as cess_sum " + 
			 
			"FROM " + 
			"    m_franchisee fr," + 
			"    t_credit_note_header ch," + 
			"t_credit_note_details cnd " + 
			"WHERE " + 
			"    ch.crn_date BETWEEN  :fromDate AND  :toDate " + 
		
			"    AND  ch.fr_id =fr.fr_id " + 
			"AND cnd.crn_id=ch.crn_id " + 
			"group by ch.crn_id,ch.fr_id  ",nativeQuery=true)
	
	List<GetCreditNoteReport> getCredNoteReportAllFr(@Param("fromDate")Date fromDate,@Param("toDate") Date toDate);
	
	
	
}

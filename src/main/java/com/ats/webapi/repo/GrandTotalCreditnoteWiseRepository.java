package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GrandTotalCreditnoteWise;

public interface GrandTotalCreditnoteWiseRepository extends JpaRepository<GrandTotalCreditnoteWise, Integer>{

	@Query(value = " SELECT\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"        t_credit_note_header.crn_date,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_credit_note_details.crnd_id ,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        m_franchisee.fr_name,\n" + 
			"        t_credit_note_header.crn_no as fr_code,\n" + 
			"        m_franchisee.fr_gst_no,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_amt) as crn_amt \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details,\n" + 
			"        t_bill_header,\n" + 
			"        m_franchisee \n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate   \n" + 
			"        AND t_credit_note_header.fr_id=m_franchisee.fr_id \n" + 
			"        AND t_bill_header.bill_no=t_credit_note_header.ex_int1 and t_credit_note_details.del_status=0 and t_bill_header.del_status=0  and t_credit_note_header.is_grn = :creditNoteType \n" + 
			"    GROUP BY \n" + 
			"        t_credit_note_details.crn_id  \n" + 
			"    order by\n" + 
			"        t_credit_note_header.crn_no", nativeQuery = true)
	List<GrandTotalCreditnoteWise> getGrandTotalCreditnotewise(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("creditNoteType") int creditNoteType);

}

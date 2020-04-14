package com.ats.webapi.repo.ownerapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ownerapp.CreditNoteDetailDisplayFroApp;

public interface CreditNoteDetailDisplayFroAppRepo extends JpaRepository<CreditNoteDetailDisplayFroApp, Integer> {
	
	@Query(value="SELECT\r\n" + 
			"    d.*,\r\n" + 
			"    c.cat_name,\r\n" + 
			"    CASE WHEN d.ex_int1 > 0 THEN(\r\n" + 
			"        SUBSTRING_INDEX(d.ex_varchar1, '#', -1)\r\n" + 
			"    ) ELSE CASE WHEN d.cat_id = 5 THEN(\r\n" + 
			"    SELECT\r\n" + 
			"        s.sp_name\r\n" + 
			"    FROM\r\n" + 
			"        m_sp_cake s\r\n" + 
			"    WHERE\r\n" + 
			"        s.sp_id = d.item_id\r\n" + 
			") ELSE(\r\n" + 
			"    SELECT\r\n" + 
			"        i.item_name\r\n" + 
			"    FROM\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        i.id = d.item_id\r\n" + 
			")\r\n" + 
			"END\r\n" + 
			"END AS item_name\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_details d,\r\n" + 
			"    t_credit_note_header h,\r\n" + 
			"    m_category c\r\n" + 
			"WHERE\r\n" + 
			"    h.crn_id = d.crn_id AND d.cat_id = c.cat_id AND h.crn_date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIds) ",nativeQuery=true)
	List<CreditNoteDetailDisplayFroApp> getCrnDetailByDateAndFr(@Param ("fromDate") String fromDate,@Param("toDate") String toDate,@Param("frIds") ArrayList<Integer> frIds);


}

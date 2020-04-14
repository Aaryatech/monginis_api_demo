package com.ats.webapi.repo.ownerapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ownerapp.BillHeaderDisplayForApp;


public interface BillHeaderDisplayForAppRepo extends JpaRepository<BillHeaderDisplayForApp, Integer> {
	
	@Query(value="SELECT h.*,f.fr_name,f.fr_address FROM t_bill_header h, m_franchisee f WHERE h.del_status=0 AND h.fr_id=f.fr_id AND h.fr_id IN(:frIds) AND h.bill_date BETWEEN :fromDate AND :toDate ",nativeQuery=true)
	List<BillHeaderDisplayForApp> getBillHeaderByDateAndFr(@Param ("fromDate") String fromDate,@Param("toDate") String toDate,@Param("frIds") ArrayList<Integer> frIds);


}

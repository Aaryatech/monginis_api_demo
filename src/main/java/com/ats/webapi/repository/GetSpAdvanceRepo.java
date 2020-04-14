package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.spprod.GetSpAdvanceReport;

public interface GetSpAdvanceRepo extends JpaRepository<GetSpAdvanceReport, Integer> {
	
	@Query(value="SELECT\n" + 
			"        tsp.sp_cust_name as cust_name,\n" + 
			"        msp.sp_name as item_name,\n" + 
			"        tsp.order_date as order_date,\n" + 
			"        tsp.sp_grand_total as total_mrp,\n" + 
			"        tsp.sp_advance as adv_amt,\n" + 
			"        tsp.sp_order_no ,\n" + 
			"        tsp.sp_selected_weight as weight,\n" + 
			"        tsp.sp_delivery_date as del_date,\n" + 
			"        tsp.sp_cust_mob_no,\n" + 
			"        tsp.rm_amount,\n" + 
			"        f.spf_name\n" + 
			"    FROM\n" + 
			"        m_sp_cake msp,\n" + 
			"        t_sp_cake tsp,\n" + 
			"        m_sp_flavour f\n" + 
			"    where\n" + 
			"        tsp.sp_id=msp.sp_id \n" + 
			"        AND tsp.sp_delivery_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND tsp.fr_id=:frId \n" + 
			"        AND tsp.del_status=0\n" + 
			"        and f.spf_id=tsp.sp_flavour_id"
			,nativeQuery=true)
	List<GetSpAdvanceReport> getSpAdvance(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}

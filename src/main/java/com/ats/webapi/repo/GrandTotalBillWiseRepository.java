package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GrandTotalBillWise;

public interface GrandTotalBillWiseRepository extends JpaRepository<GrandTotalBillWise, Integer>{

	@Query(value = "select\n" + 
			"        t_bill_detail.bill_detail_no,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        m_franchisee.fr_name,\n" + 
			"        m_franchisee.fr_gst_no,\n" + 
			"        t_bill_detail.bill_no, \n" + 
			"        ROUND(SUM(t_bill_detail.grand_total),\n" + 
			"        2) as grand_total \n" + 
			"    from\n" + 
			"        t_bill_detail,\n" + 
			"        t_bill_header,\n" + 
			"        m_franchisee \n" + 
			"    where\n" + 
			"        t_bill_header.bill_no=t_bill_detail.bill_no \n" + 
			"        AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND m_franchisee.fr_id=t_bill_header.fr_id  and t_bill_detail.del_status=0 and t_bill_header.del_status=0 \n" + 
			"    group by \n" + 
			"        bill_no \n" + 
			"    order by\n" + 
			"        t_bill_detail.bill_no", nativeQuery = true)
	List<GrandTotalBillWise> getGrandTotalBillWise(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}

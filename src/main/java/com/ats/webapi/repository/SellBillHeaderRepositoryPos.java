package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SellBillHeaderAndDetail;

public interface SellBillHeaderRepositoryPos extends JpaRepository<SellBillHeaderAndDetail, Integer>{

	
	@Query(value="select\n" + 
			"       sh.*,c.cust_name,c.gst_no \n" + 
			"    from\n" + 
			"        t_sell_bill_header sh,m_customer c \n" + 
			"    where\n" + 
			"        sh.sell_bill_no=:billId and c.cust_id=sh.cust_id",nativeQuery=true)
	SellBillHeaderAndDetail getSellBillHeaderAndDetailForPos(@Param("billId") int billId);

}

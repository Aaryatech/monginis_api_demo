package com.ats.webapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.pettycash.OtherBillDetailAdv;


public interface OtherBillDetailAdvRepo extends JpaRepository<OtherBillDetailAdv, Integer> {

	@Query(value="SELECT\n" + 
			"			UUID() as id,\n" + 
			"            COALESCE(SUM(t_other_bill_detail.bill_qty*m_item.item_mrp1),\n" + 
			"            0) as bill_detail_item_mrp\n" + 
			"        FROM\n" + 
			"            t_other_bill_detail,\n" + 
			"            m_item     \n" + 
			"        WHERE\n" + 
			"           \n" + 
			"             t_other_bill_detail.item_id=m_item.id  \n" + 
			"            AND t_other_bill_detail.bill_no IN(             SELECT\n" + 
			"                t_other_bill_header.bill_no              \n" + 
			"            FROM\n" + 
			"                t_other_bill_header              \n" + 
			"            WHERE\n" + 
			"                t_other_bill_header.fr_id=:frId                 \n" + 
			"                AND t_other_bill_header.bill_date=:date)",nativeQuery=true)
	public OtherBillDetailAdv getOtherBillDetailAdv(@Param("frId") int frId, @Param("date") String date);
}

package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.gatesale.GateSaleBillDetail;
import com.ats.webapi.model.gatesale.GateSaleBillDetailRes;

@Repository
public interface GateSaleBillDetailResRepository extends JpaRepository<GateSaleBillDetailRes, Integer>{

	@Query(value="select t_gatesale_bill_detail.bill_detail_id,\n" + 
			"t_gatesale_bill_detail.bill_id,\n" + 
			"t_gatesale_bill_detail.item_id,\n" + 
			"t_gatesale_bill_detail.item_qty,t_gatesale_bill_header.is_other,\n" + 
			"t_gatesale_bill_detail.item_rate,\n" + 
			"t_gatesale_bill_detail.item_value,\n" + 
			"CASE WHEN t_gatesale_bill_header.is_other=0 THEN (select m_item.item_name from m_item where t_gatesale_bill_detail.item_id=m_item.id)  ELSE\n" + 
			"(select m_gatesale_other_item.item_name from m_gatesale_other_item where  t_gatesale_bill_detail.item_id=m_gatesale_other_item.item_id)\n" + 
			" END AS item_name\n" + 
			"from t_gatesale_bill_detail,\n" + 
			"t_gatesale_bill_header\n" + 
			"\n" + 
			"where \n" + 
			"t_gatesale_bill_header.bill_id=t_gatesale_bill_detail.bill_id And t_gatesale_bill_header.bill_id=:billId",nativeQuery=true)
	List<GateSaleBillDetailRes> findGateSaleBillDetailByBillId(@Param("billId")int billId);

}

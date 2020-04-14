package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.purchaseorder.PurchaseOrderDetail;

public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrderDetail, Integer>{
	
	PurchaseOrderDetail save(PurchaseOrderDetail purchaseOrderDetail);
	
	@Query(value=" select t_purchase_order_detail.* from t_purchase_order_detail where t_purchase_order_detail.del_status=0 and t_purchase_order_detail.po_id=:po_id",nativeQuery=true)
	List<PurchaseOrderDetail> purchaseOrderDetaillist(@Param("po_id") int po_id);

}

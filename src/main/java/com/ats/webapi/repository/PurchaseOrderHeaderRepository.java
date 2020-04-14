package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.purchaseorder.GetPurchaseOrderList;
import com.ats.webapi.model.purchaseorder.PurchaseOrderHeader;

public interface PurchaseOrderHeaderRepository extends JpaRepository<PurchaseOrderHeader, Integer>{

	
	PurchaseOrderHeader save(PurchaseOrderHeader purchaseOrderHeader);
	
	@Query(value=" select * from t_purchase_order_header where del_status=0 and po_id=:poId",nativeQuery=true)
	PurchaseOrderHeader findbyPoId(@Param("poId")int poId);

	@Query(value=" select * from t_purchase_order_header where del_status=0 and supp_id=:suppId and po_status in (5,6)",nativeQuery=true)
	List<PurchaseOrderHeader> findBySuppId(@Param("suppId") int suppId);

	@Query(value=" select * from t_purchase_order_header where del_status=0 and po_status in (:status)",nativeQuery=true)
	List<PurchaseOrderHeader> getPoByStatus(@Param("status") List<String> status);

	@Transactional
	@Modifying
	@Query(" UPDATE PurchaseOrderHeader SET del_status=1 WHERE po_id=:poId")
	int deletePoRecord(@Param("poId") int poId);

	@Query(value=" select * from t_purchase_order_header where del_status=0 and  po_date between :fromDate and :toDate and po_status in (:status)",nativeQuery=true)
	List<PurchaseOrderHeader> getDateWisePerchaseOrderList(@Param("status")List<String> status,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
}

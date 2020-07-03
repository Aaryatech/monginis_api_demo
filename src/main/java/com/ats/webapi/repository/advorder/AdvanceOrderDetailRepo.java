package com.ats.webapi.repository.advorder;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.advorder.AdvanceOrderDetail;

public interface AdvanceOrderDetailRepo extends JpaRepository<AdvanceOrderDetail, Integer>{

 
	@Transactional
	@Modifying
	@Query(value="UPDATE t_adv_order_detail SET is_sell_bill_generated=1  WHERE adv_header_id=:advHeadId",nativeQuery=true)
	int updateIsSellBillGen(@Param("advHeadId") int advHeadId);

	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_adv_order_detail SET is_bill_generated=2  WHERE adv_detail_id=:advDetailId",nativeQuery=true)
	int updateIsBillGenInAdvOrdDetail(@Param("advDetailId") int advDetailId);//Sachin 06-01-2020

	
	
	List<AdvanceOrderDetail> findByAdvHeaderIdAndDelStatus( int advHeadId, int delStatus);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_adv_order_detail SET del_status=1  WHERE adv_header_id=:ordHeaderId",nativeQuery=true)
	int deleteAdvOrdDetail(@Param("ordHeaderId") int ordHeaderId);

	@Query(value="select adv_header_id from  t_adv_order_detail WHERE adv_detail_id=:advDetailId",nativeQuery=true)
	int getAdvOrderHeaderNo(@Param("advDetailId") int advDetailId);
	
	@Query(value="SELECT COALESCE((h.is_daily_mart),1) FROM t_adv_order_header h,t_adv_order_detail d WHERE h.adv_header_id=d.adv_header_id AND d.adv_detail_id=:advDetailId ",nativeQuery=true)
	int getIsDairyMartStatus(@Param("advDetailId") int advDetailId);
	
	
	

	
}

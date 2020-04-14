package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetRegSpCakeOrders;
import com.ats.webapi.model.RegularSpCkOrders;

@Repository
public interface RegularSpCkOrderAdminRepo extends JpaRepository<RegularSpCkOrders, Long> {

	@Query(value="SELECT t_regular_sp_cake.rsp_id, m_franchisee.fr_name ,m_item.item_name ,m_item.id,t_regular_sp_cake.rsp_delivery_dt, t_regular_sp_cake.rsp_events,t_regular_sp_cake.rsp_events_name,t_regular_sp_cake.rsp_sub_total,t_regular_sp_cake.tax_1,t_regular_sp_cake.tax_1_amt,t_regular_sp_cake.tax_2,t_regular_sp_cake.tax_2_amt,t_regular_sp_cake.rate,t_regular_sp_cake.mrp,t_regular_sp_cake.qty FROM m_franchisee ,m_item,t_regular_sp_cake WHERE t_regular_sp_cake.rsp_produ_date =:strDate and t_regular_sp_cake.del_status=0 AND t_regular_sp_cake.item_id = m_item.id AND t_regular_sp_cake.fr_id = m_franchisee.fr_id",nativeQuery=true)
	List<RegularSpCkOrders> findRegularSpCakeOrderAllFr(@Param("strDate")String strDate);

	@Query(value="SELECT t_regular_sp_cake.rsp_id, m_franchisee.fr_name ,m_item.item_name ,m_item.id,t_regular_sp_cake.rsp_delivery_dt, t_regular_sp_cake.rsp_events,t_regular_sp_cake.rsp_events_name,t_regular_sp_cake.rsp_sub_total,t_regular_sp_cake.tax_1,t_regular_sp_cake.tax_1_amt,t_regular_sp_cake.tax_2,t_regular_sp_cake.tax_2_amt,t_regular_sp_cake.rate,t_regular_sp_cake.mrp,t_regular_sp_cake.qty FROM m_franchisee ,m_item,t_regular_sp_cake WHERE t_regular_sp_cake.rsp_produ_date =:strDate and t_regular_sp_cake.del_status=0 AND t_regular_sp_cake.fr_id IN (:frId) AND t_regular_sp_cake.item_id = m_item.id AND t_regular_sp_cake.fr_id = m_franchisee.fr_id",nativeQuery=true)
	List<RegularSpCkOrders> findRegularSpCakeOrder(@Param("frId")List<Integer> frId, @Param("strDate")String strDate);

	//@Query(value="SELECT t_regular_sp_cake.rsp_id, m_franchisee.fr_name ,m_item.item_name ,m_item.id,t_regular_sp_cake.rsp_delivery_dt, t_regular_sp_cake.rsp_events,t_regular_sp_cake.rsp_events_name,t_regular_sp_cake.rsp_sub_total,t_regular_sp_cake.tax_1,t_regular_sp_cake.tax_1_amt,t_regular_sp_cake.tax_2,t_regular_sp_cake.tax_2_amt,t_regular_sp_cake.rate,t_regular_sp_cake.mrp,t_regular_sp_cake.qty FROM m_franchisee ,m_item,t_regular_sp_cake WHERE t_regular_sp_cake.rsp_delivery_dt=:spDeliveryDt and t_regular_sp_cake.del_status=0 AND t_regular_sp_cake.item_id = m_item.id AND t_regular_sp_cake.fr_id = m_franchisee.fr_id AND t_regular_sp_cake.fr_id=:frId",nativeQuery=true)
//	List<RegularSpCkOrders> findRegularCakeOrderHistory(@Param("spDeliveryDt") String spDeliveryDt, @Param("frId")int frId);

}

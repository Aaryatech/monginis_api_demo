package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetSpCakeOrders;
import com.ats.webapi.model.GetSpCkOrder;

public interface GetSpCakeOrdersRepository extends JpaRepository<GetSpCakeOrders, Integer>{

	
	@Query(value="SELECT f.fr_name , s.sp_selected_weight,  s.order_photo, s.order_photo2, s.sp_order_no, f.fr_mob, sp.sp_name, s.order_date, s.sp_price, s.sp_instructions, s.sp_sub_total,"
			+" s.sp_advance, s.rm_amount, s.sp_delivery_date, s.sp_delivery_place, s.sp_cust_name, s.sp_cust_mob_no, sf.spf_name"
			+" FROM m_franchisee f ,m_sp_cake sp, m_sp_flavour sf,t_sp_cake s WHERE s.sp_order_no IN(:spOrderNo) AND s.sp_id = sp.sp_id AND s.fr_id = f.fr_id AND sf.spf_id=s.sp_flavour_id "
			,nativeQuery=true)
	List<GetSpCakeOrders> getSpCakeOrders(@Param("spOrderNo")List<String> spOrderNo);

	
}

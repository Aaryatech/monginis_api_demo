package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetSpCkOrder;

public interface GetSpCakeOrderRepository extends JpaRepository<GetSpCkOrder, Integer>{

	@Query(value="SELECT f.fr_name , s.sp_selected_weight,coalesce((select abc_type from m_fr_route where route_id=f.fr_route_id),0) as fr_r_type,s.slip_no as slip_no,f.fr_city,ROUND(coalesce((sp.mrp_rate1*s.sp_selected_weight),0),2) as slip_mrp,  s.order_photo,s.item_id,s.sp_events,s.sp_events_name, s.order_photo2, s.sp_order_no, f.fr_mob, sp.sp_name, s.order_date, s.sp_price, s.sp_instructions, s.sp_sub_total,"
			+" s.sp_advance, s.rm_amount, s.sp_delivery_date, s.sp_delivery_place, s.sp_cust_name, s.sp_cust_mob_no,s.ex_var1, sf.spf_name"
			+" FROM m_franchisee f ,m_sp_cake sp, m_sp_flavour sf,t_sp_cake s WHERE s.sp_order_no IN(:spOrderNo) AND s.sp_id = sp.sp_id AND s.fr_id = f.fr_id AND sf.spf_id=s.sp_flavour_id "
			,nativeQuery=true)
	List<GetSpCkOrder> getSpCakeOrder(@Param("spOrderNo")List<String> spOrderNo);

	
}

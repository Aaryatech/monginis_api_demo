package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersBean;

public interface SpCakeOrdersRepoAdmin extends JpaRepository<SpCakeOrdersBean, Integer> {
	
	
	
	
	@Query(value="SELECT m_sp_cake.sp_image,t_sp_cake.slip_no,m_franchisee.fr_name ,m_sp_cake.sp_code ,m_sp_cake.sp_name ,"
			+ "t_sp_cake.item_id ,t_sp_cake.is_bill_generated,t_sp_cake.sp_order_no,t_sp_cake.sp_selected_weight,"
			+ "m_sp_flavour.spf_name,t_sp_cake.sp_events,t_sp_cake.sp_booked_for_name,t_sp_cake.is_allocated,"
			+ " t_sp_cake.sp_delivery_date, t_sp_cake.sp_price,t_sp_cake.sp_total_add_rate"
			+ " FROM m_franchisee ,m_sp_cake,m_sp_flavour,"
			+ "t_sp_cake WHERE  t_sp_cake.menu_id IN(:spMenuId) And  t_sp_cake.sp_delivery_date = :PDate And t_sp_cake.del_status=0 AND t_sp_cake.fr_id IN (:frId) AND "
			+ "t_sp_cake.sp_id = m_sp_cake.sp_id AND t_sp_cake.fr_id = m_franchisee.fr_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id  "
			,nativeQuery=true)
	
	
	List<SpCakeOrdersBean> FindAllSpCakeOrder(@Param("spMenuId")List<Integer> spMenuId,@Param("frId")List<Integer> frId,@Param("PDate")String pDate);

//
	@Query(value="SELECT m_sp_cake.sp_image,t_sp_cake.slip_no,m_franchisee.fr_name ,m_sp_cake.sp_code ,t_sp_cake.is_bill_generated,t_sp_cake.sp_booked_for_name,t_sp_cake.is_allocated, t_sp_cake.item_id ,t_sp_cake.sp_selected_weight,m_sp_cake.sp_name ,t_sp_cake.sp_order_no,t_sp_cake.sp_delivery_date, m_sp_flavour.spf_name, t_sp_cake.sp_events, t_sp_cake.sp_price,t_sp_cake.sp_total_add_rate  FROM m_franchisee ,m_sp_cake, m_sp_flavour ,t_sp_cake WHERE t_sp_cake.menu_id IN(:spMenuId) And t_sp_cake.sp_delivery_date = :prodDate And t_sp_cake.del_status=0 AND t_sp_cake.sp_id = m_sp_cake.sp_id AND t_sp_cake.fr_id = m_franchisee.fr_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id "
			,nativeQuery=true)
	List<SpCakeOrdersBean> FindAllSpCakeOrderAllFr(@Param("spMenuId")List<Integer> spMenuId,@Param("prodDate")String prodDate);
	
	
	
	
	//SELECT m_franchisee.fr_name ,m_item.item_name ,m_item.id,t_regular_sp_cake.rsp_delivery_dt, t_regular_sp_cake.rsp_events,t_regular_sp_cake.rsp_events_name,t_regular_sp_cake.rsp_sub_total,t_regular_sp_cake.tax_1,t_regular_sp_cake.tax_1_amt,t_regular_sp_cake.tax_2,t_regular_sp_cake.tax_2_amt,t_regular_sp_cake.rate,t_regular_sp_cake.mrp,t_regular_sp_cake.qty FROM m_franchisee ,m_item,t_regular_sp_cake WHERE t_regular_sp_cake.rsp_produ_date = '2017-10-03' AND t_regular_sp_cake.fr_id IN (15) AND t_regular_sp_cake.item_id = m_item.item_id AND t_regular_sp_cake.fr_id = m_franchisee.fr_id
	

	
	
}

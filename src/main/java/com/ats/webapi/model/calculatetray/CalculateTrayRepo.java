package com.ats.webapi.model.calculatetray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CalculateTrayRepo extends JpaRepository<CalCulateTray, Integer> {

	// @Query(value = " SELECT t_order.order_id,
	// m_franchisee.fr_id,m_franchisee.fr_route_id,m_franchisee.fr_name,m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,
	// SUM(t_order.order_qty) as order_qty,COALESCE((CEILING(
	// (SUM(t_order.order_qty)/ m_item_sup.no_of_item_per_tray))),0) as tray_qty
	// FROM `t_order`,m_cat_sub,m_franchisee,m_item_sup WHERE
	// m_franchisee.fr_id=t_order.fr_id AND
	// m_cat_sub.sub_cat_id=t_order.order_sub_type AND
	// t_order.delivery_date=:deliveryDate AND t_order.menu_id IN(:menuIdList) AND
	// t_order.fr_id IN(:frIdList) AND m_item_sup.item_id=t_order.item_id GROUP BY
	// t_order.fr_id,t_order.order_sub_type"
	// + "", nativeQuery = true)
	@Query(value = "SELECT t_order.order_id, m_franchisee.fr_id,m_route_tray_mgmt.route_tray_id as fr_route_id,m_franchisee.fr_name,m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name, \n"
			+ "	SUM(t_order.order_qty) as order_qty,\n"
			+ "	COALESCE((CEILING( (SUM(t_order.order_qty)/ m_item_sup.no_of_item_per_tray))),0) as tray_qty \n"
			+ "	FROM t_order,m_cat_sub,m_franchisee,m_item_sup,m_route_tray_mgmt WHERE m_franchisee.fr_id=t_order.fr_id \n"
			+ "	AND  m_cat_sub.sub_cat_id=t_order.order_sub_type and FIND_IN_SET(m_franchisee.fr_id,m_route_tray_mgmt.fr_ids)\n"
			+ "	AND t_order.delivery_date=:deliveryDate\n" + "	AND t_order.menu_id IN(:menuIdList) \n"
			+ "	AND t_order.fr_id \n" + "	IN(:frIdList)  \n"
			+ "	 AND m_route_tray_mgmt.route_tray_id IN(:routeIdList) AND " +

			"	m_item_sup.item_id=t_order.item_id GROUP BY t_order.fr_id,t_order.order_sub_type ORDER BY t_order.order_type,t_order.order_sub_type ", nativeQuery = true)
	List<CalCulateTray> getCalculateTray(@Param("deliveryDate") String deliveryDate,
			@Param("frIdList") List<Integer> frIdList, @Param("menuIdList") List<Integer> menuIdList,
			@Param("routeIdList") List<Integer> routeIdList);

}

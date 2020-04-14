package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetRegSpCakeOrderQty;

public interface GetRegSpCakeOrderQtyRepository extends JpaRepository<GetRegSpCakeOrderQty, Integer>{
	
//	@Query(value = " SELECT t_regular_sp_cake.rsp_id, SUM(t_regular_sp_cake.qty) as qty, t_regular_sp_cake.item_id, m_item.item_grp1, t_regular_sp_cake.menu_id FROM t_regular_sp_cake, m_item WHERE t_regular_sp_cake.order_date =:orderDate AND t_regular_sp_cake.item_id =:itemId AND t_regular_sp_cake.is_bill_generated=0 AND t_regular_sp_cake.menu_id=:menuId AND m_item.id=t_regular_sp_cake.item_id ", nativeQuery = true)
//	GetRegSpCakeOrderQty getRegSpCakeOrderItemQty(@Param("itemId") int itemId, @Param("orderDate") String orderDate, @Param("menuId") int menuId);

	@Query(value = " SELECT t_regular_sp_cake.rsp_id, t_regular_sp_cake.rsp_produ_date, SUM(t_regular_sp_cake.qty) as qty, t_regular_sp_cake.item_id, m_item.item_grp1, t_regular_sp_cake.menu_id, m_item.item_name FROM t_regular_sp_cake, m_item WHERE t_regular_sp_cake.rsp_produ_date =:productionDate AND t_regular_sp_cake.del_status=0 AND  t_regular_sp_cake.is_bill_generated=0 AND t_regular_sp_cake.menu_id IN(:menuId) AND m_item.id=t_regular_sp_cake.item_id GROUP BY t_regular_sp_cake.item_id", nativeQuery = true)
	List<GetRegSpCakeOrderQty> getRegSpCakeOrderAllItemQty(@Param("productionDate") String productionDate, @Param("menuId") List<String> menuId);
	
}

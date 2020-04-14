package com.ats.webapi.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetOrderItemQty;
import com.ats.webapi.model.GetRegSpCakeOrderQty;


public interface GetOrderItemRepository extends JpaRepository<GetOrderItemQty, Integer>
{
//
//	@Query(value = " SELECT t_order.order_id, SUM(t_order.order_qty) as qty, t_order.item_id, m_item.item_grp1, t_order.menu_id FROM t_order, m_item WHERE t_order.order_date =:orderDate AND t_order.is_bill_generated=0 AND t_order.menu_id=:menuId AND m_item.id=t_order.item_id ", nativeQuery = true)
//	GetOrderItemQty getOrderItemQty(@Param("itemId") int itemId, @Param("orderDate") String orderDate, @Param("menuId") int menuId);

	@Query(value = " SELECT t_order.order_id, t_order.production_date, SUM(t_order.order_qty) as qty, t_order.item_id, m_item.item_grp1, m_item.item_name, t_order.menu_id FROM t_order, m_item WHERE t_order.production_date =:productionDate AND t_order.is_bill_generated=0 AND t_order.menu_id IN(:menuId) AND m_item.id=t_order.item_id GROUP BY t_order.item_id order by item_grp2 Asc,item_sort_id Asc", nativeQuery = true)
	List<GetOrderItemQty> getOrderAllItemQty(@Param("productionDate") String productionDate, @Param("menuId") List<String> menuId);

	
//	
//	@Query(value = "SELECT t_order.item_id, t_order.order_id FROM t_order WHERE t_order.order_date=:orderDate AND t_order.item_id=:itemId" , nativeQuery=true)
//	GetOrderItemQty getOrderItemQty(@Param("itemId") int itemId, @Param("orderDate") String orderDate );
}

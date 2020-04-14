package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

	@Query(value = "SELECT * FROM t_order WHERE t_order.fr_id=:frId AND t_order.is_edit=0 and  t_order.ref_id=0 AND t_order.item_id =:items AND t_order.production_date=:date AND t_order.menu_id=:menuId", nativeQuery = true)
	Orders findPreviousOrder(@Param("items") String items, @Param("frId") int frId, @Param("date") Date date,
			@Param("menuId") int menuId);

	Orders save(Orders order);

	// Orders save(Orders order);

	@Transactional
	Long deleteByOrderDateAndFrIdAndMenuIdAndItemId(Date orderDate, int frId, int menuId, String itemId);

	@Transactional
	@Modifying
	@Query("UPDATE Orders t SET t.isBillGenerated =:status  WHERE t.orderId=:orderId")
	int updateBillStatus(@Param("orderId") int orderId,@Param("status") int status);

	
	@Transactional
	@Modifying
	@Query("UPDATE Orders t SET t.isBillGenerated =1  WHERE t.itemId IN(:orderItemId) AND production_date=:prodDate AND t.isBillGenerated=0")
	int updateStatus(@Param("orderItemId")List<String> orderItemId, @Param("prodDate")String prodDate);

	
	@Transactional
	@Modifying
	@Query("UPDATE Orders t SET t.deliveryDate=:delDate,t.productionDate=:prodDate  WHERE t.orderId IN(:orderIds)")
	int updateOrderDelivery(@Param("orderIds")List<Integer> orderIds,@Param("delDate")Date delDate,@Param("prodDate")Date prodDate);

	Orders findByOrderId(int orderId);

	
	/*@Transactional
	@Modifying
	@Query("UPDATE Orders t SET t.isBillGenerated =1  WHERE t.itemId IN(:orderItemId) AND production_date=:prodDate AND t.isBillGenerated=0")
	int updateOrderItemShelf(@Param("orderIds")List<String> orderIds,@Param("itemShelf") int itemShelf);
*/
}

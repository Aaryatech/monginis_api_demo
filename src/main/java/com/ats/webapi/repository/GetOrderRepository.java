package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.GetOrder;
import com.ats.webapi.model.Order;
@Repository
public interface GetOrderRepository extends JpaRepository<GetOrder, Integer>{
	
	
	@Query(value="SELECT m_franchisee.fr_name ,m_item.id ,m_item.item_name ,t_order.order_id,t_order.order_qty ,"
			+ "m_category.cat_name,t_order.delivery_date,"
			+ " t_order.is_edit, t_order.edit_qty,t_order.is_positive FROM m_franchisee ,m_category,"
			+ "m_item,t_order WHERE t_order.production_date = :date AND t_order.is_edit=0 AND t_order.fr_id IN (:frId) AND "
			+ "t_order.item_id = m_item.id AND t_order.menu_id IN (:menuId) AND t_order.fr_id = m_franchisee.fr_id AND "
			+ "t_order.order_type = m_category.cat_id ORDER BY m_franchisee.fr_id, m_category.cat_id,m_item.item_grp2, m_item.item_name",nativeQuery=true)
				List<GetOrder> findAllNative(@Param("frId")List<String>  frId,@Param("menuId") List<String> menuId,@Param("date")String date);

	
	// if  all franchisees selected
	
	/*@Query(value="SELECT m_franchisee.fr_name ,m_item.id ,m_item.item_name ,t_order.order_id,t_order.order_qty ,"
			+ "m_category.cat_name,t_order.delivery_date,"
			+ " t_order.is_edit, t_order.edit_qty,t_order.is_positive FROM m_franchisee ,m_category,"
			+ "m_item,t_order WHERE t_order.production_date = :date AND t_order.is_edit=0 AND "
			+ "t_order.item_id = m_item.id AND t_order.menu_id IN (:menuId) AND t_order.fr_id = m_franchisee.fr_id AND "
			+ "t_order.order_type = m_category.cat_id ORDER BY m_franchisee.fr_id, m_category.cat_id,m_item.item_grp2,m_item.item_name",nativeQuery=true)
				List<GetOrder> findAllNativeAllFr(@Param("menuId")List<String> menuId,@Param("date")String date);
*/
	
	@Query(value="SELECT m_franchisee.fr_name ,m_item.id ,m_item.item_name ,t_order.order_id,t_order.order_qty ,"
			+ "m_category.cat_name,t_order.delivery_date,"
			+ " t_order.is_bill_generated as is_edit, t_order.edit_qty,t_order.is_positive FROM m_franchisee ,m_category,"
			+ "m_item,t_order WHERE t_order.production_date = :date AND t_order.is_edit=0 AND "
			+ "t_order.item_id = m_item.id AND t_order.menu_id IN (:menuId) AND t_order.fr_id = m_franchisee.fr_id AND "
			+ "t_order.order_type = m_category.cat_id ORDER BY m_franchisee.fr_id, m_category.cat_id,m_item.item_grp2,m_item.item_name",nativeQuery=true)
				List<GetOrder> findAllNativeAllFr(@Param("menuId")List<String> menuId,@Param("date")String date);

	
	
	//Mahesh -2 APR-Pune
	@Query(value="SELECT m_franchisee.fr_name ,m_item.id ,m_item.item_name ,t_order.order_id,t_order.order_qty ,"
			+ "m_category.cat_name,t_order.delivery_date,"
			+ " t_order.is_edit, t_order.edit_qty,t_order.is_positive FROM m_franchisee ,m_category,"
			+ "m_item,t_order WHERE t_order.production_date = :date AND t_order.is_edit=0 AND "
			+ "t_order.item_id = m_item.id AND t_order.menu_id IN (:menuId) AND t_order.item_id IN(:itemId) AND t_order.fr_id = m_franchisee.fr_id AND "
			+ "t_order.order_type = m_category.cat_id ORDER BY m_franchisee.fr_id, m_category.cat_id,m_item.item_grp2,m_item.item_name",nativeQuery=true)
	
	List<GetOrder> findAllNativeAllFrByItem(@Param("menuId")List<String> menuId,@Param("date") String date,@Param("itemId") List<Integer> itemId);
	//Mahesh -2 APR-Pune
	@Query(value="SELECT m_franchisee.fr_name ,m_item.id ,m_item.item_name ,t_order.order_id,t_order.order_qty ,"
			+ "m_category.cat_name,t_order.delivery_date,"
			+ " t_order.is_edit, t_order.edit_qty,t_order.is_positive FROM m_franchisee ,m_category,"
			+ "m_item,t_order WHERE t_order.production_date = :date AND t_order.is_edit=0 AND t_order.fr_id IN (:frId) AND "
			+ "t_order.item_id = m_item.id AND t_order.menu_id IN (:menuId) And t_order.item_id IN(:itemId) AND t_order.fr_id = m_franchisee.fr_id AND "
			+ "t_order.order_type = m_category.cat_id ORDER BY m_franchisee.fr_id, m_category.cat_id,m_item.item_grp2, m_item.item_name",nativeQuery=true)
	
	List<GetOrder> findAllNativeByItemId(@Param("frId")List<String> frId,@Param("menuId") List<String> menuId,@Param("date") String date,@Param("itemId") List<Integer> itemId);

}

//SELECT m_franchisee.fr_name , m_category.cat_name ,m_item.item_id ,m_item.item_name ,t_order.order_qty , t_order.delivery_date, t_order.is_edit, t_order.edit_qty,t_order.is_positive FROM m_franchisee ,m_category,m_item,t_order WHERE t_order.production_date = '2017-01-01' AND t_order.order_type=1 AND t_order.fr_id IN (10,11) AND t_order.item_id = m_item.item_id AND t_order.order_type = m_category.cat_id AND t_order.fr_id = m_franchisee.fr_id 
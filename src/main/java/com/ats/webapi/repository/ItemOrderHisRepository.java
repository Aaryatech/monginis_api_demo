package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemOrderHis;


public interface ItemOrderHisRepository extends JpaRepository<ItemOrderHis,Long> {//o.menu_id= replaced by o.order_type 
	@Query(value="select o.*,m.menu_title,i.item_name from t_order o,m_fr_menu_show m,m_item i where o.menu_id=m.menu_id AND o.item_id=i.id AND o.menu_id IN(:catId) AND o.delivery_date=:deliveryDate AND o.fr_id=:frId",nativeQuery=true)
	List<ItemOrderHis> findByMenuIdInAndDeliveryDate(@Param("catId") List<String> catId,@Param("deliveryDate") Date deliveryDate,@Param("frId")int frId);

	@Query(value="select o.*,m.menu_title,i.item_name from t_order o,m_fr_menu_show m,m_item i where o.menu_id=m.menu_id AND o.item_id=i.id  AND o.delivery_date=:deliveryDate AND o.fr_id=:frId",nativeQuery=true)
	List<ItemOrderHis> findByMenuIdInAndDeliveryDateAll(@Param("deliveryDate")Date deliveryDate,@Param("frId") int frId);
}

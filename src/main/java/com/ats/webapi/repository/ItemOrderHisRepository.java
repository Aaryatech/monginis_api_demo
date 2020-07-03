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


	@Query(value="select o.adv_detail_id as order_id,o.order_date,o.fr_id,o.cat_id as order_type,o.sub_cat_id as order_sub_type,o.item_id as ref_id ,o.item_id,\n" + 
			"	o.qty as order_qty,o.rate as order_rate,o.mrp as order_mrp,0 as order_status,'0' as order_datetime,o.prod_date as production_date,\n" + 
			"	o.delivery_date,0 as is_edit,0 as edit_qty,0 as user_id,o.disc_per as is_positive,o.menu_id,m.menu_title,i.item_name from t_adv_order_detail o,m_fr_menu_show m,m_item i where o.menu_id=m.menu_id AND o.item_id=i.id  AND o.delivery_date=:deliveryDate AND o.fr_id=:frId AND o.adv_header_id =:advHeadId ",nativeQuery=true)
	List<ItemOrderHis> findByMenuIdInAndDeliveryDateAllForAdv(@Param("advHeadId") int advHeadId,@Param("deliveryDate")Date deliveryDate,@Param("frId") int frId);


	@Query(value="select o.adv_detail_id as order_id,o.order_date,o.fr_id,o.cat_id as order_type,o.sub_cat_id as order_sub_type,o.item_id as ref_id ,o.item_id,\n" + 
			"	o.qty as order_qty,o.rate as order_rate,o.mrp as order_mrp,0 as order_status,'0' as order_datetime,o.prod_date as production_date,\n" + 
			"	o.delivery_date,0 as is_edit,0 as edit_qty,0 as user_id,o.disc_per as is_positive,o.menu_id,m.menu_title,i.item_name from t_adv_order_detail o,m_fr_menu_show m,m_item i where o.menu_id=m.menu_id AND o.item_id=i.id AND o.adv_header_id =:advHeadId ",nativeQuery=true)
	List<ItemOrderHis> findByMenuIdInAndDeliveryDateAllForAdv(@Param("advHeadId") int advHeadId);

	
}

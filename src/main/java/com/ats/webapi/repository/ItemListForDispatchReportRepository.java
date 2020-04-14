package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemListForDispatchReport;

public interface ItemListForDispatchReportRepository extends JpaRepository<ItemListForDispatchReport, Integer>{

	 @Query(value="select\n" + 
			"    @rownum \\:= @rownum + 1 AS id,\n" + 
			"    i.id as item_id, \n" + 
			"    i.item_name,\n" + 
			"    i.item_mrp2,\n" + 
			"    coalesce((select SUM(t_order.order_qty) from\n" + 
			"    t_order, m_franchisee where\n" + 
			"    t_order.order_id In(\n" + 
			"        select\n" + 
			"            order_id \n" + 
			"        from\n" + 
			"            t_order \n" + 
			"        where\n" + 
			"            delivery_date=:date \n" + 
			"            and fr_id in(:frId) and t_order.menu_id in (:menuIds)\n" + 
			"    )   \n" + 
			"    And t_order.fr_id=m_franchisee.fr_id \n" + 
			"    and i.id=t_order.item_id),0 ) as order_qty,\n" + 
			"    coalesce((select SUM(t_order.edit_qty) from\n" + 
			"    t_order, m_franchisee where\n" + 
			"    t_order.order_id In(\n" + 
			"        select\n" + 
			"            order_id \n" + 
			"        from\n" + 
			"            t_order \n" + 
			"        where\n" + 
			"            delivery_date=:date \n" + 
			"            and fr_id in(:frId) and t_order.menu_id in (:menuIds)\n" + 
			"    )   \n" + 
			"    And t_order.fr_id=m_franchisee.fr_id \n" + 
			"    and i.id=t_order.item_id),0 ) as edit_qty\n" + 
			"from \n" + 
			"    m_item i, (SELECT @rownum \\:=:index) r \n" + 
			"where \n" + 
			"    del_status=0 \n" + 
			"    and item_mrp2=:stationN0 order by \n" + 
			"    item_grp2 asc , \n" + 
			"    item_sort_id asc",nativeQuery=true)
	List<ItemListForDispatchReport> getItemByFrIdAndDate(@Param("frId") int frId,@Param("date")  String date, @Param("index") int index,
			@Param("stationN0") int stationN0, @Param("menuIds") List<Integer> menuIds); 
	
	/*@Query(value="select\n" +  
			"    @rownum \\:= @rownum + 1 AS id,\n" + 
			"    i.id as item_id, \n" + 
			"    i.item_name,\n" + 
			"    i.item_mrp2,\n" + 
			"    coalesce((select SUM(t_order.order_qty) from t_order, m_franchisee where t_order.fr_id=m_franchisee.fr_id and i.id=t_order.item_id and t_order.production_date=:date and t_order.fr_id=:frId),0 ) as edit_qty,\n" + 
			"    coalesce((select SUM(t_order.edit_qty) from t_order, m_franchisee where t_order.fr_id=m_franchisee.fr_id and i.id=t_order.item_id and t_order.production_date=:date and t_order.fr_id:=:frId),0 ) as order_qty \n" + 
			"from \n" + 
			"    m_item i, (SELECT @rownum \\:=:index) b\n" + 
			"where \n" + 
			"    del_status=0 \n" + 
			"    and item_mrp2=:stationNo\n" + 
			"order by \n" + 
			"    item_grp2 asc,\n" + 
			"    item_sort_id asc\n" + 
			"     ",nativeQuery=true)
	List<ItemListForDispatchReport> getItemByFrIdAndDate(@Param("frId") int frId,@Param("date")  String date, @Param("index") int index,
			@Param("stationN0") int stationN0);*/
	
	@Query(value="select count(*)  from m_item where m_item.item_mrp2=:stationNo and m_item.del_status=0",nativeQuery=true)
	int getcount(@Param("stationNo")int stationNo);
	
}

	

package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.DispatchStationItem;

public interface DispatchReportRepositoryForItemwiseMin extends JpaRepository<DispatchStationItem, Integer>{

	@Query(value="select\n" + 
			"        CONCAT(i.id, m_franchisee.fr_id, i.item_mrp2) AS id,\n" + 
			"        i.id as item_id,\n" + 
			"        i.item_name,\n" + 
			"        i.item_mrp2,\n" + 
			"        m_franchisee.fr_id,\n" + 
			"        m_franchisee.fr_name,\n" + 
			"        coalesce((select\n" + 
			"            SUM(t_order.order_qty) \n" + 
			"        from\n" + 
			"            t_order \n" + 
			"        where\n" + 
			"            t_order.order_id In(         select\n" + 
			"                order_id          \n" + 
			"            from\n" + 
			"                t_order          \n" + 
			"            where\n" + 
			"                delivery_date=:date             \n" + 
			"                and  t_order.fr_id=m_franchisee.fr_id\n" + 
			"                and t_order.menu_id in (:menuIds)     )        \n" + 
			"            And t_order.fr_id=m_franchisee.fr_id  and  t_order.fr_id=m_franchisee.fr_id    \n" + 
			"            and i.id=t_order.item_id),0 ) as order_qty\n" + 
			"        \n" + 
			"    from\n" + 
			"        m_item i,\n" + 
			"       m_franchisee \n" + 
			"    where\n" + 
			"       i.del_status=0   \n" + 
			"        and item_mrp2 IN (:stationNos) AND m_franchisee.fr_id IN(:frList)\n" + 
			"    order by\n" + 
			"    m_franchisee.fr_id,\n" + 
			"        item_grp2 asc ,\n" + 
			"        item_sort_id asc\n" + 
			"",nativeQuery=true)
	List<DispatchStationItem> getItemByFrIdAndDateMin(@Param("stationNos")List<Integer> stationNos,@Param("date") String date,@Param("frList") List<Integer> frList,
			@Param("menuIds")List<Integer> menuIds);
	
	@Query(value="select \n" + 
			"			        CONCAT(i.id, m_franchisee.fr_id, i.item_mrp2) AS id, \n" + 
			"			        i.id as item_id, \n" + 
			"			        i.item_name, \n" + 
			"			        i.item_mrp2, \n" + 
			"			        m_franchisee.fr_id, \n" + 
			"			        m_franchisee.fr_name,  \n" + 
			"			        SUM(t_order.order_qty) AS   order_qty \n" + 
			"			        from \n" + 
			"			            t_order,m_item i, \n" + 
			"			       m_franchisee\n" + 
			"  \n" + 
			"			            where \n" + 
			"			               t_order.delivery_date=:date          \n" + 
			"			                and  t_order.fr_id=m_franchisee.fr_id \n" + 
			"			                and t_order.menu_id in (:menuIds)             \n" + 
			"			                 \n" + 
			"			            and i.id=t_order.item_id AND\n" + 
			"			         \n" + 
			"			          \n" + 
			"			       i.del_status=0    \n" + 
			"			        and item_mrp2 IN (:stationNos) AND m_franchisee.fr_id IN(:frList) \n" + 
			"                   group by  t_order.item_id,t_order.fr_id"+
			"			    order by \n" + 
			"			    m_franchisee.fr_id, \n" + 
			"			        item_grp2 asc , \n" + 
			"			        item_sort_id asc \n" + 
			"			",nativeQuery=true)
	List<DispatchStationItem> getItemByFrIdAndDateMin1(@Param("stationNos")List<Integer> stationNos,@Param("date") String date,@Param("frList") List<Integer> frList,
			@Param("menuIds")List<Integer> menuIds);

}

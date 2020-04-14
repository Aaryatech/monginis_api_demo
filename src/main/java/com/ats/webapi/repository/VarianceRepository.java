package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Variance;

public interface VarianceRepository extends JpaRepository<Variance, Integer>{

	@Query(value="SELECT m_item.item_name, m_item.id, m_item.item_id, coalesce((Select sum(t_order.order_qty) From t_order "
			+ "where t_order.production_date=:Date AND t_order.menu_id In(:menus) And m_item.id=t_order.item_id ), 0) AS t_order_qty, "
			+ "coalesce((Select SUM( t_regular_sp_cake.qty) From t_regular_sp_cake where m_item.id= t_regular_sp_cake.item_id "
			+ "And t_regular_sp_cake.menu_id In(:menus) AND t_regular_sp_cake.rsp_produ_date=:Date), 0) AS sp_cake_qty from m_item WHERE m_item.del_status=0 and m_item.item_grp1=:group_type "
			+ "Group by m_item.id order by m_item.item_grp1,m_item.item_grp2,m_item.item_name",nativeQuery=true)
	List<Variance> variancelistAllFr(@Param("Date")String date,@Param("menus")List<String> menus,@Param("group_type")String groupType);
	
	@Query(value="SELECT m_item.item_name, m_item.id, m_item.item_id, coalesce((Select sum(t_order.order_qty) From t_order "
			+ "where t_order.production_date=:Date AND t_order.menu_id In(:menus) AND m_item.id=t_order.item_id AND t_order.fr_id IN(:frId)), 0) AS t_order_qty,"
			+ " coalesce((Select SUM( t_regular_sp_cake.qty) From t_regular_sp_cake where m_item.id= t_regular_sp_cake.item_id"
			+ " And t_regular_sp_cake.menu_id In(:menus) AND t_regular_sp_cake.rsp_produ_date=:Date AND t_regular_sp_cake.fr_id in(:frId) ), 0) AS sp_cake_qty "
			+ "from m_item WHERE m_item.item_grp1=:group_type and m_item.del_status=0  Group by id order by m_item.item_grp1,m_item.item_grp2,m_item.item_name",nativeQuery=true)
	List<Variance> variancelistSelectedFr(@Param("Date")String date,@Param("menus")List<String> menus,@Param("group_type")String groupType,@Param("frId")List<String> frId);
	
}

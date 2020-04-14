package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.OrderCounts;

public interface OrderCountsRepository extends JpaRepository<OrderCounts, Integer>{
	/*
	@Query (value=" SELECT COALESCE(sum(t_order.order_qty),0) as total,m_fr_menu_show.menu_id,"
			+ " m_fr_menu_show.menu_title FROM m_fr_menu_show LEFT JOIN t_order "
			+ "ON m_fr_menu_show.menu_id=t_order.menu_id AND "
			+ "production_date =:cDate GROUP BY menu_id" + 
			" ",nativeQuery=true)
	List<OrderCounts> getOrderTotal(@Param("cDate") Date cDate);
	 */
	
    @Query (value=" SELECT SUM(t_order.order_qty) as total,m_fr_menu_show.menu_id,"
            + " m_fr_menu_show.menu_title FROM t_order,m_fr_menu_show where "
            + " production_date =:cDate and "
            + " m_fr_menu_show.menu_id=t_order.menu_id GROUP BY menu_id " +
            " ",nativeQuery=true)

	List<OrderCounts> getOrderTotal(@Param("cDate") String cDate);
	 
	
	
	
}

package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.AllFrIdName;

public interface AllFrIdNameRepository extends JpaRepository<AllFrIdName, Integer> {
	
	@Query(value=" SELECT m_franchisee.fr_id,m_franchisee.fr_name from m_franchisee,m_fr_route,m_franchise_sup WHERE m_fr_route.route_id=m_franchisee.fr_route_id and m_franchise_sup.fr_id=m_franchisee.fr_id and m_franchisee.del_status=0 and m_fr_route.del_status=0 order by m_franchisee.fr_name Asc",nativeQuery=true)
	
	List<AllFrIdName> getAllFrIdName();
	
		@Query(value="select m_franchisee.fr_id,m_franchisee.fr_name from m_franchisee where m_franchisee.del_status=0 And  m_franchisee.fr_id NOT"
					+" IN(select t_order.fr_id from t_order where order_date=:orderDate AND menu_id=:menuId) order by m_franchisee.fr_name Asc"
					,nativeQuery=true)
	public List<AllFrIdName> findNonOrders(@Param("orderDate") String orderDate, @Param("menuId") int menuId);

		@Query(value=" SELECT fr_id,fr_name from m_franchisee where fr_id=:frId",nativeQuery=true)
		AllFrIdName findByFrId(@Param("frId")int frId);

}


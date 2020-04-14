package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Route;
import com.ats.webapi.model.SellBillDetails;

public interface RouteRepository extends JpaRepository<Route, Integer> {
	Route save(Route route);

	List<Route> findAll();

	Route findOne(int routeId);

	List<Route> findByDelStatus(int id);

	List<Route> findByDelStatusOrderByRouteNameAsc(int i);
	
	List<Route> findByDelStatusOrderByRouteIdAsc(int i);

	List<Route> findByRouteIdIn(List<Integer> routeId);

	@Query(value = " SELECT r.route_tray_id as route_id ,r.route_name,r.del_status FROM m_route_tray_mgmt r where del_status=0 ORDER BY r.route_name ASC", nativeQuery = true)
	List<Route> findRouteMgmt();

	// SELECT r.route_tray_id as route_id ,r.route_name,r.del_status FROM
	// m_route_tray_mgmt r where del_status=0 ORDER BY r.route_name ASC

	@Query(value = " SELECT r.route_tray_id as route_id ,r.route_name,r.del_status FROM m_route_tray_mgmt r where del_status=0 AND r.is_same_day=:isSameDay ORDER BY r.route_name ASC", nativeQuery = true)
	List<Route> findRouteMgmtByIsSameDay(@Param("isSameDay") int isSameDay);

}

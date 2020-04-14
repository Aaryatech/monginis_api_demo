package com.ats.webapi.model.route;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GetRouteMgmtRepo extends JpaRepository<GetRouteMgmt, Integer> {

	@Query(value = "SELECT r.*,f.fr_name FROM m_route_tray_mgmt r,m_franchisee f WHERE  r.del_status=0 AND r.is_active=1 AND f.fr_id=r.fr_ids", nativeQuery = true)

	public List<GetRouteMgmt> getAllRouteMgmt();

	@Query(value = "SELECT r.*,f.fr_name FROM m_route_tray_mgmt r,m_franchisee f WHERE  r.del_status=0 AND r.is_active=1 AND f.fr_id=r.fr_ids AND r.route_tray_id=:routeTrayId", nativeQuery = true)

	GetRouteMgmt getAllRouteMgmtByRoutId(@Param("routeTrayId") int routeTrayId);

	@Query(value = "SELECT r.*,f.fr_name FROM m_route_tray_mgmt r,m_franchisee f WHERE  r.route_tray_id IN(:routeIdList) AND   r.del_status=0 AND r.is_active=1 AND f.fr_id=r.fr_ids", nativeQuery = true)

	public List<GetRouteMgmt> getAllRouteMgmtByRouteIdList(@Param("routeIdList") List<Integer> routeIdList);

	@Query(value = "SELECT r.*,f.fr_name FROM m_route_tray_mgmt r,m_franchisee f WHERE  r.route_tray_id=:routeId AND   r.del_status=0 AND r.is_active=1 AND f.fr_id=r.fr_ids", nativeQuery = true)
	public GetRouteMgmt findByRouteId(@Param("routeId") int routeId);

}

package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.FranchiseForDispatch;

@Repository
public interface FranchiseForDispatchRepository extends JpaRepository<FranchiseForDispatch, Integer> {

	@Query(value = " SELECT fr_name,fr_id,  fr_route_id,fr_rate,fr_rate_cat FROM m_franchisee WHERE "
			+ "fr_route_id =:routeId  and del_status=0" + "", nativeQuery = true)
	List<FranchiseForDispatch> getFranchiseForDispatch(@Param("routeId") int routeId);

	// Sumit
	@Query(value = " SELECT m_franchisee.fr_name,m_franchisee.fr_id,  m_franchisee.fr_route_id,m_franchisee.fr_rate,m_franchisee.fr_rate_cat FROM m_franchisee,m_franchise_sup,m_fr_route route WHERE "
			+ "m_franchisee.fr_route_id IN (:routeId)  and m_franchisee.del_status=0 and m_franchise_sup.fr_id=m_franchisee.fr_id and route.route_id=m_franchisee.fr_route_id order by route.abc_type,route.seq_no,m_franchise_sup.no_in_route"
			+ "", nativeQuery = true)
	List<FranchiseForDispatch> getFranchiseForDispatchRouteID(@Param("routeId") List<Integer> routeId);
//neha
	@Query(value = " SELECT m_franchisee.fr_name,m_franchisee.fr_id,  m_franchisee.fr_route_id,m_franchisee.fr_rate,m_franchisee.fr_rate_cat FROM m_franchisee,m_franchise_sup,m_fr_route route,m_franchise_sup sup  WHERE "
			+ "m_franchisee.fr_route_id IN (:routeId)  and m_franchisee.del_status=0 and m_franchise_sup.fr_id=m_franchisee.fr_id and route.route_id=m_franchisee.fr_route_id AND sup.fr_id=m_franchisee.fr_id AND sup.pass5=1 order by route.abc_type,route.seq_no,m_franchise_sup.no_in_route"
			+ "", nativeQuery = true)
	List<FranchiseForDispatch> getFranchiseForDispatchRouteIDByPass5(@Param("routeId") List<Integer> routeId);

	@Query(value = " SELECT fr_name,fr_id,  fr_route_id,fr_rate,fr_rate_cat FROM m_franchisee WHERE "
			+ "fr_id IN(:frIds)  and del_status=0" + "", nativeQuery = true)
	List<FranchiseForDispatch> getFranchiseForDispatchByFrIds(@Param("frIds") List<String> frIds);

}

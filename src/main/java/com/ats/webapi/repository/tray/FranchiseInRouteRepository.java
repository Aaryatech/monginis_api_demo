package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.FranchiseInRoute;

@Repository
public interface FranchiseInRouteRepository extends JpaRepository<FranchiseInRoute, Integer> {

	@Query(value = "select f.fr_id,f.fr_name,f.fr_code from m_franchisee f,m_franchise_sup s where f.del_status=0 and f.fr_route_id=:routeId and\n"
			+ "f.fr_id NOT IN(select fr_id from t_tray_mgt_detail where tran_id=:tranId)\n" + "and\n"
			+ "f.fr_id=s.fr_id order by s.no_in_route  ", nativeQuery = true)
	List<FranchiseInRoute> findFrInRoute(@Param("routeId") int routeId, @Param("tranId") int tranId);

	@Query(value = "select f.fr_id,f.fr_name,f.fr_code from m_franchisee f,m_franchise_sup s where f.del_status=0 and f.fr_id In (:frIdList) and\n"
			+ "f.fr_id NOT IN(select fr_id from t_tray_mgt_detail where tran_id=:tranId)\n" + "and\n"
			+ "f.fr_id=s.fr_id order by s.no_in_route  ", nativeQuery = true)
	List<FranchiseInRoute> findFrInFranchisee(@Param("frIdList") List<Integer> frIdList, @Param("tranId") int tranId);

	// select f.fr_id,f.fr_name,f.fr_code from m_franchisee f,m_franchise_sup s
	// where f.del_status=0 and f.fr_route_id=:routeId and f.fr_id=s.fr_id order by
	// s.no_in_route Desc
}

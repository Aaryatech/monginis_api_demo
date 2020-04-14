package com.ats.webapi.repository.afe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.afe.GetAfeScoreHeader;

public interface GetAfeScoreHeaderRepo extends JpaRepository<GetAfeScoreHeader, Integer> {
	
	@Query(value=" SELECT h.afe_score_header_id,h.fr_id,h.score_header_date,h.visited_by_id,h.visit_person,h.route_id,h.total_score,h.status, " + 
			" r.route_name,f.fr_name,f.fr_code FROM t_afe_score_header h,m_franchisee f,m_fr_route r " + 
			" WHERE h.fr_id=f.fr_id AND h.route_id=r.route_id AND h.del_status=0 AND h.score_header_date BETWEEN :fromDate AND :toDate "
			+ " ORDER BY h.afe_score_header_id DESC" + 
			"",nativeQuery=true)

	List<GetAfeScoreHeader> getAfeScoreHeaders(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	

	@Query(value=" SELECT h.afe_score_header_id,h.fr_id,h.score_header_date,h.visited_by_id,h.visit_person,h.route_id,h.total_score,h.status, " + 
			" r.route_name,f.fr_name,f.fr_code FROM t_afe_score_header h,m_franchisee f,m_fr_route r " + 
			" WHERE h.fr_id=:frId AND h.route_id=r.route_id AND h.del_status=0 AND h.fr_id=f.fr_id "
			+ "ORDER BY h.afe_score_header_id DESC" + 
			"",nativeQuery=true)

	List<GetAfeScoreHeader> getAfeScoreHeaderByFrId(@Param("frId") int frId);

	
}

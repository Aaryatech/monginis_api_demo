package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetFranchiseSup;

@Repository
public interface GetFranchiseSupRepository extends JpaRepository<GetFranchiseSup, Integer>{

	@Query(value="Select s.id,s.fr_id,f.fr_name,s.fr_pan_no,s.fr_state,s.fr_country,s.no_in_route,s.pest_control_date,s.frequency,s.remainder_date,s.pass1,s.pass2,s.pass3,s.pass4,s.pass5,s.del_status,s.is_tally_sync from m_franchise_sup s,m_franchisee f where f.fr_id=s.fr_id and s.del_status=0 order by f.fr_name Asc",nativeQuery=true)
	List<GetFranchiseSup> findByDelStatus();

}

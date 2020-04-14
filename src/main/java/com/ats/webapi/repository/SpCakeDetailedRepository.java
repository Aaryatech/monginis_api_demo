package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.SpCakeDetailed;


public interface SpCakeDetailedRepository extends JpaRepository<SpCakeDetailed, Integer>{
	
	SpCakeDetailed save(SpCakeDetailed spCakeDetailed);
	
	@Query(value="select * from m_sp_cake_detail where sp_id=:sp_id and del_status=0",nativeQuery=true)
	List<SpCakeDetailed> findBySpId(@Param("sp_id")int sp_id );
}

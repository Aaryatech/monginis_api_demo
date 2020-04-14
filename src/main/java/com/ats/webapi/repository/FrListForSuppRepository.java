package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.FrListForSupp;
@Repository
public interface FrListForSuppRepository extends JpaRepository<FrListForSupp, Integer>{

	@Query(value="select fr_id,fr_name from m_franchisee where del_status=0 AND fr_id NOT IN(select fr_id from m_franchise_sup where del_status=0);",nativeQuery=true)
	List<FrListForSupp> getFrListForSupp();

}

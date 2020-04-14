package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SpCake;

@Repository
public interface SpCakeListRepository extends JpaRepository<SpCake, Integer>{

	@Query(value="select sp_id,sp_name,sp_code from m_sp_cake where del_status=0 And sp_id Not In(select sp_id from m_spcake_sup where del_status=0);",nativeQuery=true)
	List<SpCake> getSpCakeList();

	@Query(value="select MAX(sp_id)+1 from m_sp_cake",nativeQuery=true)
	int getUniqueSpCode();

}

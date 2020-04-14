package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.Flavour;
import com.ats.webapi.model.Message;

@Repository
public interface FlavourRepository extends JpaRepository<Flavour, Integer>{
	Flavour save(Flavour flavour);
    Flavour findOne(int spfId);
	List<Flavour> findByDelStatus(int i);
	List<Flavour> findByOrderBySpfNameAsc();
	List<Flavour> findBySpfIdIn(List<Integer> spfId);
	List<Flavour> findBySpType(int type);
	List<Flavour> findBySpfIdNotIn(List<Integer> spfId);
	List<Flavour> findBySpfIdNotInAndSpType(List<Integer> spfId, int type);
	@Query(value="select * from m_sp_flavour where spf_id IN(select DISTINCT spf_id from m_sp_flavour_conf where m_sp_flavour_conf.del_status=0 and m_sp_flavour_conf.sp_id=:spId) and del_status=0 order by spf_name",nativeQuery=true)
	List<Flavour> findBySpId(@Param("spId")int spId);
}

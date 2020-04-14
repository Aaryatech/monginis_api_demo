package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetSpCkSupplement;
import com.ats.webapi.model.OrderSpecialCake;
import com.ats.webapi.model.SpCakeSupplement;

@Repository
public interface SpCakeSupRepository extends JpaRepository<SpCakeSupplement, Integer>{

	SpCakeSupplement saveAndFlush(SpCakeSupplement spCakeSupplement);

	/*@Modifying
	@Transactional
	@Query("Update SpCakeSupplement  SET del_status=1 WHERE sp_id IN(:id)")
	int deleteSpCakeSup(@Param("id") List<Integer> id);
*/
	//SpCakeSupplement SpCakeSupplement(String spCode);
	
	@Query(value="SELECT m_spcake_sup.id, m_spcake_sup.sp_id,m_spcake_sup.sp_hsncd,m_spcake_sup.sp_uom ,m_spcake_sup.sp_cess ,m_spcake_sup.cut_section ,m_spcake_sup.is_tally_sync,m_spcake_sup.del_status,m_spcake_sup.uom_id FROM m_spcake_sup WHERE m_spcake_sup.sp_id=:spId and m_spcake_sup.del_status=0 ORDER BY m_spcake_sup.id DESC LIMIT 1",nativeQuery=true)
	public SpCakeSupplement findBySpId(@Param("spId")int spId);

	Long deleteBySpIdIn(List<Integer> id);

	@Query(value="SELECT m_spcake_sup.id, m_spcake_sup.sp_id,m_spcake_sup.sp_hsncd,m_spcake_sup.sp_uom ,m_spcake_sup.sp_cess ,m_spcake_sup.cut_section ,m_spcake_sup.is_tally_sync,m_spcake_sup.del_status,m_spcake_sup.uom_id FROM m_spcake_sup WHERE m_spcake_sup.sp_id=:spId and m_spcake_sup.del_status=0 ORDER BY m_spcake_sup.id",nativeQuery=true)
	List<SpCakeSupplement> findBySpIdById(@Param("spId")int spId);


}

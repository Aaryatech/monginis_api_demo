package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.prod.mixing.GetSpDetailForBom;

@Repository
public interface GetSpDetailForBomRepository extends JpaRepository<GetSpDetailForBom, Integer>{

	
	@Query(value="  SELECT m_sp_cake_detail.sp_id,\n" + 
			" m_sp_cake_detail.sp_cake_detailed_id,\n" + 
			" m_sp_cake_detail.rm_id,\n" + 
			" m_sp_cake_detail.rm_name,\n" + 
			" m_sp_cake_detail.rm_type,\n" + 
			" m_rm_uom.uom,m_sp_cake_detail.rm_qty *m_sp_cake_detail.rm_weight AS total \n" + 
			" from m_sp_cake_detail,m_rm_uom \n" + 
			" WHERE m_rm_uom.uom_id=m_sp_cake_detail.rm_uom_id AND m_sp_cake_detail.del_status=0\n" + 
			" AND m_sp_cake_detail.sp_id=:spId",nativeQuery=true)
	List<GetSpDetailForBom> findSpDetailForBom(@Param("spId")int spId);

}

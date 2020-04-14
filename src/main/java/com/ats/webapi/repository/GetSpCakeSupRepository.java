package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetSpCkSupplement;

@Repository
public interface GetSpCakeSupRepository extends JpaRepository<GetSpCkSupplement, Integer>{

	@Query(value="select\n" + 
			"  s.id,sp.sp_code,\n" + 
			"  s.sp_id,\n" + 
			"  sp.sp_name,\n" + 
			"  s.sp_hsncd,\n" + 
			"  s.sp_uom,s.uom_id,s.sp_cess,\n" + 
			"  s.is_tally_sync,\n" + 
			"  s.del_status,\n" + 
			"  s.cut_section from m_spcake_sup s,m_sp_cake sp where s.del_status=:delStatus And s.sp_id=sp.sp_id",nativeQuery=true)
	List<GetSpCkSupplement> findByDelStatus(@Param("delStatus")int delStatus);

	@Query(value="select\n" + 
			"  s.id,sp.sp_code,\n" + 
			"  s.sp_id,\n" + 
			"  sp.sp_name,\n" + 
			"  s.sp_hsncd,\n" + 
			"  s.sp_uom,s.uom_id,s.sp_cess,\n" + 
			"  s.is_tally_sync,\n" + 
			"  s.del_status,\n" + 
			"  s.cut_section from m_spcake_sup s,m_sp_cake sp where s.del_status=0 And s.sp_id=sp.sp_id And id=:id",nativeQuery=true)
	GetSpCkSupplement findById(@Param("id")int id);

	@Query(value="select\n" + 
			"  s.id,sp.sp_code,\n" + 
			"  s.sp_id,\n" + 
			"  sp.sp_name,\n" + 
			"  s.sp_hsncd,\n" + 
			"  s.sp_uom,s.uom_id,s.sp_cess,\n" + 
			"  s.is_tally_sync,\n" + 
			"  s.del_status,\n" + 
			"  s.cut_section from m_spcake_sup s,m_sp_cake sp where s.del_status=0 And s.sp_id=sp.sp_id And s.sp_id=:spId",nativeQuery=true)
	GetSpCkSupplement getSpCakeSupplement(@Param("spId")int id);

}
